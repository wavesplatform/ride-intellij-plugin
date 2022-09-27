package com.wavesplatform.rideplugin.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.wavesplatform.rideplugin.psi.RideTypes.*;

%%

%{
  public _RideLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _RideLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
NUMBER=[1-9][0-9]*
INT=[0-9]+
BOOL=true|false
STRING=([\"'])((?:\\\1|(?:(?!\1)).)*)(\1)
BASE=base16|base58|base64
WHITE_SPACE=[ \t\n\x0B\f\r]+
COMMENT=#.*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "{"                { return LBRACE; }
  "}"                { return RBRACE; }
  "["                { return LBRACK; }
  "]"                { return RBRACK; }
  "("                { return LPAREN; }
  ")"                { return RPAREN; }
  ":"                { return COLON; }
  ";"                { return SEMICOLON; }
  ","                { return COMMA; }
  "=="               { return EQ; }
  "="                { return ASSIGN; }
  "!="               { return NOT_EQ; }
  "!"                { return NOT; }
  "++"               { return PLUS_PLUS; }
  "+="               { return PLUS_ASSIGN; }
  "+"                { return PLUS; }
  "--"               { return MINUS_MINUS; }
  "-="               { return MINUS_ASSIGN; }
  "-"                { return MINUS; }
  "||"               { return COND_OR; }
  "|="               { return BIT_OR_ASSIGN; }
  "&^="              { return BIT_CLEAR_ASSIGN; }
  "&^"               { return BIT_CLEAR; }
  "&&"               { return COND_AND; }
  "&="               { return BIT_AND_ASSIGN; }
  "&"                { return BIT_AND; }
  "|"                { return BIT_OR; }
  "<<="              { return SHIFT_LEFT_ASSIGN; }
  "<<"               { return SHIFT_LEFT; }
  "<-"               { return SEND_CHANNEL; }
  "<="               { return LESS_OR_EQUAL; }
  "<"                { return LESS; }
  "^="               { return BIT_XOR_ASSIGN; }
  "^"                { return BIT_XOR; }
  "*="               { return MUL_ASSIGN; }
  "*"                { return MUL; }
  "/="               { return QUOTIENT_ASSIGN; }
  "/"                { return QUOTIENT; }
  "%="               { return REMAINDER_ASSIGN; }
  "%"                { return REMAINDER; }
  ">>="              { return SHIFT_RIGHT_ASSIGN; }
  ">>"               { return SHIFT_RIGHT; }
  ">="               { return GREATER_OR_EQUAL; }
  ">"                { return GREATER; }
  ":="               { return VAR_ASSIGN; }
  "..."              { return TRIPLE_DOT; }
  "."                { return DOT; }
  "<NL>"             { return SEMICOLON_SYNTHETIC; }
  "type"             { return TYPE_; }
  "raw_string"       { return RAW_STRING; }
  "func"             { return FUNC; }
  "let"              { return LET; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "unit"             { return UNIT; }
  "base16"           { return BASE16; }
  "base58"           { return BASE58; }
  "base64"           { return BASE64; }

  {IDENTIFIER}       { return IDENTIFIER; }
  {NUMBER}           { return NUMBER; }
  {INT}              { return INT; }
  {BOOL}             { return BOOL; }
  {STRING}           { return STRING; }
  {BASE}             { return BASE; }
  {WHITE_SPACE}      { return WHITE_SPACE; }
  {COMMENT}          { return COMMENT; }

}

[^] { return BAD_CHARACTER; }
