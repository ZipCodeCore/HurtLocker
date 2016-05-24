package io.bms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by samhudgens on 5/24/16.
 */
public class ItemSpec {

    Item item;

    @Before
    public void initialize(){
        item = new Item("milk");
        item.addPriceOccurence("3.10");

    }
    @Test
    public void addPriceOccurenceTest(){
        item.addPriceOccurence("2.50");
        int expectedValue = 1;
        int actualValue = item.getNumberOfOccurence("2.50");
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void addCounterTest() {
        item.addCounter("3.10");
        int expectedValue = 2;
        int actualValue = item.getNumberOfOccurence("3.10");
        assertEquals(expectedValue,actualValue);

    }

    @Test
    public void checkPriceExistsTest()  {
        assertTrue(item.checkPriceExists("3.10"));
    }

    @Test
    public void formattedToStringTest(){
        item.addPriceOccurence("2.50");
        String expectedValue = "name:\tmilk\t\tseen: 2 times\n=============\t\t=============\n";
        expectedValue+="Price:\t2.50\t\tseen: 1 times";
        expectedValue+="\n-------------\t\t-------------\n";
        expectedValue+="Price:\t3.10\t\tseen: 1 times";
        expectedValue+="\n-------------\t\t-------------\n";
        String actualValue = item.formattedToString();
        assertEquals(expectedValue,actualValue);

    }

}