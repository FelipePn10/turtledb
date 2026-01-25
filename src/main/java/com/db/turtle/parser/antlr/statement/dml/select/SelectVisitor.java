// Generated from src/main/java/com/db/turtle/parser/antlr/statement/Select.g4 by ANTLR 4.13.1

package com.db.turtle.parser.antlr.statement.dml.select;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SelectParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SelectVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SelectParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SelectParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#selectStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStatement(SelectParser.SelectStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(SelectParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(SelectParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(SelectParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(SelectParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(SelectParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#booleanTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanTerm(SelectParser.BooleanTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#booleanFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanFactor(SelectParser.BooleanFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(SelectParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(SelectParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SelectParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SelectParser.LiteralContext ctx);
}