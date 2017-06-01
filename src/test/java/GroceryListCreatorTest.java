import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        list.createItems(itemString);
    }
    
    @Test
    public void errorCountTest() {
        //given
        int expectedErrorCount = 1;

        //when
        int actualErrorCount = list.getErrorCount();

        //then
        Assert.assertEquals(expectedErrorCount,actualErrorCount);
    }

    @Test
    public void listItemNamesTest() {
        //given
        String[] expected = {"Milk", "BreaD", "BrEAD", "MiLK", "Cookies", "Co0kieS"};

        //when
        ArrayList<String> actual = list.itemNames();

        //then
        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void getUniqueItemNamesTest() {
        //given
        String[] expected = {"milk", "bread", "cookies"};
        ArrayList<String> itemNames = list.itemNames();

        //when
        String[] actual = parser.checkIfSameItem(itemNames);

        //then
        Assert.assertArrayEquals(expected, actual);
    }


}
