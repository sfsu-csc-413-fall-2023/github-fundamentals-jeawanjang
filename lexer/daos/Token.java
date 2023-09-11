package lexer.daos;

public class Token {
  private int leftPosition, rightPosition;
  private Symbol symbol;

  public Token(Symbol symbol, int leftPosition, int rightPosition) {
    this.symbol = symbol;
    this.leftPosition = leftPosition;
    this.rightPosition = rightPosition;
  }

  public int getRightPosition() {
    return rightPosition;
  }

  public int getLeftPosition() {
    return leftPosition;
  }

  public String getLexeme() {
    return this.symbol.getLexeme();
  }

  public TokenKind getTokenKind() {
    return this.symbol.getTokenKind();
  }

  /**
   * This is not the correct way to create a String representation of an object!
   * 
   * @return String
   */
  public String testPrint() {
    return String.format(
        "L: %d, R: %d, %s", this.getLeftPosition(), this.getRightPosition(), this.getLexeme());
  }
}
