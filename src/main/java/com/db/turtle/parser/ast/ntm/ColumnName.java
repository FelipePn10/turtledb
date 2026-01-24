package com.db.turtle.parser.ast.ntm;

import com.db.turtle.parser.ast.denominator.AstNode;

/**
 * Representação formal do nome de uma coluna
 * */
public class ColumnName implements AstNode {
    private String name;
    public ColumnName(String name) {
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
