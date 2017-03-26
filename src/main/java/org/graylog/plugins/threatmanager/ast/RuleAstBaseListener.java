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
package org.graylog.plugins.threatmanager.ast;

import org.graylog.plugins.threatmanager.ast.expressions.AdditionExpression;
import org.graylog.plugins.threatmanager.ast.expressions.AndExpression;
import org.graylog.plugins.threatmanager.ast.expressions.ArrayLiteralExpression;
import org.graylog.plugins.threatmanager.ast.expressions.BinaryExpression;
import org.graylog.plugins.threatmanager.ast.expressions.BooleanExpression;
import org.graylog.plugins.threatmanager.ast.expressions.BooleanValuedFunctionWrapper;
import org.graylog.plugins.threatmanager.ast.expressions.ComparisonExpression;
import org.graylog.plugins.threatmanager.ast.expressions.ConstantExpression;
import org.graylog.plugins.threatmanager.ast.expressions.DoubleExpression;
import org.graylog.plugins.threatmanager.ast.expressions.EqualityExpression;
import org.graylog.plugins.threatmanager.ast.expressions.Expression;
import org.graylog.plugins.threatmanager.ast.expressions.FieldAccessExpression;
import org.graylog.plugins.threatmanager.ast.expressions.FieldRefExpression;
import org.graylog.plugins.threatmanager.ast.expressions.FunctionExpression;
import org.graylog.plugins.threatmanager.ast.expressions.IndexedAccessExpression;
import org.graylog.plugins.threatmanager.ast.expressions.LogicalExpression;
import org.graylog.plugins.threatmanager.ast.expressions.LongExpression;
import org.graylog.plugins.threatmanager.ast.expressions.MapLiteralExpression;
import org.graylog.plugins.threatmanager.ast.expressions.MessageRefExpression;
import org.graylog.plugins.threatmanager.ast.expressions.MultiplicationExpression;
import org.graylog.plugins.threatmanager.ast.expressions.NotExpression;
import org.graylog.plugins.threatmanager.ast.expressions.NumericExpression;
import org.graylog.plugins.threatmanager.ast.expressions.OrExpression;
import org.graylog.plugins.threatmanager.ast.expressions.SignedExpression;
import org.graylog.plugins.threatmanager.ast.expressions.StringExpression;
import org.graylog.plugins.threatmanager.ast.expressions.UnaryExpression;
import org.graylog.plugins.threatmanager.ast.expressions.VarRefExpression;
import org.graylog.plugins.threatmanager.ast.statements.FunctionStatement;
import org.graylog.plugins.threatmanager.ast.statements.Statement;
import org.graylog.plugins.threatmanager.ast.statements.VarAssignStatement;

public class RuleAstBaseListener implements RuleAstListener {
    @Override
    public void enterRule(Indicator rule) {

    }

    @Override
    public void exitRule(Indicator rule) {

    }

    @Override
    public void enterWhen(Indicator rule) {

    }

    @Override
    public void exitWhen(Indicator rule) {

    }

    @Override
    public void enterThen(Indicator rule) {

    }

    @Override
    public void exitThen(Indicator rule) {

    }

    @Override
    public void enterStatement(Statement statement) {

    }

    @Override
    public void exitStatement(Statement statement) {

    }

    @Override
    public void enterFunctionCallStatement(FunctionStatement func) {

    }

    @Override
    public void exitFunctionCallStatement(FunctionStatement func) {

    }

    @Override
    public void enterVariableAssignStatement(VarAssignStatement assign) {

    }

    @Override
    public void exitVariableAssignStatement(VarAssignStatement assign) {

    }

    @Override
    public void enterAddition(AdditionExpression expr) {

    }

    @Override
    public void exitAddition(AdditionExpression expr) {

    }

    @Override
    public void enterAnd(AndExpression expr) {

    }

    @Override
    public void exitAnd(AndExpression expr) {

    }

    @Override
    public void enterArrayLiteral(ArrayLiteralExpression expr) {

    }

    @Override
    public void exitArrayLiteral(ArrayLiteralExpression expr) {

    }

    @Override
    public void enterBinary(BinaryExpression expr) {

    }

    @Override
    public void exitBinary(BinaryExpression expr) {

    }

    @Override
    public void enterBoolean(BooleanExpression expr) {

    }

    @Override
    public void exitBoolean(BooleanExpression expr) {

    }

    @Override
    public void enterBooleanFuncWrapper(BooleanValuedFunctionWrapper expr) {

    }

    @Override
    public void exitBooleanFuncWrapper(BooleanValuedFunctionWrapper expr) {

    }

    @Override
    public void enterComparison(ComparisonExpression expr) {

    }

    @Override
    public void exitComparison(ComparisonExpression expr) {

    }

    @Override
    public void enterConstant(ConstantExpression expr) {

    }

    @Override
    public void exitConstant(ConstantExpression expr) {

    }

    @Override
    public void enterDouble(DoubleExpression expr) {

    }

    @Override
    public void exitDouble(DoubleExpression expr) {

    }

    @Override
    public void enterEquality(EqualityExpression expr) {

    }

    @Override
    public void exitEquality(EqualityExpression expr) {

    }

    @Override
    public void enterFieldAccess(FieldAccessExpression expr) {

    }

    @Override
    public void exitFieldAccess(FieldAccessExpression expr) {

    }

    @Override
    public void enterFieldRef(FieldRefExpression expr) {

    }

    @Override
    public void exitFieldRef(FieldRefExpression expr) {

    }

    @Override
    public void enterFunctionCall(FunctionExpression expr) {

    }

    @Override
    public void exitFunctionCall(FunctionExpression expr) {

    }

    @Override
    public void enterIndexedAccess(IndexedAccessExpression expr) {

    }

    @Override
    public void exitIndexedAccess(IndexedAccessExpression expr) {

    }

    @Override
    public void enterLogical(LogicalExpression expr) {

    }

    @Override
    public void exitLogical(LogicalExpression expr) {

    }

    @Override
    public void enterLong(LongExpression expr) {

    }

    @Override
    public void exitLong(LongExpression expr) {

    }

    @Override
    public void enterMapLiteral(MapLiteralExpression expr) {

    }

    @Override
    public void exitMapLiteral(MapLiteralExpression expr) {

    }

    @Override
    public void enterMessageRef(MessageRefExpression expr) {

    }

    @Override
    public void exitMessageRef(MessageRefExpression expr) {

    }

    @Override
    public void enterMultiplication(MultiplicationExpression expr) {

    }

    @Override
    public void exitMultiplication(MultiplicationExpression expr) {

    }

    @Override
    public void enterNot(NotExpression expr) {

    }

    @Override
    public void exitNot(NotExpression expr) {

    }

    @Override
    public void enterNumeric(NumericExpression expr) {

    }

    @Override
    public void exitNumeric(NumericExpression expr) {

    }

    @Override
    public void enterOr(OrExpression expr) {

    }

    @Override
    public void exitOr(OrExpression expr) {

    }

    @Override
    public void enterSigned(SignedExpression expr) {

    }

    @Override
    public void exitSigned(SignedExpression expr) {

    }

    @Override
    public void enterString(StringExpression expr) {

    }

    @Override
    public void exitString(StringExpression expr) {

    }

    @Override
    public void enterUnary(UnaryExpression expr) {

    }

    @Override
    public void exitUnary(UnaryExpression expr) {

    }

    @Override
    public void enterVariableReference(VarRefExpression expr) {

    }

    @Override
    public void exitVariableReference(VarRefExpression expr) {

    }

    @Override
    public void enterEveryExpression(Expression expr) {

    }

    @Override
    public void exitEveryExpression(Expression expr) {

    }

    @Override
    public void enterFunctionArg(FunctionExpression functionExpression, Expression expression) {

    }

    @Override
    public void exitFunctionArg(Expression expression) {

    }
}
