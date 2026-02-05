package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnRename;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;


/**
 * Representação de um comando ALTER TABLE tableName RENAME COLUMN oldNameColumn TO newNameColumn em Nó do AST.
 * */
public record AlterRenameColumnStatement(
        TableName tableName,
        ColumnRename columnRename
) implements C_Statement {
    public AlterRenameColumnStatement(
            TableName tableName,
            ColumnRename columnRename

    ) {
        if (tableName == null || columnRename == null) {
            throw new IllegalArgumentException("Table and/or Column cannot be null");
        }

        this.tableName = tableName;
        this.columnRename = columnRename;
    }
}
