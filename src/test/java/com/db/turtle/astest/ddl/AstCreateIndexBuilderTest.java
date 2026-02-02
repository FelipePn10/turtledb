package com.db.turtle.astest.ddl;

import com.db.turtle.a_frontend.common.commands_ast.statements.CreateIndexStatement;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.index.CreateIndexLexer;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.index.CreateIndexParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.IndexName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.impl.parser.visitor.AstCreateIndexBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste completa e profissional para {@link AstCreateIndexBuilder}.
 *
 * <p>Esta suite de testes verifica todos os aspectos do visitor responsável por
 * construir a AST a partir do parse tree gerado pelo ANTLR para comandos CREATE INDEX.
 *
 * <p>Cobertura de testes:
 * <ul>
 *   <li>Criação de índices simples e únicos</li>
 *   <li>Índices com uma ou múltiplas colunas</li>
 *   <li>Validação de nomes de índices, tabelas e colunas</li>
 *   <li>Casos extremos e validações de erro</li>
 *   <li>Preservação de flags (UNIQUE)</li>
 * </ul>
 *
 * @author Felipe Panosso
 * @version 1.0
 * @since 1.0
 */
@DisplayName("AstCreateIndexBuilder - Visitor Tests")
class AstCreateIndexBuilderTest {

    private AstCreateIndexBuilder visitor;

    @BeforeEach
    void setUp() {
        visitor = new AstCreateIndexBuilder();
    }


    /**
     * Método auxiliar para parsear um comando SQL e gerar o contexto.
     *
     * @param sql o comando SQL a ser parseado
     * @return o contexto de parsing do ANTLR
     */
    private CreateIndexParser.CreateIndexContext parseCreateIndex(String sql) {
        CreateIndexLexer lexer = new CreateIndexLexer(CharStreams.fromString(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CreateIndexParser parser = new CreateIndexParser(tokens);
        return parser.createIndex();
    }

    /**
     * Método auxiliar para construir e validar um statement.
     *
     * @param sql o comando SQL
     * @return o CreateIndexStatement construído
     */
    private CreateIndexStatement buildStatement(String sql) {
        CreateIndexParser.CreateIndexContext ctx = parseCreateIndex(sql);
        return (CreateIndexStatement) visitor.visitCreateIndex(ctx);
    }


    @Nested
    @DisplayName("Basic CREATE INDEX Tests")
    class BasicCreateIndexTests {

        @Test
        @DisplayName("Deve criar índice simples com uma coluna")
        void shouldCreateSimpleIndexWithSingleColumn() {
            // Given
            String sql = "CREATE INDEX idx_users ON users (email)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll("Validações do statement",
                    () -> assertNotNull(statement, "Statement não deve ser nulo"),
                    () -> assertEquals("idx_users", statement.indexName().getName(),
                            "Nome do índice deve ser 'idx_users'"),
                    () -> assertEquals("users", statement.tableName().getName(),
                            "Nome da tabela deve ser 'users'"),
                    () -> assertEquals(1, statement.columns().size(),
                            "Deve haver exatamente 1 coluna"),
                    () -> assertEquals("email", statement.columns().get(0).getName(),
                            "Nome da coluna deve ser 'email'"),
                    () -> assertFalse(statement.unique(),
                            "Índice não deve ser único")
            );
        }

        @Test
        @DisplayName("Deve criar índice único com flag UNIQUE")
        void shouldCreateUniqueIndexWithUniqueFlag() {
            // Given
            String sql = "CREATE UNIQUE INDEX idx_email_unique ON users (email)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll("Validações do índice único",
                    () -> assertNotNull(statement),
                    () -> assertEquals("idx_email_unique", statement.indexName().getName()),
                    () -> assertEquals("users", statement.tableName().getName()),
                    () -> assertTrue(statement.unique(),
                            "Índice deve ser marcado como único"),
                    () -> assertEquals(1, statement.columns().size())
            );
        }

        @Test
        @DisplayName("Deve criar índice com múltiplas colunas")
        void shouldCreateIndexWithMultipleColumns() {
            // Given
            String sql = "CREATE INDEX idx_name_email ON users (first_name, last_name, email)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll("Validações do índice com múltiplas colunas",
                    () -> assertNotNull(statement),
                    () -> assertEquals("idx_name_email", statement.indexName().getName()),
                    () -> assertEquals("users", statement.tableName().getName()),
                    () -> assertEquals(3, statement.columns().size(),
                            "Deve haver exatamente 3 colunas"),
                    () -> assertFalse(statement.unique())
            );

            // Validar ordem das colunas
            List<ColumnName> columns = statement.columns();
            assertThat(columns)
                    .extracting(ColumnName::getName)
                    .containsExactly("first_name", "last_name", "email");
        }
    }


    @Nested
    @DisplayName("Index and Table Name Variations")
    class NameVariationsTests {

        @ParameterizedTest(name = "Índice: {0}")
        @ValueSource(strings = {
                "idx_simple",
                "IDX_UPPERCASE",
                "idx_With_Mixed_Case",
                "idx123",
                "idx_with_numbers_123",
                "i",
                "very_long_index_name_that_is_still_valid"
        })
        @DisplayName("Deve aceitar nomes válidos de índices")
        void shouldAcceptValidIndexNames(String indexName) {
            // Given
            String sql = String.format("CREATE INDEX %s ON users (id)", indexName);

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertNotNull(statement);
            assertEquals(indexName, statement.indexName().getName());
        }

        @ParameterizedTest(name = "Tabela: {0}")
        @ValueSource(strings = {
                "users",
                "CUSTOMERS",
                "Order_Items",
                "t1",
                "table_with_underscores",
                "TableWithCamelCase"
        })
        @DisplayName("Deve aceitar nomes válidos de tabelas")
        void shouldAcceptValidTableNames(String tableName) {
            // Given
            String sql = String.format("CREATE INDEX idx_test ON %s (id)", tableName);

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertNotNull(statement);
            assertEquals(tableName, statement.tableName().getName());
        }

        @ParameterizedTest(name = "Coluna: {0}")
        @ValueSource(strings = {
                "id",
                "user_id",
                "firstName",
                "COLUMN_NAME",
                "col1",
                "c"
        })
        @DisplayName("Deve aceitar nomes válidos de colunas")
        void shouldAcceptValidColumnNames(String columnName) {
            // Given
            String sql = String.format("CREATE INDEX idx_test ON users (%s)", columnName);

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertNotNull(statement);
            assertEquals(1, statement.columns().size());
            assertEquals(columnName, statement.columns().get(0).getName());
        }
    }


    @Nested
    @DisplayName("Multiple Columns Index Tests")
    class MultipleColumnsTests {

        @Test
        @DisplayName("Deve criar índice composto com 2 colunas")
        void shouldCreateCompositeIndexWithTwoColumns() {
            // Given
            String sql = "CREATE INDEX idx_composite ON orders (customer_id, order_date)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals(2, statement.columns().size());
            assertThat(statement.columns())
                    .extracting(ColumnName::getName)
                    .containsExactly("customer_id", "order_date");
        }

        @Test
        @DisplayName("Deve criar índice composto com 5 colunas")
        void shouldCreateCompositeIndexWithFiveColumns() {
            // Given
            String sql = "CREATE INDEX idx_multi ON table1 (col1, col2, col3, col4, col5)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals(5, statement.columns().size());
            assertThat(statement.columns())
                    .extracting(ColumnName::getName)
                    .containsExactly("col1", "col2", "col3", "col4", "col5");
        }

        @Test
        @DisplayName("Deve preservar a ordem exata das colunas")
        void shouldPreserveColumnOrder() {
            // Given
            String sql = "CREATE INDEX idx_order ON products (category, price, name, stock)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            List<String> columnNames = statement.columns()
                    .stream()
                    .map(ColumnName::getName)
                    .toList();

            assertThat(columnNames)
                    .containsExactly("category", "price", "name", "stock")
                    .doesNotContain("stock", "name", "price", "category"); // ordem diferente
        }

        @ParameterizedTest
        @MethodSource("provideMultiColumnScenarios")
        @DisplayName("Deve criar índices com diferentes quantidades de colunas")
        void shouldCreateIndexWithVariousColumnCounts(String sql, int expectedColumnCount) {
            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals(expectedColumnCount, statement.columns().size());
        }

        static Stream<Arguments> provideMultiColumnScenarios() {
            return Stream.of(
                    Arguments.of("CREATE INDEX idx ON t (c1)", 1),
                    Arguments.of("CREATE INDEX idx ON t (c1, c2)", 2),
                    Arguments.of("CREATE INDEX idx ON t (c1, c2, c3)", 3),
                    Arguments.of("CREATE INDEX idx ON t (c1, c2, c3, c4, c5, c6)", 6),
                    Arguments.of("CREATE INDEX idx ON t (a, b, c, d, e, f, g, h, i, j)", 10)
            );
        }
    }


    @Nested
    @DisplayName("UNIQUE Flag Tests")
    class UniqueFlagTests {

        @Test
        @DisplayName("Deve marcar índice como único quando UNIQUE está presente")
        void shouldMarkIndexAsUniqueWhenKeywordPresent() {
            // Given
            String sql = "CREATE UNIQUE INDEX idx_unique ON users (email)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertTrue(statement.unique(), "Flag unique deve ser true");
        }

        @Test
        @DisplayName("Deve marcar índice como não único quando UNIQUE está ausente")
        void shouldMarkIndexAsNonUniqueWhenKeywordAbsent() {
            // Given
            String sql = "CREATE INDEX idx_regular ON users (email)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertFalse(statement.unique(), "Flag unique deve ser false");
        }

        @Test
        @DisplayName("Deve criar índice único com múltiplas colunas")
        void shouldCreateUniqueIndexWithMultipleColumns() {
            // Given
            String sql = "CREATE UNIQUE INDEX idx_unique_composite ON users (email, username)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll(
                    () -> assertTrue(statement.unique()),
                    () -> assertEquals(2, statement.columns().size())
            );
        }

        @ParameterizedTest
        @MethodSource("provideUniqueScenarios")
        @DisplayName("Deve processar corretamente diferentes cenários de UNIQUE")
        void shouldHandleVariousUniqueScenarios(String sql, boolean expectedUnique) {
            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals(expectedUnique, statement.unique());
        }

        static Stream<Arguments> provideUniqueScenarios() {
            return Stream.of(
                    Arguments.of("CREATE INDEX idx ON t (c)", false),
                    Arguments.of("CREATE UNIQUE INDEX idx ON t (c)", true),
                    Arguments.of("CREATE INDEX idx ON t (c1, c2)", false),
                    Arguments.of("CREATE UNIQUE INDEX idx ON t (c1, c2)", true),
                    Arguments.of("CREATE UNIQUE INDEX idx ON t (c1, c2, c3, c4)", true)
            );
        }
    }


    @Nested
    @DisplayName("Validation and Error Tests")
    class ValidationTests {

        @Test
        @DisplayName("Deve lançar IllegalArgumentException quando IndexName é null")
        void shouldThrowExceptionWhenIndexNameIsNull() {
            // When & Then
            assertThrows(IllegalArgumentException.class,
                    () -> new CreateIndexStatement(
                            null,
                            new TableName("table1"),
                            List.of(new ColumnName("col1")),
                            false
                    ),
                    "Deve lançar IllegalArgumentException quando IndexName é null"
            );
        }

        @Test
        @DisplayName("Deve lançar IllegalArgumentException quando TableName é null")
        void shouldThrowExceptionWhenTableNameIsNull() {
            // When & Then
            assertThrows(IllegalArgumentException.class,
                    () -> new CreateIndexStatement(
                            new IndexName("idx"),
                            null,
                            List.of(new ColumnName("col1")),
                            false
                    ),
                    "Deve lançar IllegalArgumentException quando TableName é null"
            );
        }

        @Test
        @DisplayName("Deve lançar IllegalArgumentException quando lista de colunas é null")
        void shouldThrowExceptionWhenColumnsIsNull() {
            // When & Then
            assertThrows(IllegalArgumentException.class,
                    () -> new CreateIndexStatement(
                            new IndexName("idx"),
                            new TableName("table1"),
                            null,
                            false
                    ),
                    "Deve lançar IllegalArgumentException quando lista de colunas é null"
            );
        }

        @Test
        @DisplayName("Deve lançar IllegalArgumentException quando lista de colunas está vazia")
        void shouldThrowExceptionWhenColumnsIsEmpty() {
            // When & Then
            assertThrows(IllegalArgumentException.class,
                    () -> new CreateIndexStatement(
                            new IndexName("idx"),
                            new TableName("table1"),
                            List.of(),
                            false
                    ),
                    "Deve lançar IllegalArgumentException quando lista de colunas está vazia"
            );
        }

        @Test
        @DisplayName("Deve retornar CreateIndexStatement válido")
        void shouldReturnValidCreateIndexStatement() {
            // Given
            String sql = "CREATE INDEX idx ON table1 (col1)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertThat(statement)
                    .isNotNull()
                    .isInstanceOf(CreateIndexStatement.class);
        }

        @Test
        @DisplayName("Deve construir objetos IndexName, TableName e ColumnName corretos")
        void shouldBuildCorrectNameObjects() {
            // Given
            String sql = "CREATE INDEX my_index ON my_table (my_column)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll(
                    () -> assertThat(statement.indexName())
                            .isInstanceOf(IndexName.class)
                            .extracting(IndexName::getName)
                            .isEqualTo("my_index"),


                    () -> assertThat(statement.tableName())
                            .isInstanceOf(TableName.class)
                            .extracting(TableName::getName)
                            .isEqualTo("my_table"),

                    () -> assertThat(statement.columns())
                            .hasSize(1)
                            .first()
                            .isInstanceOf(ColumnName.class)
                            .extracting(ColumnName::getName)
                            .isEqualTo("my_column")

            );
        }
    }


    @Nested
    @DisplayName("Complete Integration Tests")
    class IntegrationTests {

        @Test
        @DisplayName("Cenário completo: índice único composto em tabela de produção")
        void completeScenarioUniqueCompositeIndex() {
            // Given - Simula um caso real de produção
            String sql = "CREATE UNIQUE INDEX idx_user_email_username ON users_table (email_address, username)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll("Validação completa do cenário de produção",
                    () -> assertEquals("idx_user_email_username",
                            statement.indexName().getName()),
                    () -> assertEquals("users_table",
                            statement.tableName().getName()),
                    () -> assertTrue(statement.unique()),
                    () -> assertEquals(2, statement.columns().size()),
                    () -> assertEquals("email_address",
                            statement.columns().get(0).getName()),
                    () -> assertEquals("username",
                            statement.columns().get(1).getName())
            );
        }

        @Test
        @DisplayName("Cenário completo: índice de busca multi-coluna")
        void completeScenarioMultiColumnSearchIndex() {
            // Given
            String sql = "CREATE INDEX idx_product_search ON products (category_id, brand_id, price_range, availability_status)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll("Validação de índice de busca complexo",
                    () -> assertNotNull(statement),
                    () -> assertEquals("idx_product_search", statement.indexName().getName()),
                    () -> assertEquals("products", statement.tableName().getName()),
                    () -> assertFalse(statement.unique()),
                    () -> assertEquals(4, statement.columns().size()),
                    () -> assertThat(statement.columns())
                            .extracting(ColumnName::getName)
                            .containsExactly("category_id", "brand_id", "price_range", "availability_status")
            );
        }

        @ParameterizedTest
        @MethodSource("provideRealWorldScenarios")
        @DisplayName("Cenários do mundo real")
        void shouldHandleRealWorldScenarios(String description, String sql,
                                            String expectedIndex, String expectedTable,
                                            int expectedColumns, boolean expectedUnique) {
            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll(description,
                    () -> assertEquals(expectedIndex, statement.indexName().getName()),
                    () -> assertEquals(expectedTable, statement.tableName().getName()),
                    () -> assertEquals(expectedColumns, statement.columns().size()),
                    () -> assertEquals(expectedUnique, statement.unique())
            );
        }

        static Stream<Arguments> provideRealWorldScenarios() {
            return Stream.of(
                    Arguments.of(
                            "Índice de email único para autenticação",
                            "CREATE UNIQUE INDEX idx_auth_email ON users (email)",
                            "idx_auth_email", "users", 1, true
                    ),
                    Arguments.of(
                            "Índice composto para queries de relatório",
                            "CREATE INDEX idx_sales_report ON sales (region, year, quarter)",
                            "idx_sales_report", "sales", 3, false
                    ),
                    Arguments.of(
                            "Índice de chave estrangeira",
                            "CREATE INDEX idx_fk_customer ON orders (customer_id)",
                            "idx_fk_customer", "orders", 1, false
                    ),
                    Arguments.of(
                            "Índice único composto para constraint natural",
                            "CREATE UNIQUE INDEX idx_isbn ON books (isbn_13)",
                            "idx_isbn", "books", 1, true
                    ),
                    Arguments.of(
                            "Índice de performance para JOIN",
                            "CREATE INDEX idx_join_optimization ON order_items (order_id, product_id)",
                            "idx_join_optimization", "order_items", 2, false
                    )
            );
        }
    }


    @Nested
    @DisplayName("Edge Cases and Corner Cases")
    class EdgeCasesTests {

        @Test
        @DisplayName("Deve aceitar nomes de uma letra")
        void shouldAcceptSingleLetterNames() {
            // Given
            String sql = "CREATE INDEX i ON t (c)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll(
                    () -> assertEquals("i", statement.indexName().getName()),
                    () -> assertEquals("t", statement.tableName().getName()),
                    () -> assertEquals("c", statement.columns().get(0).getName())
            );
        }

        @Test
        @DisplayName("Deve processar nomes com underscores múltiplos")
        void shouldHandleMultipleUnderscores() {
            // Given
            String sql = "CREATE INDEX idx___test ON table___name (col___name)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertAll(
                    () -> assertEquals("idx___test", statement.indexName().getName()),
                    () -> assertEquals("table___name", statement.tableName().getName()),
                    () -> assertEquals("col___name", statement.columns().get(0).getName())
            );
        }

        @Test
        @DisplayName("Deve processar índice com 10 colunas")
        void shouldHandleIndexWithTenColumns() {
            // Given
            String sql = "CREATE INDEX idx ON t (c1, c2, c3, c4, c5, c6, c7, c8, c9, c10)";

            // When
            CreateIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals(10, statement.columns().size());
            assertThat(statement.columns())
                    .extracting(ColumnName::getName)
                    .containsExactly("c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "c10");
        }
    }


    @Nested
    @DisplayName("Immutability and Consistency Tests")
    class ImmutabilityTests {

        @Test
        @DisplayName("Múltiplas invocações do visitor devem produzir resultados consistentes")
        void multipleInvocationsShouldProduceConsistentResults() {
            // Given
            String sql = "CREATE UNIQUE INDEX idx ON users (email, username)";
            CreateIndexParser.CreateIndexContext ctx = parseCreateIndex(sql);

            // When
            CreateIndexStatement statement1 = (CreateIndexStatement) visitor.visitCreateIndex(ctx);
            CreateIndexStatement statement2 = (CreateIndexStatement) visitor.visitCreateIndex(ctx);

            // Then - Os dois statements devem ter os mesmos dados
            assertAll(
                    () -> assertEquals(statement1.indexName().getName(),
                            statement2.indexName().getName()),
                    () -> assertEquals(statement1.tableName().getName(),
                            statement2.tableName().getName()),
                    () -> assertEquals(statement1.unique(), statement2.unique()),
                    () -> assertEquals(statement1.columns().size(),
                            statement2.columns().size())
            );
        }

        @Test
        @DisplayName("Record deve ser imutável")
        void recordShouldBeImmutable() {
            // Given
            String sql = "CREATE INDEX idx ON users (email)";
            CreateIndexStatement statement = buildStatement(sql);

            // When/Then - Accessors retornam sempre os mesmos valores
            IndexName indexName1 = statement.indexName();
            IndexName indexName2 = statement.indexName();
            TableName tableName1 = statement.tableName();
            TableName tableName2 = statement.tableName();

            assertAll(
                    () -> assertSame(indexName1, indexName2),
                    () -> assertSame(tableName1, tableName2),
                    () -> assertEquals(statement.unique(), statement.unique())
            );
        }

        @Test
        @DisplayName("Deve criar statement com equals e hashCode consistentes")
        void shouldHaveConsistentEqualsAndHashCode() {
            // Given
            IndexName indexName = new IndexName("idx");
            TableName tableName = new TableName("users");
            List<ColumnName> columns = List.of(new ColumnName("email"));

            // When
            CreateIndexStatement statement1 = new CreateIndexStatement(indexName, tableName, columns, true);
            CreateIndexStatement statement2 = new CreateIndexStatement(indexName, tableName, columns, true);

            // Then - Records devem ser iguais se tiverem os mesmos componentes
            assertAll(
                    () -> assertEquals(statement1, statement2),
                    () -> assertEquals(statement1.hashCode(), statement2.hashCode())
            );
        }

        @Test
        @DisplayName("Statements com dados diferentes não devem ser iguais")
        void statementsWithDifferentDataShouldNotBeEqual() {
            // Given
            CreateIndexStatement statement1 = new CreateIndexStatement(
                    new IndexName("idx1"),
                    new TableName("users"),
                    List.of(new ColumnName("email")),
                    true
            );

            CreateIndexStatement statement2 = new CreateIndexStatement(
                    new IndexName("idx2"),
                    new TableName("users"),
                    List.of(new ColumnName("email")),
                    true
            );

            // Then
            assertNotEquals(statement1, statement2);
        }
    }
}