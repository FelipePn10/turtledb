package com.db.turtle.a_frontend.impl.parser.ast.ntm;

public record ColumnRename(ColumnName from, ColumnName to) {
    public ColumnRename {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Column rename cannot contain null values");
        }
    }
}

