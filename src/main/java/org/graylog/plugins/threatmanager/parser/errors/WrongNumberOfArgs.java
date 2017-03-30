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
import org.graylog.plugins.threatmanager.ast.functions.Function;
import org.graylog.plugins.threatmanager.ast.functions.ParameterDescriptor;
import org.graylog.plugins.threatmanager.parser.RuleLangParser;

import java.util.function.Predicate;

public class WrongNumberOfArgs extends ParseError {
    private final Function<?> function;
    private final int argCount;

    public WrongNumberOfArgs(RuleLangParser.FunctionCallContext ctx,
                             Function<?> function,
                             int argCount) {
        super("wrong_number_of_arguments", ctx);
        this.function = function;
        this.argCount = argCount;
    }

    @JsonProperty("reason")
    @Override
    public String toString() {
        final Predicate<ParameterDescriptor> optional = ParameterDescriptor::optional;
        return "Expected " + function.descriptor().params().stream().filter(optional.negate()).count() +
                " arguments but found " + argCount +
                " in call to function " + function.descriptor().name()
                + positionString();
    }
}
