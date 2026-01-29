package com.db.turtle.astest.ddl;


import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableParser;
import com.db.turtle.a_frontend.impl.parser.ast.denominator.AstNode;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnDef;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.impl.parser.ast.statements.CreateTableStatement;
import com.db.turtle.a_frontend.impl.parser.visitor.AstCreateTableBuilder;
import com.db.turtle.parser.visitor.ParserTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("AstCreateTableBuilder - Testes Unitários")
class AstCreateTableBuilderTest {

    private AstCreateTableBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new AstCreateTableBuilder();
    }

    // ==================== Testes de TableName ====================

    @Test
    @DisplayName("Deve criar TableName com nome válido")
    void shouldCreateTableNameWithValidName() {
        // Given
        String sql = "CREATE TABLE usuarios (id INT)";
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);

        // When
        AstNode result = builder.visitCreateTable(ctx);

        // Then
        assertThat(result)
                .isInstanceOf(CreateTableStatement.class);

        CreateTableStatement statement = (CreateTableStatement) result;
        assertThat(statement.tableName())
                .isNotNull()
                .extracting(TableName::getName)
                .containsExactly("usuarios");
    }

    @Test
    @DisplayName("Deve criar TableName com underscores")
    void shouldCreateTableNameWithUnderscores() {
        // Given
        String sql = "CREATE TABLE tabela_teste_123 (id INT)";
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);

        // When
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.tableName().getName())
                .isEqualTo("tabela_teste_123");
    }

    // ==================== Testes de ColumnDef ====================

    @Test
    @DisplayName("Deve criar coluna simples sem constraints")
    void shouldCreateSimpleColumnWithoutConstraints() {
        // Given
        String sql = "CREATE TABLE produtos (id INT)";
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);

        // When
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.columns())
                .hasSize(1)
                .first()
                .satisfies(column -> {
                    assertThat(column.getColumnName()).isEqualTo("id");
                    assertThat(column.getConstraints()).isEmpty();
                });
    }

    @Test
    @DisplayName("Deve criar múltiplas colunas")
    void shouldCreateMultipleColumns() {
        // Given
        String sql = """
            CREATE TABLE usuarios (
                id INT,
                nome VARCHAR(100),
                email VARCHAR(255)
            )
            """;
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);

        // When
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.columns())
                .hasSize(3)
                .extracting(ColumnDef::getColumnName)
                .containsExactly("id", "nome", "email");
    }

    // ==================== Testes de CreateTableStatement completo ====================

    @Test
    @DisplayName("Deve criar statement completo com tabela e colunas")
    void shouldCreateCompleteStatement() {
        // Given
        String sql = """
            CREATE TABLE produtos (
                id INT,
                nome VARCHAR(200),
                preco DECIMAL(10, 2)
            )
            """;
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);

        // When
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement)
                .isNotNull()
                .satisfies(stmt -> {
                    assertThat(stmt.tableName().getName()).isEqualTo("produtos");
                    assertThat(stmt.columns()).hasSize(3);
                });
    }

    @Test
    @DisplayName("Deve gerar SQL corretamente via toString")
    void shouldGenerateSqlViaToString() {
        // Given
        String sql = """
            CREATE TABLE usuarios (
                id INT,
                nome VARCHAR(100)
            )
            """;
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);

        // When
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);
        String generatedSql = statement.toString();

        // Then
        assertThat(generatedSql)
                .contains("CREATE TABLE")
                .contains("usuarios")
                .contains("id")
                .contains("nome");
    }

    // ==================== Testes de Validação ====================

    @Test
    @DisplayName("Deve lançar exceção se contexto de tableName for null")
    void shouldThrowExceptionWhenTableNameContextIsNull() {
        // When/Then
        assertThatThrownBy(() -> {
            CreateTableParser parser = ParserTestHelper.createParser("CREATE TABLE (id INT)");
            // Simula contexto inválido
            builder.visitCreateTable(parser.createTable());
        })
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Deve lançar exceção se não houver colunas")
    void shouldThrowExceptionWhenNoColumns() {
        // When/Then
        assertThatThrownBy(() -> {
            // SQL inválido sem colunas
            String invalidSql = "CREATE TABLE usuarios ()";
            CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(invalidSql);
            builder.visitCreateTable(ctx);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid column name context");
    }

    // ==================== Testes de Edge Cases ====================

    @Test
    @DisplayName("Deve aceitar nomes de colunas com underscores")
    void shouldAcceptColumnNamesWithUnderscores() {
        // Given
        String sql = "CREATE TABLE teste (id_usuario INT, nome_completo VARCHAR(100))";
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);

        // When
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.columns())
                .extracting(ColumnDef::getColumnName)
                .containsExactly("id_usuario", "nome_completo");
    }

    @Test
    @DisplayName("Deve aceitar nomes que começam com underscore")
    void shouldAcceptNamesStartingWithUnderscore() {
        // Given
        String sql = "CREATE TABLE _temp (_id INT)";
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);

        // When
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.tableName().getName()).isEqualTo("_temp");
        assertThat(statement.columns().getFirst().getColumnName()).isEqualTo("_id");
    }
}