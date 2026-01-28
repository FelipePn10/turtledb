// Generated from src/main/java/com/db/turtle/parser/antlr/statement/ddl/create/table/CreateTable.g4 by ANTLR 4.13.1

package com.db.turtle.parser.antlr.statement.ddl.create.table;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CreateTableParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CREATE=1, TABLE=2, VARCHAR=3, CHAR=4, INT=5, INTEGER=6, BIGINT=7, DECIMAL=8, 
		FLOAT=9, DOUBLE=10, DATE=11, DATETIME=12, TIMESTAMP=13, TEXT=14, BOOLEAN=15, 
		NOT=16, NULL=17, PRIMARY=18, KEY=19, UNIQUE=20, AUTO_INCREMENT=21, DEFAULT=22, 
		TRUE=23, FALSE=24, LPAREN=25, RPAREN=26, COMMA=27, IDENTIFIER=28, NUMBER=29, 
		STRING=30, WS=31;
	public static final int
		RULE_statementddl = 0, RULE_createTable = 1, RULE_columnDef = 2, RULE_columnName = 3, 
		RULE_tableName = 4, RULE_dataType = 5, RULE_columnConstraints = 6, RULE_columnConstraint = 7, 
		RULE_defaultValue = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"statementddl", "createTable", "columnDef", "columnName", "tableName", 
			"dataType", "columnConstraints", "columnConstraint", "defaultValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CREATE", "TABLE", "VARCHAR", "CHAR", "INT", "INTEGER", "BIGINT", 
			"DECIMAL", "FLOAT", "DOUBLE", "DATE", "DATETIME", "TIMESTAMP", "TEXT", 
			"BOOLEAN", "NOT", "NULL", "PRIMARY", "KEY", "UNIQUE", "AUTO_INCREMENT", 
			"DEFAULT", "TRUE", "FALSE", "LPAREN", "RPAREN", "COMMA", "IDENTIFIER", 
			"NUMBER", "STRING", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CreateTable.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CreateTableParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementddlContext extends ParserRuleContext {
		public CreateTableContext createTable() {
			return getRuleContext(CreateTableContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CreateTableParser.EOF, 0); }
		public StatementddlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementddl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitStatementddl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementddlContext statementddl() throws RecognitionException {
		StatementddlContext _localctx = new StatementddlContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statementddl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			createTable();
			setState(19);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(CreateTableParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(CreateTableParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CreateTableParser.LPAREN, 0); }
		public List<ColumnDefContext> columnDef() {
			return getRuleContexts(ColumnDefContext.class);
		}
		public ColumnDefContext columnDef(int i) {
			return getRuleContext(ColumnDefContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(CreateTableParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CreateTableParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CreateTableParser.COMMA, i);
		}
		public CreateTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitCreateTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableContext createTable() throws RecognitionException {
		CreateTableContext _localctx = new CreateTableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_createTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(CREATE);
			setState(22);
			match(TABLE);
			setState(23);
			tableName();
			setState(24);
			match(LPAREN);
			setState(25);
			columnDef();
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(26);
				match(COMMA);
				setState(27);
				columnDef();
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnDefContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ColumnConstraintsContext columnConstraints() {
			return getRuleContext(ColumnConstraintsContext.class,0);
		}
		public ColumnDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitColumnDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDefContext columnDef() throws RecognitionException {
		ColumnDefContext _localctx = new ColumnDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_columnDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			columnName();
			setState(36);
			dataType();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7798784L) != 0)) {
				{
				setState(37);
				columnConstraints();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CreateTableParser.IDENTIFIER, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CreateTableParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	 
		public DataTypeContext() { }
		public void copyFrom(DataTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharTypeContext extends DataTypeContext {
		public TerminalNode CHAR() { return getToken(CreateTableParser.CHAR, 0); }
		public TerminalNode LPAREN() { return getToken(CreateTableParser.LPAREN, 0); }
		public TerminalNode NUMBER() { return getToken(CreateTableParser.NUMBER, 0); }
		public TerminalNode RPAREN() { return getToken(CreateTableParser.RPAREN, 0); }
		public CharTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleTypeContext extends DataTypeContext {
		public TerminalNode DOUBLE() { return getToken(CreateTableParser.DOUBLE, 0); }
		public DoubleTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitDoubleType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalTypeContext extends DataTypeContext {
		public TerminalNode DECIMAL() { return getToken(CreateTableParser.DECIMAL, 0); }
		public TerminalNode LPAREN() { return getToken(CreateTableParser.LPAREN, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(CreateTableParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CreateTableParser.NUMBER, i);
		}
		public TerminalNode RPAREN() { return getToken(CreateTableParser.RPAREN, 0); }
		public TerminalNode COMMA() { return getToken(CreateTableParser.COMMA, 0); }
		public DecimalTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitDecimalType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanTypeContext extends DataTypeContext {
		public TerminalNode BOOLEAN() { return getToken(CreateTableParser.BOOLEAN, 0); }
		public BooleanTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerTypeContext extends DataTypeContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public IntegerTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitIntegerType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeContext extends DataTypeContext {
		public TerminalNode INT() { return getToken(CreateTableParser.INT, 0); }
		public IntTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextTypeContext extends DataTypeContext {
		public TerminalNode TEXT() { return getToken(CreateTableParser.TEXT, 0); }
		public TextTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitTextType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatTypeContext extends DataTypeContext {
		public TerminalNode FLOAT() { return getToken(CreateTableParser.FLOAT, 0); }
		public FloatTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTypeContext extends DataTypeContext {
		public TerminalNode DATE() { return getToken(CreateTableParser.DATE, 0); }
		public DateTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitDateType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DatetimeTypeContext extends DataTypeContext {
		public TerminalNode DATETIME() { return getToken(CreateTableParser.DATETIME, 0); }
		public DatetimeTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitDatetimeType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimestampTypeContext extends DataTypeContext {
		public TerminalNode TIMESTAMP() { return getToken(CreateTableParser.TIMESTAMP, 0); }
		public TimestampTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitTimestampType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BigintTypeContext extends DataTypeContext {
		public TerminalNode BIGINT() { return getToken(CreateTableParser.BIGINT, 0); }
		public BigintTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitBigintType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarcharTypeContext extends DataTypeContext {
		public TerminalNode VARCHAR() { return getToken(CreateTableParser.VARCHAR, 0); }
		public TerminalNode LPAREN() { return getToken(CreateTableParser.LPAREN, 0); }
		public TerminalNode NUMBER() { return getToken(CreateTableParser.NUMBER, 0); }
		public TerminalNode RPAREN() { return getToken(CreateTableParser.RPAREN, 0); }
		public VarcharTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitVarcharType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dataType);
		int _la;
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARCHAR:
				_localctx = new VarcharTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(VARCHAR);
				setState(45);
				match(LPAREN);
				setState(46);
				match(NUMBER);
				setState(47);
				match(RPAREN);
				}
				break;
			case CHAR:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(CHAR);
				setState(49);
				match(LPAREN);
				setState(50);
				match(NUMBER);
				setState(51);
				match(RPAREN);
				}
				break;
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				match(INT);
				}
				break;
			case INTEGER:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				match(INTEGER);
				}
				break;
			case BIGINT:
				_localctx = new BigintTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				match(BIGINT);
				}
				break;
			case DECIMAL:
				_localctx = new DecimalTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(55);
				match(DECIMAL);
				setState(56);
				match(LPAREN);
				setState(57);
				match(NUMBER);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(58);
					match(COMMA);
					setState(59);
					match(NUMBER);
					}
				}

				setState(62);
				match(RPAREN);
				}
				break;
			case FLOAT:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(63);
				match(FLOAT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(64);
				match(DOUBLE);
				}
				break;
			case DATE:
				_localctx = new DateTypeContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(65);
				match(DATE);
				}
				break;
			case DATETIME:
				_localctx = new DatetimeTypeContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(66);
				match(DATETIME);
				}
				break;
			case TIMESTAMP:
				_localctx = new TimestampTypeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(67);
				match(TIMESTAMP);
				}
				break;
			case TEXT:
				_localctx = new TextTypeContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(68);
				match(TEXT);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(69);
				match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnConstraintsContext extends ParserRuleContext {
		public List<ColumnConstraintContext> columnConstraint() {
			return getRuleContexts(ColumnConstraintContext.class);
		}
		public ColumnConstraintContext columnConstraint(int i) {
			return getRuleContext(ColumnConstraintContext.class,i);
		}
		public ColumnConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnConstraints; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitColumnConstraints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnConstraintsContext columnConstraints() throws RecognitionException {
		ColumnConstraintsContext _localctx = new ColumnConstraintsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_columnConstraints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(72);
				columnConstraint();
				}
				}
				setState(75); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7798784L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnConstraintContext extends ParserRuleContext {
		public ColumnConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnConstraint; }
	 
		public ColumnConstraintContext() { }
		public void copyFrom(ColumnConstraintContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullConstraintContext extends ColumnConstraintContext {
		public TerminalNode NULL() { return getToken(CreateTableParser.NULL, 0); }
		public NullConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitNullConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AutoIncrementConstraintContext extends ColumnConstraintContext {
		public TerminalNode AUTO_INCREMENT() { return getToken(CreateTableParser.AUTO_INCREMENT, 0); }
		public AutoIncrementConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitAutoIncrementConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotNullConstraintContext extends ColumnConstraintContext {
		public TerminalNode NOT() { return getToken(CreateTableParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(CreateTableParser.NULL, 0); }
		public NotNullConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitNotNullConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefaultConstraintContext extends ColumnConstraintContext {
		public TerminalNode DEFAULT() { return getToken(CreateTableParser.DEFAULT, 0); }
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public DefaultConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitDefaultConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryKeyConstraintContext extends ColumnConstraintContext {
		public TerminalNode PRIMARY() { return getToken(CreateTableParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(CreateTableParser.KEY, 0); }
		public PrimaryKeyConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitPrimaryKeyConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UniqueConstraintContext extends ColumnConstraintContext {
		public TerminalNode UNIQUE() { return getToken(CreateTableParser.UNIQUE, 0); }
		public UniqueConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitUniqueConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnConstraintContext columnConstraint() throws RecognitionException {
		ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_columnConstraint);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new NotNullConstraintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(NOT);
				setState(78);
				match(NULL);
				}
				break;
			case NULL:
				_localctx = new NullConstraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(NULL);
				}
				break;
			case PRIMARY:
				_localctx = new PrimaryKeyConstraintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				match(PRIMARY);
				setState(81);
				match(KEY);
				}
				break;
			case UNIQUE:
				_localctx = new UniqueConstraintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				match(UNIQUE);
				}
				break;
			case AUTO_INCREMENT:
				_localctx = new AutoIncrementConstraintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				match(AUTO_INCREMENT);
				}
				break;
			case DEFAULT:
				_localctx = new DefaultConstraintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(84);
				match(DEFAULT);
				setState(85);
				defaultValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultValueContext extends ParserRuleContext {
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
	 
		public DefaultValueContext() { }
		public void copyFrom(DefaultValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseDefaultContext extends DefaultValueContext {
		public TerminalNode FALSE() { return getToken(CreateTableParser.FALSE, 0); }
		public FalseDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitFalseDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberDefaultContext extends DefaultValueContext {
		public TerminalNode NUMBER() { return getToken(CreateTableParser.NUMBER, 0); }
		public NumberDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitNumberDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullDefaultContext extends DefaultValueContext {
		public TerminalNode NULL() { return getToken(CreateTableParser.NULL, 0); }
		public NullDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitNullDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueDefaultContext extends DefaultValueContext {
		public TerminalNode TRUE() { return getToken(CreateTableParser.TRUE, 0); }
		public TrueDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitTrueDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringDefaultContext extends DefaultValueContext {
		public TerminalNode STRING() { return getToken(CreateTableParser.STRING, 0); }
		public StringDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CreateTableVisitor ) return ((CreateTableVisitor<? extends T>)visitor).visitStringDefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_defaultValue);
		try {
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(NUMBER);
				}
				break;
			case STRING:
				_localctx = new StringDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(STRING);
				}
				break;
			case NULL:
				_localctx = new NullDefaultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(NULL);
				}
				break;
			case TRUE:
				_localctx = new TrueDefaultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseDefaultContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f`\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"\u001d\b\u0001\n\u0001\f\u0001 \t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\'\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005=\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005G\b"+
		"\u0005\u0001\u0006\u0004\u0006J\b\u0006\u000b\u0006\f\u0006K\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007W\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\b^\b\b\u0001\b\u0000\u0000\t\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0000\u0000o\u0000\u0012\u0001\u0000\u0000\u0000"+
		"\u0002\u0015\u0001\u0000\u0000\u0000\u0004#\u0001\u0000\u0000\u0000\u0006"+
		"(\u0001\u0000\u0000\u0000\b*\u0001\u0000\u0000\u0000\nF\u0001\u0000\u0000"+
		"\u0000\fI\u0001\u0000\u0000\u0000\u000eV\u0001\u0000\u0000\u0000\u0010"+
		"]\u0001\u0000\u0000\u0000\u0012\u0013\u0003\u0002\u0001\u0000\u0013\u0014"+
		"\u0005\u0000\u0000\u0001\u0014\u0001\u0001\u0000\u0000\u0000\u0015\u0016"+
		"\u0005\u0001\u0000\u0000\u0016\u0017\u0005\u0002\u0000\u0000\u0017\u0018"+
		"\u0003\b\u0004\u0000\u0018\u0019\u0005\u0019\u0000\u0000\u0019\u001e\u0003"+
		"\u0004\u0002\u0000\u001a\u001b\u0005\u001b\u0000\u0000\u001b\u001d\u0003"+
		"\u0004\u0002\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001d \u0001\u0000"+
		"\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000"+
		"\u0000\u0000\u001f!\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000"+
		"!\"\u0005\u001a\u0000\u0000\"\u0003\u0001\u0000\u0000\u0000#$\u0003\u0006"+
		"\u0003\u0000$&\u0003\n\u0005\u0000%\'\u0003\f\u0006\u0000&%\u0001\u0000"+
		"\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\u0005\u0001\u0000\u0000\u0000"+
		"()\u0005\u001c\u0000\u0000)\u0007\u0001\u0000\u0000\u0000*+\u0005\u001c"+
		"\u0000\u0000+\t\u0001\u0000\u0000\u0000,-\u0005\u0003\u0000\u0000-.\u0005"+
		"\u0019\u0000\u0000./\u0005\u001d\u0000\u0000/G\u0005\u001a\u0000\u0000"+
		"01\u0005\u0004\u0000\u000012\u0005\u0019\u0000\u000023\u0005\u001d\u0000"+
		"\u00003G\u0005\u001a\u0000\u00004G\u0005\u0005\u0000\u00005G\u0005\u0006"+
		"\u0000\u00006G\u0005\u0007\u0000\u000078\u0005\b\u0000\u000089\u0005\u0019"+
		"\u0000\u00009<\u0005\u001d\u0000\u0000:;\u0005\u001b\u0000\u0000;=\u0005"+
		"\u001d\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000>G\u0005\u001a\u0000\u0000?G\u0005\t\u0000\u0000"+
		"@G\u0005\n\u0000\u0000AG\u0005\u000b\u0000\u0000BG\u0005\f\u0000\u0000"+
		"CG\u0005\r\u0000\u0000DG\u0005\u000e\u0000\u0000EG\u0005\u000f\u0000\u0000"+
		"F,\u0001\u0000\u0000\u0000F0\u0001\u0000\u0000\u0000F4\u0001\u0000\u0000"+
		"\u0000F5\u0001\u0000\u0000\u0000F6\u0001\u0000\u0000\u0000F7\u0001\u0000"+
		"\u0000\u0000F?\u0001\u0000\u0000\u0000F@\u0001\u0000\u0000\u0000FA\u0001"+
		"\u0000\u0000\u0000FB\u0001\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000G\u000b\u0001\u0000"+
		"\u0000\u0000HJ\u0003\u000e\u0007\u0000IH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"L\r\u0001\u0000\u0000\u0000MN\u0005\u0010\u0000\u0000NW\u0005\u0011\u0000"+
		"\u0000OW\u0005\u0011\u0000\u0000PQ\u0005\u0012\u0000\u0000QW\u0005\u0013"+
		"\u0000\u0000RW\u0005\u0014\u0000\u0000SW\u0005\u0015\u0000\u0000TU\u0005"+
		"\u0016\u0000\u0000UW\u0003\u0010\b\u0000VM\u0001\u0000\u0000\u0000VO\u0001"+
		"\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000VR\u0001\u0000\u0000\u0000"+
		"VS\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000W\u000f\u0001\u0000"+
		"\u0000\u0000X^\u0005\u001d\u0000\u0000Y^\u0005\u001e\u0000\u0000Z^\u0005"+
		"\u0011\u0000\u0000[^\u0005\u0017\u0000\u0000\\^\u0005\u0018\u0000\u0000"+
		"]X\u0001\u0000\u0000\u0000]Y\u0001\u0000\u0000\u0000]Z\u0001\u0000\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000]\\\u0001\u0000\u0000\u0000^\u0011\u0001"+
		"\u0000\u0000\u0000\u0007\u001e&<FKV]";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}