package com.db.turtle.a_frontend.impl.parser.ast.ddl;

import com.db.turtle.a_frontend.impl.parser.ast.denominator.Statement;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnDef;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;

import java.util.List;

public record CreateTableDDL(
        TableName table,
        List<ColumnDef> columns
) implements Statement {
}
