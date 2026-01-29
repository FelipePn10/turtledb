package com.db.turtle.a_frontend.impl.parser;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.select.SelectLexer;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.select.SelectParser;
import com.db.turtle.a_frontend.common.denominator.C_Statement;
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

    public C_Statement parse(String sql) {
        SelectLexer lexer = new SelectLexer(CharStreams.fromString(sql));
        SelectParser parser = new SelectParser(new CommonTokenStream(lexer));

        AstSelectBuilder astSelectBuilder = new AstSelectBuilder();
        return (C_Statement) astSelectBuilder.visit(parser.statement());
    }
}
