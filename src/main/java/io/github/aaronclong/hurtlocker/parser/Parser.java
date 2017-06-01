package io.github.aaronclong.hurtlocker.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaronlong on 5/31/17.
 */
public class Parser {

  private String original;

  private Parser(String theOriginal) {
    original = theOriginal;
  }

  public String getOriginal() {
    return original;
  }

  public Map<String, ArrayList<Map<String, String>>> getParsed() throws ParserException {
    Map<String, ArrayList<Map<String, String>>> map = new HashMap<>();
    String[] brokenByHashTag = original.split("##");
    for (String line : brokenByHashTag) {
      ParsedLine lineParsed  = ParsedLine.parse(line);
      Map<String, String> lineAsMap = lineParsed.getParsed();
      ifEmptyAdd(map, lineAsMap);
    }
    return map;
  }

  private void ifEmptyAdd(Map<String, ArrayList<Map<String, String>>> base,
                          Map<String, String> temporary) {
    String name = temporary.get("Name");
    if (!base.containsKey(name)) {
      base.put(name, new ArrayList<>());
    }
    base.get(name).add(temporary);
  }

  public static Parser parse(String original) {
    return new Parser(original);
  }

}
