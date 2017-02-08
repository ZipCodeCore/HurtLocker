package mattern.william;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by williammattern on 2/8/17.
 */
public class GroceryListItemBuilderTest {
    GroceryListItem gli;
    GroceryListItem gliWithBuilder;

    @Before
    public void setUp(){
        gli = new GroceryListItem("Cookies","1.23","Food","1/23/2016");
        gliWithBuilder = new GroceryListItemBuilder().setName("Cookies").setPrice("1.23").setType("Food").setExpirationDate("1/23/2016").createGroceryListItem();
    }

    @Test
    public void createGroceryListItemNameTest()   {
        String expected = gli.getName(), actual = gliWithBuilder.getName();
        assertEquals(expected,actual);
    }

    @Test
    public void createGroceryListItemPriceTest()   {
        String expected = gli.getPrice(), actual = gliWithBuilder.getPrice();
        assertEquals(expected,actual);
    }

    @Test
    public void createGroceryListItemTypeTest()   {
        String expected = gli.getType(), actual = gliWithBuilder.getType();
        assertEquals(expected,actual);
    }

    @Test
    public void createGroceryListItemExpirationTest()   {
        String expected = gli.getExpirationDate(), actual = gliWithBuilder.getExpirationDate();
        assertEquals(expected,actual);
    }
}