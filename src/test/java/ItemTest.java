import org.junit.Assert;
import org.junit.Test;

/**
 * Created by markhauenstein on 5/24/16.
 */
public class ItemTest {
    @Test
    public void parseNameTest() throws IncompleteItemException{
        String[] testArray = {"naMe", "MilK","price", "3.23", "type", "Food","expiration","1/25/2016"};
        Item item = new Item(testArray);
        String expected = "cookies";
        String actual = item.parseName("Co0kies");
        Assert.assertEquals("Should return cookies",expected,actual);
    }
    @Test
    public void createItemTest() throws IncompleteItemException {
        String[] testArray = {"naMe", "MilK","price", "3.23", "type", "Food","expiration","1/25/2016"};
        Item item = new Item(testArray);
        String expectedName = "milk";
        String actualName = item.name;
        Assert.assertEquals("should return the items name value",expectedName,actualName);
    }
    @Test
    public void createItemTest2() throws IncompleteItemException {
        String[] testArray = {"naMe", "MilK","price", "3.23", "type", "Food","expiration","1/25/2016"};
        Item item = new Item(testArray);
        String expectedName = "3.23";
        String actualName = item.price;
        Assert.assertEquals("should return the items name value",expectedName,actualName);
    }
}
