package com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint;

public class PrimaryKeyConstraint extends ColumnConstraint {
    public PrimaryKeyConstraint() {
        super(ConstraintType.PRIMARY_KEY);
    }

    @Override
    public String toSql() {
        return "PRIMARY KEY";
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
