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
package org.graylog.plugins.threatmanager.ast.expressions;

import org.antlr.v4.runtime.Token;
import org.graylog.plugins.threatmanager.EvaluationContext;

public class StringExpression extends ConstantExpression {

    private final String value;

    public StringExpression(Token start, String value) {
        super(start, String.class);
        this.value = value;
    }

    @Override
    public Object evaluateUnsafe(EvaluationContext context) {
        return value;
    }

    @Override
    public String toString() {
        return '"' + value + '"';
    }
}
