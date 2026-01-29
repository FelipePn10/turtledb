package com.db.turtle.a_frontend.common.commands_ast.statements;

import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.common.denominator.C_Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;
import java.util.Objects;

public record InsertStatement(
        TableName table,
        List<ColumnName> columns,
        List<B_Expression> values
) implements C_Statement {

    public InsertStatement {
        Objects.requireNonNull(table);
        Objects.requireNonNull(columns);
        Objects.requireNonNull(values);

        columns = List.copyOf(columns);
        values = List.copyOf(values);
    }

    public TableName getTable() {
        return table;
    }

    public List<ColumnName> getColumns() {
        return columns;
    }

    public List<B_Expression> getValues() {
        return values;
    }
}

