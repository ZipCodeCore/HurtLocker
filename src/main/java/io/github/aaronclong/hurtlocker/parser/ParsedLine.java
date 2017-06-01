package io.github.aaronclong.hurtlocker.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParsedLine implements ParsedItem {
  private final String original;

  private ParsedLine(String theOriginal) {
    original = theOriginal;
  }

  public String getOriginal() {
    return original;
  }

  public Map<String, String> getParsed() throws ParserException {
    HashMap<String, String> parsedKeyValuePairs = new HashMap<>();
    String[] keyValuePairs = regexPullLines();
    for (String pair : keyValuePairs) {
      Map<String, String> parsed = handleKeyValueParse(pair);
      if (parsed != null) {
        ParsedItem.concatMaps(parsedKeyValuePairs, parsed);
      }
    }
    return parsedKeyValuePairs;
  }

  private Map<String, String> handleKeyValueParse(String pair) {
    try {
      ParsedKeyValue parsed = ParsedKeyValue.parse(pair);
      return parsed.getParsed();
    }  catch (ParserException e) {
      return null;
    }
  }

  private String[] regexPullLines() {
    ArrayList<String> matchedItems = new ArrayList<>();
    Pattern pattern = Pattern.compile("(" + ParsedKeyValue.REGEX + ")");
    Matcher matcher = pattern.matcher(original);
    while (matcher.find()) {
      matchedItems.add(matcher.group());
    }
    String[] matchedItemsAsStrings = new String[matchedItems.size()];
    matchedItems.toArray(matchedItemsAsStrings);
    return matchedItemsAsStrings;
  }

  public static ParsedLine parse(String original) {
    return new ParsedLine(original);
  }
}
