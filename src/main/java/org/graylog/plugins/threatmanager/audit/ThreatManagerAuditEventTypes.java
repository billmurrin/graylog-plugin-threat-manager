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
package org.graylog.plugins.threatmanager.audit;

import com.google.common.collect.ImmutableSet;
import org.graylog2.audit.PluginAuditEventTypes;

import java.util.Set;

public class ThreatManagerAuditEventTypes implements PluginAuditEventTypes {
    private static final String NAMESPACE = "threat_manager:";

    public static final String THREATLIST_CONNECTION_UPDATE = NAMESPACE + "threatlist_connection:update";
    public static final String THREATLIST_CREATE = NAMESPACE + "threatlist:create";
    public static final String THREATLIST_UPDATE = NAMESPACE + "threatlist:update";
    public static final String THREATLIST_DELETE = NAMESPACE + "threatlist:delete";
    public static final String THREAT_INDICATOR_CREATE = NAMESPACE + "threat_indicator:create";
    public static final String THREAT_INDICATOR_UPDATE = NAMESPACE + "threat_indicator:update";
    public static final String THREAT_INDICATOR_DELETE = NAMESPACE + "threat_indicator:delete";

    private static final Set<String> EVENT_TYPES = ImmutableSet.<String>builder()
            .add(THREATLIST_CONNECTION_UPDATE)
            .add(THREATLIST_CREATE)
            .add(THREATLIST_UPDATE)
            .add(THREATLIST_DELETE)
            .add(THREAT_INDICATOR_CREATE)
            .add(THREAT_INDICATOR_UPDATE)
            .add(THREAT_INDICATOR_DELETE)
            .build();

    @Override
    public Set<String> auditEventTypes() {
        return EVENT_TYPES;
    }
}
