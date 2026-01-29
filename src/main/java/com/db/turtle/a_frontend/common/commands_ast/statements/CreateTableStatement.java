package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnDef;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representação de um comando CREATE TABLE em Nó do AST.
 * */
public record CreateTableStatement(
        TableName tableName,
        List<ColumnDef> columns
) implements C_Statement {
    /**
     * Construtor compacto - valida os parâmetros antes de criar o objeto.
     * Também cria uma cópia imutável da lista de colunas para evitar
     * modificações externas.
     */
    public CreateTableStatement {
        if (tableName == null) {
            throw new IllegalArgumentException("tableName cannot be null");
        }
        if (columns == null || columns.isEmpty()) {
            throw new IllegalArgumentException("columns cannot be null or empty");
        }
        columns = Collections.unmodifiableList(new ArrayList<>(columns));
    }

    /**
     * Converte o AST de volta para SQL formatado.
     * Usa StringBuilder para eficiência ao concatenar strings.
     *
     * @return String com o comando SQL formatado
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(tableName).append(" (\n");

        for (int i = 0; i < columns.size(); i++) {
            sb.append("  ").append(columns.get(i));
            if (i < columns.size() - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append(");");
        return sb.toString();
    }
}