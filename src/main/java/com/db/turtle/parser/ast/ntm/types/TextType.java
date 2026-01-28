package com.db.turtle.parser.ast.ntm.types;

public class TextType extends DataType{
    public TextType() {
        super("TEXT");
    }

    @Override
    public String toString() {
        return "TEXT";
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
