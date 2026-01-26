package com.db.turtle.parser.ast.ntm.constraint;

public class UniqueConstraint extends ColumnConstraint{
    public UniqueConstraint() {
        super(ConstraintType.UNIQUE);
    }

    @Override
    public String toSql() {
        return "UNIQUE";
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
