// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/drop/table/DropTable.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.table;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link DropTableVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class DropTableBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements DropTableVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStatement(DropTableParser.StatementContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitDropTable(DropTableParser.DropTableContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitTableName(DropTableParser.TableNameContext ctx) { return visitChildren(ctx); }
}