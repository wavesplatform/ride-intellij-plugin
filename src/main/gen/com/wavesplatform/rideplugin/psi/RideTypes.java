// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.wavesplatform.rideplugin.psi.impl.*;

public interface RideTypes {

  IElementType ARGUMENTS_DEFINITION = new RideElementType("ARGUMENTS_DEFINITION");
  IElementType ARGUMENT_DEFINITION = new RideElementType("ARGUMENT_DEFINITION");
  IElementType ARRAY_DEFINITION = new RideElementType("ARRAY_DEFINITION");
  IElementType ARRAY_ELEMENT_AT_INDEX = new RideElementType("ARRAY_ELEMENT_AT_INDEX");
  IElementType BASE_LITERAL = new RideElementType("BASE_LITERAL");
  IElementType BOOLEAN_LITERAL = new RideElementType("BOOLEAN_LITERAL");
  IElementType DEFINITION = new RideElementType("DEFINITION");
  IElementType FUNCTION_BODY = new RideElementType("FUNCTION_BODY");
  IElementType FUNCTION_DEFINITION = new RideElementType("FUNCTION_DEFINITION");
  IElementType FUNCTION_INVOCATION = new RideElementType("FUNCTION_INVOCATION");
  IElementType FUNCTION_PARAMS_DEFINITION = new RideElementType("FUNCTION_PARAMS_DEFINITION");
  IElementType FUNCTION_SIGNATURE = new RideElementType("FUNCTION_SIGNATURE");
  IElementType INT_LITERAL = new RideElementType("INT_LITERAL");
  IElementType LET_DEFINITION = new RideElementType("LET_DEFINITION");
  IElementType META_DEFINITION = new RideElementType("META_DEFINITION");
  IElementType METHOD_INVOCATION = new RideElementType("METHOD_INVOCATION");
  IElementType NUMBER_LITERAL = new RideElementType("NUMBER_LITERAL");
  IElementType OBJECT_FIELD_CALL = new RideElementType("OBJECT_FIELD_CALL");
  IElementType STATEMENT = new RideElementType("STATEMENT");
  IElementType STRING_LITERAL = new RideElementType("STRING_LITERAL");
  IElementType STRUCT_CREATION = new RideElementType("STRUCT_CREATION");
  IElementType UNIT_LITERAL = new RideElementType("UNIT_LITERAL");

  IElementType ASSIGN = new RideTokenType("=");
  IElementType BASE = new RideTokenType("BASE");
  IElementType BASE16 = new RideTokenType("base16");
  IElementType BASE58 = new RideTokenType("base58");
  IElementType BASE64 = new RideTokenType("base64");
  IElementType BIT_AND = new RideTokenType("&");
  IElementType BIT_AND_ASSIGN = new RideTokenType("&=");
  IElementType BIT_CLEAR = new RideTokenType("&^");
  IElementType BIT_CLEAR_ASSIGN = new RideTokenType("&^=");
  IElementType BIT_OR = new RideTokenType("|");
  IElementType BIT_OR_ASSIGN = new RideTokenType("|=");
  IElementType BIT_XOR = new RideTokenType("^");
  IElementType BIT_XOR_ASSIGN = new RideTokenType("^=");
  IElementType COLON = new RideTokenType(":");
  IElementType COMMA = new RideTokenType(",");
  IElementType COMMENT = new RideTokenType("COMMENT");
  IElementType COND_AND = new RideTokenType("&&");
  IElementType COND_OR = new RideTokenType("||");
  IElementType DOT = new RideTokenType(".");
  IElementType EQ = new RideTokenType("==");
  IElementType FALSE = new RideTokenType("false");
  IElementType FUNC = new RideTokenType("func");
  IElementType GREATER = new RideTokenType(">");
  IElementType GREATER_OR_EQUAL = new RideTokenType(">=");
  IElementType IDENTIFIER = new RideTokenType("IDENTIFIER");
  IElementType INT = new RideTokenType("INT");
  IElementType LBRACE = new RideTokenType("{");
  IElementType LBRACK = new RideTokenType("[");
  IElementType LESS = new RideTokenType("<");
  IElementType LESS_OR_EQUAL = new RideTokenType("<=");
  IElementType LET = new RideTokenType("let");
  IElementType LPAREN = new RideTokenType("(");
  IElementType MINUS = new RideTokenType("-");
  IElementType MINUS_ASSIGN = new RideTokenType("-=");
  IElementType MINUS_MINUS = new RideTokenType("--");
  IElementType MUL = new RideTokenType("*");
  IElementType MUL_ASSIGN = new RideTokenType("*=");
  IElementType NOT = new RideTokenType("!");
  IElementType NOT_EQ = new RideTokenType("!=");
  IElementType NUMBER = new RideTokenType("NUMBER");
  IElementType PLUS = new RideTokenType("+");
  IElementType PLUS_ASSIGN = new RideTokenType("+=");
  IElementType PLUS_PLUS = new RideTokenType("++");
  IElementType QUOTIENT = new RideTokenType("/");
  IElementType QUOTIENT_ASSIGN = new RideTokenType("/=");
  IElementType RAW_STRING = new RideTokenType("raw_string");
  IElementType RBRACE = new RideTokenType("}");
  IElementType RBRACK = new RideTokenType("]");
  IElementType REMAINDER = new RideTokenType("%");
  IElementType REMAINDER_ASSIGN = new RideTokenType("%=");
  IElementType RPAREN = new RideTokenType(")");
  IElementType SEMICOLON = new RideTokenType(";");
  IElementType SEMICOLON_SYNTHETIC = new RideTokenType("<NL>");
  IElementType SEND_CHANNEL = new RideTokenType("<-");
  IElementType SHIFT_LEFT = new RideTokenType("<<");
  IElementType SHIFT_LEFT_ASSIGN = new RideTokenType("<<=");
  IElementType SHIFT_RIGHT = new RideTokenType(">>");
  IElementType SHIFT_RIGHT_ASSIGN = new RideTokenType(">>=");
  IElementType STRING = new RideTokenType("STRING");
  IElementType TRIPLE_DOT = new RideTokenType("...");
  IElementType TRUE = new RideTokenType("true");
  IElementType TYPE_ = new RideTokenType("type");
  IElementType UNIT = new RideTokenType("unit");
  IElementType VAR_ASSIGN = new RideTokenType(":=");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENTS_DEFINITION) {
        return new RideArgumentsDefinitionImpl(node);
      }
      else if (type == ARGUMENT_DEFINITION) {
        return new RideArgumentDefinitionImpl(node);
      }
      else if (type == ARRAY_DEFINITION) {
        return new RideArrayDefinitionImpl(node);
      }
      else if (type == ARRAY_ELEMENT_AT_INDEX) {
        return new RideArrayElementAtIndexImpl(node);
      }
      else if (type == BASE_LITERAL) {
        return new RideBaseLiteralImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new RideBooleanLiteralImpl(node);
      }
      else if (type == DEFINITION) {
        return new RideDefinitionImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new RideFunctionBodyImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new RideFunctionDefinitionImpl(node);
      }
      else if (type == FUNCTION_INVOCATION) {
        return new RideFunctionInvocationImpl(node);
      }
      else if (type == FUNCTION_PARAMS_DEFINITION) {
        return new RideFunctionParamsDefinitionImpl(node);
      }
      else if (type == FUNCTION_SIGNATURE) {
        return new RideFunctionSignatureImpl(node);
      }
      else if (type == INT_LITERAL) {
        return new RideIntLiteralImpl(node);
      }
      else if (type == LET_DEFINITION) {
        return new RideLetDefinitionImpl(node);
      }
      else if (type == META_DEFINITION) {
        return new RideMetaDefinitionImpl(node);
      }
      else if (type == METHOD_INVOCATION) {
        return new RideMethodInvocationImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new RideNumberLiteralImpl(node);
      }
      else if (type == OBJECT_FIELD_CALL) {
        return new RideObjectFieldCallImpl(node);
      }
      else if (type == STATEMENT) {
        return new RideStatementImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new RideStringLiteralImpl(node);
      }
      else if (type == STRUCT_CREATION) {
        return new RideStructCreationImpl(node);
      }
      else if (type == UNIT_LITERAL) {
        return new RideUnitLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
