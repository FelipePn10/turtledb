package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.A_AstNode;

/**
 * Representação formal do nome de um index
 * */
public final class IndexName implements A_AstNode {
    private final String name;

    public IndexName(String name) {
        this.name = name;
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null");
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
