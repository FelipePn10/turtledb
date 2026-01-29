package com.db.turtle.a_frontend.impl.parser.ast.expression;

import com.db.turtle.a_frontend.common.denominator.B_Expression;

/**
 * Representa operações entre duas expressões.
 * Exemplo: a + b || price > 100 || age AND active
 * Conceito: (left) operador (right)
 * @author Felipe Panosso
 * */
public class BinaryExpression implements B_Expression {
    public final B_Expression left;
    public final ComparisonOperator operator;
    public final B_Expression right;

    public BinaryExpression(
            B_Expression left,
            ComparisonOperator operator,
            B_Expression right
    ) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}
