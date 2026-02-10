package com.db.turtle.catalog;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.IntegerType;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.VarcharType;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.ColumnMetadata;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.InMemoryCatalog;
import com.db.turtle.b_query_engine.planner.volcano.logicalPlan.catalog.TableMetadata;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogTest {

    @Test
    public void deveCriarEConsultarTabela() {
        // Cria o catálogo vazio
        InMemoryCatalog catalog = new InMemoryCatalog();

        // Cria metadados de uma tabela "usuarios"
        List<ColumnMetadata> columns = List.of(
                new ColumnMetadata(new ColumnName("id"), new IntegerType(), false, 0),
                new ColumnMetadata(new ColumnName("nome"),new VarcharType(100), true, 1),
                new ColumnMetadata(new ColumnName("idade"), new IntegerType(), true, 2)
        );

        TableMetadata usuarios = new TableMetadata("public", new TableName("usuarios"), columns);

        // Registra no catálogo
        catalog.registerTable(usuarios);

        // Testa se consegue encontrar
        Optional<TableMetadata> found = catalog.getTable("public", "usuarios");

        assertTrue(found.isPresent(), "Tabela deveria existir");
        assertEquals(new TableName("usuarios"), found.get().getTableName());
        assertEquals(3, found.get().getAllColumns().size());

        // Testa buscar coluna específica
        Optional<ColumnMetadata> nomeCol = found.get().getColumn(new ColumnName("nome"));
        assertTrue(nomeCol.isPresent());
//        assertEquals(new VarcharType(100), nomeCol.get().getType());
    }

    @Test
    public void deveRetornarVazioQuandoTabelaNaoExiste() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Optional<TableMetadata> found = catalog.getTable("public", "inexistente");

        assertTrue(found.isEmpty(), "Não deveria encontrar tabela inexistente");
    }
}
