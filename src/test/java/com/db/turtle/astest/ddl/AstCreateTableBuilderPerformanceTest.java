package com.db.turtle.astest.ddl;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableParser;
import com.db.turtle.a_frontend.impl.parser.ast.statements.CreateTableStatement;
import com.db.turtle.a_frontend.impl.parser.visitor.AstCreateTableBuilder;
import com.db.turtle.parser.visitor.ParserTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.assertj.core.api.Assertions.*;

@DisplayName("AstCreateTableBuilder - Testes de Performance")
class AstCreateTableBuilderPerformanceTest {

    private AstCreateTableBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new AstCreateTableBuilder();
    }

    @Test
    @DisplayName("Deve parsear tabela com muitas colunas em tempo razoável")
    void shouldParseTableWithManyColumnsInReasonableTime() {
        // Given - Tabela com 50 colunas
        StringBuilder sql = new StringBuilder("CREATE TABLE grande (");
        for (int i = 1; i <= 50; i++) {
            sql.append("coluna").append(i).append(" VARCHAR(100)");
            if (i < 50) {
                sql.append(", ");
            }
        }
        sql.append(")");

        // When - Mede o tempo de execução
        Instant start = Instant.now();

        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql.toString());
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);

        // Then - Verifica resultado e performance
        assertThat(statement.columns()).hasSize(50);
        assertThat(duration)
                .as("Parsing de 50 colunas deve ser rápido")
                .isLessThan(Duration.ofSeconds(1));

        System.out.println("Tempo para parsear 50 colunas: " + duration.toMillis() + "ms");
    }

    @Test
    @DisplayName("Deve parsear múltiplas tabelas rapidamente")
    void shouldParseMultipleTablesQuickly() {
        // Given
        String[] sqls = new String[100];
        for (int i = 0; i < 100; i++) {
            sqls[i] = "CREATE TABLE tabela" + i + " (id INT, nome VARCHAR(100))";
        }

        // When - Mede o tempo de execução
        Instant start = Instant.now();

        for (String sql : sqls) {
            CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
            builder.visitCreateTable(ctx);
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);

        // Then - Verifica performance
        assertThat(duration)
                .as("Parsing de 100 tabelas deve ser rápido")
                .isLessThan(Duration.ofSeconds(2));

        System.out.println("Tempo para parsear 100 tabelas: " + duration.toMillis() + "ms");
        System.out.println("Média por tabela: " + (duration.toMillis() / 100.0) + "ms");
    }

//    @Test
//    @DisplayName("Deve parsear tabela complexa com constraints em tempo razoável")
//    void shouldParseComplexTableInReasonableTime() {
//        // Given - Tabela complexa com várias constraints
//        String sql = """
//            CREATE TABLE complexa (
//                id INT PRIMARY KEY,
//                nome VARCHAR(100) NOT NULL,
//                email VARCHAR(255) UNIQUE,
//                idade INT CHECK (idade >= 18),
//                criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//                atualizado_em TIMESTAMP,
//                departamento_id INT,
//                FOREIGN KEY (departamento_id) REFERENCES departamentos(id),
//                INDEX idx_nome (nome),
//                INDEX idx_email (email)
//            )
//            """;
//
//        // When - Mede o tempo de execução
//        Instant start = Instant.now();
//
//        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
//        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);
//
//        Instant end = Instant.now();
//        Duration duration = Duration.between(start, end);
//
//        // Then - Verifica resultado e performance
//        assertThat(statement.columns().size()).isGreaterThanOrEqualTo(6);
//        assertThat(duration)
//                .as("Parsing de tabela complexa deve ser rápido")
//                .isLessThan(Duration.ofMillis(500));
//
//        System.out.println("Tempo para parsear tabela complexa: " + duration.toMillis() + "ms");
//    }

    @Test
    @DisplayName("Warmup + Benchmark - múltiplas execuções")
    void benchmarkWithWarmup() {
        String sql = """
        CREATE TABLE complexa (
            id INT,
            nome VARCHAR(100) NOT NULL,
            email VARCHAR(255) UNIQUE,
            idade INT,
            criado_em TIMESTAMP,
            atualizado_em TIMESTAMP,
            departamento_id INT
        )
        """;

        // Warmup - executa 10 vezes para JIT compilation
        System.out.println("Warmup...");
        for (int i = 0; i < 10; i++) {
            CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
            builder.visitCreateTable(ctx);
        }

        // Benchmark real - média de 100 execuções
        System.out.println("📊 Benchmark real:");
        long totalTime = 0;
        int iterations = 100;

        for (int i = 0; i < iterations; i++) {
            Instant start = Instant.now();
            CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
            builder.visitCreateTable(ctx);
            Instant end = Instant.now();
            totalTime += Duration.between(start, end).toNanos();
        }

        double avgMs = (totalTime / iterations) / 1_000_000.0;
        System.out.printf("Média: %.2fms%n", avgMs);
        System.out.printf("Melhor caso: tabela simples deveria estar < 20ms%n");

        assertThat(avgMs).isLessThan(50.0); // Threshold razoável
    }

    @Test
    @DisplayName("Benchmark - Parsing progressivo de 10 a 100 colunas")
    void benchmarkProgressiveColumnCount() {
        System.out.println("\n📈 Benchmark - Colunas vs Tempo:");
        System.out.println("================================");

        int[] columnCounts = {10, 25, 50, 75, 100};

        for (int columnCount : columnCounts) {
            // Given
            StringBuilder sql = new StringBuilder("CREATE TABLE bench (");
            for (int i = 1; i <= columnCount; i++) {
                sql.append("col").append(i).append(" VARCHAR(100)");
                if (i < columnCount) {
                    sql.append(", ");
                }
            }
            sql.append(")");

            // When
            Instant start = Instant.now();
            CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql.toString());
            builder.visitCreateTable(ctx);
            Instant end = Instant.now();
            Duration duration = Duration.between(start, end);

            // Then - Log e verificação
            System.out.printf("%3d colunas: %5dms%n", columnCount, duration.toMillis());
            assertThat(duration).isLessThan(Duration.ofSeconds(2));
        }

        System.out.println("================================\n");
    }
}

