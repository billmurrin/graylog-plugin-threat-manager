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
import org.graylog.plugins.threatmanager.db.IndicatorDao;
import org.graylog.plugins.threatmanager.parser.ParseException;
import org.graylog.plugins.threatmanager.parser.PipelineRuleParser;
import org.graylog.plugins.threatmanager.parser.errors.ParseError;
import org.joda.time.DateTime;
import org.mongojack.Id;
import org.mongojack.ObjectId;

import javax.annotation.Nullable;
import java.util.Set;

@AutoValue
@JsonAutoDetect
public abstract class IndicatorSource {

    @JsonProperty("id")
    @Nullable
    @Id
    @ObjectId
    public abstract String id();

    @JsonProperty
    @Nullable
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

    @JsonProperty
    @Nullable
    public abstract Set<ParseError> errors();

    public static Builder builder() {
        return new AutoValue_IndicatorSource.Builder();
    }

    public abstract Builder toBuilder();

    @JsonCreator
    public static IndicatorSource create(@JsonProperty("id") @Id @ObjectId @Nullable String id,
                                    @JsonProperty("name") String name,
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

    public static IndicatorSource fromDao(PipelineRuleParser parser, IndicatorDao dao) {
        Set<ParseError> errors = null;
        try {
            parser.parseRule(dao.id(), dao.source(), false);

        } catch (ParseException e) {
            errors = e.getErrors();
        }

        return builder()
                .id(dao.id())
                .source(dao.source())
                .name(dao.name())
                .comment(dao.comment())
                .reporting(dao.reporting())
                .createdAt(dao.createdAt())
                .modifiedAt(dao.modifiedAt())
                .errors(errors)
                .build();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract IndicatorSource build();

        public abstract Builder id(String id);

        public abstract Builder name(String name);

        public abstract Builder comment(String comment);

        public abstract Builder source(String source);

        public abstract Builder reporting(String reporting);

        public abstract Builder createdAt(DateTime createdAt);

        public abstract Builder modifiedAt(DateTime modifiedAt);

        public abstract Builder errors(Set<ParseError> errors);
    }
}


