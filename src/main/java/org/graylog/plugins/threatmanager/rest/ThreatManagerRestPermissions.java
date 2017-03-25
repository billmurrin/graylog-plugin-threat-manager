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

import com.google.common.collect.ImmutableSet;
import org.graylog2.plugin.security.Permission;
import org.graylog2.plugin.security.PluginPermissions;

import java.util.Collections;
import java.util.Set;

import static org.graylog2.plugin.security.Permission.create;

public class ThreatManagerRestPermissions implements PluginPermissions {

    /* pipelines */
    public static final String THREATLIST_CREATE = "threatlist:create";
    public static final String THREATLIST_READ = "threatlist:read";
    public static final String THREATLIST_EDIT = "threatlist:edit";
    public static final String THREATLIST_DELETE = "threatlist:delete";

    /* rules */
    public static final String THREAT_INDICATOR_CREATE = "threat_indicator:create";
    public static final String THREAT_INDICATOR_READ = "threat_indicator:read";
    public static final String THREAT_INDICATOR_EDIT = "threat_indicator:edit";
    public static final String THREAT_INDICATOR_DELETE = "threat_indicator:delete";

    /* connections */
    public static final String THREATLIST_CONNECTION_READ = "threatlist_connection:read";
    public static final String THREATLIST_CONNECTION_EDIT = "threatlist_connection:edit";

    @Override
    public Set<Permission> permissions() {
        return ImmutableSet.of(
                create(THREATLIST_CREATE, "Create new Threat Indicator List"),
                create(THREATLIST_READ, "Read a Threat Indicator List"),
                create(THREATLIST_EDIT, "Update a Threat Indicator List"),
                create(THREATLIST_DELETE, "Delete a Threat Indicator List"),

                create(THREAT_INDICATOR_CREATE, "Create new Threat Indicator"),
                create(THREAT_INDICATOR_READ, "Read a Threat Indicator"),
                create(THREAT_INDICATOR_EDIT, "Update a Threat Indicator"),
                create(THREAT_INDICATOR_DELETE, "Delete a Threat Indicator"),

                create(THREATLIST_CONNECTION_READ, "Read a Indicator List stream connection"),
                create(THREATLIST_CONNECTION_EDIT, "Update a Indicator List stream connections")
                );
    }

    @Override
    public Set<Permission> readerBasePermissions() {
        return Collections.emptySet();
    }
}
