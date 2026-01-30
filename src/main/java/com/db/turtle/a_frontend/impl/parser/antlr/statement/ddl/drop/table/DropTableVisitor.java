// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/drop/table/DropTable.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.table;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DropTableParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DropTableVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DropTableParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DropTableParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DropTableParser#dropTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTable(DropTableParser.DropTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link DropTableParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(DropTableParser.TableNameContext ctx);
}