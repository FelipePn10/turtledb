// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/column/rename/column/AlterRenameColumn.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.rename.column;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AlterRenameColumnLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENTIFIER=1, WS=2, ALTER=3, TABLE=4, RENAME=5, COLUMN=6, TO=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENTIFIER", "WS", "ALTER", "TABLE", "RENAME", "COLUMN", "TO", "A", 
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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
			null, "IDENTIFIER", "WS", "ALTER", "TABLE", "RENAME", "COLUMN", "TO"
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


	public AlterRenameColumnLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AlterRenameColumn.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0007\u00a2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000"+
		"\u0001\u0000\u0005\u0000F\b\u0000\n\u0000\f\u0000I\t\u0000\u0001\u0001"+
		"\u0004\u0001L\b\u0001\u000b\u0001\f\u0001M\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0000\u0000!\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\u0000\u0011\u0000\u0013\u0000\u0015\u0000\u0017\u0000\u0019\u0000"+
		"\u001b\u0000\u001d\u0000\u001f\u0000!\u0000#\u0000%\u0000\'\u0000)\u0000"+
		"+\u0000-\u0000/\u00001\u00003\u00005\u00007\u00009\u0000;\u0000=\u0000"+
		"?\u0000A\u0000\u0001\u0000\u001d\u0003\u0000AZ__az\u0004\u000009AZ__a"+
		"z\u0003\u0000\t\n\r\r  \u0002\u0000AAaa\u0002\u0000BBbb\u0002\u0000CC"+
		"cc\u0002\u0000DDdd\u0002\u0000EEee\u0002\u0000FFff\u0002\u0000GGgg\u0002"+
		"\u0000HHhh\u0002\u0000IIii\u0002\u0000JJjj\u0002\u0000KKkk\u0002\u0000"+
		"LLll\u0002\u0000MMmm\u0002\u0000NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002"+
		"\u0000QQqq\u0002\u0000RRrr\u0002\u0000SSss\u0002\u0000TTtt\u0002\u0000"+
		"UUuu\u0002\u0000VVvv\u0002\u0000WWww\u0002\u0000XXxx\u0002\u0000YYyy\u0002"+
		"\u0000ZZzz\u0089\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0001C\u0001\u0000\u0000"+
		"\u0000\u0003K\u0001\u0000\u0000\u0000\u0005Q\u0001\u0000\u0000\u0000\u0007"+
		"W\u0001\u0000\u0000\u0000\t]\u0001\u0000\u0000\u0000\u000bd\u0001\u0000"+
		"\u0000\u0000\rk\u0001\u0000\u0000\u0000\u000fn\u0001\u0000\u0000\u0000"+
		"\u0011p\u0001\u0000\u0000\u0000\u0013r\u0001\u0000\u0000\u0000\u0015t"+
		"\u0001\u0000\u0000\u0000\u0017v\u0001\u0000\u0000\u0000\u0019x\u0001\u0000"+
		"\u0000\u0000\u001bz\u0001\u0000\u0000\u0000\u001d|\u0001\u0000\u0000\u0000"+
		"\u001f~\u0001\u0000\u0000\u0000!\u0080\u0001\u0000\u0000\u0000#\u0082"+
		"\u0001\u0000\u0000\u0000%\u0084\u0001\u0000\u0000\u0000\'\u0086\u0001"+
		"\u0000\u0000\u0000)\u0088\u0001\u0000\u0000\u0000+\u008a\u0001\u0000\u0000"+
		"\u0000-\u008c\u0001\u0000\u0000\u0000/\u008e\u0001\u0000\u0000\u00001"+
		"\u0090\u0001\u0000\u0000\u00003\u0092\u0001\u0000\u0000\u00005\u0094\u0001"+
		"\u0000\u0000\u00007\u0096\u0001\u0000\u0000\u00009\u0098\u0001\u0000\u0000"+
		"\u0000;\u009a\u0001\u0000\u0000\u0000=\u009c\u0001\u0000\u0000\u0000?"+
		"\u009e\u0001\u0000\u0000\u0000A\u00a0\u0001\u0000\u0000\u0000CG\u0007"+
		"\u0000\u0000\u0000DF\u0007\u0001\u0000\u0000ED\u0001\u0000\u0000\u0000"+
		"FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000H\u0002\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JL\u0007"+
		"\u0002\u0000\u0000KJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000"+
		"\u0000OP\u0006\u0001\u0000\u0000P\u0004\u0001\u0000\u0000\u0000QR\u0003"+
		"\u000f\u0007\u0000RS\u0003%\u0012\u0000ST\u00035\u001a\u0000TU\u0003\u0017"+
		"\u000b\u0000UV\u00031\u0018\u0000V\u0006\u0001\u0000\u0000\u0000WX\u0003"+
		"5\u001a\u0000XY\u0003\u000f\u0007\u0000YZ\u0003\u0011\b\u0000Z[\u0003"+
		"%\u0012\u0000[\\\u0003\u0017\u000b\u0000\\\b\u0001\u0000\u0000\u0000]"+
		"^\u00031\u0018\u0000^_\u0003\u0017\u000b\u0000_`\u0003)\u0014\u0000`a"+
		"\u0003\u000f\u0007\u0000ab\u0003\'\u0013\u0000bc\u0003\u0017\u000b\u0000"+
		"c\n\u0001\u0000\u0000\u0000de\u0003\u0013\t\u0000ef\u0003+\u0015\u0000"+
		"fg\u0003%\u0012\u0000gh\u00037\u001b\u0000hi\u0003\'\u0013\u0000ij\u0003"+
		")\u0014\u0000j\f\u0001\u0000\u0000\u0000kl\u00035\u001a\u0000lm\u0003"+
		"+\u0015\u0000m\u000e\u0001\u0000\u0000\u0000no\u0007\u0003\u0000\u0000"+
		"o\u0010\u0001\u0000\u0000\u0000pq\u0007\u0004\u0000\u0000q\u0012\u0001"+
		"\u0000\u0000\u0000rs\u0007\u0005\u0000\u0000s\u0014\u0001\u0000\u0000"+
		"\u0000tu\u0007\u0006\u0000\u0000u\u0016\u0001\u0000\u0000\u0000vw\u0007"+
		"\u0007\u0000\u0000w\u0018\u0001\u0000\u0000\u0000xy\u0007\b\u0000\u0000"+
		"y\u001a\u0001\u0000\u0000\u0000z{\u0007\t\u0000\u0000{\u001c\u0001\u0000"+
		"\u0000\u0000|}\u0007\n\u0000\u0000}\u001e\u0001\u0000\u0000\u0000~\u007f"+
		"\u0007\u000b\u0000\u0000\u007f \u0001\u0000\u0000\u0000\u0080\u0081\u0007"+
		"\f\u0000\u0000\u0081\"\u0001\u0000\u0000\u0000\u0082\u0083\u0007\r\u0000"+
		"\u0000\u0083$\u0001\u0000\u0000\u0000\u0084\u0085\u0007\u000e\u0000\u0000"+
		"\u0085&\u0001\u0000\u0000\u0000\u0086\u0087\u0007\u000f\u0000\u0000\u0087"+
		"(\u0001\u0000\u0000\u0000\u0088\u0089\u0007\u0010\u0000\u0000\u0089*\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0007\u0011\u0000\u0000\u008b,\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0007\u0012\u0000\u0000\u008d.\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0007\u0013\u0000\u0000\u008f0\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0007\u0014\u0000\u0000\u00912\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0007\u0015\u0000\u0000\u00934\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0007\u0016\u0000\u0000\u00956\u0001\u0000\u0000\u0000\u0096\u0097\u0007"+
		"\u0017\u0000\u0000\u00978\u0001\u0000\u0000\u0000\u0098\u0099\u0007\u0018"+
		"\u0000\u0000\u0099:\u0001\u0000\u0000\u0000\u009a\u009b\u0007\u0019\u0000"+
		"\u0000\u009b<\u0001\u0000\u0000\u0000\u009c\u009d\u0007\u001a\u0000\u0000"+
		"\u009d>\u0001\u0000\u0000\u0000\u009e\u009f\u0007\u001b\u0000\u0000\u009f"+
		"@\u0001\u0000\u0000\u0000\u00a0\u00a1\u0007\u001c\u0000\u0000\u00a1B\u0001"+
		"\u0000\u0000\u0000\u0003\u0000GM\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}