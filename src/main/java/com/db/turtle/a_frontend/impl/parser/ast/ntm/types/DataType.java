package com.db.turtle.a_frontend.impl.parser.ast.ntm.types;

import com.db.turtle.a_frontend.common.denominator.A_AstNode;

/**
 * Representa o tipo de dado de uma determinada coluna.
 * */
public abstract class DataType implements A_AstNode {
    private final String typeName;

    protected DataType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean isNumeric() {
        return false;
    }

    @Override
    public abstract String toString();
}
