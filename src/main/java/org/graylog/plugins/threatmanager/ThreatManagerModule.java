package org.graylog.plugins.threatmanager;

import org.graylog2.plugin.PluginModule;
import org.graylog.plugins.threatmanager.widget.strategy.QuickValuesPlusWidgetStrategy;

/**
 * Extend the PluginModule abstract class here to add you plugin to the system.
 */
public class ThreatManagerModule extends PluginModule {
    @Override
    protected void configure() {
        addWidgetStrategy(ThreatManagerStrategy.class, ThreatManagerStrategy.Factory.class);
    }
}