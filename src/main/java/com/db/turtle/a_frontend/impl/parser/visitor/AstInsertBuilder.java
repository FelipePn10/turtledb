package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.insert.InsertBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.insert.InsertLexer;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.dml.insert.InsertParser;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.common.denominator.B_Expression;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.common.commands_ast.statements.InsertStatement;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigDecimal;
import java.util.List;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos INSERT.
 */
public class AstInsertBuilder extends InsertBaseVisitor<A_AstNode> {
    /**
     * Transforma o contexto de uma regra de inserção da árvore de parsing num nó da AST.
     * <p>
     * Este método implementa o padrão Visitor para processar a regra:
     * {@code INSERT INTO tableName columnList? VALUES valueList}
     * </p>
     *
     * @param ctx O contexto da regra de inserção gerado pelo parser.
     * @return Uma instância de {@link InsertStatement} representando o comando SQL mapeado.
     * @see InsertStatement
     */
    @Override
    public A_AstNode visitInsertStatement(InsertParser.InsertStatementContext ctx) {
        TableName table = (TableName) visitTableName(ctx.tableName());

        List<ColumnName> colum =
                ctx.columnList() == null
                        ? List.of()
                        : ctx.columnList()
                        .column()
                        .stream()
                        .map(c -> (ColumnName) visitColumn(c))
                        .toList();

        List<B_Expression> values = ctx.valueList()
                .literal()
                .stream()
                .map(l -> (B_Expression) visitLiteral(l))
                .toList();

        return new InsertStatement(table, colum, values);
    }

    /**
     * Visita o contexto de uma tabela e retorna um TableName.
     *
     * @param ctx O contexto da coluna
     * @return Uma instância de ColumnName
     */
    @Override
    public A_AstNode visitTableName(InsertParser.TableNameContext ctx) {
        return buildTableName(ctx);
    }

    /**
     * Visita o contexto de uma coluna e retorna um ColumnName.
     *
     * @param ctx O contexto da coluna
     * @return Uma instância de ColumnName
     */
    @Override
    public A_AstNode visitColumn(InsertParser.ColumnContext ctx) {
        return buildColumnName(ctx);
    }

    /**
     * Visita o contexto de um literal e retorna uma LiteralExpression.
     * <p>
     * Converte tokens da gramática (NUMBER, STRING, NULL) em valores Java apropriado:
     * - NUMBER: Integer ou Double dependendo se tem ponto decimal
     * - STRING: String com aspas removidas e escapes processados
     * - NULL: null
     * Sem esse método não é possível verificar o tipo de dado que está entrando.
     *
     * @param ctx O contexto do literal
     * @return Uma instância de LiteralExpression contendo o valor parseado
     */
    @Override
    public A_AstNode visitLiteral(InsertParser.LiteralContext ctx) {
        return buildLiteral(ctx);
    }


    /**
     * Constrói um TableName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da tabela
     * @return TableName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private TableName buildTableName(InsertParser.TableNameContext ctx) {
        if (ctx == null || ctx.IDENTIFIER() == null) {
            throw new IllegalArgumentException("Invalid table name context");
        }
        return new TableName(ctx.IDENTIFIER().getText());
    }

    /**
     * Constrói um Literal tipado a partir do contexto do parser.
     *
     * @param ctx contexto contendo o valor literal (NUMBER, STRING ou NULL)
     * @return Literal imutável e tipado (StringLiteral, NumberLiteral ou NullLiteral)
     * @throws IllegalArgumentException se o tipo de literal for inválido
     */
    private Literal buildLiteral(InsertParser.LiteralContext ctx) {
        TerminalNode node = (TerminalNode) ctx.getChild(0);
        Token token = node.getSymbol();

        return switch (token.getType()) {
            case InsertLexer.NUMBER ->
                    new NumberLiteral(new BigDecimal(token.getText()));

            case InsertLexer.STRING ->
                    new StringLiteral(unquote(token.getText()));

            case InsertLexer.NULL -> NullLiteral.INSTANCE;
            case InsertLexer.TRUE -> BooleanLiteral.TRUE;
            case InsertLexer.FALSE -> BooleanLiteral.FALSE;

            default -> throw new IllegalArgumentException(
                    "Unknown literal: " + token.getText()
            );
        };
    }

    private static String unquote(String quoted) {
        return quoted.substring(1, quoted.length() - 1)
                .replace("''", "'");
    }

    /**
     * Constrói um ColumnName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da coluna
     * @return ColumnName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private ColumnName buildColumnName(InsertParser.ColumnContext ctx) {
        if (ctx == null || ctx.IDENTIFIER() == null) {
            throw new IllegalArgumentException("Invalid column name context");
        }
        return new ColumnName(ctx.IDENTIFIER().getText());
    }
}