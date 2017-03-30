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
package org.graylog.plugins.threatmanager.db;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.joda.time.DateTime;
import org.mongojack.Id;
import org.mongojack.ObjectId;

import javax.annotation.Nullable;

@AutoValue
public abstract class IndicatorDao {

    @JsonProperty("id")
    @Nullable
    @Id
    @ObjectId
    public abstract String id();

    @JsonProperty
    public abstract String name();

    @JsonProperty
    @Nullable
    public abstract String comment();

    @JsonProperty
    public abstract String source();

    @JsonProperty
    @Nullable
    public abstract String reporting();

    @JsonProperty
    @Nullable
    public abstract DateTime createdAt();

    @JsonProperty
    @Nullable
    public abstract DateTime modifiedAt();

    public static Builder builder() {
        return new AutoValue_IndicatorDao.Builder();
    }

    public abstract Builder toBuilder();

    @JsonCreator
    public static IndicatorDao create(@Id @ObjectId @JsonProperty("_id") @Nullable String id,
                                    @JsonProperty("name")  String name,
                                    @JsonProperty("comment") @Nullable String comment,
                                    @JsonProperty("source") String source,
                                    @JsonProperty("reporting") String reporting,
                                    @JsonProperty("created_at") @Nullable DateTime createdAt,
                                    @JsonProperty("modified_at") @Nullable DateTime modifiedAt) {
        return builder()
                .id(id)
                .source(source)
                .name(name)
                .comment(comment)
                .reporting(reporting)
                .createdAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract IndicatorDao build();

        public abstract Builder id(String id);

        public abstract Builder name(String name);

        public abstract Builder comment(String comment);

        public abstract Builder source(String source);

        public abstract Builder reporting(String reporting);

        public abstract Builder createdAt(DateTime createdAt);

        public abstract Builder modifiedAt(DateTime modifiedAt);
    }
}
