package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.common.commands_ast.statements.AlterColumnAddStatement;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.add.AlterColumnAddBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.add.AlterColumnAddParser;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.BooleanLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NullLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.StringLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.*;

import java.util.List;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos ALTER TABLE tableName ADD columnName dataType columnConstraints?
 */
public class AstAlterColumnAdd  extends AlterColumnAddBaseVisitor<A_AstNode> {
    @Override
    public A_AstNode visitAlterColumnAdd(AlterColumnAddParser.AlterColumnAddContext ctx) {
        TableName table = buildTableName(ctx.tableName());
        ColumnName column = buildColumn(ctx.columnName());
        DataType type = buildDataType(ctx.dataType());
        List<ColumnConstraint> constraint = buildColumnConstraints(ctx.columnConstraints());

        return new AlterColumnAddStatement(table, column, type, constraint);
    }

    /**
     * Constrói um TableName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da tabela
     * @return TableName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private TableName buildTableName(AlterColumnAddParser.TableNameContext ctx) {
        return new TableName(ctx.IDENTIFIER().getText());
    }

    /**
     * Constrói um ColumnName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da coluna
     * @return ColumnName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private ColumnName buildColumn(AlterColumnAddParser.ColumnNameContext ctx) {
        return new ColumnName(ctx.IDENTIFIER().getText());
    }

    /**
     * Constrói um DataType visitando o contexto correspondente.
     * O ANTLR automaticamente chama visitDataType, que determina
     * o tipo específico (INT, VARCHAR, DECIMAL, etc).
     *
     * @param ctx contexto do tipo de dado
     * @return DataType específico (IntType, VarcharType, etc)
     * @throws IllegalArgumentException se o contexto for inválido
     * @throws IllegalStateException se o visitor retornar tipo inesperado
     */
    private DataType buildDataType(AlterColumnAddParser.DataTypeContext ctx) {
        A_AstNode node = visit(ctx);

        if (!(node instanceof DataType)) {
            throw new IllegalStateException(
                    "Expected DataType but got " + node.getClass().getSimpleName()
            );
        }

        return (DataType) node;
    }

    private List<ColumnConstraint> buildColumnConstraints(
            List<AlterColumnAddParser.ColumnConstraintsContext> ctx) {

        if (ctx == null || ctx.isEmpty()) {
            return List.of();
        }

        return ctx.stream()
                .flatMap(c -> c.columnConstraint().stream())
                .map(this::buildColumnConstraint)
                .toList();
    }


    private ColumnConstraint buildColumnConstraint(AlterColumnAddParser.ColumnConstraintContext ctx) {
        A_AstNode node = visit(ctx);

        if (!(node instanceof ColumnConstraint)) {
            throw new IllegalStateException(
                    "Expected ColumnConstraint but got " + node.getClass().getSimpleName()
            );
        }
        return  (ColumnConstraint) node;
    }

    // visitors de constraint triviais que apenas constroem o nó da AST
    @Override
    public A_AstNode visitNotNullConstraint(AlterColumnAddParser.NotNullConstraintContext ctx) {return new NotNullConstraint();}
    @Override
    public A_AstNode visitNullConstraint(AlterColumnAddParser.NullConstraintContext ctx) {return new NullConstraint();}
    @Override
    public A_AstNode visitPrimaryKeyConstraint(AlterColumnAddParser.PrimaryKeyConstraintContext ctx) {return new PrimaryKeyConstraint();}
    @Override
    public A_AstNode visitUniqueConstraint(AlterColumnAddParser.UniqueConstraintContext ctx) {return new UniqueConstraint();}
    @Override
    public A_AstNode visitAutoIncrementConstraint(AlterColumnAddParser.AutoIncrementConstraintContext ctx) {return new AutoIncrementConstraint();}
    @Override
    public A_AstNode visitDefaultConstraint(AlterColumnAddParser.DefaultConstraintContext ctx) {
        A_AstNode value = visit(ctx.defaultValue());return new DefaultConstraint(value);}

    // visitors de tipos triviais que apenas constroem o nó da AST
    @Override
    public A_AstNode visitBigintType(AlterColumnAddParser.BigintTypeContext ctx) {return new BigIntType();}
    @Override
    public A_AstNode visitFloatType(AlterColumnAddParser.FloatTypeContext ctx) {return new FloatType();}
    @Override
    public A_AstNode visitDoubleType(AlterColumnAddParser.DoubleTypeContext ctx) {return new DoubleType();}
    @Override
    public A_AstNode visitDateType(AlterColumnAddParser.DateTypeContext ctx) {return new DateType();}
    @Override
    public A_AstNode visitDatetimeType(AlterColumnAddParser.DatetimeTypeContext ctx) {return new DateTimeType();}
    @Override
    public A_AstNode visitTimestampType(AlterColumnAddParser.TimestampTypeContext ctx) {return new TimestampType();}
    @Override
    public A_AstNode visitTextType(AlterColumnAddParser.TextTypeContext ctx) {return new TextType();}
    @Override
    public A_AstNode visitBooleanType(AlterColumnAddParser.BooleanTypeContext ctx) {return new BooleanType();}
    @Override
    public A_AstNode visitIntType(AlterColumnAddParser.IntTypeContext ctx) {return new IntType();}
    @Override
    public A_AstNode visitIntegerType(AlterColumnAddParser.IntegerTypeContext ctx) {return new IntegerType();}
    /**
     * Char é um tipo parametrizado, que necessita de um visitor para realizar o parsing,
     * assim conseguindo extrair o seu valor da gramática e construir o tipo configurado.
     *
     * @param ctx Traz o tipo do contexto
     * @return AstNode retorna o tamanho do Char num nó AST.
     */
    @Override
    public A_AstNode visitCharType(AlterColumnAddParser.CharTypeContext ctx) {
        int length = Integer.parseInt(ctx.INT_NUMBER().getText());
        return new CharType(length);
    }

    /**
     * Varchar é um tipo parametrizado, que necessita de um visitor para realizar o parsing, assim conseguindo extrair o seu valor da gramática e construir o tipo configurado.
     * @param ctx Traz o tipo do contexto
     * @return AstNode retorna o tamanho do Varchar num nó AST.
     * */
    @Override
    public A_AstNode visitVarcharType(AlterColumnAddParser.VarcharTypeContext ctx) {
        int length = Integer.parseInt(ctx.INT_NUMBER().getText());
        return new VarcharType(length);
    }

    /**
     * Decimal é um tipo parametrizado, que necessita de um visitor para realizar o parsing, assim conseguindo extrair os seus valores da gramática e construir o tipo configurado.
     * @param ctx Traz o tipo do contexto
     * @return AstNode retorna precison e a scale do Decimal num nó AST.
     * */
    @Override
    public A_AstNode visitDecimalType(AlterColumnAddParser.DecimalTypeContext ctx) {
        int precision = Integer.parseInt(ctx.INT_NUMBER(0).getText());
        Integer scale = ctx.INT_NUMBER().size() > 1
                ? Integer.parseInt(ctx.INT_NUMBER(1).getText())
                : null;

        return new DecimalType(precision, scale);
    }

    @Override
    public A_AstNode visitStringDefault(
            AlterColumnAddParser.StringDefaultContext ctx) {

        String quoted = ctx.STRING().getText();
        String unquoted = quoted.substring(1, quoted.length() - 1)
                .replace("''", "'");
        return new StringLiteral(unquoted);
    }

    @Override
    public A_AstNode visitNullDefault(
            AlterColumnAddParser.NullDefaultContext ctx) {

        return NullLiteral.INSTANCE;
    }

    @Override
    public A_AstNode visitTrueDefault(
            AlterColumnAddParser.TrueDefaultContext ctx) {

        return BooleanLiteral.TRUE;
    }

    @Override
    public A_AstNode visitFalseDefault(
            AlterColumnAddParser.FalseDefaultContext ctx) {

        return BooleanLiteral.FALSE;
    }
}
