package io.github.aaronclong.hurtlocker.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaronlong on 5/31/17.
 */
public class Parser implements ParsedItem {

  private String original;

  public String getOriginal() {
    return original;
  }

  public Map<String, String> getParsed() throws ParserException {
    return new HashMap<>();
  }
}
