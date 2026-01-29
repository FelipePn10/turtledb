package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.D_Projection;

import java.util.List;


public final class ColumnListProjection implements D_Projection {
    private final List<ColumnName> columns;

    public ColumnListProjection(List<ColumnName> columns) {
        this.columns = columns;
    }

    public List<ColumnName> getColumns() {
        return columns;
    }
}
