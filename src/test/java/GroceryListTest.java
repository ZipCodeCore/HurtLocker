import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by randallcrame on 2/8/17.
 */
public class GroceryListTest {
    GroceryList gList;
    Milk milk;
    Milk milk2;

    @Before
    public void setUp(){
        gList = new GroceryList();
        milk = new Milk("3.23", "Food", "01/11/1111" );
        milk2 = new Milk("3.25", "Food", "01/11/1111" );
    }

    @Test
    public void addTest(){
        gList.add(milk);
        String expected = "[3.23]";
        String actual   =  gList.groceryList.get("Milk").toString();
        Assert.assertEquals("Expected value 3.23 to be returned", expected, actual);
    }

    @Test
    public void add2Test(){
        gList.add(milk);
        gList.add(milk);
        int expected = 2;
        int actual = gList.groceryList.get("Milk").size();
        Assert.assertEquals("Expected value 2 to be returned", expected, actual);
    }
    @Test
    public void add3Test(){
        gList.add(milk);
        gList.add(milk);
        gList.add(milk2);
        String expected = "[3.23, 3.23, 3.25]";
        String actual = gList.groceryList.get("Milk").toString();
        Assert.assertEquals("Expected value 2 to be returned", expected, actual);
    }


}
