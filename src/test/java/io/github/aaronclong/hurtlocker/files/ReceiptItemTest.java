package io.github.aaronclong.hurtlocker.files;

import io.github.aaronclong.hurtlocker.parser.Parser;
import io.github.aaronclong.hurtlocker.parser.ParserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.ArrayList;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ReceiptItemTest {
  private Parser parser;
  private Map<String, ArrayList<Map<String, String>>> map;

  @Before
  public void setUp() {
    try {
      FileHandler handler = FileHandler.makeFileHandler("RawData.txt");
      parser = Parser.parse(handler.fileAsString());
      map = parser.getParsed();
    } catch (ParserException e) {
      Assert.fail(e.toString());
    }
  }

  @Test
  public void testToString() {
    ReceiptItem item = ReceiptItem.makeReceiptItem("Milk", map.get("Milk"));
    String expected = "name:    Milk \t\t seen: 6 times\n" +
                              "============= \t \t =============\n" +
                              "Price: \t 3.23\t\t seen: 5 times\n" +
                              "-------------\t\t -------------\n" +
                              "Price:   1.23\t\t seen: 1 time";
    Assert.assertEquals("Check toString's return", expected, item.toString());
  }
}
