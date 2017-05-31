package io.github.aaronclong.hurtlocker.parser;

import jdk.nashorn.internal.runtime.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

  public Map<String, String> getParsed() throws ParserException {
    HashMap<String, String> parsedItems = new HashMap<>();
    Pattern parsePattern = Pattern.compile("[\\w\\.\\/]+([:@\\^\\*%])[\\w\\.\\/]+");
    Matcher matched = parsePattern.matcher(original);
    System.out.println(matched.matches());
    if (!matched.matches()) throw new ParserException();

    return parsedItems;
  }

  public static ParsedKeyValue parse(String original) {
    return new ParsedKeyValue(original);
  }
}
