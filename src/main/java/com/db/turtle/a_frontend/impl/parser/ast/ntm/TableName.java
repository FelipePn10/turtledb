package com.db.turtle.a_frontend.impl.parser.ast.ntm;

import com.db.turtle.a_frontend.common.denominator.A_AstNode;

/**
 * Representação formal do nome de uma Tabela
 * */
public final class TableName implements A_AstNode {

    private final String name;

    public TableName(String name) {
        this.name = name;
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("name cannot be null or blank");
            }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableName that)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
