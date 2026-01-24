package com.db.turtle.parser.ast.ntm.types;

/**
 * Representa o tipo de dado de uma determinada coluna.
 * */
public abstract class DataType {
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
