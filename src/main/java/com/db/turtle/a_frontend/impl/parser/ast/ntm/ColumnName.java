package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.A_AstNode;

/**
 * Representação formal do nome de uma coluna
 * */
public class ColumnName implements A_AstNode {
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
