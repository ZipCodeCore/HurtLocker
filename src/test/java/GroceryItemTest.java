import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sarahweisser on 5/31/17.
 */
public class GroceryItemTest {
    String itemString;
    Parser parser;
    GroceryItem item;
    String[] itemInfo;

    @Before
    public void setUpTests() {
        itemString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        parser = new Parser();
        itemInfo = parser.itemStringInfo(itemString);

    }

    @Test
    public void createGroceryItemTest() {
        //given
        parser.itemStrings(itemString);
        item = new GroceryItem(itemInfo);
        String expectedNameOfItem = "Milk";
        String expectedPriceOfItem = "3.23";
        String expectedTypeOfItem = "Food";
        String expectedExpirationDate = "1/25/2016";

        //when
        item = new GroceryItem(itemInfo);
        String actualNameOfItem = item.getNameOfItem();
        String actualPriceOfItem = item.getPriceOfItem();
        String actualTypeOfItem = item.getTypeOfItem();
        String actualExpirationDate = item.getExpirationDate();

        //then
        Assert.assertEquals(expectedNameOfItem, actualNameOfItem);
        Assert.assertEquals(expectedPriceOfItem, actualPriceOfItem);
        Assert.assertEquals(expectedTypeOfItem, actualTypeOfItem);
        Assert.assertEquals(expectedExpirationDate, actualExpirationDate);
    }
}
