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
INTEGER=[0-9]+
BOOL=true|false
STRING=(\")[^\"]*\"
WHITE_SPACE=[ \t\n\x0B\f\r]+
COMMENT=#.*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "{-#"              { return LDBRACKET; }
  "#-}"              { return RDBRACKET; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "if"               { return IF; }
  "else"             { return ELSE; }
  "{"                { return LBRACE; }
  "}"                { return RBRACE; }
  "["                { return LBRACK; }
  "]"                { return RBRACK; }
  "("                { return LPAREN; }
  ")"                { return RPAREN; }
  ":"                { return COLON; }
  ","                { return COMMA; }
  "=="               { return EQ; }
  "="                { return ASSIGN; }
  "!="               { return NOT_EQ; }
  "!"                { return BANG; }
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
  "<"                { return LESS; }
  "*"                { return MUL; }
  "/"                { return QUOTIENT; }
  ">="               { return GREATER_OR_EQUAL; }
  ">"                { return GREATER; }
  "."                { return DOT; }
  "func"             { return FUNCTION; }
  "let"              { return LET; }
  "strict"           { return STRICT; }
  "RETURN"           { return RETURN; }
  "INT"              { return INT; }
  "ASTERISK"         { return ASTERISK; }
  "SLASH"            { return SLASH; }
  "LT"               { return LT; }
  "GT"               { return GT; }
  "LBRACKET"         { return LBRACKET; }
  "RBRACKET"         { return RBRACKET; }
  "IDENT"            { return IDENT; }

  {IDENTIFIER}       { return IDENTIFIER; }
  {NUMBER}           { return NUMBER; }
  {INTEGER}          { return INTEGER; }
  {BOOL}             { return BOOL; }
  {STRING}           { return STRING; }
  {WHITE_SPACE}      { return WHITE_SPACE; }
  {COMMENT}          { return COMMENT; }

}

[^] { return BAD_CHARACTER; }
