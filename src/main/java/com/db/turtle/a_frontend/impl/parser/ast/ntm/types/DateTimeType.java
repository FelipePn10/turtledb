package com.db.turtle.a_frontend.impl.parser.ast.ntm.types;

public class DateTimeType extends DataType{
    public DateTimeType() {
        super("DATETIME");
    }

    @Override
    public String toString() {
        return "DATETIME";
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
