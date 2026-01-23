package com.db.turtle.parser.ast.statements;

import com.db.turtle.parser.ast.denominator.Expression;
import com.db.turtle.parser.ast.denominator.Statement;
import com.db.turtle.parser.ast.ntm.ColumnName;
import com.db.turtle.parser.ast.ntm.TableName;

import java.util.List;
import java.util.Objects;

public record InsertStatement(
        TableName table,
        List<ColumnName> columns,
        List<Expression> values
) implements Statement {

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

    public List<Expression> getValues() {
        return values;
    }
}

