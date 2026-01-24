package com.db.turtle.parser.ast.ntm.types;

import java.util.Objects;

public class VarcharType extends DataType {
    private final int size;

    public VarcharType(int size) {
        super("VARCHAR");
        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than 0");
        }
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "VARCHAR(" + size + ")";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarcharType that = (VarcharType) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeName(), size);
    }

}
