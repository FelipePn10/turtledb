package com.db.turtle.a_frontend.impl.parser.ast.ntm.types;

public class BooleanType extends DataType{
    public BooleanType() {
        super("BOOLEAN");
    }

    @Override
    public String toString() {
        return "BOOLEAN";
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
