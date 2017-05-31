package io.github.aaronclong.hurtlocker.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParsedLine implements ParsedItem {
  private final String original;

  private ParsedLine(String theOriginal) {
    original = theOriginal;
  }

  public String getOriginal() {
    return "";
  }

  public Map<String, String> getParsed() throws ParserException {
    HashMap<String, String> parsedKeyValuePairs = new HashMap<>();
    String[] keyValuePairs = original.split("(" + ParsedKeyValue.REGEX + ")");
    Arrays.stream(keyValuePairs).forEach(System.out::println);
    for (String pair : keyValuePairs) {
      Map<String, String> parsed = handleKeyValueParse(pair);
      if (parsed != null) {
        concatMaps(parsedKeyValuePairs, parsed);
      } else {
        System.out.println("Nope");
      }
    }
    return parsedKeyValuePairs;
  }

  private void concatMaps(Map<String, String> base, Map<String, String> temporary) {
    Set<String> tempKeys = temporary.keySet();
    for (String key : tempKeys) {
      if (!base.containsKey(key)) {
        base.put(key, temporary.get(key));
      }
    }
  }

  private Map<String, String> handleKeyValueParse(String pair) {
    try {
      ParsedKeyValue parsed = ParsedKeyValue.parse(pair);
      return parsed.getParsed();
    }  catch (ParserException e) {
      return null;
    }
  }

  public static ParsedLine parse(String original) {
    return new ParsedLine(original);
  }
}
