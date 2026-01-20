package com.db.turtle.parser;

import com.db.turtle.parser.antlr.SqlLexer;
import com.db.turtle.parser.antlr.SqlParser;
import com.db.turtle.parser.ast.Statement;
import com.db.turtle.parser.visitor.AstBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Isola o ANTLR do resto do sistema. Podendo trocar gramática
 * sem quebrar o engine, testes mais simples, design profissional.
 *
 * @author Felipe Panosso
 * */
public class SqlParserFacade {

    public Statement parse(String sql) {
        SqlLexer lexer = new SqlLexer(CharStreams.fromString(sql));
        SqlParser parser = new SqlParser(new CommonTokenStream(lexer));

        AstBuilder astBuilder = new AstBuilder();
        return (Statement) astBuilder.visit(parser.statement());
    }
}
