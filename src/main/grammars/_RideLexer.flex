package com.wavesplatform.rideplugin.parser;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.wavesplatform.rideplugin.psi.RideTypes;

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

AT_SYMBOL=@

BOOL=true|false
COMMENT=#.*
INTEGER=[0-9_]+
WHITE_SPACE=[ \t\n\x0B\f\r]+
STRING=(\")[^\"]*\"
SQSTRING=(')[^']*'
RIDE_FILE = [a-zA-Z0-9\/\\.\\_-]*\.ride
UPPER_ID = [A-Z_-][a-zA-Z0-9_]*
LOWER_ID = [a-z_-][a-zA-Z0-9_]*
IDENT=[a-zA-Z_-][a-zA-Z0-9_]*
//todo this is bad
//this is needed to create tolerance to whitespaces in RDBRACKET
RDBRACKET="#-}"{WHITE_SPACE}*


//%state ANNOTATION

//annotation = {AT_SYMBOL}{IDENT}

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "="                { return ASSIGN; }
  "{-#"              { return LDBRACKET; }
  {RDBRACKET}        { return RDBRACKET; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "if"               { return IF; }
  "else"             { return ELSE; }
  "unit"             { return UNIT; }
  "_"                { return UNDERSCORE; }
  "["                { return LBRACKET; }
  "]"                { return RBRACKET; }
  "{"                { return LBRACE; }
  "}"                { return RBRACE; }
  "("                { return LPAREN; }
  ")"                { return RPAREN; }
  ":"                { return COLON; }
  ","                { return COMMA; }
  "=="               { return EQ; }
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
  "*"                { return MUL; }
  "/"                { return SLASH; }
  "%"                { return PERCENT; }
  ">="               { return GREATER_OR_EQUAL; }
  "<="               { return LESS_OR_EQUAL; }
  ">"                { return GT; }
  "<"                { return LESS; }
  "."                { return DOT; }
  "++"               { return CONCAT; }
  ":+"               { return APPEND; }
  "::"               { return PREPEND; }
  "func"             { return FUNCTION; }
  "match"            { return MATCH; }
  "case"             { return CASE; }
  "strict"           { return STRICT; }
  "let"              { return LET; }
  "then"             { return THEN; }
  "FOLD"             { return FOLD_KW; }
  "nil"              { return NIL; }
  "INT"              { return INT; }
  "ASTERISK"         { return ASTERISK; }
  "base16"           { return BASE16; }
  "base58"           { return BASE58; }
  "base64"           { return BASE64; }

  {BOOL}             { return BOOL; }
  {COMMENT}          { return COMMENT; }
  {INTEGER}          { return INTEGER; }
  {WHITE_SPACE}      { return WHITE_SPACE; }
  {STRING}           { return STRING; }
  {SQSTRING}         { return SQSTRING; }
  {RIDE_FILE}        { return RIDE_FILE; }
  {UPPER_ID}         { return UPPER_ID; }
  {LOWER_ID}         { return LOWER_ID; }
  {IDENT}            { return IDENT; }
  {AT_SYMBOL}        { return AT_SYMBOL; }

}

[^] { return BAD_CHARACTER; }
