package com.db.turtle.parser.visitor;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableLexer;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Utilitário para criar parser ANTLR a partir de SQL.
 * Facilita a criação de testes.
 */
public class ParserTestHelper {

    /**
     * Cria um parser a partir de uma string SQL.
     *
     * @param sql comando SQL a ser parseado
     * @return parser configurado e pronto para uso
     */
    public static CreateTableParser createParser(String sql) {
        // 1. Cria o lexer (análise léxica - tokens)
        CreateTableLexer lexer = new CreateTableLexer(CharStreams.fromString(sql));

        // 2. Cria o stream de tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 3. Cria e retorna o parser
        return new CreateTableParser(tokens);
    }

    /**
     * Parse completo de um comando CREATE TABLE.
     *
     * @param sql comando SQL
     * @return contexto do CREATE TABLE
     */
    public static CreateTableParser.CreateTableContext parseCreateTable(String sql) {
        CreateTableParser parser = createParser(sql);
        return parser.createTable();
    }
}