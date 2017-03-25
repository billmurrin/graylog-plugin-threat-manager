package org.graylog.plugins.threatmanager.db.memory;

import org.graylog.plugins.threatmanager.db.ThreatManagerService;
import org.graylog.plugins.threatmanager.db.ThreatManagerStreamConnectionsService;
import org.graylog.plugins.threatmanager.db.IndicatorService;
import org.graylog2.plugin.PluginModule;

public class InMemoryServicesModule extends PluginModule {
    @Override
    protected void configure() {
        bind(IndicatorService.class).to(InMemoryIndicatorService.class).asEagerSingleton();
        bind(ThreatManagerService.class).to(InMemoryThreatManagerService.class).asEagerSingleton();
        bind(ThreatManagerStreamConnectionsService.class).to(InMemoryThreatManagerStreamConnectionsService.class).asEagerSingleton();
    }
}
