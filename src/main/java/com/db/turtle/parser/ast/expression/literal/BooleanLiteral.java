package com.db.turtle.parser.ast.expression.literal;

/**
 * Boolean literal: TRUE | FALSE
 * SQL padroniza booleanos, diferente de Java que aceita 0/1
 */
public enum BooleanLiteral implements Literal {
    TRUE, FALSE;

    @Override
    public Object rawValue() {
        return this == TRUE;
    }

    @Override
    public String toString() {
        return name();
    }
}
