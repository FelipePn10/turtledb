// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/column/add/AlterColumnAdd.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.add;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AlterColumnAddParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALTER=1, TABLE=2, ADD=3, VARCHAR=4, CHAR=5, INT=6, INTEGER=7, BIGINT=8, 
		DECIMAL=9, FLOAT=10, DOUBLE=11, DATE=12, DATETIME=13, TIMESTAMP=14, TEXT=15, 
		BOOLEAN=16, NOT=17, NULL=18, PRIMARY=19, KEY=20, UNIQUE=21, AUTO_INCREMENT=22, 
		DEFAULT=23, TRUE=24, FALSE=25, LPAREN=26, RPAREN=27, COMMA=28, NUMBER=29, 
		INT_NUMBER=30, DECIMAL_NUMBER=31, STRING=32, IDENTIFIER=33, WS=34;
	public static final int
		RULE_statement = 0, RULE_alterColumnAdd = 1, RULE_tableName = 2, RULE_columnName = 3, 
		RULE_columnConstraints = 4, RULE_columnConstraint = 5, RULE_defaultValue = 6, 
		RULE_dataType = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "alterColumnAdd", "tableName", "columnName", "columnConstraints", 
			"columnConstraint", "defaultValue", "dataType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'('", "')'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ALTER", "TABLE", "ADD", "VARCHAR", "CHAR", "INT", "INTEGER", "BIGINT", 
			"DECIMAL", "FLOAT", "DOUBLE", "DATE", "DATETIME", "TIMESTAMP", "TEXT", 
			"BOOLEAN", "NOT", "NULL", "PRIMARY", "KEY", "UNIQUE", "AUTO_INCREMENT", 
			"DEFAULT", "TRUE", "FALSE", "LPAREN", "RPAREN", "COMMA", "NUMBER", "INT_NUMBER", 
			"DECIMAL_NUMBER", "STRING", "IDENTIFIER", "WS"
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
	public String getGrammarFileName() { return "AlterColumnAdd.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlterColumnAddParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AlterColumnAddContext alterColumnAdd() {
			return getRuleContext(AlterColumnAddContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AlterColumnAddParser.EOF, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			alterColumnAdd();
			setState(17);
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
	public static class AlterColumnAddContext extends ParserRuleContext {
		public TerminalNode ALTER() { return getToken(AlterColumnAddParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(AlterColumnAddParser.TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode ADD() { return getToken(AlterColumnAddParser.ADD, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public List<ColumnConstraintsContext> columnConstraints() {
			return getRuleContexts(ColumnConstraintsContext.class);
		}
		public ColumnConstraintsContext columnConstraints(int i) {
			return getRuleContext(ColumnConstraintsContext.class,i);
		}
		public AlterColumnAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterColumnAdd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitAlterColumnAdd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterColumnAddContext alterColumnAdd() throws RecognitionException {
		AlterColumnAddContext _localctx = new AlterColumnAddContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_alterColumnAdd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(ALTER);
			setState(20);
			match(TABLE);
			setState(21);
			tableName();
			setState(22);
			match(ADD);
			setState(23);
			columnName();
			setState(24);
			dataType();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 15597568L) != 0)) {
				{
				{
				setState(25);
				columnConstraints();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AlterColumnAddParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
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
	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AlterColumnAddParser.IDENTIFIER, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
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
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitColumnConstraints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnConstraintsContext columnConstraints() throws RecognitionException {
		ColumnConstraintsContext _localctx = new ColumnConstraintsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_columnConstraints);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(35);
					columnConstraint();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(38); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode NULL() { return getToken(AlterColumnAddParser.NULL, 0); }
		public NullConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitNullConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AutoIncrementConstraintContext extends ColumnConstraintContext {
		public TerminalNode AUTO_INCREMENT() { return getToken(AlterColumnAddParser.AUTO_INCREMENT, 0); }
		public AutoIncrementConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitAutoIncrementConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotNullConstraintContext extends ColumnConstraintContext {
		public TerminalNode NOT() { return getToken(AlterColumnAddParser.NOT, 0); }
		public TerminalNode NULL() { return getToken(AlterColumnAddParser.NULL, 0); }
		public NotNullConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitNotNullConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefaultConstraintContext extends ColumnConstraintContext {
		public TerminalNode DEFAULT() { return getToken(AlterColumnAddParser.DEFAULT, 0); }
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public DefaultConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitDefaultConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryKeyConstraintContext extends ColumnConstraintContext {
		public TerminalNode PRIMARY() { return getToken(AlterColumnAddParser.PRIMARY, 0); }
		public TerminalNode KEY() { return getToken(AlterColumnAddParser.KEY, 0); }
		public PrimaryKeyConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitPrimaryKeyConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UniqueConstraintContext extends ColumnConstraintContext {
		public TerminalNode UNIQUE() { return getToken(AlterColumnAddParser.UNIQUE, 0); }
		public UniqueConstraintContext(ColumnConstraintContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitUniqueConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnConstraintContext columnConstraint() throws RecognitionException {
		ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_columnConstraint);
		try {
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				_localctx = new NotNullConstraintContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(NOT);
				setState(41);
				match(NULL);
				}
				break;
			case NULL:
				_localctx = new NullConstraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(NULL);
				}
				break;
			case PRIMARY:
				_localctx = new PrimaryKeyConstraintContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(PRIMARY);
				setState(44);
				match(KEY);
				}
				break;
			case UNIQUE:
				_localctx = new UniqueConstraintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				match(UNIQUE);
				}
				break;
			case AUTO_INCREMENT:
				_localctx = new AutoIncrementConstraintContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				match(AUTO_INCREMENT);
				}
				break;
			case DEFAULT:
				_localctx = new DefaultConstraintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
				match(DEFAULT);
				setState(48);
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
		public TerminalNode FALSE() { return getToken(AlterColumnAddParser.FALSE, 0); }
		public FalseDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitFalseDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalDefaultContext extends DefaultValueContext {
		public TerminalNode DECIMAL_NUMBER() { return getToken(AlterColumnAddParser.DECIMAL_NUMBER, 0); }
		public DecimalDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitDecimalDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullDefaultContext extends DefaultValueContext {
		public TerminalNode NULL() { return getToken(AlterColumnAddParser.NULL, 0); }
		public NullDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitNullDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntDefaultContext extends DefaultValueContext {
		public TerminalNode INT_NUMBER() { return getToken(AlterColumnAddParser.INT_NUMBER, 0); }
		public IntDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitIntDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueDefaultContext extends DefaultValueContext {
		public TerminalNode TRUE() { return getToken(AlterColumnAddParser.TRUE, 0); }
		public TrueDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitTrueDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringDefaultContext extends DefaultValueContext {
		public TerminalNode STRING() { return getToken(AlterColumnAddParser.STRING, 0); }
		public StringDefaultContext(DefaultValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitStringDefault(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_defaultValue);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_NUMBER:
				_localctx = new IntDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(INT_NUMBER);
				}
				break;
			case DECIMAL_NUMBER:
				_localctx = new DecimalDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				match(DECIMAL_NUMBER);
				}
				break;
			case STRING:
				_localctx = new StringDefaultContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				match(STRING);
				}
				break;
			case NULL:
				_localctx = new NullDefaultContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				match(NULL);
				}
				break;
			case TRUE:
				_localctx = new TrueDefaultContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseDefaultContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
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
		public TerminalNode CHAR() { return getToken(AlterColumnAddParser.CHAR, 0); }
		public TerminalNode LPAREN() { return getToken(AlterColumnAddParser.LPAREN, 0); }
		public TerminalNode INT_NUMBER() { return getToken(AlterColumnAddParser.INT_NUMBER, 0); }
		public TerminalNode RPAREN() { return getToken(AlterColumnAddParser.RPAREN, 0); }
		public CharTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitCharType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleTypeContext extends DataTypeContext {
		public TerminalNode DOUBLE() { return getToken(AlterColumnAddParser.DOUBLE, 0); }
		public DoubleTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitDoubleType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecimalTypeContext extends DataTypeContext {
		public TerminalNode DECIMAL() { return getToken(AlterColumnAddParser.DECIMAL, 0); }
		public TerminalNode LPAREN() { return getToken(AlterColumnAddParser.LPAREN, 0); }
		public List<TerminalNode> INT_NUMBER() { return getTokens(AlterColumnAddParser.INT_NUMBER); }
		public TerminalNode INT_NUMBER(int i) {
			return getToken(AlterColumnAddParser.INT_NUMBER, i);
		}
		public TerminalNode RPAREN() { return getToken(AlterColumnAddParser.RPAREN, 0); }
		public TerminalNode COMMA() { return getToken(AlterColumnAddParser.COMMA, 0); }
		public DecimalTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitDecimalType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanTypeContext extends DataTypeContext {
		public TerminalNode BOOLEAN() { return getToken(AlterColumnAddParser.BOOLEAN, 0); }
		public BooleanTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerTypeContext extends DataTypeContext {
		public TerminalNode INTEGER() { return getToken(AlterColumnAddParser.INTEGER, 0); }
		public IntegerTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitIntegerType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeContext extends DataTypeContext {
		public TerminalNode INT() { return getToken(AlterColumnAddParser.INT, 0); }
		public IntTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextTypeContext extends DataTypeContext {
		public TerminalNode TEXT() { return getToken(AlterColumnAddParser.TEXT, 0); }
		public TextTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitTextType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatTypeContext extends DataTypeContext {
		public TerminalNode FLOAT() { return getToken(AlterColumnAddParser.FLOAT, 0); }
		public FloatTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitFloatType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DateTypeContext extends DataTypeContext {
		public TerminalNode DATE() { return getToken(AlterColumnAddParser.DATE, 0); }
		public DateTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitDateType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DatetimeTypeContext extends DataTypeContext {
		public TerminalNode DATETIME() { return getToken(AlterColumnAddParser.DATETIME, 0); }
		public DatetimeTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitDatetimeType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimestampTypeContext extends DataTypeContext {
		public TerminalNode TIMESTAMP() { return getToken(AlterColumnAddParser.TIMESTAMP, 0); }
		public TimestampTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitTimestampType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BigintTypeContext extends DataTypeContext {
		public TerminalNode BIGINT() { return getToken(AlterColumnAddParser.BIGINT, 0); }
		public BigintTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitBigintType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarcharTypeContext extends DataTypeContext {
		public TerminalNode VARCHAR() { return getToken(AlterColumnAddParser.VARCHAR, 0); }
		public TerminalNode LPAREN() { return getToken(AlterColumnAddParser.LPAREN, 0); }
		public TerminalNode INT_NUMBER() { return getToken(AlterColumnAddParser.INT_NUMBER, 0); }
		public TerminalNode RPAREN() { return getToken(AlterColumnAddParser.RPAREN, 0); }
		public VarcharTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterColumnAddVisitor ) return ((AlterColumnAddVisitor<? extends T>)visitor).visitVarcharType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dataType);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARCHAR:
				_localctx = new VarcharTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(VARCHAR);
				setState(60);
				match(LPAREN);
				setState(61);
				match(INT_NUMBER);
				setState(62);
				match(RPAREN);
				}
				break;
			case CHAR:
				_localctx = new CharTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(CHAR);
				setState(64);
				match(LPAREN);
				setState(65);
				match(INT_NUMBER);
				setState(66);
				match(RPAREN);
				}
				break;
			case INT:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(INT);
				}
				break;
			case INTEGER:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				match(INTEGER);
				}
				break;
			case BIGINT:
				_localctx = new BigintTypeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
				match(BIGINT);
				}
				break;
			case DECIMAL:
				_localctx = new DecimalTypeContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(70);
				match(DECIMAL);
				setState(71);
				match(LPAREN);
				setState(72);
				match(INT_NUMBER);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(73);
					match(COMMA);
					setState(74);
					match(INT_NUMBER);
					}
				}

				setState(77);
				match(RPAREN);
				}
				break;
			case FLOAT:
				_localctx = new FloatTypeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				match(FLOAT);
				}
				break;
			case DOUBLE:
				_localctx = new DoubleTypeContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(79);
				match(DOUBLE);
				}
				break;
			case DATE:
				_localctx = new DateTypeContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(80);
				match(DATE);
				}
				break;
			case DATETIME:
				_localctx = new DatetimeTypeContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(81);
				match(DATETIME);
				}
				break;
			case TIMESTAMP:
				_localctx = new TimestampTypeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(82);
				match(TIMESTAMP);
				}
				break;
			case TEXT:
				_localctx = new TextTypeContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(83);
				match(TEXT);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(84);
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

	public static final String _serializedATN =
		"\u0004\u0001\"X\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001b\b\u0001\n"+
		"\u0001\f\u0001\u001e\t\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0004\u0004%\b\u0004\u000b\u0004\f\u0004&\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u00052\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006:\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007L\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007V\b\u0007\u0001\u0007\u0000\u0000"+
		"\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0000h\u0000\u0010\u0001"+
		"\u0000\u0000\u0000\u0002\u0013\u0001\u0000\u0000\u0000\u0004\u001f\u0001"+
		"\u0000\u0000\u0000\u0006!\u0001\u0000\u0000\u0000\b$\u0001\u0000\u0000"+
		"\u0000\n1\u0001\u0000\u0000\u0000\f9\u0001\u0000\u0000\u0000\u000eU\u0001"+
		"\u0000\u0000\u0000\u0010\u0011\u0003\u0002\u0001\u0000\u0011\u0012\u0005"+
		"\u0000\u0000\u0001\u0012\u0001\u0001\u0000\u0000\u0000\u0013\u0014\u0005"+
		"\u0001\u0000\u0000\u0014\u0015\u0005\u0002\u0000\u0000\u0015\u0016\u0003"+
		"\u0004\u0002\u0000\u0016\u0017\u0005\u0003\u0000\u0000\u0017\u0018\u0003"+
		"\u0006\u0003\u0000\u0018\u001c\u0003\u000e\u0007\u0000\u0019\u001b\u0003"+
		"\b\u0004\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001e\u0001\u0000"+
		"\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000"+
		"\u0000\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000"+
		"\u0000\u0000\u001f \u0005!\u0000\u0000 \u0005\u0001\u0000\u0000\u0000"+
		"!\"\u0005!\u0000\u0000\"\u0007\u0001\u0000\u0000\u0000#%\u0003\n\u0005"+
		"\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&$\u0001\u0000"+
		"\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\t\u0001\u0000\u0000\u0000()"+
		"\u0005\u0011\u0000\u0000)2\u0005\u0012\u0000\u0000*2\u0005\u0012\u0000"+
		"\u0000+,\u0005\u0013\u0000\u0000,2\u0005\u0014\u0000\u0000-2\u0005\u0015"+
		"\u0000\u0000.2\u0005\u0016\u0000\u0000/0\u0005\u0017\u0000\u000002\u0003"+
		"\f\u0006\u00001(\u0001\u0000\u0000\u00001*\u0001\u0000\u0000\u00001+\u0001"+
		"\u0000\u0000\u00001-\u0001\u0000\u0000\u00001.\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u00002\u000b\u0001\u0000\u0000\u00003:\u0005\u001e"+
		"\u0000\u00004:\u0005\u001f\u0000\u00005:\u0005 \u0000\u00006:\u0005\u0012"+
		"\u0000\u00007:\u0005\u0018\u0000\u00008:\u0005\u0019\u0000\u000093\u0001"+
		"\u0000\u0000\u000094\u0001\u0000\u0000\u000095\u0001\u0000\u0000\u0000"+
		"96\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u000098\u0001\u0000\u0000"+
		"\u0000:\r\u0001\u0000\u0000\u0000;<\u0005\u0004\u0000\u0000<=\u0005\u001a"+
		"\u0000\u0000=>\u0005\u001e\u0000\u0000>V\u0005\u001b\u0000\u0000?@\u0005"+
		"\u0005\u0000\u0000@A\u0005\u001a\u0000\u0000AB\u0005\u001e\u0000\u0000"+
		"BV\u0005\u001b\u0000\u0000CV\u0005\u0006\u0000\u0000DV\u0005\u0007\u0000"+
		"\u0000EV\u0005\b\u0000\u0000FG\u0005\t\u0000\u0000GH\u0005\u001a\u0000"+
		"\u0000HK\u0005\u001e\u0000\u0000IJ\u0005\u001c\u0000\u0000JL\u0005\u001e"+
		"\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MV\u0005\u001b\u0000\u0000NV\u0005\n\u0000\u0000OV\u0005"+
		"\u000b\u0000\u0000PV\u0005\f\u0000\u0000QV\u0005\r\u0000\u0000RV\u0005"+
		"\u000e\u0000\u0000SV\u0005\u000f\u0000\u0000TV\u0005\u0010\u0000\u0000"+
		"U;\u0001\u0000\u0000\u0000U?\u0001\u0000\u0000\u0000UC\u0001\u0000\u0000"+
		"\u0000UD\u0001\u0000\u0000\u0000UE\u0001\u0000\u0000\u0000UF\u0001\u0000"+
		"\u0000\u0000UN\u0001\u0000\u0000\u0000UO\u0001\u0000\u0000\u0000UP\u0001"+
		"\u0000\u0000\u0000UQ\u0001\u0000\u0000\u0000UR\u0001\u0000\u0000\u0000"+
		"US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000V\u000f\u0001\u0000"+
		"\u0000\u0000\u0006\u001c&19KU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}