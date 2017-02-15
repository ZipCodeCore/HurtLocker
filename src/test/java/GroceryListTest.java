import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by randallcrame on 2/8/17.
 */
public class GroceryListTest {
    GroceryList gList;
    GroceryItem milk, milk2, milk3;


    @Before
    public void setUp(){
        gList = new GroceryList();
        milk = new GroceryItem("Milk","3.23", "Food", "01/11/1111" );
        milk2 = new GroceryItem("Milk","3.25", "Food", "01/11/1111" );
        milk3 = new GroceryItem("Milk","", "Food", "01/11/1111" );

    }

    @Test
    public void addTest(){
        gList.add(milk);
        String expected = "3.23";
        String actual   =  gList.groceryList.get("Milk").get(0).getPrice();
        Assert.assertEquals("Expected value 3.23 to be returned", expected, actual);
    }

    @Test
    public void add2Test() {
        gList.add(milk);
        gList.add(milk);
        int expected = 2;
        int actual = gList.groceryList.get("Milk").size();
        Assert.assertEquals("Expected value 2 to be returned", expected, actual);
    }

}
