package com.db.turtle.parser.ast.ntm;

import com.db.turtle.parser.ast.ntm.constraint.ColumnConstraint;
import com.db.turtle.parser.ast.ntm.types.DataType;

import java.util.List;

/**
 * Representação de uma coluna com o seu tipo e a sua constraint.
 *
 * */
public class ColumnDef {
    private final ColumnName columnName;
    private final DataType dataType;
    private final List<ColumnConstraint> constraints;

    public ColumnDef(
            ColumnName columnName,
            DataType dataType,
            List<ColumnConstraint> constraints
    ) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.constraints = constraints;
    }

    public String getColumnName() {
        return columnName.toString();
    }

    public DataType getDataType() {
        return dataType;
    }

    public List<ColumnConstraint> getConstraints() {
        return constraints;
    }

    public boolean hasConstraints() {
        return !constraints.isEmpty();
    }
}
