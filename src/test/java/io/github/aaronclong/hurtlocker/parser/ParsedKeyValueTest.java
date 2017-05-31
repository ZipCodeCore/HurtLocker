package io.github.aaronclong.hurtlocker.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParsedKeyValueTest {
  @Test
  public void testGetParsedWithColon() {
    try {
      ParsedKeyValue kvPair = ParsedKeyValue.parse("price:1.23;");
      HashMap<String, String> mapSeparatedByColon = new HashMap<>();
      mapSeparatedByColon.put("Price", "1.23");
      assertEquals("Testing getting pair with colon", mapSeparatedByColon, kvPair.getParsed());
    } catch(ParserException e) {
      fail(e.toString());
    }
  }

  @Test
  public void testGetParsedWithAtSign() {
    try {
      ParsedKeyValue kvPair = ParsedKeyValue.parse("naMe@Milk;");
      HashMap<String, String> mapSeparatedByColon = new HashMap<>();
      mapSeparatedByColon.put("Name", "Milk");
      assertEquals("Testing getting pair with atSign", mapSeparatedByColon, kvPair.getParsed());
    } catch(ParserException e) {
      fail(e.toString());
    }
  }

  @Test
  public void testGetParsedWithUpWardsArrow() {
    try {
      ParsedKeyValue kvPair = ParsedKeyValue.parse("expiration^5/02/2016;");
      HashMap<String, String> mapSeparatedByColon = new HashMap<>();
      mapSeparatedByColon.put("Expiration", "5/02/2016");
      assertEquals("Testing getting pair with atSign", mapSeparatedByColon, kvPair.getParsed());
    } catch(ParserException e) {
      fail(e.toString());
    }
  }

  @Test
  public void testGetParsedWithAsterisk() {
    try {
      ParsedKeyValue kvPair = ParsedKeyValue.parse("naMe*Milk;");
      HashMap<String, String> mapSeparatedByColon = new HashMap<>();
      mapSeparatedByColon.put("Name", "Milk");
      assertEquals("Testing getting pair with atSign", mapSeparatedByColon, kvPair.getParsed());
    } catch(ParserException e) {
      fail(e.toString());
    }
  }

  @Test
  public void testGetParsedWithPercentSymbol() {
    try {
      ParsedKeyValue kvPair = ParsedKeyValue.parse("naMe%Milk;");
      HashMap<String, String> mapSeparatedByColon = new HashMap<>();
      mapSeparatedByColon.put("Name", "Milk");
      assertEquals("Testing getting pair with atSign", mapSeparatedByColon, kvPair.getParsed());
    } catch(ParserException e) {
      fail(e.toString());
    }
  }

  @Test
  public void testGetParseZero() {
    try {
      ParsedKeyValue kvPair = ParsedKeyValue.parse("naMe%Co0kies;");
      HashMap<String, String> mapWithZero = new HashMap<>();
      mapWithZero.put("Name", "Cookies");
      assertEquals("Testing getting pair with atSign", mapWithZero, kvPair.getParsed());
    } catch(ParserException e) {
      fail(e.toString());
    }
  }
}
