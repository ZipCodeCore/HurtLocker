package io.hurtlocker;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by taiseerhabib on 5/24/16.
 */
public class ItemParserSpec {

    Main testMain = new Main();
    String fileData = " ";
    String [] testArrayData;

    @Before
            public void testSetup(){

        try {
            fileData = testMain.readRawDataToString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        testArrayData = fileData.split("##");
    }

    @Test
    public void testStringSPlit(){

        int expectedArrayLength = 28;
        int actualArrayLength = testArrayData.length;
        assertEquals(expectedArrayLength,actualArrayLength);
    }

    @Test
    public void testRegexValuePattern(){

        String expression = "[mM][iIlLkK]{3}|[bB][rReEaAdD]{4}|[cC][oO0kKiIeEsS]{6}|[aA][pPlLeEsS]{5}";
        String expectedValue = "Milk";
        String actualValue = ItemParser.regexMatcher(expression, testArrayData[0]);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void RegexMasterTest(){
        String expectedVal = "123434";
        String actualValue = ItemParser.regexMatcher("[0-9]{1,}", "123434");
        assertEquals(expectedVal, actualValue);
    }

    @Test
    public void testPriceValuePattern(){
        String testExpression = "\\d\\.\\d{2}";
        String expectedValue = "1.23";
        String actualValue = ItemParser.regexMatcher(testExpression, testArrayData[1]);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testExpirationValuePattern(){
        String testExpression = "\\d{1,2}[/]\\d{1,2}[/]\\d{2,4}";
        String expectedValue = "1/25/2016";
        String actualValue = ItemParser.regexMatcher(testExpression, testArrayData[0]);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testingjerkSON(){

        ItemParser testItemParser = new ItemParser();
        String expectedVal = "Milk";
        testItemParser.JerkSON(fileData);
        String actualVal = testItemParser.getItemList().get(0).getName();
        assertEquals(expectedVal, actualVal);
    }

    @Test
    public void testArrayLength(){
        ItemParser testItemParser = new ItemParser();
        int expectedLength = 28;
        testItemParser.JerkSON(fileData);
        int actualLength = testItemParser.getItemList().size();
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testMilkChecker() {
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedValue = 1;
        testItemParser.milkCHecker(testItemParser.getItemList().get(0).getName(), testItemParser.getItemList().get(0).getPrice());
        int actualValue = testItemParser.getMilkCount();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testMilkPriceHighChecker(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedValue = 1;
        testItemParser.milkCHecker(testItemParser.getItemList().get(0).getName(), testItemParser.getItemList().get(0).getPrice());
        int actualValue = testItemParser.getMilkCostHighCount();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testMilkPriceLowChecker(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedValue = 1;
        testItemParser.milkCHecker(testItemParser.getItemList().get(9).getName(), testItemParser.getItemList().get(9).getPrice());
        int actualValue = testItemParser.getMilkCostLow();
        assertEquals(expectedValue, actualValue);
    }

    @Test

    public void testBreadCHecker(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedValue = 1;
        testItemParser.breadChecker(testItemParser.getItemList().get(2).getName(), testItemParser.getItemList().get(2).getPrice());
        int actualVal = testItemParser.getBreadCount();
        assertEquals(expectedValue, actualVal);

    }

    @Test
    public void testBreadPriceCount(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedPrice = 1;
        testItemParser.breadChecker(testItemParser.getItemList().get(2).getName(), testItemParser.getItemList().get(2).getPrice());
        int actualPrice = testItemParser.getBreadPriceCount();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testCookiesChecker(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedPrice = 1;
        testItemParser.cookieChecker(testItemParser.getItemList().get(7).getName(), testItemParser.getItemList().get(7).getPrice());
        int actualPrice = testItemParser.getCookiePriceCount();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testApplesChecker(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedPrice = 1;
        testItemParser.appleChecker(testItemParser.getItemList().get(10).getName(), testItemParser.getItemList().get(10).getPrice());
        int actualPrice = testItemParser.getAppleCount();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testApplesPriceLowChecker(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedPrice = 1;
        testItemParser.appleChecker(testItemParser.getItemList().get(11).getName(), testItemParser.getItemList().get(11).getPrice());
        int actualPrice = testItemParser.getApplePriceLowCount();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testApplesPriceHighChecker(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedPrice = 1;
        testItemParser.appleChecker(testItemParser.getItemList().get(10).getName(), testItemParser.getItemList().get(10).getPrice());
        int actualPrice = testItemParser.getApplePriceHighCount();
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void testCustomException(){
        ItemParser testItemParser = new ItemParser();
        testItemParser.JerkSON(fileData);
        int expectedPrice = 0;
        testItemParser.appleChecker(testItemParser.getItemList().get(27).getName(), testItemParser.getItemList().get(27).getPrice());
        int actualPrice = testItemParser.getApplePriceLowCount();
        assertEquals(expectedPrice, actualPrice);
    }








}
