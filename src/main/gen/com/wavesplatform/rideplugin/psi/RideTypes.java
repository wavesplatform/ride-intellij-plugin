// This is a generated file. Not intended for manual editing.
package com.wavesplatform.rideplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.wavesplatform.rideplugin.psi.impl.RideElementTypeFactory;
import com.wavesplatform.rideplugin.psi.impl.*;

public interface RideTypes {

  IElementType ALL = new RideElementType("ALL");
  IElementType AND_EXPR = new RideElementType("AND_EXPR");
  IElementType ANNOTATION = new RideElementType("ANNOTATION");
  IElementType ANNOTATION_EXPR = new RideElementType("ANNOTATION_EXPR");
  IElementType APPEND_EXPR = new RideElementType("APPEND_EXPR");
  IElementType ARGUMENT = new RideElementType("ARGUMENT");
  IElementType ARGUMENTS = new RideElementType("ARGUMENTS");
  IElementType ARRAY_EXPR = new RideElementType("ARRAY_EXPR");
  IElementType ARRAY_TYPE = new RideElementType("ARRAY_TYPE");
  IElementType BLOCK_STATE = new RideElementType("BLOCK_STATE");
  IElementType BOOL_LITERAL = new RideElementType("BOOL_LITERAL");
  IElementType BYTE_VECTOR_LITERAL = new RideElementType("BYTE_VECTOR_LITERAL");
  IElementType CALLING_OBJECT = new RideElementType("CALLING_OBJECT");
  IElementType CALL_ARGUMENTS = new RideElementType("CALL_ARGUMENTS");
  IElementType CALL_CAST_CHAIN = new RideElementType("CALL_CAST_CHAIN");
  IElementType CALL_CHAIN = new RideElementType("CALL_CHAIN");
  IElementType CALL_FIELD_CHAIN = new RideElementType("CALL_FIELD_CHAIN");
  IElementType CALL_FUNCTION_CHAIN = new RideElementType("CALL_FUNCTION_CHAIN");
  IElementType CASE_CLOSURE = new RideElementType("CASE_CLOSURE");
  IElementType CASE_EXPR = new RideElementType("CASE_EXPR");
  IElementType CLOSURE = new RideElementType("CLOSURE");
  IElementType CONCAT_EXPR = new RideElementType("CONCAT_EXPR");
  IElementType DIRECTIVE = new RideElementType("DIRECTIVE");
  IElementType DIV_EXPR = new RideElementType("DIV_EXPR");
  IElementType ELSE_BLOCK = new RideElementType("ELSE_BLOCK");
  IElementType ELSE_IF_BLOCK = new RideElementType("ELSE_IF_BLOCK");
  IElementType EQUAL_EXPR = new RideElementType("EQUAL_EXPR");
  IElementType EXPR = new RideElementType("EXPR");
  IElementType EXPR_CALL = new RideElementType("EXPR_CALL");
  IElementType FIELD_CALL = new RideElementType("FIELD_CALL");
  IElementType FIELD_DEFINITION = new RideElementType("FIELD_DEFINITION");
  IElementType FOLD_EXPR = new RideElementType("FOLD_EXPR");
  IElementType FUNCTION_CALL = new RideElementType("FUNCTION_CALL");
  IElementType FUNCTION_DEFINITION = RideElementTypeFactory.factory("FUNCTION_DEFINITION");
  IElementType FUNC_EXPR = new RideElementType("FUNC_EXPR");
  IElementType IF_COND = new RideElementType("IF_COND");
  IElementType IF_EXPR = new RideElementType("IF_EXPR");
  IElementType IMPORTS = new RideElementType("IMPORTS");
  IElementType INDEX_EXPR = new RideElementType("INDEX_EXPR");
  IElementType INTEGER_LITERAL = new RideElementType("INTEGER_LITERAL");
  IElementType INVOKE_FUNCTION_NAME = new RideElementType("INVOKE_FUNCTION_NAME");
  IElementType LESS_EXPR = new RideElementType("LESS_EXPR");
  IElementType LESS_OR_EQ_EXPR = new RideElementType("LESS_OR_EQ_EXPR");
  IElementType LITERAL_EXPR = new RideElementType("LITERAL_EXPR");
  IElementType MINUS_EXPR = new RideElementType("MINUS_EXPR");
  IElementType MOD_EXPR = new RideElementType("MOD_EXPR");
  IElementType MORE_EXPR = new RideElementType("MORE_EXPR");
  IElementType MORE_OR_EQ_EXPR = new RideElementType("MORE_OR_EQ_EXPR");
  IElementType MUL_EXPR = new RideElementType("MUL_EXPR");
  IElementType NIL_LITERAL = new RideElementType("NIL_LITERAL");
  IElementType NOT_EQUAL_EXPR = new RideElementType("NOT_EQUAL_EXPR");
  IElementType NUMERIC_LITERAL = new RideElementType("NUMERIC_LITERAL");
  IElementType OBJECT_FUNCTION_CALL = new RideElementType("OBJECT_FUNCTION_CALL");
  IElementType OR_EXPR = new RideElementType("OR_EXPR");
  IElementType PARAM_DEFINITION = new RideElementType("PARAM_DEFINITION");
  IElementType PARAM_GROUP = new RideElementType("PARAM_GROUP");
  IElementType PAREN_EXPR = new RideElementType("PAREN_EXPR");
  IElementType PATTERN_MATCHING_EXPR = new RideElementType("PATTERN_MATCHING_EXPR");
  IElementType PLUS_EXPR = new RideElementType("PLUS_EXPR");
  IElementType PREPEND_EXPR = new RideElementType("PREPEND_EXPR");
  IElementType SIMPLE_REF_EXPR = new RideElementType("SIMPLE_REF_EXPR");
  IElementType SIMPLE_TYPE = new RideElementType("SIMPLE_TYPE");
  IElementType STANDALONE_FUNCTION_CALL = new RideElementType("STANDALONE_FUNCTION_CALL");
  IElementType STATEMENT = new RideElementType("STATEMENT");
  IElementType STRING_LITERAL = new RideElementType("STRING_LITERAL");
  IElementType STRUCT_CALL = new RideElementType("STRUCT_CALL");
  IElementType TUPLE_DEFINITION = new RideElementType("TUPLE_DEFINITION");
  IElementType TUPLE_EXPR = new RideElementType("TUPLE_EXPR");
  IElementType TUPLE_TYPE = new RideElementType("TUPLE_TYPE");
  IElementType TYPE = new RideElementType("TYPE");
  IElementType TYPE_DEFINITION = new RideElementType("TYPE_DEFINITION");
  IElementType UNARY_MIN_EXPR = new RideElementType("UNARY_MIN_EXPR");
  IElementType UNARY_NOT_EXPR = new RideElementType("UNARY_NOT_EXPR");
  IElementType UNION_TYPE = new RideElementType("UNION_TYPE");
  IElementType UNIT_LITERAL = new RideElementType("UNIT_LITERAL");
  IElementType VAR_DECLARATION_STATEMENT = new RideElementType("VAR_DECLARATION_STATEMENT");
  IElementType VAR_DEFINITION = RideElementTypeFactory.factory("VAR_DEFINITION");

  IElementType APPEND = new RideTokenType(":+");
  IElementType ASSIGN = new RideTokenType("=");
  IElementType ASTERISK = new RideTokenType("ASTERISK");
  IElementType AT_SYMBOL = new RideTokenType("@");
  IElementType BANG = new RideTokenType("!");
  IElementType BASE16 = new RideTokenType("base16");
  IElementType BASE58 = new RideTokenType("base58");
  IElementType BASE64 = new RideTokenType("base64");
  IElementType BIT_AND = new RideTokenType("&");
  IElementType BIT_AND_ASSIGN = new RideTokenType("&=");
  IElementType BIT_CLEAR = new RideTokenType("&^");
  IElementType BIT_CLEAR_ASSIGN = new RideTokenType("&^=");
  IElementType BIT_OR = new RideTokenType("|");
  IElementType BIT_OR_ASSIGN = new RideTokenType("|=");
  IElementType BOOL = new RideTokenType("BOOL");
  IElementType CASE = new RideTokenType("case");
  IElementType COLON = new RideTokenType(":");
  IElementType COMMA = new RideTokenType(",");
  IElementType COMMENT = new RideTokenType("COMMENT");
  IElementType CONCAT = new RideTokenType("++");
  IElementType COND_AND = new RideTokenType("&&");
  IElementType COND_OR = new RideTokenType("||");
  IElementType DOT = new RideTokenType(".");
  IElementType ELSE = new RideTokenType("else");
  IElementType EQ = new RideTokenType("==");
  IElementType FALSE = new RideTokenType("false");
  IElementType FOLD_KW = new RideTokenType("FOLD");
  IElementType FUNCTION = new RideTokenType("func");
  IElementType GREATER_OR_EQUAL = new RideTokenType(">=");
  IElementType GT = new RideTokenType(">");
  IElementType IF = new RideTokenType("if");
  IElementType INT = new RideTokenType("INT");
  IElementType INTEGER = new RideTokenType("INTEGER");
  IElementType LBRACE = new RideTokenType("{");
  IElementType LBRACKET = new RideTokenType("[");
  IElementType LDBRACKET = new RideTokenType("{-#");
  IElementType LESS = new RideTokenType("<");
  IElementType LESS_OR_EQUAL = new RideTokenType("<=");
  IElementType LET = new RideTokenType("let");
  IElementType LOWER_ID = new RideTokenType("LOWER_ID");
  IElementType LPAREN = new RideTokenType("(");
  IElementType MATCH = new RideTokenType("match");
  IElementType MINUS = new RideTokenType("-");
  IElementType MINUS_ASSIGN = new RideTokenType("-=");
  IElementType MINUS_MINUS = new RideTokenType("--");
  IElementType MUL = new RideTokenType("*");
  IElementType NIL = new RideTokenType("nil");
  IElementType NOT_EQ = new RideTokenType("!=");
  IElementType PERCENT = new RideTokenType("%");
  IElementType PLUS = new RideTokenType("+");
  IElementType PREPEND = new RideTokenType("::");
  IElementType RBRACE = new RideTokenType("}");
  IElementType RBRACKET = new RideTokenType("]");
  IElementType RDBRACKET = new RideTokenType("#-}");
  IElementType RIDE_FILE = new RideTokenType("RIDE_FILE");
  IElementType RPAREN = new RideTokenType(")");
  IElementType SLASH = new RideTokenType("/");
  IElementType SQSTRING = new RideTokenType("SQSTRING");
  IElementType STRICT = new RideTokenType("strict");
  IElementType STRING = new RideTokenType("STRING");
  IElementType THEN = new RideTokenType("then");
  IElementType TRUE = new RideTokenType("true");
  IElementType TUPPLE_FIELD = new RideTokenType("TUPPLE_FIELD");
  IElementType UNDERSCORE = new RideTokenType("_");
  IElementType UNIT = new RideTokenType("unit");
  IElementType UPPER_ID = new RideTokenType("UPPER_ID");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALL) {
        return new RideAllImpl(node);
      }
      else if (type == AND_EXPR) {
        return new RideAndExprImpl(node);
      }
      else if (type == ANNOTATION) {
        return new RideAnnotationImpl(node);
      }
      else if (type == ANNOTATION_EXPR) {
        return new RideAnnotationExprImpl(node);
      }
      else if (type == APPEND_EXPR) {
        return new RideAppendExprImpl(node);
      }
      else if (type == ARGUMENT) {
        return new RideArgumentImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new RideArgumentsImpl(node);
      }
      else if (type == ARRAY_EXPR) {
        return new RideArrayExprImpl(node);
      }
      else if (type == ARRAY_TYPE) {
        return new RideArrayTypeImpl(node);
      }
      else if (type == BLOCK_STATE) {
        return new RideBlockStateImpl(node);
      }
      else if (type == BOOL_LITERAL) {
        return new RideBoolLiteralImpl(node);
      }
      else if (type == BYTE_VECTOR_LITERAL) {
        return new RideByteVectorLiteralImpl(node);
      }
      else if (type == CALLING_OBJECT) {
        return new RideCallingObjectImpl(node);
      }
      else if (type == CALL_ARGUMENTS) {
        return new RideCallArgumentsImpl(node);
      }
      else if (type == CALL_CAST_CHAIN) {
        return new RideCallCastChainImpl(node);
      }
      else if (type == CALL_CHAIN) {
        return new RideCallChainImpl(node);
      }
      else if (type == CALL_FIELD_CHAIN) {
        return new RideCallFieldChainImpl(node);
      }
      else if (type == CALL_FUNCTION_CHAIN) {
        return new RideCallFunctionChainImpl(node);
      }
      else if (type == CASE_CLOSURE) {
        return new RideCaseClosureImpl(node);
      }
      else if (type == CASE_EXPR) {
        return new RideCaseExprImpl(node);
      }
      else if (type == CLOSURE) {
        return new RideClosureImpl(node);
      }
      else if (type == CONCAT_EXPR) {
        return new RideConcatExprImpl(node);
      }
      else if (type == DIRECTIVE) {
        return new RideDirectiveImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new RideDivExprImpl(node);
      }
      else if (type == ELSE_BLOCK) {
        return new RideElseBlockImpl(node);
      }
      else if (type == ELSE_IF_BLOCK) {
        return new RideElseIfBlockImpl(node);
      }
      else if (type == EQUAL_EXPR) {
        return new RideEqualExprImpl(node);
      }
      else if (type == EXPR_CALL) {
        return new RideExprCallImpl(node);
      }
      else if (type == FIELD_CALL) {
        return new RideFieldCallImpl(node);
      }
      else if (type == FIELD_DEFINITION) {
        return new RideFieldDefinitionImpl(node);
      }
      else if (type == FOLD_EXPR) {
        return new RideFoldExprImpl(node);
      }
      else if (type == FUNCTION_DEFINITION) {
        return new RideFunctionDefinitionImpl(node);
      }
      else if (type == FUNC_EXPR) {
        return new RideFuncExprImpl(node);
      }
      else if (type == IF_COND) {
        return new RideIfCondImpl(node);
      }
      else if (type == IF_EXPR) {
        return new RideIfExprImpl(node);
      }
      else if (type == IMPORTS) {
        return new RideImportsImpl(node);
      }
      else if (type == INDEX_EXPR) {
        return new RideIndexExprImpl(node);
      }
      else if (type == INTEGER_LITERAL) {
        return new RideIntegerLiteralImpl(node);
      }
      else if (type == INVOKE_FUNCTION_NAME) {
        return new RideInvokeFunctionNameImpl(node);
      }
      else if (type == LESS_EXPR) {
        return new RideLessExprImpl(node);
      }
      else if (type == LESS_OR_EQ_EXPR) {
        return new RideLessOrEqExprImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new RideLiteralExprImpl(node);
      }
      else if (type == MINUS_EXPR) {
        return new RideMinusExprImpl(node);
      }
      else if (type == MOD_EXPR) {
        return new RideModExprImpl(node);
      }
      else if (type == MORE_EXPR) {
        return new RideMoreExprImpl(node);
      }
      else if (type == MORE_OR_EQ_EXPR) {
        return new RideMoreOrEqExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new RideMulExprImpl(node);
      }
      else if (type == NIL_LITERAL) {
        return new RideNilLiteralImpl(node);
      }
      else if (type == NOT_EQUAL_EXPR) {
        return new RideNotEqualExprImpl(node);
      }
      else if (type == NUMERIC_LITERAL) {
        return new RideNumericLiteralImpl(node);
      }
      else if (type == OBJECT_FUNCTION_CALL) {
        return new RideObjectFunctionCallImpl(node);
      }
      else if (type == OR_EXPR) {
        return new RideOrExprImpl(node);
      }
      else if (type == PARAM_DEFINITION) {
        return new RideParamDefinitionImpl(node);
      }
      else if (type == PARAM_GROUP) {
        return new RideParamGroupImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new RideParenExprImpl(node);
      }
      else if (type == PATTERN_MATCHING_EXPR) {
        return new RidePatternMatchingExprImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new RidePlusExprImpl(node);
      }
      else if (type == PREPEND_EXPR) {
        return new RidePrependExprImpl(node);
      }
      else if (type == SIMPLE_REF_EXPR) {
        return new RideSimpleRefExprImpl(node);
      }
      else if (type == SIMPLE_TYPE) {
        return new RideSimpleTypeImpl(node);
      }
      else if (type == STANDALONE_FUNCTION_CALL) {
        return new RideStandaloneFunctionCallImpl(node);
      }
      else if (type == STATEMENT) {
        return new RideStatementImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new RideStringLiteralImpl(node);
      }
      else if (type == STRUCT_CALL) {
        return new RideStructCallImpl(node);
      }
      else if (type == TUPLE_DEFINITION) {
        return new RideTupleDefinitionImpl(node);
      }
      else if (type == TUPLE_EXPR) {
        return new RideTupleExprImpl(node);
      }
      else if (type == TUPLE_TYPE) {
        return new RideTupleTypeImpl(node);
      }
      else if (type == TYPE_DEFINITION) {
        return new RideTypeDefinitionImpl(node);
      }
      else if (type == UNARY_MIN_EXPR) {
        return new RideUnaryMinExprImpl(node);
      }
      else if (type == UNARY_NOT_EXPR) {
        return new RideUnaryNotExprImpl(node);
      }
      else if (type == UNION_TYPE) {
        return new RideUnionTypeImpl(node);
      }
      else if (type == UNIT_LITERAL) {
        return new RideUnitLiteralImpl(node);
      }
      else if (type == VAR_DECLARATION_STATEMENT) {
        return new RideVarDeclarationStatementImpl(node);
      }
      else if (type == VAR_DEFINITION) {
        return new RideVarDefinitionImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
