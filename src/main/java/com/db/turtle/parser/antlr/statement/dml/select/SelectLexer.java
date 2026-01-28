// Generated from src/main/java/com/db/turtle/parser/antlr/statement/dml/select/Select.g4 by ANTLR 4.13.1

package com.db.turtle.parser.antlr.statement.dml.select;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SelectLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, FROM=2, WHERE=3, AND=4, OR=5, NULL=6, TRUE=7, FALSE=8, STAR=9, 
		COMMA=10, LEFT_PAREN=11, RIGHT_PAREN=12, EQ=13, GT=14, GE=15, LT=16, LE=17, 
		NE=18, IDENTIFIER=19, NUMBER=20, STRING=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SELECT", "FROM", "WHERE", "AND", "OR", "NULL", "TRUE", "FALSE", "STAR", 
			"COMMA", "LEFT_PAREN", "RIGHT_PAREN", "EQ", "GT", "GE", "LT", "LE", "NE", 
			"IDENTIFIER", "NUMBER", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'SELECT'", "'FROM'", "'WHERE'", "'AND'", "'OR'", "'NULL'", "'TRUE'", 
			"'FALSE'", "'*'", "','", "'('", "')'", "'='", "'>'", "'>='", "'<'", "'<='", 
			"'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SELECT", "FROM", "WHERE", "AND", "OR", "NULL", "TRUE", "FALSE", 
			"STAR", "COMMA", "LEFT_PAREN", "RIGHT_PAREN", "EQ", "GT", "GE", "LT", 
			"LE", "NE", "IDENTIFIER", "NUMBER", "STRING", "WS"
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


	public SelectLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Select.g4"; }

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
		"\u0004\u0000\u0016\u0093\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005\u0012p\b"+
		"\u0012\n\u0012\f\u0012s\t\u0012\u0001\u0013\u0004\u0013v\b\u0013\u000b"+
		"\u0013\f\u0013w\u0001\u0013\u0001\u0013\u0004\u0013|\b\u0013\u000b\u0013"+
		"\f\u0013}\u0003\u0013\u0080\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u0086\b\u0014\n\u0014\f\u0014\u0089\t\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0004\u0015\u008e\b\u0015\u000b\u0015\f"+
		"\u0015\u008f\u0001\u0015\u0001\u0015\u0000\u0000\u0016\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016\u0001\u0000\u0005\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0001\u000009\u0002\u0000\'\'\\\\\u0003\u0000"+
		"\t\n\r\r  \u0099\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000"+
		"%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0001-\u0001\u0000\u0000"+
		"\u0000\u00034\u0001\u0000\u0000\u0000\u00059\u0001\u0000\u0000\u0000\u0007"+
		"?\u0001\u0000\u0000\u0000\tC\u0001\u0000\u0000\u0000\u000bF\u0001\u0000"+
		"\u0000\u0000\rK\u0001\u0000\u0000\u0000\u000fP\u0001\u0000\u0000\u0000"+
		"\u0011V\u0001\u0000\u0000\u0000\u0013X\u0001\u0000\u0000\u0000\u0015Z"+
		"\u0001\u0000\u0000\u0000\u0017\\\u0001\u0000\u0000\u0000\u0019^\u0001"+
		"\u0000\u0000\u0000\u001b`\u0001\u0000\u0000\u0000\u001db\u0001\u0000\u0000"+
		"\u0000\u001fe\u0001\u0000\u0000\u0000!g\u0001\u0000\u0000\u0000#j\u0001"+
		"\u0000\u0000\u0000%m\u0001\u0000\u0000\u0000\'u\u0001\u0000\u0000\u0000"+
		")\u0081\u0001\u0000\u0000\u0000+\u008d\u0001\u0000\u0000\u0000-.\u0005"+
		"S\u0000\u0000./\u0005E\u0000\u0000/0\u0005L\u0000\u000001\u0005E\u0000"+
		"\u000012\u0005C\u0000\u000023\u0005T\u0000\u00003\u0002\u0001\u0000\u0000"+
		"\u000045\u0005F\u0000\u000056\u0005R\u0000\u000067\u0005O\u0000\u0000"+
		"78\u0005M\u0000\u00008\u0004\u0001\u0000\u0000\u00009:\u0005W\u0000\u0000"+
		":;\u0005H\u0000\u0000;<\u0005E\u0000\u0000<=\u0005R\u0000\u0000=>\u0005"+
		"E\u0000\u0000>\u0006\u0001\u0000\u0000\u0000?@\u0005A\u0000\u0000@A\u0005"+
		"N\u0000\u0000AB\u0005D\u0000\u0000B\b\u0001\u0000\u0000\u0000CD\u0005"+
		"O\u0000\u0000DE\u0005R\u0000\u0000E\n\u0001\u0000\u0000\u0000FG\u0005"+
		"N\u0000\u0000GH\u0005U\u0000\u0000HI\u0005L\u0000\u0000IJ\u0005L\u0000"+
		"\u0000J\f\u0001\u0000\u0000\u0000KL\u0005T\u0000\u0000LM\u0005R\u0000"+
		"\u0000MN\u0005U\u0000\u0000NO\u0005E\u0000\u0000O\u000e\u0001\u0000\u0000"+
		"\u0000PQ\u0005F\u0000\u0000QR\u0005A\u0000\u0000RS\u0005L\u0000\u0000"+
		"ST\u0005S\u0000\u0000TU\u0005E\u0000\u0000U\u0010\u0001\u0000\u0000\u0000"+
		"VW\u0005*\u0000\u0000W\u0012\u0001\u0000\u0000\u0000XY\u0005,\u0000\u0000"+
		"Y\u0014\u0001\u0000\u0000\u0000Z[\u0005(\u0000\u0000[\u0016\u0001\u0000"+
		"\u0000\u0000\\]\u0005)\u0000\u0000]\u0018\u0001\u0000\u0000\u0000^_\u0005"+
		"=\u0000\u0000_\u001a\u0001\u0000\u0000\u0000`a\u0005>\u0000\u0000a\u001c"+
		"\u0001\u0000\u0000\u0000bc\u0005>\u0000\u0000cd\u0005=\u0000\u0000d\u001e"+
		"\u0001\u0000\u0000\u0000ef\u0005<\u0000\u0000f \u0001\u0000\u0000\u0000"+
		"gh\u0005<\u0000\u0000hi\u0005=\u0000\u0000i\"\u0001\u0000\u0000\u0000"+
		"jk\u0005!\u0000\u0000kl\u0005=\u0000\u0000l$\u0001\u0000\u0000\u0000m"+
		"q\u0007\u0000\u0000\u0000np\u0007\u0001\u0000\u0000on\u0001\u0000\u0000"+
		"\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000r&\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tv\u0007"+
		"\u0002\u0000\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\u007f\u0001\u0000"+
		"\u0000\u0000y{\u0005.\u0000\u0000z|\u0007\u0002\u0000\u0000{z\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007fy\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080(\u0001\u0000\u0000\u0000"+
		"\u0081\u0087\u0005\'\u0000\u0000\u0082\u0086\b\u0003\u0000\u0000\u0083"+
		"\u0084\u0005\\\u0000\u0000\u0084\u0086\t\u0000\u0000\u0000\u0085\u0082"+
		"\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089"+
		"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005\'\u0000\u0000\u008b*\u0001"+
		"\u0000\u0000\u0000\u008c\u008e\u0007\u0004\u0000\u0000\u008d\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0006\u0015\u0000\u0000\u0092,\u0001\u0000"+
		"\u0000\u0000\b\u0000qw}\u007f\u0085\u0087\u008f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}