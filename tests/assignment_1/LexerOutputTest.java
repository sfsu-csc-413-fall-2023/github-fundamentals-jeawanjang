package tests.assignment_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lexer.Lexer;
import lexer.daos.TokenKind;
import lexer.readers.IReader;
import tests.helpers.TestReader;

public class LexerOutputTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }

  @Test
  public void testLexerOutput() throws Exception {
    List<String> sourceFileLines = List.of(
        "int i",
        "program");

    IReader reader = new TestReader(sourceFileLines);
    try (Lexer lexer = new Lexer(reader)) {
      while (lexer.nextToken().getTokenKind() != TokenKind.EOF) {

      }
    }

    List<String> output = Arrays.asList(outputStreamCaptor.toString().split(System.lineSeparator()));

    assertEquals(output.get(0), "int                  left: 0        right: 2        line: 1        IntType");
    assertEquals(output.get(1), "i                    left: 4        right: 4        line: 1        Identifier");
    assertEquals(output.get(2), "");
    assertEquals(output.get(3), "  1: int i");
    assertEquals(output.get(4), "  2: program");

  }
}
