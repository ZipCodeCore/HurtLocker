import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sarahweisser on 5/31/17.
 */
public class GroceryListCreatorTest {
    String itemString;
    String[] itemStrings;
    Parser parser;
    GroceryItem item;
    String[] itemInfo;
    GroceryListCreator list;

    @Before
    public void setUpTests() {
        itemString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##";
        parser = new Parser();
        list = new GroceryListCreator();
        list.createItemKeys(itemString);
    }

   /* @Test
    public void errorCountTest() {
        //given
        int expectedErrorCount = 1;

        //when
        int actualErrorCount = list.getErrorCount();

        //then
        Assert.assertEquals(expectedErrorCount,actualErrorCount);
    }*/

    @Test
    public void listItemNamesTest() {
        //given
        String[] expected = {"Milk", "BreaD", "BrEAD", "MiLK", "Cookies", "", "Co0kieS"};
        itemStrings = parser.itemStrings(itemString);

        //when
        ArrayList<String> actual = list.itemNames(itemStrings);

        //then
        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void getUniqueItemNamesTest() {
        //given
        String[] expected = {"milk", "bread", "cookies"};
        itemStrings = parser.itemStrings(itemString);
        ArrayList<String> itemNames = list.itemNames(itemStrings);

        //when
        String[] actual = list.findUniqueItemNames(itemNames);

        //then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void createKeys() {
        //given
        ArrayList<String> expected = new ArrayList<>();
        expected.add("milk");
        expected.add("bread");
        expected.add("cookies");

        //when
        ArrayList<String> actual = list.createItemKeys(itemString);

        //then
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
