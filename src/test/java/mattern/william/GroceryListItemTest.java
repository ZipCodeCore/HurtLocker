package mattern.william;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GroceryListItemTest {
    GroceryListItem g;

    @Before
    public void setUp(){
        g = new GroceryListItem("Cookies","1.23","Food", "1/23/2016");
    }

    @Test
    public void getName()   {
        String expected = "Cookies", actual = g.getName();
        assertEquals(expected,actual);
    }

    @Test
    public void getPrice()   {
        String expected = "1.23", actual = g.getPrice();
        assertEquals(expected,actual);
    }

    @Test
    public void getType()   {
        String expected = "Food", actual = g.getType();
        assertEquals(expected,actual);

    }

    @Test
    public void getExpirationDate()   {
        String expected = "1/23/2016", actual = g.getExpirationDate();
        assertEquals(expected,actual);

    }

}