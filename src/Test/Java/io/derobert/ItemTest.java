package io.derobert;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void formatItemAppleTest() throws Exception {
        Item item = new Apples();
        item.increaseNameCounter();
        item.increaseNameCounter();
        item.increaseNameCounter();
        item.increaseNameCounter();
        item.addPrice("0.25");
        item.addPrice("0.25");
        item.addPrice("0.23");
        item.addPrice("0.23");

        String expected =
                "name:  Apples        seen: 4 times\n" +
                        "=============        =============\n" +
                        "Price:   0.25        seen: 2 times\n" +
                        "-------------        -------------\n" +
                        "Price:   0.23        seen: 2 times";
        String actual = item.formatItem();
        assertEquals(expected, actual);
    }

    @Test
    public void formatItemCookieTest() throws Exception {
        Item item = new Cookies();
        item.increaseNameCounter();
        item.addPrice("3.23");
        item.addPrice("1.23");

        String expected =
                "name: Cookies        seen: 1 time\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: 1 time\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: 1 time";
        String actual = item.formatItem();
        assertEquals(expected, actual);
    }

    @Test
    public void formatItemBreadTest() throws Exception {
        Item item = new Bread();
        item.increaseNameCounter();
        item.addPrice("3.23");
        item.addPrice("1.23");

        String expected =
                "name:   Bread        seen: 1 time\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: 1 time\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: 1 time";
        String actual = item.formatItem();
        assertEquals(expected, actual);
    }

    @Test
    public void formatItemMilkTest() throws Exception {
        Item item = new Milk();
        item.increaseNameCounter();
        item.addPrice("3.23");
        item.addPrice("1.23");
        String expected =
                "name:    Milk        seen: 1 time\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: 1 time\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: 1 time";
        String actual = item.formatItem();
        assertEquals(expected, actual);
    }

    @Test
    public void decreaseNameCounterTest(){
        Item item = new Item();
        item.increaseNameCounter();
        item.increaseNameCounter();
        item.decreaseNameCounterForError();
        int expected = 1;
        int actual = item.getNameSeenCounter();
        assertEquals(expected, actual);
    }

    @Test
    public void increaseNameCounterTest(){
        Item item = new Item();
        item.increaseNameCounter();
        int expected = 1;
        int actual = item.getNameSeenCounter();
        assertEquals(expected, actual);
    }
}