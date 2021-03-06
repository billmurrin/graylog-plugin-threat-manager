package org.graylog.plugins.threatmanager.processors;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Maps;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import com.codahale.metrics.MetricRegistry;

import org.graylog.plugins.threatmanager.ast.ThreatList;
import org.graylog.plugins.threatmanager.ast.Indicator;
import org.graylog.plugins.threatmanager.codegen.ThreatManagerClassloader;
import org.graylog.plugins.threatmanager.db.ThreatManagerService;
import org.graylog.plugins.threatmanager.db.ThreatManagerStreamConnectionsService;
import org.graylog.plugins.threatmanager.db.IndicatorService;
import org.graylog.plugins.threatmanager.events.ThreatManagerConnectionsChangedEvent;
import org.graylog.plugins.threatmanager.events.ThreatManagerChangedEvent;
import org.graylog.plugins.threatmanager.events.IndicatorsChangedEvent;
import org.graylog.plugins.threatmanager.parser.FunctionRegistry;
import org.graylog.plugins.threatmanager.parser.ParseException;
import org.graylog.plugins.threatmanager.parser.PipelineRuleParser;
import org.graylog.plugins.threatmanager.rest.ThreatManagerConnections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.tools.ToolProvider;

import static com.codahale.metrics.MetricRegistry.name;

@Singleton
public class ConfigurationStateUpdater {
    private static final Logger log = LoggerFactory.getLogger(ConfigurationStateUpdater.class);

    private final IndicatorService ruleService;
    private final ThreatManagerService pipelineService;
    private final ThreatManagerStreamConnectionsService pipelineStreamConnectionsService;
    private final PipelineRuleParser pipelineRuleParser;
    private final MetricRegistry metricRegistry;
    private final FunctionRegistry functionRegistry;
    private final ScheduledExecutorService scheduler;
    private final EventBus serverEventBus;
    private final PipelineInterpreter.State.Factory stateFactory;
    /**
     * non-null if the update has successfully loaded a state
     */
    private final AtomicReference<PipelineInterpreter.State> latestState = new AtomicReference<>();
    private static boolean allowCodeGeneration = false;

    @Inject
    public ConfigurationStateUpdater(IndicatorService ruleService,
                                     ThreatManagerService pipelineService,
                                     ThreatManagerStreamConnectionsService pipelineStreamConnectionsService,
                                     PipelineRuleParser pipelineRuleParser,
                                     MetricRegistry metricRegistry,
                                     FunctionRegistry functionRegistry,
                                     @Named("daemonScheduler") ScheduledExecutorService scheduler,
                                     EventBus serverEventBus,
                                     PipelineInterpreter.State.Factory stateFactory,
                                     @Named("generate_native_code") boolean allowCodeGeneration) {
        this.ruleService = ruleService;
        this.pipelineService = pipelineService;
        this.pipelineStreamConnectionsService = pipelineStreamConnectionsService;
        this.pipelineRuleParser = pipelineRuleParser;
        this.metricRegistry = metricRegistry;
        this.functionRegistry = functionRegistry;
        this.scheduler = scheduler;
        this.serverEventBus = serverEventBus;
        this.stateFactory = stateFactory;
        // ignore global config, never allow generating code
        setAllowCodeGeneration(false);

        // listens to cluster wide Rule, Pipeline and pipeline stream connection changes
        serverEventBus.register(this);

        reloadAndSave();
    }

    private static void setAllowCodeGeneration(Boolean allowCodeGeneration) {
        if (allowCodeGeneration && ToolProvider.getSystemJavaCompiler() == null) {
            log.warn("Your Java runtime does not have a compiler available, turning off dynamic " +
                    "code generation. Please consider running Graylog in a JDK, not a JRE, to " +
                    "avoid a performance penalty in pipeline processing.");
            allowCodeGeneration = false;
        }
        ConfigurationStateUpdater.allowCodeGeneration = allowCodeGeneration;
    }

    public static boolean isAllowCodeGeneration() {
        return allowCodeGeneration;
    }

    // only the singleton instance should mutate itself, others are welcome to reload a new state, but we don't
    // currently allow direct global state updates from external sources (if you need to, send an event on the bus instead)
    private synchronized PipelineInterpreter.State reloadAndSave() {
        // this classloader will hold all generated rule classes
        ThreatManagerClassloader commonClassLoader = allowCodeGeneration ? new ThreatManagerClassloader() : null;

        // read all rules and parse them
        Map<String, Indicator> ruleNameMap = Maps.newHashMap();
        ruleService.loadAll().forEach(ruleDao -> {
            Indicator rule;
            try {
                rule = pipelineRuleParser.parseRule(ruleDao.id(), ruleDao.source(), false, commonClassLoader);
            } catch (ParseException e) {
                rule = Indicator.alwaysFalse("Failed to parse rule: " + ruleDao.id());
            }
            ruleNameMap.put(rule.name(), rule);
        });

        // read all pipelines and parse them
        ImmutableMap.Builder<String, ThreatList> pipelineIdMap = ImmutableMap.builder();
        pipelineService.loadAll().forEach(pipelineDao -> {
            ThreatList pipeline;
            try {
                pipeline = pipelineRuleParser.parsePipeline(pipelineDao.id(), pipelineDao.source());
            } catch (ParseException e) {
                pipeline = ThreatList.empty("Failed to parse pipeline" + pipelineDao.id());
            }
            //noinspection ConstantConditions
            pipelineIdMap.put(pipelineDao.id(), resolvePipeline(pipeline, ruleNameMap));
        });

        final ImmutableMap<String, ThreatList> currentPipelines = pipelineIdMap.build();

        // read all stream connections of those pipelines to allow processing messages through them
        final HashMultimap<String, ThreatList> connections = HashMultimap.create();
        for (ThreatManagerConnections streamConnection : pipelineStreamConnectionsService.loadAll()) {
            streamConnection.threatListIds().stream()
                    .map(currentPipelines::get)
                    .filter(Objects::nonNull)
                    .forEach(pipeline -> connections.put(streamConnection.streamId(), pipeline));
        }
        ImmutableSetMultimap<String, ThreatList> streamPipelineConnections = ImmutableSetMultimap.copyOf(connections);

        final PipelineInterpreter.State newState = stateFactory.newState(currentPipelines, streamPipelineConnections, commonClassLoader);
        latestState.set(newState);
        return newState;
    }


    /**
     * Can be used to inspect or use the current state of the pipeline system.
     * For example, the interpreter
     * @return the currently loaded state of the updater
     */
    public PipelineInterpreter.State getLatestState() {
        return latestState.get();
    }

    @Nonnull
    private ThreatList resolvePipeline(ThreatList pipeline, Map<String, Indicator> ruleNameMap) {
        log.debug("Resolving pipeline {}", pipeline.name());

        pipeline.stages().forEach(stage -> {
            final List<Indicator> resolvedRules = stage.ruleReferences().stream()
                    .map(ref -> {
                        Indicator rule = ruleNameMap.get(ref);
                        if (rule == null) {
                            rule = Indicator.alwaysFalse("Unresolved rule " + ref);
                        }
                        // make a copy so that the metrics match up (we don't share actual objects between stages)
                        // this also makes sure we don't accidentally share state of generated code between threads
                        rule = rule.invokableCopy(functionRegistry);
                        log.debug("Resolved rule `{}` to {}", ref, rule);
                        // include back reference to stage
                        rule.registerMetrics(metricRegistry, pipeline.id(), String.valueOf(stage.stage()));
                        return rule;
                    })
                    .collect(Collectors.toList());
            stage.setRules(resolvedRules);
            stage.setPipeline(pipeline);
            stage.registerMetrics(metricRegistry, pipeline.id());
        });

        pipeline.registerMetrics(metricRegistry);
        return pipeline;
    }

    // TODO avoid reloading everything on every change, certain changes can get away with doing less work
    @Subscribe
    public void handleRuleChanges(IndicatorsChangedEvent event) {
        event.deletedRuleIds().forEach(id -> {
            log.debug("Invalidated rule {}", id);
            metricRegistry.removeMatching((name, metric) -> name.startsWith(name(Indicator.class, id)));
        });
        event.updatedRuleIds().forEach(id -> log.debug("Refreshing rule {}", id));
        scheduler.schedule(() -> serverEventBus.post(reloadAndSave()), 0, TimeUnit.SECONDS);
    }

    @Subscribe
    public void handlePipelineChanges(ThreatManagerChangedEvent event) {
        event.deletedPipelineIds().forEach(id -> {
            log.debug("Invalidated pipeline {}", id);
            metricRegistry.removeMatching((name, metric) -> name.startsWith(name(ThreatList.class, id)));
        });
        event.updatedPipelineIds().forEach(id -> log.debug("Refreshing pipeline {}", id));
        scheduler.schedule(() -> serverEventBus.post(reloadAndSave()), 0, TimeUnit.SECONDS);
    }

    @Subscribe
    public void handlePipelineConnectionChanges(ThreatManagerConnectionsChangedEvent event) {
        log.debug("Pipeline stream connection changed: {}", event);
        scheduler.schedule(() -> serverEventBus.post(reloadAndSave()), 0, TimeUnit.SECONDS);
    }

    @VisibleForTesting
    PipelineInterpreter.State reload() {
        return reloadAndSave();
    }
}
