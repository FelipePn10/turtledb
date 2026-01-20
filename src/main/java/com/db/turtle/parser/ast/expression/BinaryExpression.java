package com.db.turtle.parser.ast.expression;

/**
 * Representa operações entre duas expressões.
 * Exemplo: a + b || price > 100 || age AND active
 * Conceito: (left) operador (right)
 * @author Felipe Panosso
 * */
public class BinaryExpression implements Expression {
    public final Expression left;
    public final String operator;
    public final Expression right;

    public BinaryExpression(
            Expression left,
            String operator,
            Expression right
    ) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}
