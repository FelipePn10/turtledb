package com.db.turtle.a_frontend.impl.parser.visitor;

import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableBaseVisitor;
import com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.create.table.CreateTableParser;
import com.db.turtle.a_frontend.impl.parser.ast.denominator.AstNode;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.BooleanLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NullLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.NumberLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.expression.literal.StringLiteral;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.constraint.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.types.*;
import com.db.turtle.a_frontend.parser.ast.ntm.constraint.*;
import com.db.turtle.a_frontend.parser.ast.ntm.types.*;
import com.db.turtle.parser.ast.expression.literal.*;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnDef;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.ColumnName;
import com.db.turtle.a_frontend.impl.parser.ast.ntm.TableName;
import com.db.turtle.parser.ast.ntm.constraint.*;
import com.db.turtle.parser.ast.ntm.types.*;
import com.db.turtle.a_frontend.impl.parser.ast.statements.CreateTableStatement;

import java.util.List;

/**
 * Visitor que constrói a AST (Abstract Syntax Tree) a partir do parse tree
 * gerado pelo ANTLR para comandos CREATE TABLE.
 */
public class AstCreateTableBuilder extends CreateTableBaseVisitor<AstNode> {

    @Override
    public AstNode visitCreateTable(CreateTableParser.CreateTableContext ctx) {
        TableName table = buildTableName(ctx.tableName());

        List<ColumnDef> columns = ctx.columnDef()
                .stream()
                .map(this::buildColumnDef)
                .toList();

        return new CreateTableStatement(table, columns);
    }

    @Override
    public AstNode visitTableName(CreateTableParser.TableNameContext ctx) {
        return buildTableName(ctx);
    }

    @Override
    public AstNode visitColumnDef(CreateTableParser.ColumnDefContext ctx) {
        return buildColumnDef(ctx);
    }

    /**
     * Constrói um TableName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da tabela
     * @return TableName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private TableName buildTableName(CreateTableParser.TableNameContext ctx) {
        if (ctx == null || ctx.IDENTIFIER() == null) {
            throw new IllegalArgumentException("Invalid table name context");
        }
        return new TableName(ctx.IDENTIFIER().getText());
    }

    /**
     * Constrói um ColumnDef a partir do contexto do parser.
     *
     * @param ctx contexto contendo nome, tipo e constraints da coluna
     * @return ColumnDef imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private ColumnDef buildColumnDef(CreateTableParser.ColumnDefContext ctx) {
        if (ctx == null) {
            throw new IllegalArgumentException("Invalid column definition context");
        }

        ColumnName columnName = buildColumnName(ctx.columnName());
        DataType dataType = buildDataType(ctx.dataType());
        List<ColumnConstraint> constraints = buildConstraints(ctx.columnConstraints());

        return new ColumnDef(columnName, dataType, constraints);
    }

    /**
     * Constrói um ColumnName a partir do contexto do parser.
     *
     * @param ctx contexto contendo o identificador da coluna
     * @return ColumnName imutável
     * @throws IllegalArgumentException se o contexto for inválido
     */
    private ColumnName buildColumnName(CreateTableParser.ColumnNameContext ctx) {
        if (ctx == null || ctx.IDENTIFIER() == null) {
            throw new IllegalArgumentException("Invalid column name context");
        }
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
    private DataType buildDataType(CreateTableParser.DataTypeContext ctx) {
        if (ctx == null) {
            throw new IllegalArgumentException("Invalid data type context");
        }

        // Delega para o visitor específico via contexto ANTLR (VARCHAR, INT, etc)
        AstNode node = visit(ctx);

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
        if (ctx == null || ctx.columnConstraint() == null) {
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
        if (ctx == null) {
            throw new IllegalArgumentException("Invalid constraint context");
        }

        // Delega para o visitor específico via contexto ANTLR (NOT NULL, PRIMARY KEY, etc)
        AstNode node = visit(ctx);

        if (!(node instanceof ColumnConstraint)) {
            throw new IllegalStateException(
                    "Expected ColumnConstraint but got " + node.getClass().getSimpleName()
            );
        }

        return (ColumnConstraint) node;
    }

    // visitors de constraint triviais que apenas constroem o nó da AST
    @Override
    public AstNode visitNotNullConstraint(CreateTableParser.NotNullConstraintContext ctx) {return new NotNullConstraint();}
    @Override
    public AstNode visitNullConstraint(CreateTableParser.NullConstraintContext ctx) {return new NullConstraint();}
    @Override
    public AstNode visitPrimaryKeyConstraint(CreateTableParser.PrimaryKeyConstraintContext ctx) {return new PrimaryKeyConstraint();}
    @Override
    public AstNode visitUniqueConstraint(CreateTableParser.UniqueConstraintContext ctx) {return new UniqueConstraint();}
    @Override
    public AstNode visitAutoIncrementConstraint(CreateTableParser.AutoIncrementConstraintContext ctx) {return new AutoIncrementConstraint();}
    @Override
    public AstNode visitDefaultConstraint(CreateTableParser.DefaultConstraintContext ctx) {AstNode value = visit(ctx.defaultValue());return new DefaultConstraint(value);}

    // visitors de tipos triviais que apenas constroem o nó da AST
    @Override
    public AstNode visitBigintType(CreateTableParser.BigintTypeContext ctx) {return new BigIntType();}
    @Override
    public AstNode visitFloatType(CreateTableParser.FloatTypeContext ctx) {return new FloatType();}
    @Override
    public AstNode visitDoubleType(CreateTableParser.DoubleTypeContext ctx) {return new DoubleType();}
    @Override
    public AstNode visitDateType(CreateTableParser.DateTypeContext ctx) {return new DateType();}
    @Override
    public AstNode visitDatetimeType(CreateTableParser.DatetimeTypeContext ctx) {return new DateTimeType();}
    @Override
    public AstNode visitTimestampType(CreateTableParser.TimestampTypeContext ctx) {return new TimestampType();}
    @Override
    public AstNode visitTextType(CreateTableParser.TextTypeContext ctx) {return new TextType();}
    @Override
    public AstNode visitBooleanType(CreateTableParser.BooleanTypeContext ctx) {return new BooleanType();}
    @Override
    public AstNode visitIntType(CreateTableParser.IntTypeContext ctx) {return new IntType();}
    @Override
    public AstNode visitIntegerType(CreateTableParser.IntegerTypeContext ctx) {return new IntegerType();}
/**
 * Char é um tipo parametrizado, que necessita de um visitor para realizar o parsing,
 * assim conseguindo extrair o seu valor da gramática e construir o tipo configurado.
 *
 * @param ctx Traz o tipo do contexto
 * @return AstNode retorna o tamanho do Char num nó AST.
 */
@Override
public AstNode visitCharType(CreateTableParser.CharTypeContext ctx) {
    int length = Integer.parseInt(ctx.NUMBER().getText());
    return new CharType(length);
}

    /**
     * Varchar é um tipo parametrizado, que necessita de um visitor para realizar o parsing, assim conseguindo extrair o seu valor da gramática e construir o tipo configurado.
     * @param ctx Traz o tipo do contexto
     * @return AstNode retorna o tamanho do Varchar num nó AST.
     * */
    @Override
    public AstNode visitVarcharType(CreateTableParser.VarcharTypeContext ctx) {
        int length = Integer.parseInt(ctx.NUMBER().getText());
        return new VarcharType(length);
    }

    /**
     * Decimal é um tipo parametrizado, que necessita de um visitor para realizar o parsing, assim conseguindo extrair os seus valores da gramática e construir o tipo configurado.
     * @param ctx Traz o tipo do contexto
     * @return AstNode retorna precison e a scale do Decimal num nó AST.
     * */
    @Override
    public AstNode visitDecimalType(CreateTableParser.DecimalTypeContext ctx) {
        int precision = Integer.parseInt(ctx.NUMBER(0).getText());
        Integer scale = ctx.NUMBER().size() > 1
                ? Integer.parseInt(ctx.NUMBER(1).getText())
                : null;

        return new DecimalType(precision, scale);
    }

@Override
public AstNode visitStringDefault(
        CreateTableParser.StringDefaultContext ctx) {

    String quoted = ctx.STRING().getText();
    // Remove aspas externas e trata escape ('' -> ')
    String unquoted = quoted.substring(1, quoted.length() - 1)
            .replace("''", "'");
    return new StringLiteral(unquoted);
}

@Override
public AstNode visitNumberDefault(CreateTableParser.NumberDefaultContext ctx) {
    return new NumberLiteral(ctx.NUMBER().getText());
}

@Override
public AstNode visitNullDefault(
        CreateTableParser.NullDefaultContext ctx) {

    return NullLiteral.INSTANCE;
}

@Override
public AstNode visitTrueDefault(
        CreateTableParser.TrueDefaultContext ctx) {

    return BooleanLiteral.TRUE;
}

@Override
public AstNode visitFalseDefault(
        CreateTableParser.FalseDefaultContext ctx) {

    return BooleanLiteral.FALSE;
  }
}