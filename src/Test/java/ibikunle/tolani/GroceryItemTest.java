package ibikunle.tolani;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by tolaniibikunle on 2/15/17.
 */
public class GroceryItemTest {


    @Test
    public void toStringTest(){
        GroceryItem groceryItem = new GroceryItem("bread","3.23", "Food","1/25/2016");
        String expectedGrocery = "bread 3.23";
        String actualGrocery = groceryItem.toString();
        Assert.assertEquals("I am expecting  Grocery Item",expectedGrocery,actualGrocery);


    }
}
