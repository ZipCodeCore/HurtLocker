import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prestonbattin on 2/10/17.
 */
public class GroceryItemTest {


    GroceryItem item;
    GroceryItem itemClone;
    GroceryItem error;

    @Before
    public void setup(){

        item = new GroceryItem("Cookies", "2.25", "Food", "1/23/2028");
        itemClone = new GroceryItem("Cookies", "2.25", "Food", "1/23/2028");
        error= new GroceryItem("Bad", "2.25", "Food", "1/23/2028");
    }

    @Test
    public void equalsTest(){

        Assert.assertTrue(item.equals(itemClone));
    }

    @Test
    public void toStringTest(){

        String expected = "Cookie 1.00 Food 1/23/2028";
        String actual = item.toString();
        Assert.assertEquals("Tesing the string method is the same", expected, actual);
    }

    @Test
    public void nameCounterTest(){

        int expected = 2;
        int actual = GroceryItem.cookieCounter;
        Assert.assertEquals("Testing the count of a cookie", expected, actual );
    }

    @Test
    public void priceCounterTest(){

        int expected = 2;
        int actual = GroceryItem.cookiePriceOneCount;
        Assert.assertEquals("Testing the count for the price of 2.23 is set", expected, actual);
    }

    @Test
    public void errorCountTest(){

        int expected = 1;
        int actual = GroceryItem.errorCount;
        Assert.assertEquals("Testing error counter", expected, actual);
    }


}
