import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by markhauenstein on 5/24/16.
 */
public class ReciptTest {
    @Test
    public void countTheItemsTest() throws Exception {
        Recipt recipt = new Recipt();
        ShoppingList shoppingList = new ShoppingList();
        String rawJerkson = shoppingList.readRawDataToString();
        String[] madeList = shoppingList.listMaker(rawJerkson);
        ArrayList listOfItems = shoppingList.itemCreator(madeList);
        int listSize = listOfItems.size();
        recipt.countTheItems();


        int expected =8;
        int actual = recipt.milkCounter;

        Assert.assertEquals("Should find 6 milk instances",expected,actual);
    }
}
