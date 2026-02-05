package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint.ColumnConstraint;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;

import java.util.List;

/**
 * Representação de um comando ALTER ADD COLUMN em Nó do AST.
 * */
public record AlterColumnAddStatement (
        TableName tableName,
        ColumnName column,
        DataType type,
        List<ColumnConstraint> constraint
) implements C_Statement {
    public AlterColumnAddStatement(
            TableName tableName,
            ColumnName column,
            DataType type,
            List<ColumnConstraint> constraint
    ) {
        if (tableName == null || column == null) {
            throw new IllegalArgumentException("Table and/or Column cannot be null");
        }

        this.tableName = tableName;
        this.column = column;
        this.type = type;
        this.constraint = constraint;
    }
}