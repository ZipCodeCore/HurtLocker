package io.github.aaronclong.hurtlocker.parser;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

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

  public Map<String, String> getParsed() throws ParserException {
    return new HashMap<String, String>();
  }

  public static ParsedLine parse(String original) {
    return new ParsedLine(original);
  }
}
