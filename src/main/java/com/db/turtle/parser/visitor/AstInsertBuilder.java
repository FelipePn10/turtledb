package com.db.turtle.parser.visitor;

import com.db.turtle.parser.antlr.statement.insert.InsertBaseVisitor;
import com.db.turtle.parser.antlr.statement.insert.InsertParser;
import com.db.turtle.parser.ast.denominator.AstNode;
import com.db.turtle.parser.ast.denominator.Expression;
import com.db.turtle.parser.ast.ntm.ColumnName;
import com.db.turtle.parser.ast.ntm.TableName;
import com.db.turtle.parser.ast.statements.InsertStatement;

import java.util.List;

/**
 * Visita a parse tree do ANTLR
 * <p>
 * Converte cada parte em objetos de domínio e traduz SQL para modelo interno
 * </p>
 * */
public class AstInsertBuilder extends InsertBaseVisitor<AstNode> {
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
    public AstNode visitInsertStatement(InsertParser.InsertStatementContext ctx) {
        TableName table = (TableName) visitTableName(ctx.tableName());
        List<ColumnName> colum =
                ctx.columnList() == null
                        ? List.of()
                        : ctx.columnList()
                            .column()
                            .stream()
                            .map(c -> (ColumnName) visit(c))
                            .toList();

        List<Expression> values = ctx.valueList()
                .literal()
                .stream()
                .map(l -> (Expression) visit(l))
                .toList();

        return new InsertStatement(table, colum, values);
    }

    @Override
    public AstNode visitTableName(InsertParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }
}
