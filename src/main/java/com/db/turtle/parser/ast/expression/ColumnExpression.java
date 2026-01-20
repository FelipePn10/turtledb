package com.db.turtle.parser.ast.expression;

/**
 * Aponta para uma coluna lógica.
 * Pode ser usada em expressões e ser resolvida depois pelo planner.
 * Não acessa dados, apenas descreve intenção.
 *
 * @author Felipe Panosso
 * */
public class ColumnExpression implements Expression {
    public final String columnName;

    public ColumnExpression(String columnName) {
        this.columnName = columnName;
    }
}

