package io.github.aaronclong.hurtlocker.parser;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParsedKeyValueTest {
  @Test
  public void testGetParsedWithColon() {
    ParsedKeyValue kvPair = ParsedKeyValue.parse("naMe:Milk;");
    HashMap<String, String> mapSeparatedByColon = new HashMap<>();
    mapSeparatedByColon.put("naMe", "Milk");
    assertEquals("Testing getting pair with colon", mapSeparatedByColon, kvPair.getParsed());
  }
}
