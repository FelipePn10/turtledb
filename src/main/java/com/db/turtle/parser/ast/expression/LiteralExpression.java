package com.db.turtle.parser.ast.expression;


import com.db.turtle.parser.ast.denominator.Expression;

/**
 * Representa valores constantes vindos da query
 * Exemplo: 10 || "Felipe" || true
 * @author Felipe Panosso
 * */
public class LiteralExpression implements Expression {
    public final Object value;

    public LiteralExpression(
            Object value
    ) {
        this.value = value;
    }
}
