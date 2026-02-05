// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/table/rename/AlterRenameTable.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.table.rename;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class AlterRenameTableParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENTIFIER=1, WS=2, ALTER=3, TABLE=4, RENAME=5, TO=6;
	public static final int
		RULE_statement = 0, RULE_alterRenameTable = 1, RULE_tableName = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"statement", "alterRenameTable", "tableName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IDENTIFIER", "WS", "ALTER", "TABLE", "RENAME", "TO"
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
	public String getGrammarFileName() { return "AlterRenameTable.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AlterRenameTableParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AlterRenameTableContext alterRenameTable() {
			return getRuleContext(AlterRenameTableContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AlterRenameTableParser.EOF, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterRenameTableVisitor ) return ((AlterRenameTableVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			alterRenameTable();
			setState(7);
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
	public static class AlterRenameTableContext extends ParserRuleContext {
		public TerminalNode ALTER() { return getToken(AlterRenameTableParser.ALTER, 0); }
		public TerminalNode TABLE() { return getToken(AlterRenameTableParser.TABLE, 0); }
		public List<TableNameContext> tableName() {
			return getRuleContexts(TableNameContext.class);
		}
		public TableNameContext tableName(int i) {
			return getRuleContext(TableNameContext.class,i);
		}
		public TerminalNode RENAME() { return getToken(AlterRenameTableParser.RENAME, 0); }
		public TerminalNode TO() { return getToken(AlterRenameTableParser.TO, 0); }
		public AlterRenameTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alterRenameTable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterRenameTableVisitor ) return ((AlterRenameTableVisitor<? extends T>)visitor).visitAlterRenameTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AlterRenameTableContext alterRenameTable() throws RecognitionException {
		AlterRenameTableContext _localctx = new AlterRenameTableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_alterRenameTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			match(ALTER);
			setState(10);
			match(TABLE);
			setState(11);
			tableName();
			setState(12);
			match(RENAME);
			setState(13);
			match(TO);
			setState(14);
			tableName();
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
		public TerminalNode IDENTIFIER() { return getToken(AlterRenameTableParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AlterRenameTableVisitor ) return ((AlterRenameTableVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0006\u0013\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0000\u0000\u0003\u0000\u0002\u0004"+
		"\u0000\u0000\u000f\u0000\u0006\u0001\u0000\u0000\u0000\u0002\t\u0001\u0000"+
		"\u0000\u0000\u0004\u0010\u0001\u0000\u0000\u0000\u0006\u0007\u0003\u0002"+
		"\u0001\u0000\u0007\b\u0005\u0000\u0000\u0001\b\u0001\u0001\u0000\u0000"+
		"\u0000\t\n\u0005\u0003\u0000\u0000\n\u000b\u0005\u0004\u0000\u0000\u000b"+
		"\f\u0003\u0004\u0002\u0000\f\r\u0005\u0005\u0000\u0000\r\u000e\u0005\u0006"+
		"\u0000\u0000\u000e\u000f\u0003\u0004\u0002\u0000\u000f\u0003\u0001\u0000"+
		"\u0000\u0000\u0010\u0011\u0005\u0001\u0000\u0000\u0011\u0005\u0001\u0000"+
		"\u0000\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}