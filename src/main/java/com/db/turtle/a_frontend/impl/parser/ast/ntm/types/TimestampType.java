package com.db.turtle.a_frontend.impl.parser.ast.ntm.types;

public class TimestampType extends DataType{
    public TimestampType() {
        super("TIMESTAMP");
    }

    @Override
    public String toString() {
        return "TIMESTAMP";
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
