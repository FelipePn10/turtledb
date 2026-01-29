package com.db.turtle.a_frontend.impl.parser.ast.expression;

import com.db.turtle.a_frontend.impl.parser.ast.denominator.Expression;

/**
 * Aponta para uma coluna lógica.
 * <p>
 *  Pode ser usada em expressões e ser resolvida depois pelo planner.
 *  Não acessa dados, apenas descreve intenção.
 * </p>
 * */
public class ColumnExpression implements Expression {
    public final String columnName;

    public ColumnExpression(String columnName) {
        this.columnName = columnName;
    }
}

