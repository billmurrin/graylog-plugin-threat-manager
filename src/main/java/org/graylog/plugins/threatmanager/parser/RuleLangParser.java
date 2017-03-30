package org.graylog.plugins.threatmanager.parser;// Generated from C:/Data/graylog-plugin-threat-manager/src/main/antlr4/org/graylog/plugins/pipelineprocessor/parser\RuleLang.g4 by ANTLR 4.6

import org.graylog.plugins.threatmanager.ast.expressions.Expression;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RuleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, All=23, Either=24, And=25, 
		Or=26, Not=27, Pipeline=28, Rule=29, During=30, Stage=31, When=32, Then=33, 
		End=34, Let=35, Match=36, MessageRef=37, Boolean=38, Integer=39, Float=40, 
		Char=41, String=42, Identifier=43, WS=44, COMMENT=45, LINE_COMMENT=46;
	public static final int
		RULE_file = 0, RULE_pipelineDecls = 1, RULE_pipeline = 2, RULE_pipelineDeclaration = 3, 
		RULE_stageDeclaration = 4, RULE_ruleRef = 5, RULE_ruleDecls = 6, RULE_ruleDeclaration = 7, 
		RULE_expression = 8, RULE_propAssignment = 9, RULE_statement = 10, RULE_functionCall = 11, 
		RULE_arguments = 12, RULE_literal = 13;
	public static final String[] ruleNames = {
		"file", "pipelineDecls", "pipeline", "pipelineDeclaration", "stageDeclaration", 
		"ruleRef", "ruleDecls", "ruleDeclaration", "expression", "propAssignment", 
		"statement", "functionCall", "arguments", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'('", "')'", "'['", "','", "']'", "'{'", "'}'", "'.'", "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'<='", "'>='", "'>'", "'<'", "'=='", "'!='", 
		"':'", "'='", null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "'$message'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "All", 
		"Either", "And", "Or", "Not", "Pipeline", "Rule", "During", "Stage", "When", 
		"Then", "End", "Let", "Match", "MessageRef", "Boolean", "Integer", "Float", 
		"Char", "String", "Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
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
	public String getGrammarFileName() { return "RuleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RuleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RuleLangParser.EOF, 0); }
		public List<RuleDeclarationContext> ruleDeclaration() {
			return getRuleContexts(RuleDeclarationContext.class);
		}
		public RuleDeclarationContext ruleDeclaration(int i) {
			return getRuleContext(RuleDeclarationContext.class,i);
		}
		public List<PipelineDeclarationContext> pipelineDeclaration() {
			return getRuleContexts(PipelineDeclarationContext.class);
		}
		public PipelineDeclarationContext pipelineDeclaration(int i) {
			return getRuleContext(PipelineDeclarationContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(30);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Rule:
					{
					setState(28);
					ruleDeclaration();
					}
					break;
				case Pipeline:
					{
					setState(29);
					pipelineDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Pipeline || _la==Rule );
			setState(34);
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

	public static class PipelineDeclsContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RuleLangParser.EOF, 0); }
		public List<PipelineDeclarationContext> pipelineDeclaration() {
			return getRuleContexts(PipelineDeclarationContext.class);
		}
		public PipelineDeclarationContext pipelineDeclaration(int i) {
			return getRuleContext(PipelineDeclarationContext.class,i);
		}
		public PipelineDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipelineDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterPipelineDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitPipelineDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitPipelineDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipelineDeclsContext pipelineDecls() throws RecognitionException {
		PipelineDeclsContext _localctx = new PipelineDeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pipelineDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				pipelineDeclaration();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Pipeline );
			setState(41);
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

	public static class PipelineContext extends ParserRuleContext {
		public PipelineDeclarationContext pipelineDeclaration() {
			return getRuleContext(PipelineDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RuleLangParser.EOF, 0); }
		public PipelineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipeline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterPipeline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitPipeline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitPipeline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipelineContext pipeline() throws RecognitionException {
		PipelineContext _localctx = new PipelineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pipeline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			pipelineDeclaration();
			setState(44);
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

	public static class PipelineDeclarationContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Pipeline() { return getToken(RuleLangParser.Pipeline, 0); }
		public TerminalNode End() { return getToken(RuleLangParser.End, 0); }
		public TerminalNode String() { return getToken(RuleLangParser.String, 0); }
		public List<StageDeclarationContext> stageDeclaration() {
			return getRuleContexts(StageDeclarationContext.class);
		}
		public StageDeclarationContext stageDeclaration(int i) {
			return getRuleContext(StageDeclarationContext.class,i);
		}
		public PipelineDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipelineDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterPipelineDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitPipelineDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitPipelineDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipelineDeclarationContext pipelineDeclaration() throws RecognitionException {
		PipelineDeclarationContext _localctx = new PipelineDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pipelineDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(Pipeline);
			setState(47);
			((PipelineDeclarationContext)_localctx).name = match(String);
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				stageDeclaration();
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Stage );
			setState(53);
			match(End);
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

	public static class StageDeclarationContext extends ParserRuleContext {
		public Token stage;
		public Token modifier;
		public TerminalNode Stage() { return getToken(RuleLangParser.Stage, 0); }
		public TerminalNode Match() { return getToken(RuleLangParser.Match, 0); }
		public TerminalNode Integer() { return getToken(RuleLangParser.Integer, 0); }
		public TerminalNode All() { return getToken(RuleLangParser.All, 0); }
		public TerminalNode Either() { return getToken(RuleLangParser.Either, 0); }
		public List<RuleRefContext> ruleRef() {
			return getRuleContexts(RuleRefContext.class);
		}
		public RuleRefContext ruleRef(int i) {
			return getRuleContext(RuleRefContext.class,i);
		}
		public StageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterStageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitStageDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitStageDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StageDeclarationContext stageDeclaration() throws RecognitionException {
		StageDeclarationContext _localctx = new StageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stageDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(Stage);
			setState(56);
			((StageDeclarationContext)_localctx).stage = match(Integer);
			setState(57);
			match(Match);
			setState(58);
			((StageDeclarationContext)_localctx).modifier = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==All || _la==Either) ) {
				((StageDeclarationContext)_localctx).modifier = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Rule) {
				{
				{
				setState(59);
				ruleRef();
				}
				}
				setState(64);
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

	public static class RuleRefContext extends ParserRuleContext {
		public Token name;
		public TerminalNode Rule() { return getToken(RuleLangParser.Rule, 0); }
		public TerminalNode String() { return getToken(RuleLangParser.String, 0); }
		public RuleRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterRuleRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitRuleRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitRuleRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleRefContext ruleRef() throws RecognitionException {
		RuleRefContext _localctx = new RuleRefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ruleRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(Rule);
			setState(66);
			((RuleRefContext)_localctx).name = match(String);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(67);
				match(T__0);
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

	public static class RuleDeclsContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RuleLangParser.EOF, 0); }
		public List<RuleDeclarationContext> ruleDeclaration() {
			return getRuleContexts(RuleDeclarationContext.class);
		}
		public RuleDeclarationContext ruleDeclaration(int i) {
			return getRuleContext(RuleDeclarationContext.class,i);
		}
		public RuleDeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleDecls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterRuleDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitRuleDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitRuleDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleDeclsContext ruleDecls() throws RecognitionException {
		RuleDeclsContext _localctx = new RuleDeclsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ruleDecls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				ruleDeclaration();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Rule );
			setState(75);
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

	public static class RuleDeclarationContext extends ParserRuleContext {
		public Token name;
		public ExpressionContext condition;
		public StatementContext actions;
		public TerminalNode Rule() { return getToken(RuleLangParser.Rule, 0); }
		public TerminalNode When() { return getToken(RuleLangParser.When, 0); }
		public TerminalNode End() { return getToken(RuleLangParser.End, 0); }
		public TerminalNode String() { return getToken(RuleLangParser.String, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Then() { return getToken(RuleLangParser.Then, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterRuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitRuleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitRuleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleDeclarationContext ruleDeclaration() throws RecognitionException {
		RuleDeclarationContext _localctx = new RuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ruleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(Rule);
			setState(78);
			((RuleDeclarationContext)_localctx).name = match(String);
			setState(79);
			match(When);
			setState(80);
			((RuleDeclarationContext)_localctx).condition = expression(0);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Then) {
				{
				setState(81);
				match(Then);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << Let) | (1L << Identifier))) != 0)) {
					{
					{
					setState(82);
					((RuleDeclarationContext)_localctx).actions = statement();
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(90);
			match(End);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiplicationContext extends ExpressionContext {
		public ExpressionContext left;
		public Token mult;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionContext extends ExpressionContext {
		public ExpressionContext left;
		public Token add;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExpressionContext {
		public ExpressionContext left;
		public Token or;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Or() { return getToken(RuleLangParser.Or, 0); }
		public OrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FuncContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MessageRefContext extends ExpressionContext {
		public ExpressionContext field;
		public TerminalNode MessageRef() { return getToken(RuleLangParser.MessageRef, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MessageRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterMessageRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitMessageRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitMessageRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedContext extends ExpressionContext {
		public ExpressionContext fieldSet;
		public ExpressionContext field;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NestedContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterNested(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitNested(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitNested(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExpressionContext {
		public TerminalNode Not() { return getToken(RuleLangParser.Not, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexedAccessContext extends ExpressionContext {
		public ExpressionContext array;
		public ExpressionContext index;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IndexedAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterIndexedAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitIndexedAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitIndexedAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(RuleLangParser.Identifier, 0); }
		public IdentifierContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ExpressionContext {
		public ExpressionContext left;
		public Token comparison;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralPrimaryContext extends ExpressionContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralPrimaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterLiteralPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitLiteralPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitLiteralPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExpressionContext {
		public ExpressionContext left;
		public Token and;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode And() { return getToken(RuleLangParser.And, 0); }
		public AndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLiteralExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayLiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterArrayLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitArrayLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitArrayLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MapLiteralExprContext extends ExpressionContext {
		public List<PropAssignmentContext> propAssignment() {
			return getRuleContexts(PropAssignmentContext.class);
		}
		public PropAssignmentContext propAssignment(int i) {
			return getRuleContext(PropAssignmentContext.class,i);
		}
		public MapLiteralExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterMapLiteralExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitMapLiteralExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitMapLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityContext extends ExpressionContext {
		public ExpressionContext left;
		public Token equality;
		public ExpressionContext right;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SignedExpressionContext extends ExpressionContext {
		public Token sign;
		public ExpressionContext expr;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SignedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterSignedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitSignedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitSignedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(93);
				match(T__1);
				setState(94);
				expression(0);
				setState(95);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new LiteralPrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				literal();
				}
				break;
			case 3:
				{
				_localctx = new FuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				functionCall();
				}
				break;
			case 4:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(Identifier);
				}
				break;
			case 5:
				{
				_localctx = new ArrayLiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(T__3);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << Not) | (1L << MessageRef) | (1L << Boolean) | (1L << Integer) | (1L << Float) | (1L << Char) | (1L << String) | (1L << Identifier))) != 0)) {
					{
					{
					setState(101);
					expression(0);
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(102);
						match(T__4);
						setState(103);
						expression(0);
						}
						}
						setState(108);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(T__5);
				}
				break;
			case 6:
				{
				_localctx = new MapLiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(T__6);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Identifier) {
					{
					{
					setState(116);
					propAssignment();
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(117);
						match(T__4);
						setState(118);
						propAssignment();
						}
						}
						setState(123);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(129);
				match(T__7);
				}
				break;
			case 7:
				{
				_localctx = new MessageRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				match(MessageRef);
				setState(131);
				match(T__8);
				setState(132);
				((MessageRefContext)_localctx).field = expression(11);
				}
				break;
			case 8:
				{
				_localctx = new SignedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				((SignedExpressionContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
					((SignedExpressionContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				((SignedExpressionContext)_localctx).expr = expression(8);
				}
				break;
			case 9:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				match(Not);
				setState(136);
				expression(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(165);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new NestedContext(new ExpressionContext(_parentctx, _parentState));
						((NestedContext)_localctx).fieldSet = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(139);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(140);
						match(T__8);
						setState(141);
						((NestedContext)_localctx).field = expression(11);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						((MultiplicationContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(142);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(143);
						((MultiplicationContext)_localctx).mult = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
							((MultiplicationContext)_localctx).mult = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(144);
						((MultiplicationContext)_localctx).right = expression(7);
						}
						break;
					case 3:
						{
						_localctx = new AdditionContext(new ExpressionContext(_parentctx, _parentState));
						((AdditionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(146);
						((AdditionContext)_localctx).add = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__10) ) {
							((AdditionContext)_localctx).add = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(147);
						((AdditionContext)_localctx).right = expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(148);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(149);
						((ComparisonContext)_localctx).comparison = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
							((ComparisonContext)_localctx).comparison = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(150);
						((ComparisonContext)_localctx).right = expression(5);
						}
						break;
					case 5:
						{
						_localctx = new EqualityContext(new ExpressionContext(_parentctx, _parentState));
						((EqualityContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(151);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(152);
						((EqualityContext)_localctx).equality = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
							((EqualityContext)_localctx).equality = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						((EqualityContext)_localctx).right = expression(4);
						}
						break;
					case 6:
						{
						_localctx = new AndContext(new ExpressionContext(_parentctx, _parentState));
						((AndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(154);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(155);
						((AndContext)_localctx).and = match(And);
						setState(156);
						((AndContext)_localctx).right = expression(3);
						}
						break;
					case 7:
						{
						_localctx = new OrContext(new ExpressionContext(_parentctx, _parentState));
						((OrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(158);
						((OrContext)_localctx).or = match(Or);
						setState(159);
						((OrContext)_localctx).right = expression(2);
						}
						break;
					case 8:
						{
						_localctx = new IndexedAccessContext(new ExpressionContext(_parentctx, _parentState));
						((IndexedAccessContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(160);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(161);
						match(T__3);
						setState(162);
						((IndexedAccessContext)_localctx).index = expression(0);
						setState(163);
						match(T__5);
						}
						break;
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PropAssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(RuleLangParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PropAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterPropAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitPropAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitPropAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropAssignmentContext propAssignment() throws RecognitionException {
		PropAssignmentContext _localctx = new PropAssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_propAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(Identifier);
			setState(171);
			match(T__20);
			setState(172);
			expression(0);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarAssignStmtContext extends StatementContext {
		public Token varName;
		public TerminalNode Let() { return getToken(RuleLangParser.Let, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(RuleLangParser.Identifier, 0); }
		public VarAssignStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterVarAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitVarAssignStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitVarAssignStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncStmtContext extends StatementContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FuncStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterFuncStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitFuncStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitFuncStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyStmtContext extends StatementContext {
		public EmptyStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterEmptyStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitEmptyStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitEmptyStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new FuncStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				functionCall();
				setState(175);
				match(T__0);
				}
				break;
			case Let:
				_localctx = new VarAssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(Let);
				setState(178);
				((VarAssignStmtContext)_localctx).varName = match(Identifier);
				setState(179);
				match(T__21);
				setState(180);
				expression(0);
				setState(181);
				match(T__0);
				}
				break;
			case T__0:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(T__0);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public Token funcName;
		public TerminalNode Identifier() { return getToken(RuleLangParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			((FunctionCallContext)_localctx).funcName = match(Identifier);
			setState(187);
			match(T__1);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << Not) | (1L << MessageRef) | (1L << Boolean) | (1L << Integer) | (1L << Float) | (1L << Char) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(188);
				arguments();
				}
			}

			setState(191);
			match(T__2);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	 
		public ArgumentsContext() { }
		public void copyFrom(ArgumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PositionalArgsContext extends ArgumentsContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PositionalArgsContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterPositionalArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitPositionalArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitPositionalArgs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NamedArgsContext extends ArgumentsContext {
		public List<PropAssignmentContext> propAssignment() {
			return getRuleContexts(PropAssignmentContext.class);
		}
		public PropAssignmentContext propAssignment(int i) {
			return getRuleContext(PropAssignmentContext.class,i);
		}
		public NamedArgsContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterNamedArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitNamedArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitNamedArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arguments);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new NamedArgsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				propAssignment();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(194);
					match(T__4);
					setState(195);
					propAssignment();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new PositionalArgsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				expression(0);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(202);
					match(T__4);
					setState(203);
					expression(0);
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IntegerContext extends LiteralContext {
		public TerminalNode Integer() { return getToken(RuleLangParser.Integer, 0); }
		public IntegerContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatContext extends LiteralContext {
		public TerminalNode Float() { return getToken(RuleLangParser.Float, 0); }
		public FloatContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharContext extends LiteralContext {
		public TerminalNode Char() { return getToken(RuleLangParser.Char, 0); }
		public CharContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitChar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends LiteralContext {
		public TerminalNode String() { return getToken(RuleLangParser.String, 0); }
		public StringContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanContext extends LiteralContext {
		public TerminalNode Boolean() { return getToken(RuleLangParser.Boolean, 0); }
		public BooleanContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RuleLangListener ) ((RuleLangListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RuleLangVisitor ) return ((RuleLangVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_literal);
		try {
			setState(216);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(Integer);
				}
				break;
			case Float:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(Float);
				}
				break;
			case Char:
				_localctx = new CharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(213);
				match(Char);
				}
				break;
			case String:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(214);
				match(String);
				}
				break;
			case Boolean:
				_localctx = new BooleanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(215);
				match(Boolean);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		case 7:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u00dd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\6\2!\n\2\r\2\16\2\""+
		"\3\2\3\2\3\3\6\3(\n\3\r\3\16\3)\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\6\5\64"+
		"\n\5\r\5\16\5\65\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3"+
		"\7\3\7\3\7\5\7G\n\7\3\b\6\bJ\n\b\r\b\16\bK\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\7\tV\n\t\f\t\16\tY\13\t\5\t[\n\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\nk\n\n\f\n\16\nn\13\n\7\np\n\n\f\n\16\ns\13"+
		"\n\3\n\3\n\3\n\3\n\3\n\7\nz\n\n\f\n\16\n}\13\n\7\n\177\n\n\f\n\16\n\u0082"+
		"\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008c\n\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\n\u00a8\n\n\f\n\16\n\u00ab\13\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00bb\n\f\3\r\3\r\3\r\5\r"+
		"\u00c0\n\r\3\r\3\r\3\16\3\16\3\16\7\16\u00c7\n\16\f\16\16\16\u00ca\13"+
		"\16\3\16\3\16\3\16\7\16\u00cf\n\16\f\16\16\16\u00d2\13\16\5\16\u00d4\n"+
		"\16\3\17\3\17\3\17\3\17\3\17\5\17\u00db\n\17\3\17\2\3\22\20\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\2\7\3\2\31\32\3\2\f\r\3\2\16\20\3\2\21\24\3"+
		"\2\25\26\u00f5\2 \3\2\2\2\4\'\3\2\2\2\6-\3\2\2\2\b\60\3\2\2\2\n9\3\2\2"+
		"\2\fC\3\2\2\2\16I\3\2\2\2\20O\3\2\2\2\22\u008b\3\2\2\2\24\u00ac\3\2\2"+
		"\2\26\u00ba\3\2\2\2\30\u00bc\3\2\2\2\32\u00d3\3\2\2\2\34\u00da\3\2\2\2"+
		"\36!\5\20\t\2\37!\5\b\5\2 \36\3\2\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2"+
		"\2\"#\3\2\2\2#$\3\2\2\2$%\7\2\2\3%\3\3\2\2\2&(\5\b\5\2\'&\3\2\2\2()\3"+
		"\2\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\2\2\3,\5\3\2\2\2-.\5\b\5\2."+
		"/\7\2\2\3/\7\3\2\2\2\60\61\7\36\2\2\61\63\7,\2\2\62\64\5\n\6\2\63\62\3"+
		"\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7$"+
		"\2\28\t\3\2\2\29:\7!\2\2:;\7)\2\2;<\7&\2\2<@\t\2\2\2=?\5\f\7\2>=\3\2\2"+
		"\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\13\3\2\2\2B@\3\2\2\2CD\7\37\2\2DF\7"+
		",\2\2EG\7\3\2\2FE\3\2\2\2FG\3\2\2\2G\r\3\2\2\2HJ\5\20\t\2IH\3\2\2\2JK"+
		"\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\2\2\3N\17\3\2\2\2OP\7\37\2"+
		"\2PQ\7,\2\2QR\7\"\2\2RZ\5\22\n\2SW\7#\2\2TV\5\26\f\2UT\3\2\2\2VY\3\2\2"+
		"\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZS\3\2\2\2Z[\3\2\2\2[\\\3\2"+
		"\2\2\\]\7$\2\2]\21\3\2\2\2^_\b\n\1\2_`\7\4\2\2`a\5\22\n\2ab\7\5\2\2b\u008c"+
		"\3\2\2\2c\u008c\5\34\17\2d\u008c\5\30\r\2e\u008c\7-\2\2fq\7\6\2\2gl\5"+
		"\22\n\2hi\7\7\2\2ik\5\22\n\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2m"+
		"p\3\2\2\2nl\3\2\2\2og\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2"+
		"sq\3\2\2\2t\u008c\7\b\2\2u\u0080\7\t\2\2v{\5\24\13\2wx\7\7\2\2xz\5\24"+
		"\13\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3\2\2\2~"+
		"v\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u008c\7\n\2\2\u0084\u0085\7\'\2\2\u0085"+
		"\u0086\7\13\2\2\u0086\u008c\5\22\n\r\u0087\u0088\t\3\2\2\u0088\u008c\5"+
		"\22\n\n\u0089\u008a\7\35\2\2\u008a\u008c\5\22\n\t\u008b^\3\2\2\2\u008b"+
		"c\3\2\2\2\u008bd\3\2\2\2\u008be\3\2\2\2\u008bf\3\2\2\2\u008bu\3\2\2\2"+
		"\u008b\u0084\3\2\2\2\u008b\u0087\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u00a9"+
		"\3\2\2\2\u008d\u008e\f\f\2\2\u008e\u008f\7\13\2\2\u008f\u00a8\5\22\n\r"+
		"\u0090\u0091\f\b\2\2\u0091\u0092\t\4\2\2\u0092\u00a8\5\22\n\t\u0093\u0094"+
		"\f\7\2\2\u0094\u0095\t\3\2\2\u0095\u00a8\5\22\n\b\u0096\u0097\f\6\2\2"+
		"\u0097\u0098\t\5\2\2\u0098\u00a8\5\22\n\7\u0099\u009a\f\5\2\2\u009a\u009b"+
		"\t\6\2\2\u009b\u00a8\5\22\n\6\u009c\u009d\f\4\2\2\u009d\u009e\7\33\2\2"+
		"\u009e\u00a8\5\22\n\5\u009f\u00a0\f\3\2\2\u00a0\u00a1\7\34\2\2\u00a1\u00a8"+
		"\5\22\n\4\u00a2\u00a3\f\13\2\2\u00a3\u00a4\7\6\2\2\u00a4\u00a5\5\22\n"+
		"\2\u00a5\u00a6\7\b\2\2\u00a6\u00a8\3\2\2\2\u00a7\u008d\3\2\2\2\u00a7\u0090"+
		"\3\2\2\2\u00a7\u0093\3\2\2\2\u00a7\u0096\3\2\2\2\u00a7\u0099\3\2\2\2\u00a7"+
		"\u009c\3\2\2\2\u00a7\u009f\3\2\2\2\u00a7\u00a2\3\2\2\2\u00a8\u00ab\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\23\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ad\7-\2\2\u00ad\u00ae\7\27\2\2\u00ae\u00af\5\22\n\2"+
		"\u00af\25\3\2\2\2\u00b0\u00b1\5\30\r\2\u00b1\u00b2\7\3\2\2\u00b2\u00bb"+
		"\3\2\2\2\u00b3\u00b4\7%\2\2\u00b4\u00b5\7-\2\2\u00b5\u00b6\7\30\2\2\u00b6"+
		"\u00b7\5\22\n\2\u00b7\u00b8\7\3\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00bb\7"+
		"\3\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b3\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb"+
		"\27\3\2\2\2\u00bc\u00bd\7-\2\2\u00bd\u00bf\7\4\2\2\u00be\u00c0\5\32\16"+
		"\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2"+
		"\7\5\2\2\u00c2\31\3\2\2\2\u00c3\u00c8\5\24\13\2\u00c4\u00c5\7\7\2\2\u00c5"+
		"\u00c7\5\24\13\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3"+
		"\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00d4\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb"+
		"\u00d0\5\22\n\2\u00cc\u00cd\7\7\2\2\u00cd\u00cf\5\22\n\2\u00ce\u00cc\3"+
		"\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00c3\3\2\2\2\u00d3\u00cb\3\2"+
		"\2\2\u00d4\33\3\2\2\2\u00d5\u00db\7)\2\2\u00d6\u00db\7*\2\2\u00d7\u00db"+
		"\7+\2\2\u00d8\u00db\7,\2\2\u00d9\u00db\7(\2\2\u00da\u00d5\3\2\2\2\u00da"+
		"\u00d6\3\2\2\2\u00da\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2"+
		"\2\2\u00db\35\3\2\2\2\30 \")\65@FKWZlq{\u0080\u008b\u00a7\u00a9\u00ba"+
		"\u00bf\u00c8\u00d0\u00d3\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}