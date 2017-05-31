package io.github.aaronclong.hurtlocker.parser;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParsedKeyValue implements ParsedItem {
  private String original;

  private ParsedKeyValue(String theOriginal) {
    original = theOriginal;
  }

  public String getOriginal() {
    return "";
  }

  public String getParsed() {
    return "";
  }

  public static ParsedKeyValue parse(String original) {
    return new ParsedKeyValue(original);
  }
}
