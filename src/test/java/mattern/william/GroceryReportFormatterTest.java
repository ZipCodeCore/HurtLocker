package mattern.william;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by williammattern on 2/8/17.
 */
public class GroceryReportFormatterTest {
    GroceryReportFormatter grf;
    GroceryList groceryList;
    GroceryListItem gli;
    GroceryListItem cookies;
    GroceryListItem bread;
    GroceryListItem bread2;
    GroceryListItem bread3, milk1, milk2, milk3, milk4, milk5;
    TreeMap<String, Integer> singleItemData;



    @Before
    public void setUp(){
        grf = new GroceryReportFormatter();
        groceryList = new GroceryList();
        gli = new GroceryListItemBuilder().setName("Milk").setPrice("1.23").createGroceryListItem();
        cookies = new GroceryListItemBuilder().setName("Cookies").setPrice("3.00").setType("Food").setExpirationDate("1/1/2016").createGroceryListItem();
        bread = new GroceryListItemBuilder().setName("Bread").setPrice("1.00").setType("Food").setExpirationDate("2/14/2017").createGroceryListItem();
        bread2 = new GroceryListItemBuilder().setName("Bread").setPrice("1.00").setType("Food").setExpirationDate("2/14/2017").createGroceryListItem();
        bread3 = new GroceryListItemBuilder().setName("Bread").setPrice("1.11").setType("Food").setExpirationDate("2/14/2017").createGroceryListItem();
        groceryList.addGroceryListItemToList(gli);
        groceryList.addGroceryListItemToList(cookies);
        groceryList.addGroceryListItemToList(bread);
        groceryList.addGroceryListItemToList(bread2);
        groceryList.addGroceryListItemToList(bread3);
        milk1 = new GroceryListItemBuilder().setName("Milk").setPrice("3.23").createGroceryListItem();
        milk2 = new GroceryListItemBuilder().setName("Milk").setPrice("3.23").createGroceryListItem();
        milk3 = new GroceryListItemBuilder().setName("Milk").setPrice("3.23").createGroceryListItem();
        milk4 = new GroceryListItemBuilder().setName("Milk").setPrice("3.23").createGroceryListItem();
        milk5 = new GroceryListItemBuilder().setName("Milk").setPrice("3.23").createGroceryListItem();
        groceryList.addGroceryListItemToList(milk1);
        groceryList.addGroceryListItemToList(milk2);
        groceryList.addGroceryListItemToList(milk3);
        groceryList.addGroceryListItemToList(milk4);
        groceryList.addGroceryListItemToList(milk5);
        singleItemData = grf.nameAndPriceCountMapper(groceryList,"Milk");
    }

    @Test
    public void formatNameLineTest()   {
        String expected = "name:    Milk          seen: 6 times";
        String actual = grf.formatNameLine("Milk", 6);
        assertEquals(expected,actual);
    }

    @Test
    public void formatPriceLineTest(){
        String expected = "Price:   3.23          seen: 5 times";
        String actual = grf.formatPriceLine("3.23", 5);
        assertEquals(expected,actual);
    }

    @Test
    public void nameAndPriceCountMapperTest(){
        String expected = "{1.23=1, 3.23=5, Milk=6}";
        Map<String, Integer> singleItemData = grf.nameAndPriceCountMapper(groceryList,"Milk");
        String actual = singleItemData.toString();
        assertEquals(expected,actual);
    }

    @Test
    public void nameAndPriceCountMapperTestCookies(){
        String expected = "{3.00=1, Cookies=1}";
        Map<String, Integer> singleItemData = grf.nameAndPriceCountMapper(groceryList,"Cookies");
        String actual = singleItemData.toString();
        assertEquals(expected,actual);
    }

    @Test
    public void nameAndPriceCountMapperTestBread(){
        String expected = "{1.00=2, 1.11=1, Bread=3}";
        Map<String, Integer> singleItemData = grf.nameAndPriceCountMapper(groceryList,"Bread");
        String actual = singleItemData.toString();
        assertEquals(expected,actual);
    }

    @Test
    public void singleItemPriceMapperFudgedTest(){
        String expected = "name:    Milk          seen: 6 times\n" +
                "=============          =============\n" +
                "Price:   1.23          seen: 1 time \n" +
                "-------------          -------------\n" +
                "Price:   3.23          seen: 5 times\n" +
                "-------------          -------------\n";
        String actual = grf.formatSingleItemGroceryReport(singleItemData);
        assertEquals(expected,actual);
    }

    @Test
    public void singleItemPriceMapperRealTest(){
        String expected = "name:    Milk          seen: 6 times\n" +
                "=============          =============\n" +
                "Price:   3.23          seen: 5 times\n" +
                "-------------          -------------\n" +
                "Price:   1.23          seen: 1 time \n";
        String actual = grf.formatSingleItemGroceryReport(singleItemData);
        assertEquals(expected,actual);
    }
}