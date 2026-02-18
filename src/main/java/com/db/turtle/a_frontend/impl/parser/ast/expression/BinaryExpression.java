package com.db.turtle.a_frontend.impl.parser.ast.expression;

import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.common.denominator.E_BinaryOperator;

/**
 * Representa operações entre duas expressões.
 * Exemplo: a + b || price > 100 || age AND active
 * Conceito: (left) operador (right)
 * */
public class BinaryExpression implements B_Expression {
    public final B_Expression left;
    public final E_BinaryOperator operator;
    public final B_Expression right;

    public BinaryExpression(
            B_Expression left,
            E_BinaryOperator operator,
            B_Expression right
    ) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}
