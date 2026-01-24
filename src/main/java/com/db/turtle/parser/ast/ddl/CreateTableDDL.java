package com.db.turtle.parser.ast.ddl;

import com.db.turtle.parser.ast.denominator.Statement;
import com.db.turtle.parser.ast.ntm.ColumnDef;
import com.db.turtle.parser.ast.ntm.TableName;

import java.util.List;

public record CreateTableDDL(
        TableName table,
        List<ColumnDef> columns
) implements Statement {
}
