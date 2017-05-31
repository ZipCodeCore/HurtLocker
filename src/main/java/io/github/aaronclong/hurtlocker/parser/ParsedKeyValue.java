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
    return Collections.singletonMap(matched.group(1), matched.group(3));
  }

  public static ParsedKeyValue parse(String original) {
    return new ParsedKeyValue(original);
  }
}
