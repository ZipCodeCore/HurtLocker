package io.github.aaronclong.hurtlocker.parser;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParsedLine implements ParsedItem {
  private String original;

  private ParsedLine(String theOriginal) {
    original = theOriginal;
  }

  public String getOriginal() {
    return "";
  }

  public String getParsed() {
    return "";
  }

  public static ParsedLine parse(String original) {
    return new ParsedLine(original);
  }
}
