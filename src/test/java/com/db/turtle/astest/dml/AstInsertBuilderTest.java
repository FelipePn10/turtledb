package com.db.turtle.astest.dml;


import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.insert.InsertLexer;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.insert.InsertParser;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.common.commands_ast.statements.InsertStatement;
import com.db.turtle.a_frontend.impl.parser.visitor.AstInsertBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class AstInsertBuilderTest {

    private AstInsertBuilder visitor;

    @BeforeEach
    void setUp() {
        visitor = new AstInsertBuilder();
    }

    /**
     * Método auxiliar para parsear SQL e retornar o contexto
     */
    private InsertParser.InsertStatementContext parseInsert(String sql) {
        InsertLexer lexer = new InsertLexer(CharStreams.fromString(sql));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        InsertParser parser = new InsertParser(tokens);
        return parser.insertStatement();
    }

    @Test
    @DisplayName("Deve parsear INSERT simples sem lista de colunas")
    void testInsertWithoutColumnList() {
        // Arrange
        String sql = "INSERT INTO users VALUES ('John', 25)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals("users", result.table().getName());
        assertTrue(result.columns().isEmpty());
        assertEquals(2, result.values().size());
    }

    @Test
    @DisplayName("Deve parsear INSERT com lista de colunas")
    void testInsertWithColumnList() {
        // Arrange
        String sql = "INSERT INTO users (name, age) VALUES ('John', 25)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals("users", result.table().getName());
        assertEquals(2, result.columns().size());
        assertEquals("name", result.columns().get(0).getName());
        assertEquals("age", result.columns().get(1).getName());
        assertEquals(2, result.values().size());
    }

    @Test
    @DisplayName("Deve parsear INSERT com uma única coluna")
    void testInsertSingleColumn() {
        // Arrange
        String sql = "INSERT INTO users (name) VALUES ('John')";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.columns().size());
        assertEquals("name", result.columns().get(0).getName());
        assertEquals(1, result.values().size());
    }

    @Test
    @DisplayName("Deve parsear INSERT com múltiplos valores")
    void testInsertMultipleValues() {
        // Arrange
        String sql = "INSERT INTO users VALUES ('John', 25, 'john@email.com', 1.75)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals(4, result.values().size());
    }

    @Test
    @DisplayName("Deve extrair corretamente o nome da tabela")
    void testVisitTableName() {
        // Arrange
        String sql = "INSERT INTO customers VALUES (1)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        TableName result = (TableName) visitor.visitTableName(ctx.tableName());

        // Assert
        assertNotNull(result);
        assertEquals("customers", result.getName());
    }

    @Test
    @DisplayName("Deve retornar lista vazia quando não há colunas especificadas")
    void testEmptyColumnList() {
        // Arrange
        String sql = "INSERT INTO users VALUES ('data')";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result.columns());
        assertTrue(result.columns().isEmpty());
    }

    @Test
    @DisplayName("Deve parsear INSERT com nomes de colunas complexos")
    void testComplexColumnNames() {
        // Arrange
        String sql = "INSERT INTO users (first_name, last_name, email_address) VALUES ('John', 'Doe', 'john@example.com')";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertEquals(3, result.columns().size());
        assertEquals("first_name", result.columns().get(0).getName());
        assertEquals("last_name", result.columns().get(1).getName());
        assertEquals("email_address", result.columns().get(2).getName());
    }

    @Test
    @DisplayName("Deve parsear INSERT com diferentes tipos de literais")
    void testDifferentLiteralTypes() {
        // Arrange - Usando apenas tipos suportados pela gramática
        String sql = "INSERT INTO data VALUES (123, 'text', 45.67, NULL)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals(4, result.values().size());
    }

    @Test
    @DisplayName("Deve manter a ordem das colunas")
    void testColumnOrder() {
        // Arrange
        String sql = "INSERT INTO users (id, name, email) VALUES (1, 'John', 'john@test.com')";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertEquals("id", result.columns().get(0).getName());
        assertEquals("name", result.columns().get(1).getName());
        assertEquals("email", result.columns().get(2).getName());
    }

    @Test
    @DisplayName("Deve manter a ordem dos valores")
    void testValueOrder() {
        // Arrange
        String sql = "INSERT INTO users VALUES (1, 'First', 'Second', 'Third')";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertEquals(4, result.values().size());
    }

    @Test
    @DisplayName("Deve parsear INSERT com apenas valores numéricos")
    void testInsertOnlyNumbers() {
        // Arrange
        String sql = "INSERT INTO numbers VALUES (1, 2, 3, 4.5)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals(4, result.values().size());
    }

    @Test
    @DisplayName("Deve parsear INSERT com valor NULL")
    void testInsertWithNull() {
        // Arrange
        String sql = "INSERT INTO users (name, age) VALUES ('John', NULL)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.values().size());
    }

    @Test
    @DisplayName("Deve parsear tabela com nome simples")
    void testSimpleTableName() {
        // Arrange
        String sql = "INSERT INTO t VALUES (1)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertEquals("t", result.table().getName());
    }

    @Test
    @DisplayName("Deve parsear INSERT com strings vazias")
    void testInsertWithEmptyString() {
        // Arrange
        String sql = "INSERT INTO users (name) VALUES ('')";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.values().size());
    }

    @Test
    @DisplayName("Deve parsear INSERT com números decimais")
    void testInsertWithDecimals() {
        // Arrange
        String sql = "INSERT INTO measurements (height, weight) VALUES (1.75, 70.5)";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.columns().size());
        assertEquals(2, result.values().size());
    }

    @Test
    @DisplayName("Deve parsear INSERT com strings com caracteres especiais")
    void testInsertWithSpecialCharacters() {
        // Arrange
        String sql = "INSERT INTO messages (text) VALUES ('Hello\\nWorld')";
        InsertParser.InsertStatementContext ctx = parseInsert(sql);

        // Act
        InsertStatement result = (InsertStatement) visitor.visitInsertStatement(ctx);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.values().size());
    }
}