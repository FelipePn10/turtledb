package com.db.turtle.parser.ast.ntm.types;

public class IntegerType extends DataType{
    public IntegerType() {
        super("INTEGER");
    }

    @Override
    public String toString() {
        return "INTEGER";
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
