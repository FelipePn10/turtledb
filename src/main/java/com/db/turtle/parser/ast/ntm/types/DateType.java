package com.db.turtle.parser.ast.ntm.types;

public class DateType extends DataType{

    public DateType() {
        super("DATE");
    }

    @Override
    public String toString() {
        return "DATE";
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
