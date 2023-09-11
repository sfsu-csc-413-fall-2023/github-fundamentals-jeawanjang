package lexer;

import java.nio.file.Paths;

import lexer.daos.Symbol;
import lexer.daos.Token;
import lexer.daos.TokenKind;
import lexer.readers.IReader;
import lexer.readers.SourceFileReader;

public class Lexer implements ILexer, AutoCloseable {
  private IReader reader;

  private char ch;
  private int startPosition, endPosition;

  public Lexer(IReader reader) {
    this.reader = reader;
    this.ch = ' ';
  }

  public Lexer(String sourceFilePath) {
    this(new SourceFileReader(sourceFilePath));
  }

  @Override
  public void close() throws Exception {
    this.reader.close();
  }

  @Override
  public Token nextToken() throws Lexception {
    ignoreWhitespace();

    beginNewToken();

    if (Character.isJavaIdentifierStart(this.ch)) {
      return identifierOrKeyword();
    }

    if (Character.isDigit(this.ch)) {
      return integer();
    }

    return operatorOrSeparator();
  }

  private void ignoreWhitespace() {
    while (Character.isWhitespace(this.ch)) {
      advance();
    }
  }

  private void beginNewToken() {
    this.startPosition = this.reader.getColumn();
    this.endPosition = this.startPosition;
  }

  private Token identifierOrKeyword() {
    String lexeme = "";

    do {
      lexeme += this.ch;
      advance();
    } while (Character.isJavaIdentifierPart(this.ch) && !atEof());

    return new Token(
        SymbolTable.recordSymbol(lexeme, TokenKind.Identifier),
        this.startPosition,
        this.endPosition - 1);
  }

  private Token integer() {
    String lexeme = "";

    do {
      lexeme += this.ch;
      advance();
    } while (Character.isDigit(this.ch) && !atEof());

    return new Token(
        SymbolTable.recordSymbol(lexeme, TokenKind.IntLit),
        this.startPosition,
        this.endPosition - 1);
  }

  private Token operatorOrSeparator() throws Lexception {
    String singleCharacter = "" + this.ch;

    if (atEof()) {
      return new Token(
          SymbolTable.recordSymbol(singleCharacter, TokenKind.EOF),
          this.startPosition,
          this.endPosition);
    }

    advance();

    String doubleCharacter = singleCharacter + this.ch;
    Symbol symbol = SymbolTable.recordSymbol(doubleCharacter, TokenKind.BogusToken);

    if (symbol == null) {
      return singleCharacterOperatorOrSeparator(singleCharacter);
    } else if (symbol.getTokenKind() == TokenKind.Comment) {
      ignoreComment();
      return nextToken();
    } else {
      advance();

      return new Token(
          symbol,
          this.startPosition,
          this.endPosition - 1);
    }
  }

  private Token singleCharacterOperatorOrSeparator(String lexeme) throws Lexception {
    Symbol symbol = SymbolTable.recordSymbol(lexeme, TokenKind.BogusToken);

    if (symbol == null) {
      throw new Lexception(lexeme, this.reader.getLineNumber(), this.reader.getColumn());
    } else {
      return new Token(
          symbol,
          this.startPosition,
          this.endPosition - 1);
    }
  }

  private void ignoreComment() {
    int currentLine = this.reader.getLineNumber();

    while (currentLine == this.reader.getLineNumber() && !atEof()) {
      advance();
    }
  }

  private void advance() {
    this.ch = this.reader.read();
    this.endPosition++;
  }

  private boolean atEof() {
    return this.ch == '\0';
  }

  public static void main(String[] args) {
    String sourceFilePath = Paths.get("xsamples", "simple.x").toString();

    try (Lexer lexer = new Lexer(sourceFilePath)) {
      Token token;

      while ((token = lexer.nextToken()).getTokenKind() != TokenKind.EOF) {
        System.out.println(token.testPrint());
      }
    } catch (Lexception lexception) {
      System.err.println(lexception.getMessage());
      System.exit(1);
    } catch (Exception exception) {
      System.err.println("Failed to close the Lexer");
      System.exit(1);
    }
  }
}
