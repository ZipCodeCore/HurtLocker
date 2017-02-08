package mattern.william;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by williammattern on 2/8/17.
 */
public class GroceryListTest {

    GroceryList gl;
    GroceryListItem milk;
    GroceryListItem cookies;
    GroceryListItem bread;

    @Before
    public void setUp(){
        gl = new GroceryList();
        milk = new GroceryListItemBuilder().setName("Milk").setPrice("2.50").setType("Food").setExpirationDate("2/2/2017").createGroceryListItem();
        cookies = new GroceryListItemBuilder().setName("Cookies").setPrice("3.00").setType("Food").setExpirationDate("1/1/2016").createGroceryListItem();
        bread = new GroceryListItemBuilder().setName("Bread").setPrice("1.00").setType("Food").setExpirationDate("2/14/2017").createGroceryListItem();
    }

    @Test
    public void getAllGroceryListItemsTest(){
        gl.list.add(milk);
        gl.list.add(cookies);
        String actual = gl.getAllGroceryListItems().toString();
        String expected = "[Milk,2.50,Food,2/2/2017, Cookies,3.00,Food,1/1/2016]";
        assertEquals(expected,actual);
    }

    @Test
    public void addItemToGroceryListTest(){
        gl.addGroceryListItemToList(bread);
        System.out.println(gl.getAllGroceryListItems().toString());
        assertTrue(gl.list.contains(bread));
    }


}