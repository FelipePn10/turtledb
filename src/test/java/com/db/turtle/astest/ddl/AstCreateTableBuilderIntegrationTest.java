package com.db.turtle.astest.ddl;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnDef;
import com.db.turtle.a_frontend.common.commands_ast.statements.CreateTableStatement;
import com.db.turtle.a_frontend.impl.parser.visitor.AstCreateTableBuilder;
import com.db.turtle.parser.visitor.ParserTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("AstCreateTableBuilder - Testes de Integração")
class AstCreateTableBuilderIntegrationTest {

    private AstCreateTableBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new AstCreateTableBuilder();
    }

    @Test
    @DisplayName("Deve parsear tabela de usuários completa")
    void shouldParseCompleteUsersTable() {
        // Given
        String sql = """
            CREATE TABLE usuarios (
                id INT PRIMARY KEY AUTO_INCREMENT,
                nome VARCHAR(100) NOT NULL,
                email VARCHAR(255)  NOT NULL UNIQUE,
                senha VARCHAR(255) NOT NULL,
                ativo BOOLEAN DEFAULT TRUE
            )
            """;
        // data_criacao TIMESTAMP DEFAULT -> Erro
        // CURRENT_TIMESTAMP (futuramente usada na tabela acima)


        // When
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.tableName().getName()).isEqualTo("usuarios");
        assertThat(statement.columns()).hasSize(5);

        // Verifica primeira coluna (id)
        assertThat(statement.columns().getFirst())
                .satisfies(column -> {
                    assertThat(column.getColumnName()).isEqualTo("id");
                    // Aqui verificaria o tipo e constraints quando eu implementar
                });
    }

    @Test
    @DisplayName("Deve parsear tabela de produtos com DECIMAL")
    void shouldParseProductsTableWithDecimal() {
        // Given
        String sql = """
            CREATE TABLE produtos (
                id BIGINT PRIMARY KEY,
                nome VARCHAR(200) NOT NULL,
                descricao TEXT NOT NULL,
                preco DECIMAL(10, 2) NOT NULL,
                estoque INT DEFAULT 0,
                ativo BOOLEAN DEFAULT TRUE
            )
            """;

        // When
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.tableName().getName()).isEqualTo("produtos");
        assertThat(statement.columns())
                .hasSize(6)
                .extracting(ColumnDef::getColumnName)
                .containsExactly("id", "nome", "descricao", "preco", "estoque", "ativo");
    }

    @Test
    @DisplayName("Deve parsear tabela simples com uma coluna")
    void shouldParseSingleColumnTable() {
        // Given
        String sql = "CREATE TABLE teste (id INT)";

        // When
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.tableName().getName()).isEqualTo("teste");
        assertThat(statement.columns()).hasSize(1);
        assertThat(statement.columns().getFirst().getColumnName()).isEqualTo("id");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "CREATE TABLE t1 (c1 INT)",
            "CREATE TABLE tabela_longa_com_underscores (coluna_longa_com_underscores VARCHAR(100))",
            "CREATE TABLE _temp (_id BIGINT)",
            "CREATE TABLE Table123 (Column456 DECIMAL(5, 2))"
    })
    @DisplayName("Deve parsear diferentes formatos de nomes")
    void shouldParseDifferentNameFormats(String sql) {
        // When
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement).isNotNull();
        assertThat(statement.tableName()).isNotNull();
        assertThat(statement.columns()).isNotEmpty();
    }

    // Unknown data type: dbturtleparserastntmColumnDef3b8ee898 -> erro de mapeamento de coluna (colunas de tipos)
    // Nó está vindo null
    @Test
    @DisplayName("Deve gerar SQL válido que pode ser re-parseado")
    void shouldGenerateReparseableSql() {
        // Given
        String originalSql = """
            CREATE TABLE usuarios (
                id INT,
                nome VARCHAR(100)
            )
            """;

        // When - Parse original
        CreateTableParser.CreateTableContext ctx1 = ParserTestHelper.parseCreateTable(originalSql);
        CreateTableStatement statement1 = (CreateTableStatement) builder.visitCreateTable(ctx1);

        // Gera SQL a partir da AST
        String generatedSql = statement1.toString();

        // Parse do SQL gerado
        CreateTableParser.CreateTableContext ctx2 = ParserTestHelper.parseCreateTable(generatedSql);
        CreateTableStatement statement2 = (CreateTableStatement) builder.visitCreateTable(ctx2);

        // Then - Ambos devem ser equivalentes
        assertThat(statement1.tableName().getName())
                .isEqualTo(statement2.tableName().getName());

        assertThat(statement1.columns())
                .hasSameSizeAs(statement2.columns());
    }

    @Test
    @DisplayName("Deve parsear tabela com todos os tipos de dados")
    void shouldParseTableWithAllDataTypes() {
        // Given
        String sql = """
            CREATE TABLE tipos (
                col_int INT,
                col_bigint BIGINT,
                col_varchar VARCHAR(100),
                col_char CHAR(10),
                col_decimal DECIMAL(10, 2),
                col_float FLOAT,
                col_double DOUBLE,
                col_date DATE,
                col_datetime DATETIME,
                col_timestamp TIMESTAMP,
                col_text TEXT,
                col_boolean BOOLEAN
            )
            """;

        // When
        CreateTableParser.CreateTableContext ctx = ParserTestHelper.parseCreateTable(sql);
        CreateTableStatement statement = (CreateTableStatement) builder.visitCreateTable(ctx);

        // Then
        assertThat(statement.columns()).hasSize(12);
        assertThat(statement.columns())
                .extracting(ColumnDef::getColumnName)
                .containsExactly(
                        "col_int", "col_bigint", "col_varchar", "col_char",
                        "col_decimal", "col_float", "col_double", "col_date",
                        "col_datetime", "col_timestamp", "col_text", "col_boolean"
                );
    }
}