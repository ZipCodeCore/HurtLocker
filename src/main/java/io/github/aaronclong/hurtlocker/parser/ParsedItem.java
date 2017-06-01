package io.github.aaronclong.hurtlocker.parser;

import java.util.Map;
import java.util.Set;

/**
 * Created by aaronlong on 5/31/17.
 */
public interface ParsedItem {

  String getOriginal();

  Map<String, String> getParsed() throws ParserException;

   static void concatMaps(Map<String, String> base, Map<String, String> temporary) {
    Set<String> tempKeys = temporary.keySet();
    for (String key : tempKeys) {
      if (!base.containsKey(key)) {
        base.put(key, temporary.get(key));
      }
    }
  }

}
