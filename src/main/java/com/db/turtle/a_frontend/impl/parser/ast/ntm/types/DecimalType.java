package com.db.turtle.a_frontend.impl.parser.ast.ntm.types;

import java.util.Objects;

public class DecimalType extends DataType {
    private final int precision;
    private final Integer scale;

    public DecimalType(int precision, Integer scale) {
        super("DECIMAL");
        this.precision = precision;
        this.scale = scale;
    }

    @Override
    public boolean isNumeric() {
        return true;
    }

    public int getPrecision() {
        return precision;
    }

    public Integer getScale() {
        return scale;
    }

    @Override
    public String toString() {
        return scale != null ?
                "DECIMAL(" + precision + "," + scale + ")" :
                "DECIMAL(" + precision + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecimalType that = (DecimalType) o;
        return precision == that.precision && Objects.equals(scale, that.scale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeName(), precision, scale);
    }
}
