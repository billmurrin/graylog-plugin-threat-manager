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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.Set;

@AutoValue
@JsonAutoDetect
public abstract class ThreatManagerReverseConnections {
    @JsonProperty
    public abstract String threatListId();

    @JsonProperty
    public abstract Set<String> streamIds();

    @JsonCreator
    public static ThreatManagerReverseConnections create(@JsonProperty("threatlist_id") String threatListId,
                                                    @JsonProperty("stream_ids") Set<String> streamIds) {
        return new AutoValue_ThreatManagerReverseConnections(threatListId, streamIds);
    }
}
