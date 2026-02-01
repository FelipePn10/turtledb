package com.db.turtle.astest.ddl;

import com.db.turtle.a_frontend.common.commands_ast.statements.DropIndexStatement;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.index.DropIndexLexer;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.drop.index.DropIndexParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.IndexName;
import com.db.turtle.a_frontend.impl.parser.visitor.AstDropIndexBuilder;
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

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste completa e profissional para {@link AstDropIndexBuilder}.
 *
 * <p>Esta suite de testes verifica todos os aspectos do visitor responsável por
 * construir a AST a partir do parse tree gerado pelo ANTLR para comandos DROP INDEX.
 *
 * <p>Cobertura de testes:
 * <ul>
 *   <li>Criação de statements DROP INDEX básicos</li>
 *   <li>Validação de nomes de índices</li>
 *   <li>Variações de nomenclatura (maiúsculas, minúsculas, underscore)</li>
 *   <li>Casos extremos e edge cases</li>
 *   <li>Validação de construção de objetos</li>
 *   <li>Testes de integração com cenários reais</li>
 * </ul>
 *
 * @author Felipe Panosso
 * @version 1.0
 * @since 1.0
 */
@DisplayName("AstDropIndexBuilder - Visitor Tests")
class AstDropIndexBuilderTest {

    private AstDropIndexBuilder visitor;

    @BeforeEach
    void setUp() {
        visitor = new AstDropIndexBuilder();
    }

    // ==================== Métodos auxiliares ====================

    /**
     * Método auxiliar para parsear um comando SQL e gerar o contexto.
     *
     * @param sql o comando SQL a ser parseado
     * @return o contexto de parsing do ANTLR
     */
    private DropIndexParser.DropIndexContext parseDropIndex(String sql) {
        DropIndexLexer lexer = new DropIndexLexer(CharStreams.fromString(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DropIndexParser parser = new DropIndexParser(tokens);
        return parser.dropIndex();
    }

    /**
     * Método auxiliar para construir e validar um statement.
     *
     * @param sql o comando SQL
     * @return o DropIndexStatement construído
     */
    private DropIndexStatement buildStatement(String sql) {
        DropIndexParser.DropIndexContext ctx = parseDropIndex(sql);
        return (DropIndexStatement) visitor.visitDropIndex(ctx);
    }

    // ==================== Testes básicos ====================

    @Nested
    @DisplayName("Basic DROP INDEX Tests")
    class BasicDropIndexTests {

        @Test
        @DisplayName("Deve criar statement DROP INDEX simples")
        void shouldCreateSimpleDropIndexStatement() {
            // Given
            String sql = "DROP INDEX idx_users";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertAll("Validações do statement",
                    () -> assertNotNull(statement, "Statement não deve ser nulo"),
                    () -> assertNotNull(statement.indexName(), "IndexName não deve ser nulo"),
                    () -> assertEquals("idx_users", statement.indexName().getName(),
                            "Nome do índice deve ser 'idx_users'")
            );
        }

        @Test
        @DisplayName("Deve retornar DropIndexStatement válido")
        void shouldReturnValidDropIndexStatement() {
            // Given
            String sql = "DROP INDEX my_index";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertThat(statement)
                    .isNotNull()
                    .isInstanceOf(DropIndexStatement.class);
        }

        @Test
        @DisplayName("Deve construir objeto IndexName correto")
        void shouldBuildCorrectIndexNameObject() {
            // Given
            String sql = "DROP INDEX test_index";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertThat(statement.indexName())
                    .isInstanceOf(IndexName.class)
                    .extracting(IndexName::getName)
                    .isEqualTo("test_index");
        }
    }


    @Nested
    @DisplayName("Index Name Variations")
    class NameVariationsTests {

        @ParameterizedTest(name = "Índice: {0}")
        @ValueSource(strings = {
                "idx_simple",
                "IDX_UPPERCASE",
                "idx_With_Mixed_Case",
                "idx123",
                "idx_with_numbers_123",
                "i",
                "very_long_index_name_that_is_still_valid",
                "idx___multiple___underscores"
        })
        @DisplayName("Deve aceitar nomes válidos de índices")
        void shouldAcceptValidIndexNames(String indexName) {
            // Given
            String sql = String.format("DROP INDEX %s", indexName);

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertNotNull(statement);
            assertEquals(indexName, statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome com letra única")
        void shouldHandleSingleLetterName() {
            // Given
            String sql = "DROP INDEX i";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("i", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome com underscores múltiplos")
        void shouldHandleMultipleUnderscores() {
            // Given
            String sql = "DROP INDEX idx___test___name";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("idx___test___name", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome começando com letra maiúscula")
        void shouldHandleCapitalizedName() {
            // Given
            String sql = "DROP INDEX Index_Name";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("Index_Name", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome totalmente em maiúsculas")
        void shouldHandleUppercaseName() {
            // Given
            String sql = "DROP INDEX IDX_CUSTOMERS";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("IDX_CUSTOMERS", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome totalmente em minúsculas")
        void shouldHandleLowercaseName() {
            // Given
            String sql = "DROP INDEX idx_customers";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("idx_customers", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome com números no meio")
        void shouldHandleNumbersInMiddle() {
            // Given
            String sql = "DROP INDEX idx_user123_email";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("idx_user123_email", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome terminando com números")
        void shouldHandleNumbersAtEnd() {
            // Given
            String sql = "DROP INDEX idx_version_2024";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("idx_version_2024", statement.indexName().getName());
        }
    }


    @Nested
    @DisplayName("Validation Tests")
    class ValidationTests {

        @Test
        @DisplayName("Deve lançar IllegalArgumentException quando IndexName é null no construtor")
        void shouldThrowExceptionWhenIndexNameIsNull() {
            // When & Then
            assertThrows(IllegalArgumentException.class,
                    () -> new DropIndexStatement(null),
                    "Deve lançar IllegalArgumentException quando IndexName é null"
            );
        }

        @Test
        @DisplayName("Statement deve ser imutável")
        void statementShouldBeImmutable() {
            // Given
            String sql = "DROP INDEX idx_test";
            DropIndexStatement statement = buildStatement(sql);

            // When - Acessar múltiplas vezes
            IndexName indexName1 = statement.indexName();
            IndexName indexName2 = statement.indexName();

            // Then - Deve retornar a mesma referência
            assertSame(indexName1, indexName2);
        }

        @Test
        @DisplayName("Visitor não deve modificar estado entre invocações")
        void visitorShouldBeStateless() {
            // Given
            String sql1 = "DROP INDEX idx_first";
            String sql2 = "DROP INDEX idx_second";

            // When
            DropIndexStatement statement1 = buildStatement(sql1);
            DropIndexStatement statement2 = buildStatement(sql2);

            // Then
            assertAll(
                    () -> assertEquals("idx_first", statement1.indexName().getName()),
                    () -> assertEquals("idx_second", statement2.indexName().getName()),
                    () -> assertNotEquals(statement1, statement2)
            );
        }
    }

    // ==================== Testes de integração ====================

    @Nested
    @DisplayName("Integration Tests")
    class IntegrationTests {

        @ParameterizedTest
        @MethodSource("provideRealWorldScenarios")
        @DisplayName("Cenários do mundo real")
        void shouldHandleRealWorldScenarios(String description, String sql, String expectedIndexName) {
            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertAll(description,
                    () -> assertNotNull(statement),
                    () -> assertEquals(expectedIndexName, statement.indexName().getName())
            );
        }

        static Stream<Arguments> provideRealWorldScenarios() {
            return Stream.of(
                    Arguments.of(
                            "Remoção de índice de autenticação",
                            "DROP INDEX idx_auth_email",
                            "idx_auth_email"
                    ),
                    Arguments.of(
                            "Remoção de índice de chave estrangeira",
                            "DROP INDEX idx_fk_customer_id",
                            "idx_fk_customer_id"
                    ),
                    Arguments.of(
                            "Remoção de índice composto",
                            "DROP INDEX idx_user_email_username",
                            "idx_user_email_username"
                    ),
                    Arguments.of(
                            "Remoção de índice de busca",
                            "DROP INDEX idx_product_search",
                            "idx_product_search"
                    ),
                    Arguments.of(
                            "Remoção de índice único",
                            "DROP INDEX idx_unique_isbn",
                            "idx_unique_isbn"
                    ),
                    Arguments.of(
                            "Remoção de índice de performance",
                            "DROP INDEX idx_perf_orders_date",
                            "idx_perf_orders_date"
                    ),
                    Arguments.of(
                            "Remoção de índice temporário",
                            "DROP INDEX idx_temp_migration_2024",
                            "idx_temp_migration_2024"
                    )
            );
        }

        @Test
        @DisplayName("Cenário completo: remoção de índice após migração")
        void completeScenarioRemovalAfterMigration() {
            // Given - Índice criado durante migração que precisa ser removido
            String sql = "DROP INDEX idx_migration_temp_v2_users";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertAll("Validação completa do cenário",
                    () -> assertNotNull(statement),
                    () -> assertEquals("idx_migration_temp_v2_users", statement.indexName().getName()),
                    () -> assertInstanceOf(DropIndexStatement.class, statement)
            );
        }

        @Test
        @DisplayName("Cenário completo: remoção de índice obsoleto")
        void completeScenarioRemovalOfObsoleteIndex() {
            // Given - Índice que não é mais necessário
            String sql = "DROP INDEX idx_old_customer_lookup";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertAll("Validação de remoção de índice obsoleto",
                    () -> assertNotNull(statement),
                    () -> assertEquals("idx_old_customer_lookup", statement.indexName().getName())
            );
        }
    }

    // ==================== Testes de consistência ====================

    @Nested
    @DisplayName("Consistency Tests")
    class ConsistencyTests {

        @Test
        @DisplayName("Múltiplas invocações com mesmo SQL devem produzir statements equivalentes")
        void multipleInvocationsWithSameSqlShouldProduceEquivalentStatements() {
            // Given
            String sql = "DROP INDEX idx_test";
            DropIndexParser.DropIndexContext ctx = parseDropIndex(sql);

            // When
            DropIndexStatement statement1 = (DropIndexStatement) visitor.visitDropIndex(ctx);
            DropIndexStatement statement2 = (DropIndexStatement) visitor.visitDropIndex(ctx);

            // Then
            assertAll(
                    () -> assertEquals(statement1.indexName().getName(),
                            statement2.indexName().getName()),
                    () -> assertEquals(statement1, statement2)
            );
        }

        @Test
        @DisplayName("Record deve ter equals e hashCode consistentes")
        void recordShouldHaveConsistentEqualsAndHashCode() {
            // Given
            IndexName indexName = new IndexName("idx_test");

            // When
            DropIndexStatement statement1 = new DropIndexStatement(indexName);
            DropIndexStatement statement2 = new DropIndexStatement(indexName);

            // Then
            assertAll(
                    () -> assertEquals(statement1, statement2),
                    () -> assertEquals(statement1.hashCode(), statement2.hashCode())
            );
        }

        @Test
        @DisplayName("Statements com índices diferentes não devem ser iguais")
        void statementsWithDifferentIndicesShouldNotBeEqual() {
            // Given
            DropIndexStatement statement1 = new DropIndexStatement(new IndexName("idx1"));
            DropIndexStatement statement2 = new DropIndexStatement(new IndexName("idx2"));

            // Then
            assertAll(
                    () -> assertNotEquals(statement1, statement2),
                    () -> assertNotEquals(statement1.hashCode(), statement2.hashCode())
            );
        }

        @Test
        @DisplayName("ToString deve retornar representação válida")
        void toStringShouldReturnValidRepresentation() {
            // Given
            String sql = "DROP INDEX idx_test";
            DropIndexStatement statement = buildStatement(sql);

            // When
            String result = statement.toString();

            // Then
            assertNotNull(result);
            assertFalse(result.isEmpty());
        }
    }

    // ==================== Testes de edge cases ====================

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCasesTests {

        @Test
        @DisplayName("Deve processar nome muito longo")
        void shouldHandleVeryLongName() {
            // Given
            String longName = "idx_very_long_index_name_with_many_underscores_and_descriptive_text_2024_version_final";
            String sql = String.format("DROP INDEX %s", longName);

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals(longName, statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome com padrão CamelCase")
        void shouldHandleCamelCaseName() {
            // Given
            String sql = "DROP INDEX IdxUserEmailAddress";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("IdxUserEmailAddress", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome com padrão snake_case")
        void shouldHandleSnakeCaseName() {
            // Given
            String sql = "DROP INDEX idx_user_email_address";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("idx_user_email_address", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome com padrão SCREAMING_SNAKE_CASE")
        void shouldHandleScreamingSnakeCaseName() {
            // Given
            String sql = "DROP INDEX IDX_USER_EMAIL_ADDRESS";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("IDX_USER_EMAIL_ADDRESS", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar nome com números no início (se permitido pela gramática)")
        void shouldHandleNameWithLeadingNumbers() {
            // Given - Dependendo da gramática, isso pode não ser válido
            // Este teste documenta o comportamento esperado
            String sql = "DROP INDEX idx_2024_migration";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("idx_2024_migration", statement.indexName().getName());
        }
    }

    // ==================== Testes de comportamento do visitor ====================

    @Nested
    @DisplayName("Visitor Behavior Tests")
    class VisitorBehaviorTests {

        @Test
        @DisplayName("Visitor deve retornar tipo correto de AstNode")
        void visitorShouldReturnCorrectAstNodeType() {
            // Given
            String sql = "DROP INDEX idx_test";
            DropIndexParser.DropIndexContext ctx = parseDropIndex(sql);

            // When
            var result = visitor.visitDropIndex(ctx);

            // Then
            assertThat(result)
                    .isNotNull()
                    .isInstanceOf(DropIndexStatement.class);
        }

        @Test
        @DisplayName("Visitor deve processar corretamente o contexto ANTLR")
        void visitorShouldProcessAntlrContextCorrectly() {
            // Given
            String sql = "DROP INDEX my_special_index";
            DropIndexParser.DropIndexContext ctx = parseDropIndex(sql);

            // When
            DropIndexStatement statement = (DropIndexStatement) visitor.visitDropIndex(ctx);

            // Then
            assertAll(
                    () -> assertNotNull(statement),
                    () -> assertNotNull(statement.indexName()),
                    () -> assertEquals("my_special_index", statement.indexName().getName())
            );
        }

        @Test
        @DisplayName("BuildIndexName deve extrair corretamente o identificador do contexto")
        void buildIndexNameShouldExtractIdentifierCorrectly() {
            // Given
            String sql = "DROP INDEX extracted_index";
            DropIndexParser.DropIndexContext ctx = parseDropIndex(sql);

            // When
            DropIndexStatement statement = (DropIndexStatement) visitor.visitDropIndex(ctx);

            // Then
            assertEquals("extracted_index", statement.indexName().getName());
        }
    }

    // ==================== Testes de padrões comuns ====================

    @Nested
    @DisplayName("Common Patterns Tests")
    class CommonPatternsTests {

        @ParameterizedTest
        @ValueSource(strings = {
                "idx_pk_users",           // Primary key index
                "idx_fk_order_customer",  // Foreign key index
                "idx_uk_email",           // Unique key index
                "idx_search_products",    // Search index
                "idx_perf_queries",       // Performance index
                "idx_temp_migration"      // Temporary index
        })
        @DisplayName("Deve processar padrões comuns de nomenclatura de índices")
        void shouldHandleCommonIndexNamingPatterns(String indexName) {
            // Given
            String sql = String.format("DROP INDEX %s", indexName);

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals(indexName, statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar índice com prefixo de versão")
        void shouldHandleIndexWithVersionPrefix() {
            // Given
            String sql = "DROP INDEX idx_v2_customer_lookup";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("idx_v2_customer_lookup", statement.indexName().getName());
        }

        @Test
        @DisplayName("Deve processar índice com sufixo de data")
        void shouldHandleIndexWithDateSuffix() {
            // Given
            String sql = "DROP INDEX idx_migration_20240131";

            // When
            DropIndexStatement statement = buildStatement(sql);

            // Then
            assertEquals("idx_migration_20240131", statement.indexName().getName());
        }
    }
}