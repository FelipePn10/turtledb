package com.db.turtle.a_frontend.impl.parser.ast.expression.literal;

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
