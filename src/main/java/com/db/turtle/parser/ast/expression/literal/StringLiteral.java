package com.db.turtle.parser.ast.expression.literal;

/**
 * String literal: 'hello world', 'O''Brien'
 * Nota: o conteúdo já vem sem as aspas da gramática ANTLR
 */
public record StringLiteral(String value) implements Literal {
    public StringLiteral{
        if (value == null) {
            throw new IllegalArgumentException("" +
                    "StringLiteral cannot be null. Use NullLiteral instead.");
        }
    }

    @Override
    public Object rawValue() {
        return value;
    }

    @Override
    public String toString() {
        return "'" + value.replace("'", "''") + "'";
    }
}
