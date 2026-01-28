package com.db.turtle.parser.ast.expression.literal;

import java.math.BigDecimal;

/**
 * Número literal: 42, 3.14, 1e10
 * Usa BigDecimal internamente para preservar precisão SQL (DECIMAL)
 */
public record NumberLiteral(BigDecimal value) implements Literal {
    public NumberLiteral(String text) {
        this(new BigDecimal(text));
    }
    @Override
    public Object rawValue() {
        return value;
    }

    public boolean isInteger() {
        return value.scale() == 0;
    }

    @Override
    public String toString() {
        return value.toPlainString();
    }
}
