package org.graylog.plugins.threatmanager.parser;// Generated from C:/Data/graylog-plugin-threat-manager/src/main/antlr4/org/graylog/plugins/pipelineprocessor/parser\RuleLang.g4 by ANTLR 4.6

import org.graylog.plugins.threatmanager.ast.expressions.Expression;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RuleLangParser}.
 */
public interface RuleLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(RuleLangParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(RuleLangParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#pipelineDecls}.
	 * @param ctx the parse tree
	 */
	void enterPipelineDecls(RuleLangParser.PipelineDeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#pipelineDecls}.
	 * @param ctx the parse tree
	 */
	void exitPipelineDecls(RuleLangParser.PipelineDeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void enterPipeline(RuleLangParser.PipelineContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#pipeline}.
	 * @param ctx the parse tree
	 */
	void exitPipeline(RuleLangParser.PipelineContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#pipelineDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPipelineDeclaration(RuleLangParser.PipelineDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#pipelineDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPipelineDeclaration(RuleLangParser.PipelineDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#stageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStageDeclaration(RuleLangParser.StageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#stageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStageDeclaration(RuleLangParser.StageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#ruleRef}.
	 * @param ctx the parse tree
	 */
	void enterRuleRef(RuleLangParser.RuleRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#ruleRef}.
	 * @param ctx the parse tree
	 */
	void exitRuleRef(RuleLangParser.RuleRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#ruleDecls}.
	 * @param ctx the parse tree
	 */
	void enterRuleDecls(RuleLangParser.RuleDeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#ruleDecls}.
	 * @param ctx the parse tree
	 */
	void exitRuleDecls(RuleLangParser.RuleDeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#ruleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRuleDeclaration(RuleLangParser.RuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#ruleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRuleDeclaration(RuleLangParser.RuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(RuleLangParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(RuleLangParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddition(RuleLangParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddition(RuleLangParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(RuleLangParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(RuleLangParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Func}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunc(RuleLangParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Func}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunc(RuleLangParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MessageRef}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMessageRef(RuleLangParser.MessageRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MessageRef}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMessageRef(RuleLangParser.MessageRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Nested}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNested(RuleLangParser.NestedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Nested}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNested(RuleLangParser.NestedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(RuleLangParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(RuleLangParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexedAccess}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIndexedAccess(RuleLangParser.IndexedAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexedAccess}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIndexedAccess(RuleLangParser.IndexedAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(RuleLangParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(RuleLangParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(RuleLangParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(RuleLangParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralPrimary}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralPrimary(RuleLangParser.LiteralPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralPrimary}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralPrimary(RuleLangParser.LiteralPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(RuleLangParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(RuleLangParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayLiteralExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralExpr(RuleLangParser.ArrayLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayLiteralExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralExpr(RuleLangParser.ArrayLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MapLiteralExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMapLiteralExpr(RuleLangParser.MapLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MapLiteralExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMapLiteralExpr(RuleLangParser.MapLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality(RuleLangParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality(RuleLangParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(RuleLangParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(RuleLangParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SignedExpression}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSignedExpression(RuleLangParser.SignedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SignedExpression}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSignedExpression(RuleLangParser.SignedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#propAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropAssignment(RuleLangParser.PropAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#propAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropAssignment(RuleLangParser.PropAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterFuncStmt(RuleLangParser.FuncStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitFuncStmt(RuleLangParser.FuncStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarAssignStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignStmt(RuleLangParser.VarAssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarAssignStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignStmt(RuleLangParser.VarAssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStmt(RuleLangParser.EmptyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStmt(RuleLangParser.EmptyStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link RuleLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(RuleLangParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link RuleLangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(RuleLangParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NamedArgs}
	 * labeled alternative in {@link RuleLangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterNamedArgs(RuleLangParser.NamedArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NamedArgs}
	 * labeled alternative in {@link RuleLangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitNamedArgs(RuleLangParser.NamedArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PositionalArgs}
	 * labeled alternative in {@link RuleLangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterPositionalArgs(RuleLangParser.PositionalArgsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PositionalArgs}
	 * labeled alternative in {@link RuleLangParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitPositionalArgs(RuleLangParser.PositionalArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterInteger(RuleLangParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitInteger(RuleLangParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Float}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFloat(RuleLangParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFloat(RuleLangParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Char}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterChar(RuleLangParser.CharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Char}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitChar(RuleLangParser.CharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterString(RuleLangParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitString(RuleLangParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(RuleLangParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(RuleLangParser.BooleanContext ctx);
}