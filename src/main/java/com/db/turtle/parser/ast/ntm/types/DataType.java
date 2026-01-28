package com.db.turtle.parser.ast.ntm.types;

import com.db.turtle.parser.ast.denominator.AstNode;

/**
 * Representa o tipo de dado de uma determinada coluna.
 * */
public abstract class DataType implements AstNode {
    private final String typeName;

    protected DataType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public abstract String toString();
}
