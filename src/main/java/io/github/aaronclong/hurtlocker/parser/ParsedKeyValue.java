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
    String result = fixConsecutiveCapitalization(unformatted);
    result = fixFirstCharacterCapitalization(result);
    //result = fixZeros(result);
    return result;
  }

  private String fixFirstCharacterCapitalization(String unformatted) {
    Pattern parsePattern = Pattern.compile("\\b([a-z])");
    Matcher matcher = parsePattern.matcher(unformatted);
    String result = unformatted;
    while (matcher.find()) {
      String lowerToUpper = matcher.group().toUpperCase();
      result = matcher.replaceAll(lowerToUpper);
    }
    return result;
  }

  private String fixConsecutiveCapitalization(String unformatted) {
    Pattern parsePattern = Pattern.compile("([A-Z])");
    Matcher matcher = parsePattern.matcher(unformatted);
    String result = unformatted;
    while (matcher.find()) {
      String match = matcher.group();
      String upperToLower = match.toLowerCase();
      result = result.replaceAll(match, upperToLower);
    }
    return result;
  }

  private String fixZeros(String unformatted) {
    Pattern parsePattern = Pattern.compile("o\\d+");
    Matcher matcher = parsePattern.matcher(unformatted);
    String result = unformatted;
    while (matcher.find()) {
      result = matcher.replaceAll("oo");
    }
    return result;
  }
}
