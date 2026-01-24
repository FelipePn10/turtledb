package com.db.turtle.parser.ast.ntm.types;

public class IntType extends DataType {
    public IntType() {
        super("INT");
    }

    @Override
    public String toString() {
        return "INT";
    }

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return getTypeName().hashCode();
    }
}
