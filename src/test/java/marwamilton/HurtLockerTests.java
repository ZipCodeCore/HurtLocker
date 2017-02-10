package marwamilton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by mkulima on 2/9/17.
 */
public class HurtLockerTests {
    HurtLocker hurtLocker;
    GroceryRegexEngine groceryRegexEngine = new GroceryRegexEngine();
    String dString;
    String grocery1;
    String grocery2;
    String[] twoGroceries;
    String pairOf;
    String[] splitGrocery;
    List<String[]> baggedGroceries;
    List<List<String[]>> labelledGroceries;
    List<String[]> finalizedGroceries;
    List<List<String[]>> groupedGroceries;


    @Before
    public void setup(){
        hurtLocker =new HurtLocker();
        dString = "dt!str;t^h*u%d@l";
        grocery1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        grocery2 = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";
        pairOf = "naMe:Milk";
        twoGroceries = new String[]{grocery1, grocery2};
        splitGrocery = hurtLocker.getPairs(grocery1);
        baggedGroceries = hurtLocker.bagGroceries(twoGroceries);
        labelledGroceries = hurtLocker.labelTheGroceries(baggedGroceries);
        groupedGroceries = hurtLocker.groupGroceries(groceryRegexEngine.Milk, labelledGroceries);
        finalizedGroceries = hurtLocker.finalizeGroceries();

    }

    @Test
    public void getPairsTest(){
        String[] expected = new String[]{"dt","str","t","h","u","d","l"};
        Assert.assertEquals("Pairs Split Fail", expected, hurtLocker.getPairs(dString));
    }

    @Test
    public void getLabeltest(){
        String[] expectedPair = new String[]{"naMe", "Milk"};
        Assert.assertEquals("Inner pairs split fail",expectedPair,hurtLocker.getLabels(pairOf));
    }

    @Test
    public void bagGroceriesTest(){
        String expectedAtFirstPosition = "naMe:Milk";
        String actualAtFirstPosition = (hurtLocker.bagGroceries(twoGroceries)).get(0)[0];
        Assert.assertEquals("",expectedAtFirstPosition,actualAtFirstPosition);
    }

    @Test
    public void splitLabelPairsTest(){
        String expectedAtZeroIndex = "naMe";
        String actualAtZeroIndex = (hurtLocker.splitLabelPairs(splitGrocery)).get(0)[0];
        Assert.assertEquals("", expectedAtZeroIndex, actualAtZeroIndex);
    }

    @Test
    public void labelTheGroceriesTest(){
        String[] expectedAtZeroIndex = new String[]{"naMe","Milk"};
        String[] actualAtIndexZero = ((hurtLocker.labelTheGroceries(baggedGroceries)).get(0)).get(0);
        Assert.assertEquals("",expectedAtZeroIndex[0], actualAtIndexZero[0]);
    }

    @Test
    public void groupGroceriesTest(){
        groupedGroceries = hurtLocker.groupGroceries(groceryRegexEngine.Milk, labelledGroceries);
        String expectedAtIndex3 = "price";
        String actualAtIndex3 = ((groupedGroceries.get(0)).get(1))[0];
        Assert.assertEquals(expectedAtIndex3, actualAtIndex3);
    }

    @Test
    public void handleMissingTest(){
        String expectedIfMissing = "Milk";
        String actualMissing = hurtLocker.handleMissing(groupedGroceries.get(0));
        Assert.assertEquals(expectedIfMissing, actualMissing);
    }

    @Test
    public void mergedPricesTest(){
        String expectedAtIndex2 = "3.23";
        // recall from: grocery1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String actualAtIndex2 = (hurtLocker.mergedPrices(groupedGroceries))[1];
        Assert.assertEquals(expectedAtIndex2, actualAtIndex2);
    }

    @Test
    public void finalizeGroceriesTest(){
        String expectedAtIndex3 = "apPles";
        String actualAtIndex3 = (finalizedGroceries.get(3))[0];
        Assert.assertEquals(expectedAtIndex3,actualAtIndex3);
    }

    @Test
    public void removeBadPricesTest(){
        String[] hasBadPrices = new String[]{"1.23","3.23","BAD","7.89","BAD", "2.25"};
        int expectedLength = 4;
        int actualLength = ((hurtLocker.removeBadPrices(finalizedGroceries)).get(0)).length;
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void matchBadTest(){
        String badPrice = "BAD";
        boolean expectedBool = true;
        boolean actualBool = hurtLocker.matchBad(badPrice);
        Assert.assertEquals(expectedBool,actualBool);

    }

    @Test
    public void matchPriceTest(){
        String[] prices = new String[]{"1.23","3.23","4.56","7.89","2.25"};
        int expectedMatches = 1;
        int actualMatches = hurtLocker.matchPrice(groceryRegexEngine.Prices, prices);
        Assert.assertEquals(expectedMatches, actualMatches);

    }

    @Test
    public void makePrintableTest(){
        List<String[]> removedBadPrices = hurtLocker.removeBadPrices(hurtLocker.finalizeGroceries());
        List<String[]> withBadPrices = hurtLocker.finalizeGroceries();
        String expectedPrintable = "name:    Milk             seen: 92 times\n" +
                "==============            =============\n" +
                "Price:    3.23            seen: 5 times\n" +
                "______________            _____________\n" +
                "Price:    1.23            seen: 5 times\n" +
                "______________            _____________\n";

        String actualPrintable = hurtLocker.makePrintable(removedBadPrices.get(0), withBadPrices.get(0));
        Assert.assertEquals(expectedPrintable, actualPrintable);
    }

}
