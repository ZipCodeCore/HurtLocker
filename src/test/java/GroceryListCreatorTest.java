import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        itemString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##";
        parser = new Parser();
    }

    @Test
    public void createGroceryItemObjects() {
        //given
        list = new GroceryListCreator();
        list.createItems(itemString);
        System.out.println(list.getItems());

        //when

        //then


    }

    @Test
    public void errorCountTest() {
        //given
        list = new GroceryListCreator();
        list.createItems(itemString);
        int expectedErrorCount = 1;

        //when
        int actualErrorCount = list.getErrorCount();

        //then
        Assert.assertEquals(expectedErrorCount,actualErrorCount);
    }


}
