package io.github.aaronclong.hurtlocker.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaronlong on 5/31/17.
 */
public class Parser implements ParsedItem {

  private String original;

  private Parser(String theOriginal) {
    original = theOriginal;
  }

  public String getOriginal() {
    return original;
  }

  public Map<String, String> getParsed() throws ParserException {
    HashMap<String, String> map = new HashMap<>();
    String[] brokenByHashTag = original.split("##");
    for (String line : brokenByHashTag) {
      System.out.println(line);
      ParsedLine lineParsed  = ParsedLine.parse(line);
      Map<String, String> mapper = lineParsed.getParsed();
      System.out.println(mapper);
    }
    return map;
  }

  public static Parser parse(String original) {
    return new Parser(original);
  }

}
