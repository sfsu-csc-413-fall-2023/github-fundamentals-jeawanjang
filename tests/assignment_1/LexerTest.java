package tests.assignment_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lexer.Lexer;
import lexer.daos.Token;
import lexer.daos.TokenKind;
import tests.helpers.TestReader;

public class LexerTest {

  // @ParameterizedTest
  // @MethodSource("provideAssignmentOneKeywords")
  // public void testAssignmentOneKeywords(String source, TokenKind kind, int expectedStart, int expectedEnd)
  //     throws Exception {
  //   try (Lexer lexer = new Lexer(new TestReader(List.of(source)))) {
  //     Token token = lexer.nextToken();

  //     assertEquals(source.trim(), token.getLexeme());
  //     assertEquals(kind, token.getTokenKind());
  //     assertEquals(expectedStart, token.getLeftPosition());
  //     assertEquals(expectedEnd, token.getRightPosition());
  //   }
  // }

  // @ParameterizedTest
  // @MethodSource("provideAssignmentOneOperators")
  // public void testAssignmentOneOperators(String source, TokenKind kind, int expectedStart, int expectedEnd)
  //     throws Exception {
  //   try (Lexer lexer = new Lexer(new TestReader(List.of(source)))) {
  //     Token token = lexer.nextToken();

  //     assertEquals(source.trim(), token.getLexeme());
  //     assertEquals(kind, token.getTokenKind());
  //     assertEquals(expectedStart, token.getLeftPosition());
  //     assertEquals(expectedEnd, token.getRightPosition());
  //   }
  // }

  // @ParameterizedTest
  // @MethodSource("provideAssignmentOneSeparators")
  // public void testAssignmentOneSeparators(String source, TokenKind kind, int expectedStart, int expectedEnd)
  //     throws Exception {
  //   try (Lexer lexer = new Lexer(new TestReader(List.of(source)))) {
  //     Token token = lexer.nextToken();

  //     assertEquals(source.trim(), token.getLexeme());
  //     assertEquals(kind, token.getTokenKind());
  //     assertEquals(expectedStart, token.getLeftPosition());
  //     assertEquals(expectedEnd, token.getRightPosition());
  //   }
  // }

  // @ParameterizedTest
  // @MethodSource("provideAssignmentOneBinaryLiterals")
  // public void testBinaryLiterals(String source, TokenKind kind, int expectedStart, int expectedEnd)
  //     throws Exception {
  //   try (Lexer lexer = new Lexer(new TestReader(List.of(source)))) {
  //     Token token = lexer.nextToken();

  //     assertEquals(source.trim(), token.getLexeme());
  //     assertEquals(kind, token.getTokenKind());
  //     assertEquals(expectedStart, token.getLeftPosition());
  //     assertEquals(expectedEnd, token.getRightPosition());
  //   }
  // }

  // @ParameterizedTest
  // @MethodSource("provideAssignmentOneCharLiterals")
  // public void testCharLiterals(String source, TokenKind kind, int expectedStart, int expectedEnd)
  //     throws Exception {
  //   try (Lexer lexer = new Lexer(new TestReader(List.of(source)))) {
  //     Token token = lexer.nextToken();

  //     assertEquals(source.trim(), token.getLexeme());
  //     assertEquals(kind, token.getTokenKind());
  //     assertEquals(expectedStart, token.getLeftPosition());
  //     assertEquals(expectedEnd, token.getRightPosition());
  //   }
  // }

  // private static Stream<Arguments> provideAssignmentOneKeywords() {
  //   return Stream.of(
  //       Arguments.of(" binary  ", TokenKind.BinaryType, 1, 6),
  //       Arguments.of(" char  ", TokenKind.CharType, 1, 4),
  //       Arguments.of(" and  ", TokenKind.BoolAnd, 1, 3),
  //       Arguments.of(" or  ", TokenKind.BoolOr, 1, 2),
  //       Arguments.of(" xor  ", TokenKind.BoolXor, 1, 3),
  //       Arguments.of(" iter  ", TokenKind.Iterate, 1, 4));
  // }

  // private static Stream<Arguments> provideAssignmentOneOperators() {
  //   return Stream.of(
  //       Arguments.of(" > ", TokenKind.Greater, 1, 1),
  //       Arguments.of(" >= ", TokenKind.GreaterEqual, 1, 2));
  // }

  // private static Stream<Arguments> provideAssignmentOneSeparators() {
  //   return Stream.of(
  //       Arguments.of(" | ", TokenKind.Pipe, 1, 1),
  //       Arguments.of(" ~ ", TokenKind.Tilde, 1, 1));
  // }

  // private static Stream<Arguments> provideAssignmentOneBinaryLiterals() {
  //   return Stream.of(
  //       Arguments.of(" 0b ", TokenKind.BinaryLit, 1, 2),
  //       Arguments.of(" 1B ", TokenKind.BinaryLit, 1, 2),
  //       Arguments.of(" 01b ", TokenKind.BinaryLit, 1, 3),
  //       Arguments.of(" 10B ", TokenKind.BinaryLit, 1, 3),
  //       Arguments.of(" 00001b ", TokenKind.BinaryLit, 1, 6),
  //       Arguments.of(" 10101B ", TokenKind.BinaryLit, 1, 6));
  // }

  // private static Stream<Arguments> provideAssignmentOneCharLiterals() {
  //   return Stream.of(
  //       Arguments.of(" 'a' ", TokenKind.CharLit, 1, 2),
  //       Arguments.of(" '7' ", TokenKind.CharLit, 1, 2),
  //       Arguments.of(" '\n' ", TokenKind.CharLit, 1, 2),
  //       Arguments.of(" ' ' ", TokenKind.CharLit, 1, 2),
  //       Arguments.of(" 'Z' ", TokenKind.CharLit, 1, 2));
  // }
}
