package io.derobert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemInventoryTest {
    ItemInventory inventory;
    @Before
    public void setUp(){
        inventory = new ItemInventory();
    }

    @Test
    public void setAndGetApplesTest() {
        Apples apple = inventory.getApples();
        apple.setName("Eden");
        inventory.setApples(apple);
        assertTrue(inventory.getApples().getName().equals("Eden"));
    }

    @Test
    public void setAndGetBread() {
        Bread bread = inventory.getBread();
        bread.setName("Peeta");
        inventory.setBread(bread);
        assertTrue(inventory.getBread().getName().equals("Peeta"));
    }

    @Test
    public void setAndGetCookies() {
        Cookies cookies = inventory.getCookies();
        cookies.setName("Cookie Monster");
        inventory.setCookies(cookies);
        assertTrue(inventory.getCookies().getName().equals("Cookie Monster"));
    }

    @Test
    public void setAndGetMilk() {
        Milk milk = inventory.getMilk();
        milk.setName("Man");
        inventory.setMilk(milk);
        assertTrue(inventory.getMilk().getName().equals("Man"));
    }

    @Test
    public void displayInventory() {
        Milk milk = inventory.getMilk();
        milk.increaseNameCounter();
        milk.addPrice("3.23");
        milk.addPrice("1.23");
        inventory.setMilk(milk);

        Bread bread = inventory.getBread();
        bread.increaseNameCounter();
        bread.addPrice("3.23");
        bread.addPrice("1.23");
        inventory.setBread(bread);

        Cookies cookies = inventory.getCookies();
        cookies.increaseNameCounter();
        cookies.addPrice("3.23");
        cookies.addPrice("1.23");
        inventory.setCookies(cookies);

        Apples apples = inventory.getApples();
        apples.increaseNameCounter();
        apples.increaseNameCounter();
        apples.increaseNameCounter();
        apples.increaseNameCounter();
        apples.addPrice("0.25");
        apples.addPrice("0.25");
        apples.addPrice("0.23");
        apples.addPrice("0.23");

        String expected =
                "name:    Milk        seen: 1 time\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: 1 time\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: 1 time\n\n" +
                        "name:   Bread        seen: 1 time\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: 1 time\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: 1 time\n\n" +
                        "name: Cookies        seen: 1 time\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: 1 time\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: 1 time\n\n" +
                        "name:  Apples        seen: 4 times\n" +
                        "=============        =============\n" +
                        "Price:   0.25        seen: 2 times\n" +
                        "-------------        -------------\n" +
                        "Price:   0.23        seen: 2 times\n\n" +
                        "Errors               seen: 0 times";
        String actual = inventory.displayInventory();
        assertEquals(expected, actual);
    }

}