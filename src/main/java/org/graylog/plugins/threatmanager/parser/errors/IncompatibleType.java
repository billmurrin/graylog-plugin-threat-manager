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
package org.graylog.plugins.threatmanager.parser.errors;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.graylog.plugins.threatmanager.parser.RuleLangParser;

public class IncompatibleType extends ParseError {
    private final Class<?> expected;
    private final Class<?> actual;

    public IncompatibleType(RuleLangParser.MessageRefContext ctx, Class<?> expected, Class<?> actual) {
        super("incompatible_type", ctx);
        this.expected = expected;
        this.actual = actual;
    }

    @JsonProperty("reason")
    @Override
    public String toString() {
        return "Expected type " + expected.getSimpleName() + " but found " + actual.getSimpleName() + positionString();
    }
}
