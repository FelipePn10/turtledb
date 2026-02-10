package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint.ColumnConstraint;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;

import java.util.List;

/**
 * Representação de uma coluna com o seu tipo e a sua constraint.
 * */
public class ColumnDef implements A_AstNode {
    private final ColumnRef columnRef;
    private final DataType dataType;
    private final List<ColumnConstraint> constraints;

    public ColumnDef(
            ColumnRef columnRef,
            DataType dataType,
            List<ColumnConstraint> constraints
    ) {
        this.columnRef = columnRef;
        this.dataType = dataType;
        this.constraints = constraints;
    }

    public String getColumnName() {
        return columnRef.name().toString();
    }

    public String getQualifierName() {return columnRef.qualifier().toString();}

    public DataType getDataType() {
        return dataType;
    }

    public List<ColumnConstraint> getConstraints() {
        return constraints;
    }

    public boolean hasConstraints() {
        return !constraints.isEmpty();
    }

    @Override
    public String toString() {
        return columnRef.name() + "" + dataType +
                (constraints.isEmpty() ? "" : ", " + constraints);
    }
}
