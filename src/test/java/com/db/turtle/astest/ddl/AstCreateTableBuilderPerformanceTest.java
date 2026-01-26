//package com.db.turtle.astest.ddl;
//import com.db.turtle.parser.antlr.statement.ddl.create.table.CreateTableParser;
//import com.db.turtle.parser.ast.statements.CreateTableStatement;
//import com.db.turtle.parser.visitor.AstCreateTableBuilder;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.time.Duration;
//
//import static org.assertj.core.api.Assertions.*;
//
//@DisplayName("AstCreateTableBuilder - Testes de Performance")
//class AstCreateTableBuilderPerformanceTest {
//
//    private AstCreateTableBuilder builder;
//
//    @BeforeEach
//    void setUp() {
//        builder = new AstCreateTableBuilder();
//    }
//
//    @Test
//    @DisplayName("Deve parsear tabela com muitas colunas em tempo razoável")
//    void shouldParseTableWithManyColumnsInReasonableTime() {
//        // Given - Tabela com 50 colunas
//        StringBuilder sql = new StringBuilder("CREATE TABLE grande (");
//        for (int i = 1; i <= 50; i++) {
//            sql.append("coluna").append(i).append(" VARCHAR(100)");
//            if (i < 50) {
//                sql.append(", ");
//            }
//        }
//        sql.append(")");
//
//        // When/Then - Deve executar em menos de 1 segundo
//        assertThatCode(() -> {
//            CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql.toString());
//            CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);
//            assertThat(statement.columns()).hasSize(50);
//        })
//                .doesNotThrowAnyException()
//                .completes(Duration.ofSeconds(1));
//    }
//
//    @Test
//    @DisplayName("Deve parsear múltiplas tabelas rapidamente")
//    void shouldParseMultipleTablesQuickly() {
//        // Given
//        String[] sqls = new String[100];
//        for (int i = 0; i < 100; i++) {
//            sqls[i] = "CREATE TABLE tabela" + i + " (id INT, nome VARCHAR(100))";
//        }
//
//        // When/Then - 100 tabelas em menos de 2 segundos
//        assertThatCode(() -> {
//            for (String sql : sqls) {
//                CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
//                builder.visitCreateTable(ctx);
//            }
//        })
//                .doesNotThrowAnyException()
//                .completes(Duration.ofSeconds(2));
//    }
//}