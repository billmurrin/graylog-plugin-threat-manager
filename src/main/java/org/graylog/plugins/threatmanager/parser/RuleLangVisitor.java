package org.graylog.plugins.threatmanager.parser;// Generated from C:/Data/graylog-plugin-threat-manager/src/main/antlr4/org/graylog/plugins/pipelineprocessor/parser\RuleLang.g4 by ANTLR 4.6

import org.graylog.plugins.threatmanager.ast.expressions.Expression;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RuleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RuleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(RuleLangParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#pipelineDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelineDecls(RuleLangParser.PipelineDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#pipeline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeline(RuleLangParser.PipelineContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#pipelineDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipelineDeclaration(RuleLangParser.PipelineDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#stageDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStageDeclaration(RuleLangParser.StageDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#ruleRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleRef(RuleLangParser.RuleRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#ruleDecls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleDecls(RuleLangParser.RuleDeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#ruleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleDeclaration(RuleLangParser.RuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(RuleLangParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(RuleLangParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(RuleLangParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Func}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(RuleLangParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MessageRef}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageRef(RuleLangParser.MessageRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Nested}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested(RuleLangParser.NestedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(RuleLangParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexedAccess}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexedAccess(RuleLangParser.IndexedAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(RuleLangParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(RuleLangParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralPrimary}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralPrimary(RuleLangParser.LiteralPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(RuleLangParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLiteralExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralExpr(RuleLangParser.ArrayLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MapLiteralExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapLiteralExpr(RuleLangParser.MapLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(RuleLangParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(RuleLangParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SignedExpression}
	 * labeled alternative in {@link RuleLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedExpression(RuleLangParser.SignedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#propAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropAssignment(RuleLangParser.PropAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncStmt(RuleLangParser.FuncStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarAssignStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignStmt(RuleLangParser.VarAssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyStmt}
	 * labeled alternative in {@link RuleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(RuleLangParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link RuleLangParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(RuleLangParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NamedArgs}
	 * labeled alternative in {@link RuleLangParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArgs(RuleLangParser.NamedArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PositionalArgs}
	 * labeled alternative in {@link RuleLangParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionalArgs(RuleLangParser.PositionalArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(RuleLangParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(RuleLangParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Char}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar(RuleLangParser.CharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(RuleLangParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link RuleLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(RuleLangParser.BooleanContext ctx);
}