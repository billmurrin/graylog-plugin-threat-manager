/**
 * This file is part of Graylog Pipeline Processor.
 *
 * Graylog Pipeline Processor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog Pipeline Processor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog Pipeline Processor.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.plugins.threatmanager.rest;

import com.google.common.eventbus.EventBus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.graylog.plugins.threatmanager.ast.Indicator;
import org.graylog.plugins.threatmanager.ast.functions.Function;
import org.graylog.plugins.threatmanager.audit.ThreatManagerAuditEventTypes;
import org.graylog.plugins.threatmanager.db.IndicatorDao;
import org.graylog.plugins.threatmanager.db.IndicatorService;
import org.graylog.plugins.threatmanager.events.IndicatorsChangedEvent;
import org.graylog.plugins.threatmanager.parser.FunctionRegistry;
import org.graylog.plugins.threatmanager.parser.ParseException;
import org.graylog.plugins.threatmanager.parser.PipelineRuleParser;
import org.graylog2.audit.jersey.AuditEvent;
import org.graylog2.audit.jersey.NoAuditEvent;
import org.graylog2.database.NotFoundException;
import org.graylog2.events.ClusterEventBus;
import org.graylog2.plugin.rest.PluginRestResource;
import org.graylog2.shared.rest.resources.RestResource;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.stream.Collectors;

@Api(value = "ThreatManager/Indicators", description = "Threat Indicators")
@Path("/system/threatmanager/indicator")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequiresAuthentication
public class
IndicatorResource extends RestResource implements PluginRestResource {

    private static final Logger log = LoggerFactory.getLogger(IndicatorResource.class);

    private final IndicatorService ruleService;
    private final PipelineRuleParser pipelineRuleParser;
    private final EventBus clusterBus;
    private final FunctionRegistry functionRegistry;

    @Inject
    public IndicatorResource(IndicatorService ruleService,
                        PipelineRuleParser pipelineRuleParser,
                        ClusterEventBus clusterBus,
                        FunctionRegistry functionRegistry) {
        this.ruleService = ruleService;
        this.pipelineRuleParser = pipelineRuleParser;
        this.clusterBus = clusterBus;
        this.functionRegistry = functionRegistry;
    }


    @ApiOperation(value = "Create a threat indicator from source", notes = "")
    @POST
    @RequiresPermissions(ThreatManagerRestPermissions.THREAT_INDICATOR_CREATE)
    @AuditEvent(type = ThreatManagerAuditEventTypes.THREAT_INDICATOR_CREATE)
    public IndicatorSource createFromParser(@ApiParam(name = "indicator", required = true) @NotNull IndicatorSource ruleSource) throws ParseException {
        final Indicator indicator;
        try {
            indicator = pipelineRuleParser.parseRule(ruleSource.id(), ruleSource.source(), false);
        } catch (ParseException e) {
            throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).entity(e.getErrors()).build());
        }
        final IndicatorDao newRuleSource = IndicatorDao.builder()
                .name(indicator.name()) // use the name from the parsed rule source.
                .comment(ruleSource.comment())
                .source(ruleSource.source())
                .reporting(ruleSource.reporting())
                .createdAt(DateTime.now())
                .modifiedAt(DateTime.now())
                .build();
        final IndicatorDao save = ruleService.save(newRuleSource);
        // TODO determine which pipelines could change because of this new rule (there could be pipelines referring to a previously unresolved rule)
        clusterBus.post(IndicatorsChangedEvent.updatedRuleId(save.id()));
        log.debug("Created new indicator {}", save);
        return IndicatorSource.fromDao(pipelineRuleParser, save);
    }

    @ApiOperation(value = "Get all indicators")
    @GET
    @RequiresPermissions(ThreatManagerRestPermissions.THREAT_INDICATOR_READ)
    public Collection<IndicatorSource> getAll() {
        final Collection<IndicatorDao> ruleDaos = ruleService.loadAll();
        return ruleDaos.stream()
                .map(ruleDao -> IndicatorSource.fromDao(pipelineRuleParser, ruleDao))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Get a threat indicator", notes = "It can take up to a second until the change is applied")
    @Path("/{id}")
    @GET
    public IndicatorSource get(@ApiParam(name = "id") @PathParam("id") String id) throws NotFoundException {
        checkPermission(ThreatManagerRestPermissions.THREAT_INDICATOR_READ, id);
        return IndicatorSource.fromDao(pipelineRuleParser, ruleService.load(id));
    }

    @ApiOperation("Retrieve the threat indicators in bulk")
    @Path("/multiple")
    @POST
    @NoAuditEvent("only used to get multiple indicators")
    public Collection<IndicatorSource> getBulk(@ApiParam("indicators") BulkIndicatorRequest indicators) {
        Collection<IndicatorDao> ruleDaos = ruleService.loadNamed(indicators.indicators());

        return ruleDaos.stream()
                .map(ruleDao -> IndicatorSource.fromDao(pipelineRuleParser, ruleDao))
                .filter(rule -> isPermitted(ThreatManagerRestPermissions.THREAT_INDICATOR_READ, rule.id()))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Modify an indicator", notes = "It can take up to a second until the change is applied")
    @Path("/{id}")
    @PUT
    @AuditEvent(type = ThreatManagerAuditEventTypes.THREAT_INDICATOR_UPDATE)
    public IndicatorSource update(@ApiParam(name = "id") @PathParam("id") String id,
                             @ApiParam(name = "rule", required = true) @NotNull IndicatorSource update) throws NotFoundException {
        checkPermission(ThreatManagerRestPermissions.THREAT_INDICATOR_EDIT, id);

        final IndicatorDao ruleDao = ruleService.load(id);
        final Indicator rule;
        try {
            rule = pipelineRuleParser.parseRule(id, update.source(), false);
        } catch (ParseException e) {
            throw new BadRequestException(Response.status(Response.Status.BAD_REQUEST).entity(e.getErrors()).build());
        }
        final IndicatorDao toSave = ruleDao.toBuilder()
                .name(rule.name())
                .comment(update.comment())
                .source(update.source())
                .reporting(update.reporting())
                .modifiedAt(DateTime.now())
                .build();
        final IndicatorDao savedRule = ruleService.save(toSave);

        // TODO determine which pipelines could change because of this updated rule
        clusterBus.post(IndicatorsChangedEvent.updatedRuleId(savedRule.id()));

        return IndicatorSource.fromDao(pipelineRuleParser, savedRule);
    }

    @ApiOperation(value = "Delete an indicator", notes = "It can take up to a second until the change is applied")
    @Path("/{id}")
    @DELETE
    @AuditEvent(type = ThreatManagerAuditEventTypes.THREAT_INDICATOR_DELETE)
    public void delete(@ApiParam(name = "id") @PathParam("id") String id) throws NotFoundException {
        checkPermission(ThreatManagerRestPermissions.THREAT_INDICATOR_DELETE, id);
        ruleService.load(id);
        ruleService.delete(id);

        // TODO determine which pipelines could change because of this deleted rule, causing them to recompile
        clusterBus.post(IndicatorsChangedEvent.deletedRuleId(id));
    }


    @ApiOperation("Get function descriptors")
    @Path("/functions")
    @GET
    public Collection<Object> functionDescriptors() {
        return functionRegistry.all().stream()
                .map(Function::descriptor)
                .collect(Collectors.toList());
    }

}
