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
    ParsedKeyValue kvPair = ParsedKeyValue.parse("price:1.23;");
    HashMap<String, String> mapSeparatedByColon = new HashMap<>();
    mapSeparatedByColon.put("price", "1.23");
    assertEquals("Testing getting pair with colon", mapSeparatedByColon, kvPair.getParsed());
  }

  @Test
  public void testGetParsedWithAtSign() {
    ParsedKeyValue kvPair = ParsedKeyValue.parse("naMe@Milk;");
    HashMap<String, String> mapSeparatedByColon = new HashMap<>();
    mapSeparatedByColon.put("naMe", "Milk");
    assertEquals("Testing getting pair with atSign", mapSeparatedByColon, kvPair.getParsed());
  }

  @Test
  public void testGetParsedWithUpWardsArrow() {
    ParsedKeyValue kvPair = ParsedKeyValue.parse("expiration^5/02/2016;");
    HashMap<String, String> mapSeparatedByColon = new HashMap<>();
    mapSeparatedByColon.put("naMe", "Milk");
    assertEquals("Testing getting pair with atSign", mapSeparatedByColon, kvPair.getParsed());
  }

  @Test
  public void testGetParsedWithAsterisk() {
    ParsedKeyValue kvPair = ParsedKeyValue.parse("naMe*Milk;");
    HashMap<String, String> mapSeparatedByColon = new HashMap<>();
    mapSeparatedByColon.put("naMe", "Milk");
    assertEquals("Testing getting pair with atSign", mapSeparatedByColon, kvPair.getParsed());
  }

  @Test
  public void testGetParsedWithPercentSymbol() {
    ParsedKeyValue kvPair = ParsedKeyValue.parse("naMe%Milk;");
    HashMap<String, String> mapSeparatedByColon = new HashMap<>();
    mapSeparatedByColon.put("naMe", "Milk");
    assertEquals("Testing getting pair with atSign", mapSeparatedByColon, kvPair.getParsed());
  }
}
