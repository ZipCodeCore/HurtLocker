import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by markhauenstein on 5/24/16.
 */
public class ShoppingListTest {

    @Test
    public void listMakerTest() throws Exception {
        ShoppingList shoppingList = new ShoppingList();
        String testString = "something##anotherthing##thethirdthing";
        String[] expected = {"something", "anotherthing", "thethirdthing"};
        String[] actual = shoppingList.listMaker(testString);
        Assert.assertEquals("Should return three items in an Array", expected, actual);
    }

    @Test
    public void itemCreator() {
        ShoppingList shoppingList = new ShoppingList();
        String[] testArray = {"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016","naMe:Milk;price:3.23;type:Food;expiration:1/25/2016","naMe:Milk;price:3.23;type:Food;expiration:1/25/2016"};
        ArrayList<Item> testList = shoppingList.itemCreator(testArray);
        int expected = 3;
        int actual = testList.size();
        Assert.assertEquals("The array size should be 3", expected, actual);
    }

    @Test
    public void itemParserTest() {
        ShoppingList shoppingList = new ShoppingList();
        String testString = "naMe:Milk;:price:3.23;type:Food";
        String[] expected = {"naMe", "Milk","","price", "3.23", "type", "Food",};
        String[] actual = shoppingList.itemParser(testString);
        Assert.assertEquals("Should return three items in an Array", expected, actual);
    }
}
