package io.MMJ;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import io.MMJ.*;

/**
 * Created by matthewb on 5/24/16.
 */

    public class ParserSpecs {

        @Before
        public void init(){};
        ItemParser itemParser = new ItemParser();


        @Test
        public void correctExpirationTest() {
            String beforeExpiration = "ExpIraTion";
            String expectedString = "expiration";
            String actualString = itemParser.correctExpiration(beforeExpiration);
            assertEquals(expectedString, actualString);
        }

        @Test
        public void correctTypeTest() {
            String beforeType = "tYpE";
            String expectedString = "type";
            String actualString = itemParser.correctType(beforeType);
            assertEquals(expectedString, actualString);
        }

        @Test
        public void correctPriceTest() {
            String beforePrice = "prIcE";
            String expectedString = "price";
            String actualString = itemParser.correctPrice(beforePrice);
            assertEquals(expectedString, actualString);
        }

        @Test
        public void correctNameTest() {
            String beforeName = "NAme";
            String expectedString = "name";
            String actualString = itemParser.correctName(beforeName);
            assertEquals(expectedString, actualString);
        }

        @Test
        public void correctCookiesTest(){
            String beforeCookies = "CO0kieS";
            String expectedString = "Cookies";
            String actualString = itemParser.correctCookies(beforeCookies);
            assertEquals("Expected value should be cookies",expectedString,actualString);
        }

        @Test
        public void correctMilkTest() {
            String beforeMilk = "mIlK";
            String expectedString = "Milk";
            String actualString = itemParser.correctMilk(beforeMilk);
            assertEquals(expectedString, actualString);
        }

        @Test
        public void correctBreadTest() {
            String beforeBread = "bReAd";
            String expectedString = "Bread";
            String actualString = itemParser.correctBread(beforeBread);
            assertEquals(expectedString, actualString);
        }

        @Test
        public void correctApplesTest(){
            String beforeApples = "@Pples";
            String expectedString = "Apples";
            String actualString = itemParser.correctApples(beforeApples);
            assertEquals(expectedString,actualString);
        }

        @Test
        public void correctFoodTest() {
            String beforeFood = "F0Od.";
            String expectedString = "Food;";
            String actualString = itemParser.correctFood(beforeFood);
            assertEquals(expectedString, actualString);
        }

    }

