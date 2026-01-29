package com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint;

public class NotNullConstraint extends ColumnConstraint {
    public NotNullConstraint() {
        super (ConstraintType.NOT_NULL);
    }
    @Override
    public String toSql() {
        return "NOT NULL";
    }

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return getType().hashCode();
    }
}
