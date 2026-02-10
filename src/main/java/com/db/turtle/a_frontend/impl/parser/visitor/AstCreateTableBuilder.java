package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableParser;
import com.db.turtle.a_frontend.common.denominator.A_AstNode;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.BooleanLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NullLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NumberLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.StringLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.*;
import com.db.turtle.a_frontend.common.commands_ast.statements.CreateTableStatement;

import java.util.List;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos CREATE TABLE.
 */
public class AstCreateTableBuilder extends CreateTableBaseVisitor<A_AstNode> {

    @Override
    public A_AstNode visitCreateTable(CreateTableParser.CreateTableContext ctx) {
        TableName table = buildTableName(ctx.tableName()).name();

        List<ColumnDef> columns = ctx.columnDef()
                .stream()
                .map(this::buildColumnDef)
                .toList();

        return new CreateTableStatement(table, columns);
    }
    /**
     * Constrói um TableName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da tabela
     * @return TableName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private TableRef buildTableName(CreateTableParser.TableNameContext ctx) {
        return TableRef.of(new TableName(ctx.IDENTIFIER().getText()));
    }

    /**
     * Constrói um ColumnDef a partir do contexto do parser.
     *
     * @param ctx contexto contendo nome, tipo e constraints da coluna
     * @return ColumnDef imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private ColumnDef buildColumnDef(CreateTableParser.ColumnDefContext ctx) {
        ColumnRef columnRef = buildColumnName(ctx.columnName());
        DataType dataType = buildDataType(ctx.dataType());
        List<ColumnConstraint> constraints = buildConstraints(ctx.columnConstraints());

        return new ColumnDef(columnRef, dataType, constraints);
    }

    /**
     * Constrói um ColumnName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da coluna
     * @return ColumnName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private ColumnRef buildColumnName(CreateTableParser.ColumnNameContext ctx) {
        return ColumnRef.of(new ColumnName(ctx.IDENTIFIER().getText()));
    }

    /**
     * Constrói um DataType visitando o contexto correspondente.
     * O ANTLR automaticamente chama visitDataType, que determina
     * o tipo específico (INT, VARCHAR, DECIMAL, etc).
     *
     * @param ctx contexto do tipo de dado
     * @return DataType específico (IntType, VarcharType, etc)
     * @throws IllegalStateException se o visitor retornar tipo inesperado
     */
    private DataType buildDataType(CreateTableParser.DataTypeContext ctx) {
        // Delega para o visitor específico via contexto ANTLR (VARCHAR, INT, etc)
        A_AstNode node = visit(ctx);

        if (!(node instanceof DataType)) {
            throw new IllegalStateException(
                    "Expected DataType but got " + node.getClass().getSimpleName()
            );
        }

        return (DataType) node;
    }

    /**
     * Constrói uma lista de ColumnConstraints a partir do contexto.
     * Retorna lista vazia se não houver constraints.
     *
     * @param ctx contexto contendo as constraints (pode ser null)
     * @return lista imutável de ColumnConstraint (vazia se sem constraints)
     */
    private List<ColumnConstraint> buildConstraints(
            CreateTableParser.ColumnConstraintsContext ctx
    ) {
        if (ctx.columnConstraint() == null) {
            return List.of();
        }

        return ctx.columnConstraint()
                .stream()
                .map(this::buildColumnConstraint)
                .toList();
    }

    /**
     * Constrói um ColumnConstraint visitando o contexto correspondente.
     * O ANTLR automaticamente chama visitColumnConstraint, que determina
     * o tipo específico (NOT NULL, PRIMARY KEY, UNIQUE, etc).
     *
     * @param ctx contexto da constraint
     * @return ColumnConstraint específico
     * @throws IllegalArgumentException se o contexto for inválido
     * @throws IllegalStateException se o visitor retornar tipo inesperado
     */
    private ColumnConstraint buildColumnConstraint(CreateTableParser.ColumnConstraintContext ctx) {
        // Delega para o visitor específico via contexto ANTLR (NOT NULL, PRIMARY KEY, etc)
        A_AstNode node = visit(ctx);

        if (!(node instanceof ColumnConstraint)) {
            throw new IllegalStateException(
                    "Expected ColumnConstraint but got " + node.getClass().getSimpleName()
            );
        }

        return (ColumnConstraint) node;
    }

    // visitors de constraint triviais que apenas constroem o nó da AST
    @Override
    public A_AstNode visitNotNullConstraint(CreateTableParser.NotNullConstraintContext ctx) {return new NotNullConstraint();}
    @Override
    public A_AstNode visitNullConstraint(CreateTableParser.NullConstraintContext ctx) {return new NullConstraint();}
    @Override
    public A_AstNode visitPrimaryKeyConstraint(CreateTableParser.PrimaryKeyConstraintContext ctx) {return new PrimaryKeyConstraint();}
    @Override
    public A_AstNode visitUniqueConstraint(CreateTableParser.UniqueConstraintContext ctx) {return new UniqueConstraint();}
    @Override
    public A_AstNode visitAutoIncrementConstraint(CreateTableParser.AutoIncrementConstraintContext ctx) {return new AutoIncrementConstraint();}
    @Override
    public A_AstNode visitDefaultConstraint(CreateTableParser.DefaultConstraintContext ctx) {
        A_AstNode value = visit(ctx.defaultValue());return new DefaultConstraint(value);}

    // visitors de tipos triviais que apenas constroem o nó da AST
    @Override
    public A_AstNode visitBigintType(CreateTableParser.BigintTypeContext ctx) {return new BigIntType();}
    @Override
    public A_AstNode visitFloatType(CreateTableParser.FloatTypeContext ctx) {return new FloatType();}
    @Override
    public A_AstNode visitDoubleType(CreateTableParser.DoubleTypeContext ctx) {return new DoubleType();}
    @Override
    public A_AstNode visitDateType(CreateTableParser.DateTypeContext ctx) {return new DateType();}
    @Override
    public A_AstNode visitDatetimeType(CreateTableParser.DatetimeTypeContext ctx) {return new DateTimeType();}
    @Override
    public A_AstNode visitTimestampType(CreateTableParser.TimestampTypeContext ctx) {return new TimestampType();}
    @Override
    public A_AstNode visitTextType(CreateTableParser.TextTypeContext ctx) {return new TextType();}
    @Override
    public A_AstNode visitBooleanType(CreateTableParser.BooleanTypeContext ctx) {return new BooleanType();}
    @Override
    public A_AstNode visitIntType(CreateTableParser.IntTypeContext ctx) {return new IntType();}
    @Override
    public A_AstNode visitIntegerType(CreateTableParser.IntegerTypeContext ctx) {return new IntegerType();}
/**
 * Char é um tipo parametrizado, que necessita de um visitor para realizar o parsing,
 * assim conseguindo extrair o seu valor da gramática e construir o tipo configurado.
 *
 * @param ctx Traz o tipo do contexto
 * @return AstNode retorna o tamanho do Char num nó AST.
 */
@Override
public A_AstNode visitCharType(CreateTableParser.CharTypeContext ctx) {
    int length = Integer.parseInt(ctx.NUMBER().getText());
    return new CharType(length);
}

    /**
     * Varchar é um tipo parametrizado, que necessita de um visitor para realizar o parsing, assim conseguindo extrair o seu valor da gramática e construir o tipo configurado.
     * @param ctx Traz o tipo do contexto
     * @return AstNode retorna o tamanho do Varchar num nó AST.
     * */
    @Override
    public A_AstNode visitVarcharType(CreateTableParser.VarcharTypeContext ctx) {
        int length = Integer.parseInt(ctx.NUMBER().getText());
        return new VarcharType(length);
    }

    /**
     * Decimal é um tipo parametrizado, que necessita de um visitor para realizar o parsing, assim conseguindo extrair os seus valores da gramática e construir o tipo configurado.
     * @param ctx Traz o tipo do contexto
     * @return AstNode retorna precison e a scale do Decimal num nó AST.
     * */
    @Override
    public A_AstNode visitDecimalType(CreateTableParser.DecimalTypeContext ctx) {
        int precision = Integer.parseInt(ctx.NUMBER(0).getText());
        Integer scale = ctx.NUMBER().size() > 1
                ? Integer.parseInt(ctx.NUMBER(1).getText())
                : null;

        return new DecimalType(precision, scale);
    }

@Override
public A_AstNode visitStringDefault(
        CreateTableParser.StringDefaultContext ctx) {

    String quoted = ctx.STRING().getText();
    // Remove aspas externas e trata escape ('' -> ')
    String unquoted = quoted.substring(1, quoted.length() - 1)
            .replace("''", "'");
    return new StringLiteral(unquoted);
}

@Override
public A_AstNode visitNumberDefault(CreateTableParser.NumberDefaultContext ctx) {
    return new NumberLiteral(ctx.NUMBER().getText());
}

@Override
public A_AstNode visitNullDefault(
        CreateTableParser.NullDefaultContext ctx) {

    return NullLiteral.INSTANCE;
}

@Override
public A_AstNode visitTrueDefault(
        CreateTableParser.TrueDefaultContext ctx) {

    return BooleanLiteral.TRUE;
}

@Override
public A_AstNode visitFalseDefault(
        CreateTableParser.FalseDefaultContext ctx) {

    return BooleanLiteral.FALSE;
  }
}