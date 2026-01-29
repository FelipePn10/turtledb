package com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint;


public class NullConstraint extends ColumnConstraint {
    public NullConstraint() {
        super(ConstraintType.NULL);
    }

    @Override
    public String toSql() {
        return "NULL";
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
