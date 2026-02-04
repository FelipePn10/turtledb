// Generated from src/main/java/com/db/turtle/a_frontend/impl/parser/antlr/statement/ddl/alter/column/drop/AlterColumnDrop.g4 by ANTLR 4.13.1

package com.db.turtle.a_frontend.impl.parser.antlr.statement.ddl.alter.column.drop;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AlterColumnDropLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ALTER=2, TABLE=3, DROP=4, COLUMN=5, SEMICOLON=6, IDENTIFIER=7, 
		WS=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "ALTER", "TABLE", "DROP", "COLUMN", "SEMICOLON", "IDENTIFIER", 
			"WS", "A", "B", "C", "D", "E", "L", "M", "N", "O", "P", "R", "T", "U", 
			"I", "S"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "ALTER", "TABLE", "DROP", "COLUMN", "SEMICOLON", "IDENTIFIER", 
			"WS"
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


	public AlterColumnDropLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AlterColumnDrop.g4"; }

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
		"\u0004\u0000\b\u007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0005"+
		"\u0006V\b\u0006\n\u0006\f\u0006Y\t\u0006\u0001\u0007\u0004\u0007\\\b\u0007"+
		"\u000b\u0007\f\u0007]\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0000\u0000\u0017\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\u0000\u0013\u0000\u0015"+
		"\u0000\u0017\u0000\u0019\u0000\u001b\u0000\u001d\u0000\u001f\u0000!\u0000"+
		"#\u0000%\u0000\'\u0000)\u0000+\u0000-\u0000\u0001\u0000\u0012\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0002\u0000AAaa\u0002"+
		"\u0000BBbb\u0002\u0000CCcc\u0002\u0000DDdd\u0002\u0000EEee\u0002\u0000"+
		"LLll\u0002\u0000MMmm\u0002\u0000NNnn\u0002\u0000OOoo\u0002\u0000PPpp\u0002"+
		"\u0000RRrr\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000IIii\u0002\u0000"+
		"SSssq\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0001"+
		"/\u0001\u0000\u0000\u0000\u00031\u0001\u0000\u0000\u0000\u00057\u0001"+
		"\u0000\u0000\u0000\u0007=\u0001\u0000\u0000\u0000\tB\u0001\u0000\u0000"+
		"\u0000\u000bI\u0001\u0000\u0000\u0000\rS\u0001\u0000\u0000\u0000\u000f"+
		"[\u0001\u0000\u0000\u0000\u0011a\u0001\u0000\u0000\u0000\u0013c\u0001"+
		"\u0000\u0000\u0000\u0015e\u0001\u0000\u0000\u0000\u0017g\u0001\u0000\u0000"+
		"\u0000\u0019i\u0001\u0000\u0000\u0000\u001bk\u0001\u0000\u0000\u0000\u001d"+
		"m\u0001\u0000\u0000\u0000\u001fo\u0001\u0000\u0000\u0000!q\u0001\u0000"+
		"\u0000\u0000#s\u0001\u0000\u0000\u0000%u\u0001\u0000\u0000\u0000\'w\u0001"+
		"\u0000\u0000\u0000)y\u0001\u0000\u0000\u0000+{\u0001\u0000\u0000\u0000"+
		"-}\u0001\u0000\u0000\u0000/0\u0005,\u0000\u00000\u0002\u0001\u0000\u0000"+
		"\u000012\u0003\u0011\b\u000023\u0003\u001b\r\u000034\u0003\'\u0013\u0000"+
		"45\u0003\u0019\f\u000056\u0003%\u0012\u00006\u0004\u0001\u0000\u0000\u0000"+
		"78\u0003\'\u0013\u000089\u0003\u0011\b\u00009:\u0003\u0013\t\u0000:;\u0003"+
		"\u001b\r\u0000;<\u0003\u0019\f\u0000<\u0006\u0001\u0000\u0000\u0000=>"+
		"\u0003\u0017\u000b\u0000>?\u0003%\u0012\u0000?@\u0003!\u0010\u0000@A\u0003"+
		"#\u0011\u0000A\b\u0001\u0000\u0000\u0000BC\u0003\u0015\n\u0000CD\u0003"+
		"!\u0010\u0000DE\u0003\u001b\r\u0000EF\u0003)\u0014\u0000FG\u0003\u001d"+
		"\u000e\u0000GH\u0003\u001f\u000f\u0000H\n\u0001\u0000\u0000\u0000IJ\u0003"+
		"-\u0016\u0000JK\u0003\u0019\f\u0000KL\u0003\u001d\u000e\u0000LM\u0003"+
		"+\u0015\u0000MN\u0003\u0015\n\u0000NO\u0003!\u0010\u0000OP\u0003\u001b"+
		"\r\u0000PQ\u0003!\u0010\u0000QR\u0003\u001f\u000f\u0000R\f\u0001\u0000"+
		"\u0000\u0000SW\u0007\u0000\u0000\u0000TV\u0007\u0001\u0000\u0000UT\u0001"+
		"\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000X\u000e\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000Z\\\u0007\u0002\u0000\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_`\u0006\u0007\u0000\u0000`\u0010\u0001\u0000"+
		"\u0000\u0000ab\u0007\u0003\u0000\u0000b\u0012\u0001\u0000\u0000\u0000"+
		"cd\u0007\u0004\u0000\u0000d\u0014\u0001\u0000\u0000\u0000ef\u0007\u0005"+
		"\u0000\u0000f\u0016\u0001\u0000\u0000\u0000gh\u0007\u0006\u0000\u0000"+
		"h\u0018\u0001\u0000\u0000\u0000ij\u0007\u0007\u0000\u0000j\u001a\u0001"+
		"\u0000\u0000\u0000kl\u0007\b\u0000\u0000l\u001c\u0001\u0000\u0000\u0000"+
		"mn\u0007\t\u0000\u0000n\u001e\u0001\u0000\u0000\u0000op\u0007\n\u0000"+
		"\u0000p \u0001\u0000\u0000\u0000qr\u0007\u000b\u0000\u0000r\"\u0001\u0000"+
		"\u0000\u0000st\u0007\f\u0000\u0000t$\u0001\u0000\u0000\u0000uv\u0007\r"+
		"\u0000\u0000v&\u0001\u0000\u0000\u0000wx\u0007\u000e\u0000\u0000x(\u0001"+
		"\u0000\u0000\u0000yz\u0007\u000f\u0000\u0000z*\u0001\u0000\u0000\u0000"+
		"{|\u0007\u0010\u0000\u0000|,\u0001\u0000\u0000\u0000}~\u0007\u0011\u0000"+
		"\u0000~.\u0001\u0000\u0000\u0000\u0003\u0000W]\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}