package io.HandroHoxtah;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/24/16.
 */
public class ParserSpec {

    Parser parser;
    Main main;

    String name;
    double price;
    @Before
    public void setup(){
        main = new Main();
        parser = new Parser();
        name = "Randy";
        price = 24.99;
    }

    @Test
    public void getDetaFragmentTest(){
        String fragment = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/";
        String actual = parser.getDataFragment("[n|N(a|A|@)m|M(e|E|3)]{4}:([(a-z)|(A-Z)]{4,7}){0,1}[^(a-z)|(A-Z)]{1,2}[p|Pr|Ri|Ic|Ce|E]{5}:(\\d*.\\d{2}){0,1}", fragment).get(0);
        String expected = "naMe:Milk;price:3.23";
        assertEquals(expected, actual);
    }

    @Test
    public void addItem(){
        parser.addItem(new Item(name, price));
        int actualSize = parser.getItems().size();
        int expectedSize = 1;
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void correctMilkTest(){
        String expectedMilk = "Milk";
        String actualMilk = parser.grammarNazi("MiLK");
        assertEquals(expectedMilk, actualMilk);
    }

    @Test
    public void correctBreadTest(){
        String expectedBread = "Bread";
        String actualBread = parser.grammarNazi("BreaD");
        assertEquals(expectedBread, actualBread);
    }

    @Test
    public void correctedApplesTest(){
        String expectedApples= "Apples";
        String actualApples = parser.grammarNazi("apPles");
        assertEquals(expectedApples, actualApples);
    }
    

    @Test
    public void createItemsTest(){
        String expectedTest = "Milk";
        parser.createItems("\"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        String actualItem = parser.getItems().get(0).getName();
        assertEquals(expectedTest, actualItem);
    }
}
