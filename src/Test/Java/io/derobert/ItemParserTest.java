package io.derobert;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemParserTest {
    @Test(expected = EmptyKeyValueException.class)
    public void checkForErrorTest() throws Exception {
        ItemParser.checkForError("", "test");
    }

    @Test
    public void checkItemNameTest() throws Exception {
        ItemParser.checkItemName("milk");
        assertNotNull(ItemParser.getCurrentItem());
    }

    @Test
    public void parseItemsTest() throws Exception {
        String expected =
                "name:    Milk        seen: 6 times\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: 5 times\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: 1 time\n" +
                        "\n" +
                        "name:   Bread        seen: 6 times\n" +
                        "=============        =============\n" +
                        "Price:   1.23        seen: 6 times\n" +
                        "\n" +
                        "name: Cookies        seen: 8 times\n" +
                        "=============        =============\n" +
                        "Price:   2.25        seen: 8 times\n" +
                        "\n" +
                        "name:  Apples        seen: 4 times\n" +
                        "=============        =============\n" +
                        "Price:   0.25        seen: 2 times\n" +
                        "-------------        -------------\n" +
                        "Price:   0.23        seen: 2 times\n" +
                        "\n" +
                        "Errors               seen: 4 times";
        String actual = ItemParser.parseItems("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##");
        assertEquals(expected, actual);
    }

    @Test
    public void formatErrorCount() {
        String expected = "Errors               seen: 4 times";
        String actual = ItemParser.formatErrorCount();
        assertEquals(expected, actual);
    }

}