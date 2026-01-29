package com.db.turtle.a_frontend.impl.parser;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.select.SelectLexer;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.select.SelectParser;
import com.db.turtle.a_frontend.impl.parser.ast.denominator.Statement;
import com.db.turtle.a_frontend.impl.parser.visitor.AstSelectBuilder;
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
