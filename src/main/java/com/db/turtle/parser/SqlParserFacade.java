package com.db.turtle.parser;

import com.db.turtle.parser.antlr.statement.dml.select.SelectLexer;
import com.db.turtle.parser.antlr.statement.dml.select.SelectParser;
import com.db.turtle.parser.ast.denominator.Statement;
import com.db.turtle.parser.visitor.AstSelectBuilder;
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
        SelectLexer lexer = new SelectLexer(CharStreams.fromString(sql));
        SelectParser parser = new SelectParser(new CommonTokenStream(lexer));

        AstSelectBuilder astSelectBuilder = new AstSelectBuilder();
        return (Statement) astSelectBuilder.visit(parser.statement());
    }
}
