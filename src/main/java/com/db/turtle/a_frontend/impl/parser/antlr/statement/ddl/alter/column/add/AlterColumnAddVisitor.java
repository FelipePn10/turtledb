// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/column/add/AlterColumnAdd.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.add;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlterColumnAddParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlterColumnAddVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlterColumnAddParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(AlterColumnAddParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterColumnAddParser#alterColumnAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlterColumnAdd(AlterColumnAddParser.AlterColumnAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterColumnAddParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(AlterColumnAddParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterColumnAddParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(AlterColumnAddParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlterColumnAddParser#columnConstraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnConstraints(AlterColumnAddParser.ColumnConstraintsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notNullConstraint}
	 * labeled alternative in {@link AlterColumnAddParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotNullConstraint(AlterColumnAddParser.NotNullConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullConstraint}
	 * labeled alternative in {@link AlterColumnAddParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullConstraint(AlterColumnAddParser.NullConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryKeyConstraint}
	 * labeled alternative in {@link AlterColumnAddParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryKeyConstraint(AlterColumnAddParser.PrimaryKeyConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniqueConstraint}
	 * labeled alternative in {@link AlterColumnAddParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueConstraint(AlterColumnAddParser.UniqueConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code autoIncrementConstraint}
	 * labeled alternative in {@link AlterColumnAddParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoIncrementConstraint(AlterColumnAddParser.AutoIncrementConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultConstraint}
	 * labeled alternative in {@link AlterColumnAddParser#columnConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultConstraint(AlterColumnAddParser.DefaultConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDefault}
	 * labeled alternative in {@link AlterColumnAddParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDefault(AlterColumnAddParser.IntDefaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalDefault}
	 * labeled alternative in {@link AlterColumnAddParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalDefault(AlterColumnAddParser.DecimalDefaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringDefault}
	 * labeled alternative in {@link AlterColumnAddParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDefault(AlterColumnAddParser.StringDefaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullDefault}
	 * labeled alternative in {@link AlterColumnAddParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullDefault(AlterColumnAddParser.NullDefaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueDefault}
	 * labeled alternative in {@link AlterColumnAddParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueDefault(AlterColumnAddParser.TrueDefaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseDefault}
	 * labeled alternative in {@link AlterColumnAddParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseDefault(AlterColumnAddParser.FalseDefaultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varcharType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarcharType(AlterColumnAddParser.VarcharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharType(AlterColumnAddParser.CharTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(AlterColumnAddParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerType(AlterColumnAddParser.IntegerTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bigintType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBigintType(AlterColumnAddParser.BigintTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalType(AlterColumnAddParser.DecimalTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatType(AlterColumnAddParser.FloatTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleType(AlterColumnAddParser.DoubleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dateType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateType(AlterColumnAddParser.DateTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code datetimeType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatetimeType(AlterColumnAddParser.DatetimeTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timestampType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimestampType(AlterColumnAddParser.TimestampTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextType(AlterColumnAddParser.TextTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link AlterColumnAddParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(AlterColumnAddParser.BooleanTypeContext ctx);
}