package com.db.turtle.parser.ast.ntm;

import com.db.turtle.parser.ast.denominator.AstNode;

public final class TableName implements AstNode {

    private final String name;

    public TableName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
