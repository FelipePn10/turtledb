package com.db.turtle.parser.visitor;

import com.db.turtle.parser.antlr.statement.ddl.create.table.CreateTableBaseVisitor;
import com.db.turtle.parser.antlr.statement.ddl.create.table.CreateTableParser;
import com.db.turtle.parser.ast.denominator.AstNode;
import com.db.turtle.parser.ast.ntm.ColumnDef;
import com.db.turtle.parser.ast.ntm.ColumnName;
import com.db.turtle.parser.ast.ntm.TableName;
import com.db.turtle.parser.ast.ntm.constraint.ColumnConstraint;
import com.db.turtle.parser.ast.ntm.constraint.DefaultConstraint;
import com.db.turtle.parser.ast.ntm.constraint.NotNullConstraint;
import com.db.turtle.parser.ast.ntm.constraint.PrimaryKeyConstraint;
import com.db.turtle.parser.ast.ntm.types.DataType;
import com.db.turtle.parser.ast.ntm.types.DecimalType;
import com.db.turtle.parser.ast.ntm.types.IntType;
import com.db.turtle.parser.ast.ntm.types.VarcharType;
import com.db.turtle.parser.ast.statements.CreateTableStatement;

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

    @Override
    public AstNode visitDataType(CreateTableParser.DataTypeContext ctx) {
        if (ctx.VARCHAR() != null) {
            return parseVarchar(ctx);
        }

        if (ctx.INT() != null) {
            return new IntType();
        }

        if (ctx.DECIMAL() != null) {
            return parseDecimal(ctx);
        }

        // CHAR, INTEGER, BIGINT, FLOAT, DOUBLE, DATE, DATETIME, TIMESTAMP, TEXT, BOOLEAN

        throw new IllegalStateException("Unknown data type: " + ctx.getText());
    }


    @Override
    public AstNode visitColumnConstraint(CreateTableParser.ColumnConstraintContext ctx) {

        // NOT NULL
        if (ctx.NOT() != null && ctx.NULL() != null) {
            return new NotNullConstraint();
        }

        // PRIMARY KEY
        if (ctx.PRIMARY() != null && ctx.KEY() != null) {
            return new PrimaryKeyConstraint();
        }

        // DEFAULT valor
        if (ctx.DEFAULT() != null) {
            Object defaultValue = parseDefaultValue(ctx.defaultValue());
            return new DefaultConstraint(defaultValue);
        }

        // UNIQUE, AUTO_INCREMENT, NULL

        throw new IllegalStateException("Unknown constraint: " + ctx.getText());
    }

    private VarcharType parseVarchar(CreateTableParser.DataTypeContext ctx) {
        int size = Integer.parseInt(ctx.NUMBER(0).getText());
        return new VarcharType(size);
    }

    private DecimalType parseDecimal(CreateTableParser.DataTypeContext ctx) {
        int precision = Integer.parseInt(ctx.NUMBER(0).getText());
        Integer scale = ctx.NUMBER().size() > 1
                ? Integer.parseInt(ctx.NUMBER(1).getText())
                : null;

        return new DecimalType(precision, scale);
    }

    /**
     * Parseia o valor default da constraint DEFAULT
     */
    private Object parseDefaultValue(CreateTableParser.DefaultValueContext ctx) {
        if (ctx == null) {
            throw new IllegalArgumentException("Default value cannot be null");
        }

        // NUMBER
        if (ctx.NUMBER() != null) {
            String numberText = ctx.NUMBER().getText();
            if (numberText.contains(".")) {
                return Double.parseDouble(numberText);
            } else {
                return Integer.parseInt(numberText);
            }
        }

        // STRING
        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            // Remove aspas do início e fim
            return text.substring(1, text.length() - 1);
        }

        // NULL
        if (ctx.NULL() != null) {
            return null;
        }

        // TRUE
        if (ctx.TRUE() != null) {
            return true;
        }

        // FALSE
        if (ctx.FALSE() != null) {
            return false;
        }

        throw new IllegalStateException("Unknown default value: " + ctx.getText());
    }
}
