package com.db.turtle.parser.ast.expression.literal;

public enum NullLiteral implements Literal {
    INSTANCE;


    @Override
    public Object rawValue() {
        return null;
    }

    @Override
    public String toString() {
        return "NULL";
    }
}
