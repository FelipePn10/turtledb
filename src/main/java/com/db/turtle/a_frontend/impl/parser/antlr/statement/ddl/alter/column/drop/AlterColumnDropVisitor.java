// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/column/drop/AlterColumnDrop.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.drop;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlterColumnDropParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlterColumnDropVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlterColumnDropParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AlterColumnDropParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterColumnDropParser#alterColumnDrop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumnDrop(AlterColumnDropParser.AlterColumnDropContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterColumnDropParser#dropColumnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropColumnClause(AlterColumnDropParser.DropColumnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterColumnDropParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(AlterColumnDropParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterColumnDropParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(AlterColumnDropParser.ColumnNameContext ctx);
}