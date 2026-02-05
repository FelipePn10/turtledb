package com.db.turtle.a_frontend.impl.parser.ast.ntm;

public record TableRename(TableName from, TableName to) {
    public TableRename {
        if (from == to || to == null) {
            throw new IllegalArgumentException("TableRename requires both from and to.");
        }
    }
}
