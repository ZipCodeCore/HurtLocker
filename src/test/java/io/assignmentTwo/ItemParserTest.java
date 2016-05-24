package io.assignmentTwo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class ItemParserTest {

    ItemParser itemParser;
    Item item;
    Item item2;
    Item item3;

    @Before
    public void setUp() throws Exception {
        itemParser = new ItemParser();
        item = new Item();
        item2 = new Item();
        item3 = new Item();
    }

    @Test
    public void parseRawData() throws Exception {
        String rawData = "naMe:Cookies;price:2.25;type:Food*expiration:1/25/2016##";
        ArrayList<Item> ev = new ArrayList<>();
        item.setName("Cookies");
        item.setPrice(2.25);
        ev.add(item);
        String expectedName = "Cookies";
        String actualName = itemParser.parseRawData(rawData).get(0).getName();
        assertEquals("The expected value is Name : cookies, Price : 2.25", expectedName, actualName);
        double expectedPrice = 2.25;
        double actualPrice = itemParser.parseRawData(rawData).get(0).getPrice();
        assertEquals("The expected value is 2.25", expectedPrice, actualPrice, 0);
    }

    @Test
    public void formatArrayListIntoString() throws Exception {

    }

    @Test
    public void splitDataByDoubleHashCharacter() throws Exception {
        String str = "mike mike mike mike##tom tom tom tom##";
        String[] expectedValue = {"mike mike mike mike", "tom tom tom tom"};
        String[] actualValue = itemParser.splitDataByDoubleHashCharacter(str);
        assertArrayEquals("The expected value is two lines of mike and tom", expectedValue, actualValue);
    }

    @Test
    public void separateKeyPairValuesTest() {
        String[] separatedByLines = {"name:cookies@price:2.22"};
        String[] expectedValue = {"name:cookies", "price:2.22"};
        ArrayList<ArrayList<String>> al = itemParser.separateKeyPairValues(separatedByLines);
        ArrayList<String> actualValue = al.get(0);
        assertArrayEquals("The expected value is name:cookies price:2.22", expectedValue, actualValue.toArray());
    }

    @Test
    public void countPricesTest() {

    }

    @Test
    public void countNamesTest() {

    }

    @Test
    public void isMilkTest(){
        boolean value = itemParser.isMilk("MiLk");
        assertTrue(value);
    }

    @Test
    public void isApplesTest(){
        boolean value = itemParser.isApples("aPPles");
        assertTrue(value);
    }

    @Test
    public void isBreadTest(){
        boolean value = itemParser.isBread("BreAd");
        assertTrue(value);
    }

    @Test
    public void isCookiesTest(){
        boolean value = itemParser.isCookies("co0kies");
        assertTrue(value);
    }
}