import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by markbrown on 5/31/17.
 */
public class BreadTests {

    @Test
    public void testParseForBreadPriceKeyPair() {
        //Given:
        String rawData = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        ArrayList<String> productList = Main.createListOfFoodItems(rawData);
        ArrayList<ArrayList<String>> expectedBreadProductList = new ArrayList<ArrayList<String>>();
        ArrayList<String> breadProductOne = new ArrayList<String>();
        breadProductOne.add("BreaD");
        breadProductOne.add("1.23");
        ArrayList<String> breadProductTwo = new ArrayList<String>();
        breadProductTwo.add("BrEAD");
        breadProductTwo.add("1.23");
        expectedBreadProductList.add(breadProductOne);
        expectedBreadProductList.add(breadProductTwo);

        //When:
        ArrayList<ArrayList<String>> actualBreadProductList = Bread.parseListForBreadPriceKeyPair(productList);

        //Then:
        Assert.assertTrue(expectedBreadProductList.equals(actualBreadProductList));
    }

    @Test
    public void testParseForBreadPriceKeyPairReturnsAnError() {
        //Given:
        String rawData = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        ArrayList<String> productList = Main.createListOfFoodItems(rawData);
        ArrayList<ArrayList<String>> expectedBreadProductList = new ArrayList<ArrayList<String>>();
        ArrayList<String> breadProductOne = new ArrayList<String>();
        breadProductOne.add("BreaD");
        breadProductOne.add("1.23");
        expectedBreadProductList.add(breadProductOne);
        int expectedErrorCount = 1;

        //When:
        ArrayList<ArrayList<String>> actualBreadProductList = Bread.parseListForBreadPriceKeyPair(productList);
        int actualErrorCount = ErrorCounter.getErrorCount();

        //Then:
        Assert.assertTrue(expectedBreadProductList.equals(actualBreadProductList));
        Assert.assertTrue(expectedErrorCount == actualErrorCount);
    }

    @Test
    public void testCorrectBreadPriceCount() {
        //Given:
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        ArrayList<String> foodList = Main.createListOfFoodItems(rawData);
        Main.checkForMissingNameErrors(foodList);
        ArrayList<ArrayList<String>> breadList = Bread.parseListForBreadPriceKeyPair(foodList);
        TreeMap<String, Integer> breadPriceCount = Bread.getBreadPriceList(breadList);
        int expectedCount = 6;

        //When:
        int actualCount = breadPriceCount.get("1.23");

        //Then:
        Assert.assertTrue(expectedCount == actualCount);
    }
}
