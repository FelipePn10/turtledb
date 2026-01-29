package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.impl.parser.ast.denominator.AstNode;

/**
 * Representação formal do nome de uma Tabela
 * */
public final class TableName implements AstNode {

    private final String name;

    public TableName(String name) {
        this.name = name;
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name cannot be null or blank");
            }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
