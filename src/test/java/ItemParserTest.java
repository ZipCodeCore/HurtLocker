import org.junit.Assert;
import org.junit.Test;

public class ItemParserTest {

    @Test
    public void separateWordsTest() {
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";

        String[] expected = {
                "naMe",
                "Milk",
                "price",
                "3.23",
                "type",
                "Food",
                "expiration",
                "1/25/2016"
        };

        String[] actual = ItemParser.separateWords(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void separateWordsMissingValuesTest() {
        String input = "naMe:;price:3.23;type:Food^expiration:1/04/2016";

        String[] expected = {
                "naMe",
                "",
                "price",
                "3.23",
                "type",
                "Food",
                "expiration",
                "1/04/2016"
        };

        String[] actual = ItemParser.separateWords(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void matchNameTest() {
         String toParse = "aPPleS";
         String expected = "Apples";
         String actual = ItemParser.matchName(toParse);
         Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doesNotMatchNameTest() {
        String toParse = "aPPleSoooo!";

        String actual = ItemParser.matchName(toParse);
    }

    @Test
    public void matchPriceTest() {
        String toParse = "1.99";
        ItemParser.matchPrice(toParse);
        Assert.assertEquals("1.99", toParse);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doesNotMatchPriceTest() {
        String toParse = "A.22";

        ItemParser.matchPrice(toParse);
    }

    @Test
    public void matchTypeTest() {
        String toParse = "Food";
        ItemParser.matchType(toParse);
        Assert.assertEquals("Food", toParse);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doesNotMatchTypeTest() {
        String toParse = "Foo";

        ItemParser.matchType(toParse);
    }

    @Test
    public void matchExpirationTest() {
        String toParse = "11/22/2017";
        ItemParser.matchExpiration(toParse);
        Assert.assertEquals("11/22/2017", toParse);
    }

    @Test(expected = IllegalArgumentException.class)
    public void doesNotMatchExpirationTest() {
        String toParse = "11-22-2017";

        ItemParser.matchExpiration(toParse);
    }

    @Test
    public void parseItemTest() {
        String toParse = "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016";
        Item cookies = ItemParser.parseItem(toParse);

        Assert.assertEquals("Cookies", cookies.getName());
        Assert.assertEquals("2.25", cookies.getPrice());
        Assert.assertEquals("Food", cookies.getType());
        Assert.assertEquals("3/22/2016", cookies.getExpiration());
    }

    @Test(expected = IllegalArgumentException.class)
    public void doesNotParseItemTest() {
        String toParse = "naMe:COokIes;price:;type:Food;expiration:3/22/2016";
        Item cookies = ItemParser.parseItem(toParse);
    }
}
