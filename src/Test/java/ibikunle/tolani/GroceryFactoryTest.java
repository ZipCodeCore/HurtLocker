package ibikunle.tolani;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by tolaniibikunle on 2/15/17.
 */
public class GroceryFactoryTest {

    GroceryFactory groceryFactory;

    @Before
    public void set(){
        groceryFactory = new GroceryFactory();
        String sampleInput = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##\n" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##\n" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##";
    }

    @Test
    public void produceGroceryTest(){
        HashMap<String,String> inputMap = new HashMap<>();
        inputMap.put("name","bread");
        inputMap.put("price","1.23");
        inputMap.put("type", "Food");
        inputMap.put("expiration","1/25/2016");
        String expectedGrocery = "bread 1.23";
        String actualGrocery = groceryFactory.produceGrocery(inputMap).toString();
        System.out.println(inputMap);
        Assert.assertEquals("I am expecting  Grocery Item",expectedGrocery,actualGrocery);
    }

}

