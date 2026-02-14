package com.db.turtle.a_frontend.impl.parser.ast.ntm.types;

public class DoubleType extends DataType{
    public DoubleType() {
        super("DOUBLE");
    }

    @Override
    public boolean isNumeric() {
        return true;
    }

    @Override
    public String toString() {
        return "DOUBLE";
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
