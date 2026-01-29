package com.db.turtle.a_frontend.impl.parser.ast.expression;

import com.db.turtle.a_frontend.impl.parser.ast.denominator.Expression;

/**
 * Representa operações entre duas expressões.
 * Exemplo: a + b || price > 100 || age AND active
 * Conceito: (left) operador (right)
 * @author Felipe Panosso
 * */
public class BinaryExpression implements Expression {
    public final Expression left;
    public final ComparisonOperator operator;
    public final Expression right;

    public BinaryExpression(
            Expression left,
            ComparisonOperator operator,
            Expression right
    ) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}
