package com.db.turtle.catalog;

import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.DataType;
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
                new ColumnMetadata("id", DataType.INTEGER, false, 0),
                new ColumnMetadata("nome", DataType.VARCHAR, true, 1),
                new ColumnMetadata("idade", DataType.INTEGER, true, 2)
        );

        TableMetadata usuarios = new TableMetadata("public", "usuarios", columns);

        // Registra no catálogo
        catalog.registerTable(usuarios);

        // Testa se consegue encontrar
        Optional<TableMetadata> found = catalog.getTable("public", "usuarios");

        assertTrue(found.isPresent(), "Tabela deveria existir");
        assertEquals("usuarios", found.get().getTableName());
        assertEquals(3, found.get().getAllColumns().size());

        // Testa buscar coluna específica
        Optional<ColumnMetadata> nomeCol = found.get().getColumn("nome");
        assertTrue(nomeCol.isPresent());
        assertEquals(DataType.VARCHAR, nomeCol.get().getType());
    }

    @Test
    public void deveRetornarVazioQuandoTabelaNaoExiste() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Optional<TableMetadata> found = catalog.getTable("public", "inexistente");

        assertTrue(found.isEmpty(), "Não deveria encontrar tabela inexistente");
    }
}
