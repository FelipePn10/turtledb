package com.db.turtle.a_frontend.impl.parser.ast.ntm.types;

public class BigIntType extends DataType{
    public BigIntType() {
        super("BIGINT");
    }

    @Override
    public String toString() {
        return "BIGINT";
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
