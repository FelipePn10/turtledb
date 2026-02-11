package com.db.turtle.binder;

import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.IntegerType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.VarcharType;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.Binder;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundSelectStmt;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.bound.BoundStatement;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.exception.BindExceptionApplication;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.binder.ntm.BoundColumnRef;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class BinderTest {

    private InMemoryCatalog catalog;
    private Binder binder;

    @BeforeEach
    public void setup() {
        catalog = new InMemoryCatalog();

        List<ColumnMetadata> columns = List.of(
                new ColumnMetadata(new ColumnName("id"), new IntegerType(), false, 0),
                new ColumnMetadata(new ColumnName("nome"), new VarcharType(100), true, 1),
                new ColumnMetadata(new ColumnName("idade"), new IntegerType(), true, 2)
        );

        TableMetadata usuarios = new TableMetadata("public", new TableName("usuarios"), columns);
        catalog.registerTable(usuarios);

        binder = new Binder(catalog);
    }

    @Test
    public void deveValidarTabelaExistente() {
        // Cria AST manualmente (simulando o parser)
        TableRef tableRef = TableRef.of(new TableName("usuarios"));

        SelectStmt selectStmt = new SelectStmt(
                List.of(),
                tableRef,
                Optional.empty()
        );

        BoundStatement bound = binder.bind(selectStmt);

        assertInstanceOf(BoundSelectStmt.class, bound);
        BoundSelectStmt boundSelect = (BoundSelectStmt) bound;

        assertEquals(new TableName("usuarios"), boundSelect.from().getTableName());
    }

    @Test
    public void deveFalharQuandoTabelaNaoExiste() {
        TableRef tableRef = TableRef.of(new TableName("tabelaInexistente"));

        SelectStmt selectStmt = new SelectStmt(
                List.of(),
                tableRef,
                Optional.empty()
        );

        BindExceptionApplication exception = assertThrows(
                BindExceptionApplication.class,
                () -> binder.bind(selectStmt)
        );

        assertTrue(exception.getMessage().contains("tabelaInexistente"));
    }

    @Test
    public void deveValidarColunasExistentes() {
        TableRef tableRef = TableRef.of(new TableName("usuarios"));

        // Cria projeção com colunas válidas
        List<B_Expression> projection = List.of(
                ColumnRef.of(new ColumnName("nome")),
                ColumnRef.of(new ColumnName("idade"))
        );

        SelectStmt selectStmt = new SelectStmt(projection, tableRef, null);

        BoundStatement bound = binder.bind(selectStmt);
        BoundSelectStmt boundSelect = (BoundSelectStmt) bound;

        // Verifica se as 2 colunas foram validadas
        assertEquals(2, boundSelect.projection().size());

        BoundColumnRef col1 = (BoundColumnRef) boundSelect.projection().getFirst();
        assertEquals(new ColumnName("nome"), col1.columnName());
        assertEquals(new VarcharType(100), col1.type());
    }

    @Test
    public void deveFalharQuandoColunaNaoExiste() {
        TableRef tableRef = TableRef.of(new TableName("usuarios"));

        List<B_Expression> projection = List.of(
                ColumnRef.of(new ColumnName("coluna_inexistente"))
        );

        SelectStmt selectStmt = new SelectStmt(projection, tableRef, null);

        assertThrows(
                BindExceptionApplication.class,
                () -> binder.bind(selectStmt)
        );
    }
}