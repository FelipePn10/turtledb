package com.db.turtle.parser.ast.ntm.types;

import java.util.Objects;

public class CharType extends DataType{
    private final int size;

    public CharType(int size) {
        super("CHAR");
        if (size <= 0) {
            throw new IllegalArgumentException("CHAR size must be positive");
        }
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "CHAR(" + size + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharType that = (CharType) o;
        return size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeName(), size);
    }
}
