package com.db.turtle.parser.ast.ntm.constraint;

import java.util.Objects;

public class DefaultConstraint extends ColumnConstraint {
    private final Object defaultValue;
    public DefaultConstraint(Object defaultValue) {
        super(ConstraintType.DEFAULT);
        this.defaultValue = defaultValue;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String toSql() {
        if (defaultValue instanceof String) {
            return "DEFAULT '" + defaultValue + "'";
        }
        return "DEFAULT " + defaultValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultConstraint that = (DefaultConstraint) o;
        return defaultValue.equals(that.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), defaultValue);
    }
}
