package com.db.turtle.parser.visitor;

import com.db.turtle.parser.antlr.statement.dml.insert.InsertBaseVisitor;
import com.db.turtle.parser.antlr.statement.dml.insert.InsertParser;
import com.db.turtle.parser.ast.denominator.AstNode;
import com.db.turtle.parser.ast.denominator.Expression;
import com.db.turtle.parser.ast.expression.literal.*;
import com.db.turtle.parser.ast.ntm.ColumnName;
import com.db.turtle.parser.ast.ntm.TableName;
import com.db.turtle.parser.ast.statements.InsertStatement;

import java.util.List;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos INSERT.
 */
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
                        .map(c -> (ColumnName) visitColumn(c))
                        .toList();

        List<Expression> values = ctx.valueList()
                .literal()
                .stream()
                .map(l -> (Expression) visitLiteral(l))
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
    public AstNode visitTableName(InsertParser.TableNameContext ctx) {
        return buildTableName(ctx);
    }

    /**
     * Visita o contexto de uma coluna e retorna um ColumnName.
     *
     * @param ctx O contexto da coluna
     * @return Uma instância de ColumnName
     */
    @Override
    public AstNode visitColumn(InsertParser.ColumnContext ctx) {
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
    public AstNode visitLiteral(InsertParser.LiteralContext ctx) {
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
/**
 * Constrói um Literal tipado a partir do contexto do parser.
 *
 * @param ctx contexto contendo o valor literal (NUMBER, STRING ou NULL)
 * @return Literal imutável e tipado (StringLiteral, NumberLiteral ou NullLiteral)
 * @throws IllegalArgumentException se o tipo de literal for inválido
 */
private Literal buildLiteral(InsertParser.LiteralContext ctx) {

        if (ctx.NUMBER() != null) {
            String numberText = ctx.NUMBER().getText();
            return new NumberLiteral(numberText);
        }

        // STRING -> StringLiteral (remove aspas e processa escapes)
        if (ctx.STRING() != null) {
            String quoted = ctx.STRING().getText();
            // Remove aspas do início e fim
            String unquoted = quoted.substring(1, quoted.length() - 1)
                    .replace("''", "'"); // SQL escapa aspas com aspas
            return new StringLiteral(unquoted);
        }

        // NULL -> NullLiteral (singleton)
        if (ctx.NULL() != null) {
            return NullLiteral.INSTANCE;
        }

        // TRUE/FALSE (se sua gramática suportar literais booleanos)
        if (ctx.TRUE() != null) {
            return BooleanLiteral.TRUE;
        }

        if (ctx.FALSE() != null) {
            return BooleanLiteral.FALSE;
        }

        throw new IllegalArgumentException("Unknown literal type: " + ctx.getText());
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