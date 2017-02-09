package reynoldstitko.gillian;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by gillianreynolds-titko on 2/9/17.
 */

    public class GroceryItemTest {
    GroceryItem groceryItem = new GroceryItem("Milk", 3.25);

    @Test
    public void getNameTest(){
        String expected = "Milk";
        String actual = groceryItem.getName();
        assertEquals("Expected to get milk", expected, actual);
    }

    @Test
    public void getPriceTest(){
        Double expected = 3.25;
        Double actual = groceryItem.getPrice();
        assertEquals("Expected to get 3.25", expected, actual);
    }

    @Test
    public void getTypeTest(){
        String expected = "Food";
        String actual = groceryItem.getType();
        assertEquals("Expected to get the default 'Food'", expected, actual);
    }

    @Test
    public void getExpirationTest(){
    String expected = "1/02/2016";
    String actual = groceryItem.getExpiration();
    assertEquals("Expected 1/02/2016", expected, actual);
    }

    @Test
    public void calculatePriceSummaryDataTest(){
        int expected = 2;
        int actual = groceryItem.calculatePriceSummaryData(groceryItem.getPrice()).length;
        assertEquals("Expected a size of 2", expected, actual);
    }

    @Test
    public void calculateGroceryItemCountTest(){
        int expected = 3;
        int actual = groceryItem.calculateGroceryItemCount(groceryItem);
        assertEquals("Expected to get 3 items", expected, actual);

    }
}
