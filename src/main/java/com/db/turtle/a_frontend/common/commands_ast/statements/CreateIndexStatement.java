package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnDef;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.IndexName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;

/**
 * Representação de um comando CREATE UNIQUE? INDEX em Nó do AST.
 * */
public record CreateIndexStatement(
        IndexName indexName,
        TableName tableName,
        List<ColumnName> columns
) implements C_Statement {
    /**
     * Construtor compacto - valida os parâmetros antes de criar o objeto.
     * Também cria uma cópia imutável da lista de colunas para evitar
     * modificações externas.
     */
    public CreateIndexStatement(
            IndexName indexName,
            TableName tableName,
            List<ColumnName> columns) {
        if (indexName == null || tableName == null) {
            throw new IllegalArgumentException("IndexName or TableName cannot be null");
        }
        if (columns == null || columns.isEmpty()) {
            throw new IllegalArgumentException("Columns cannot be null or empty");
        }
        this.indexName = indexName;
        this.tableName = tableName;
        this.columns = columns;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE INDEX ").append(indexName.toString()).append(" ON ").append(tableName.toString()).append(columns.toString()).append(" (");
        for (int i = 0; i < columns.size(); i++) {
            if (i <columns.size() - 1) {
                sb.append(", ");
            }
            sb.append("\n");
        }
        sb.append(");");
        return sb.toString();
    }
}
