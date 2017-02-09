package mattern.william;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
    GroceryListItem bread3;

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
        String expected = "{1.23=1, Milk=1}";
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
}