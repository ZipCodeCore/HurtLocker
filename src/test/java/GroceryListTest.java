import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryangross on 2/8/17.
 */
public class GroceryListTest {

    GroceryList testList;
    String testFood = "naMe:Milk;price:3.23;";

    @Before
    public void setUp() {
        testList = new GroceryList();
    }

    @Test
    public void convertTo() {
        GroceryItem anItem = testList.convertToGroceryItem("naMe:Milk;price:3.23;");
        Assert.assertEquals("milk", anItem.getName());
        Assert.assertEquals("3.23", anItem.getPrice());
    }

    @Test
    public void convertPriceTest() {
        Assert.assertEquals("3.23", testList.convertPrice(testFood));
    }

    @Test
    public void convertFoodTest() {
        Assert.assertEquals("milk", testList.convertFoodType(testFood));
    }
}
