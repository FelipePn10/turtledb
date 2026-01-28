package com.db.turtle.parser.ast.expression.literal;


import com.db.turtle.parser.ast.denominator.Expression;

/**
 * Valor constante conhecido em tempo de compilação.
 * Exemplos: 42, "hello", true, null, 3.14
 */
public sealed interface Literal extends Expression
    permits StringLiteral, NumberLiteral, BooleanLiteral, NullLiteral{
    /**
     * Retorna o valor Java correspondente (para avaliação constante).
     */
    Object rawValue();
}
