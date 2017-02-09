package mccann.kevin.hurtlocker;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/9/17.
 */
public class ItemParserTest {
    private ItemParser itemParser = new ItemParser();

    @Test
    public void addItemToListTest() throws Exception {
        int expected = 1;
        itemParser.addItemToList(new Item("milk","1.23"));
        int actual = itemParser.getItemList().size();
        assertEquals("1 expected",expected,actual);
    }

    @Test
    public void splitStringsTest() throws Exception {
        int expected = 8;
        int actual = itemParser.splitStrings("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016").length;
        assertEquals(expected,actual);
    }

    @Test
    public void getItemFieldTest() throws Exception {
        String expected = "Milk";
        String actual = itemParser.getItemField("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016",1);
        assertEquals(expected,actual);
    }

    @Test
    public void createItemFromFieldsTest() throws Exception {
        int expected = 2;
        itemParser.createItemFromFields("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        int actual = itemParser.getItemList().size();
        assertEquals(expected,actual);
    }

    @Test
    public void sanitizeNameTest() throws Exception {
        String expected = "Milk";
        String actual = itemParser.sanitizeName("m1lk");
        assertEquals(expected,actual);
    }

    @Test
    public void getErrorCountTest() throws Exception {
        int expected = 0;
        int actual = itemParser.getErrorCount();
        assertEquals(expected,actual);
    }

    @Test
    public void getErrorCountTest2() throws Exception {
        int expected = 1;
        itemParser.createItemFromFields("naMe:;price:3.23;type:Food;expiration:1/04/2016");
        int actual = itemParser.getErrorCount();
        assertEquals(expected,actual);
    }

}