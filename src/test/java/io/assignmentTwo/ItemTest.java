package io.assignmentTwo;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ItemTest {


    Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item();

    }

    @Test
    public void getNameTest() throws Exception {
        String expectedValue = "Mike";
        item.setName("Mike");
        String actualValue = item.getName();
        assertEquals("The expected value is Mike", expectedValue, actualValue);
    }

    @Test
    public void setNameTest() throws Exception {
        String expectedValue = "Tom";
        item.setName("Tom");
        String actualValue = item.getName();
        assertEquals("The expected value is Tom", expectedValue, actualValue);
    }

    @Test
    public void getPriceTest() throws Exception {
        double expectedValue = 2.22;
        item.setPrice(2.22);
        double actualValue = item.getPrice();
        assertEquals("The expected value is 2.22", expectedValue, actualValue, 0);

    }

    @Test
    public void setPrice() throws Exception {
        double expectedValue = 3.4;
        item.setPrice(3.4);
        double actualValue = item.getPrice();
        assertEquals("The expected value is 3.4", expectedValue, actualValue, 0);
    }


}