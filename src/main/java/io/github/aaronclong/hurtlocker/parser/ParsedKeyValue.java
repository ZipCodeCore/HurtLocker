package io.github.aaronclong.hurtlocker.parser;

import java.util.HashMap;
import java.util.Map;

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

  public Map<String, String> getParsed() {
    return new HashMap<String, String>();
  }

  public static ParsedKeyValue parse(String original) {
    return new ParsedKeyValue(original);
  }
}
