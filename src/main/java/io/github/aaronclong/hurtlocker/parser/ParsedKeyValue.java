package io.github.aaronclong.hurtlocker.parser;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParsedKeyValue implements ParsedItem {
  private final String original;
  protected static final String REGEX = "([\\w\\.\\/]+)([:@\\^\\*%])([\\w\\.\\/]+)";

  private ParsedKeyValue(String theOriginal) {
    original = theOriginal;
  }

  public String getOriginal() {
    return original;
  }

  public Map<String, String> getParsed() throws ParserException {
    Pattern parsePattern = Pattern.compile(REGEX);
    Matcher matched = parsePattern.matcher(original);
    if (!matched.lookingAt()) {
      throw new ParserException();
    }
    return Collections.singletonMap(stringFormatter(matched.group(1)),
                stringFormatter(matched.group(3)));
  }

  public static ParsedKeyValue parse(String original) {
    return new ParsedKeyValue(original);
  }

  private String stringFormatter (String unformatted) {
    String result = fixFirstlettercapitilization(unformatted);
    result = fixConsecutiveCapitilization(result);
    return result;
  }

  private String fixFirstlettercapitilization(String unformatted) {
    Pattern parsePattern = Pattern.compile("\\b([a-z])");
    Matcher matcher = parsePattern.matcher(unformatted);
    String result = unformatted;
    while (matcher.find()) {
      String lowerToUpper = matcher.group().toUpperCase();
      result = matcher.replaceAll(lowerToUpper);
    }
    return result;
  }

  private String fixConsecutiveCapitilization(String unformatted) {
    Pattern parsePattern = Pattern.compile("(?!^[A-Z])[A-Z]");
    Matcher matcher = parsePattern.matcher(unformatted);
    String result = unformatted;
    while (matcher.find()) {
      String upperToLower = matcher.group().toLowerCase();
      result = matcher.replaceAll(upperToLower);
    }
    return result;
  }
}
