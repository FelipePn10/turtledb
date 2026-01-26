package com.db.turtle.parser.ast.ntm.types;

public class FloatType extends DataType{
    public FloatType() {
        super("FLOAT");
    }

    @Override
    public String toString() {
        return "FLOAT";
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
