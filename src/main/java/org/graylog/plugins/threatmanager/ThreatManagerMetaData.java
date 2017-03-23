package org.graylog.plugins.threatmanager;

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.ServerStatus;
import org.graylog2.plugin.Version;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

/**
 * Implement the PluginMetaData interface here.
 */
public class ThreatManagerMetaData implements PluginMetaData {
    private static final String PLUGIN_PROPERTIES = "org.graylog.plugins.graylog-plugin-threatmanager/graylog-plugin.properties";

    @Override
    public String getUniqueId() {
        return "org.graylog.plugins.threatmanager.ThreatManagerPlugin";
    }

    @Override
    public String getName() {
        return "ThreatManager";
    }

    @Override
    public String getAuthor() {
        return "Bill Murrin <bill@billmurrin.com>";
    }

    @Override
    public URI getURL() {
        return URI.create("https://github.com/billmurrin/graylog-plugin-threat-manager");
    }

    @Override
    public Version getVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "version", Version.from(0, 0, 0, "unknown"));
    }

    @Override
    public String getDescription() {
        // TODO Insert correct plugin description
        return "The Threat Manager plugin provides a graphical interface for manager threat indicators.";
    }

    @Override
    public Version getRequiredVersion() {
        return Version.fromPluginProperties(getClass(), PLUGIN_PROPERTIES, "graylog.version", Version.from(0, 0, 0, "unknown"));
    }

    @Override
    public Set<ServerStatus.Capability> getRequiredCapabilities() {
        return Collections.emptySet();
    }
}
