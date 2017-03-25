/**
 * This file is part of Graylog Threat Manager.
 *
 * Graylog Threat Manager is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog Threat Manager is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog Threat Manager.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.plugins.threatmanager.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.Sets;

import java.util.Set;

import static java.util.Collections.emptySet;

@AutoValue
public abstract class ThreatManagerChangedEvent {

    @JsonProperty
    public abstract Set<String> deletedPipelineIds();

    @JsonProperty
    public abstract Set<String> updatedPipelineIds();

    public static Builder builder() {
        return new AutoValue_ThreatManagerChangedEvent.Builder().deletedPipelineIds(emptySet()).updatedPipelineIds(emptySet());
    }

    public static ThreatManagerChangedEvent updatedPipelineId(String id) {
        return builder().updatedPipelineId(id).build();
    }

    public static ThreatManagerChangedEvent deletedPipelineId(String id) {
        return builder().deletedPipelineId(id).build();
    }

    @JsonCreator
    public static ThreatManagerChangedEvent create(@JsonProperty("deleted_pipeline_ids") Set<String> deletedIds, @JsonProperty("updated_pipeline_ids") Set<String> updatedIds) {
        return builder().deletedPipelineIds(deletedIds).updatedPipelineIds(updatedIds).build();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder deletedPipelineIds(Set<String> ids);
        public Builder deletedPipelineId(String id) {
            return deletedPipelineIds(Sets.newHashSet(id));
        }
        public abstract Builder updatedPipelineIds(Set<String> ids);
        public Builder updatedPipelineId(String id) {
            return updatedPipelineIds(Sets.newHashSet(id));
        }
        public abstract ThreatManagerChangedEvent build();
    }
}
