package io.github.aaronclong.hurtlocker.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.HashMap;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParsedLineTest {

  private final String standardLine = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";

  @Test
  public void testStandardLine() {
    HashMap<String, String> map = new HashMap<>();
    map.put("naMe", "Milk");
    map.put("price", "3.21");
    map.put("type", "Food");
    map.put("expiration", "1/25/2016");
    ParsedLine actualLine = ParsedLine.parse(standardLine);
    try {
      assertEquals("Testing standard line", map, actualLine.getParsed());
    } catch(ParserException e) {
      fail(e.toString());
    }
  }

}
