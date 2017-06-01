import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by sarahweisser on 5/31/17.
 */

public class GroceryItemTest {
    String itemString;
    Parser parser;
    GroceryItem item;
    String[] itemInfo;

    @Before
    public void setUpTests() {
        itemString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        parser = new Parser();
        itemInfo = parser.itemStringInfo(itemString);

    }

    @Test
    public void createGroceryItemTest() {
        //given
        parser.itemStrings(itemString);
        item = new GroceryItem(itemInfo);
        String expectedNameOfItem = "Milk";
        BigDecimal expectedPriceOfItem = new BigDecimal("3.23");
        String expectedTypeOfItem = "Food";
        String expectedExpirationDate = "1/25/2016";
        ArrayList<BigDecimal> expectedPrices = new ArrayList<BigDecimal>();
        expectedPrices.add(expectedPriceOfItem);

        //when
        item = new GroceryItem(itemInfo);
        String actualNameOfItem = item.getNameOfItem();
        BigDecimal actualPriceOfItem = item.getPriceOfItem();
        String actualTypeOfItem = item.getTypeOfItem();
        String actualExpirationDate = item.getExpirationDate();
        ArrayList<BigDecimal> actualPrices = item.getPrices();

        //then
        Assert.assertEquals(expectedNameOfItem, actualNameOfItem);
        Assert.assertEquals(expectedPriceOfItem, actualPriceOfItem);
        Assert.assertEquals(expectedTypeOfItem, actualTypeOfItem);
        Assert.assertEquals(expectedExpirationDate, actualExpirationDate);
        Assert.assertEquals(expectedPrices.get(0), actualPrices.get(0));
    }
}
