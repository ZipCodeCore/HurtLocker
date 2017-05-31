import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by markbrown on 5/31/17.
 */
public class MilkTests {

    @Test
    public void testParseForMilkPriceKeyPair() {
        //Given:
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        ArrayList<String> productList = Main.createListOfFoodItems(rawData);
        ArrayList<ArrayList<String>> expectedMilkProductList = new ArrayList<ArrayList<String>>();
        ArrayList<String> milkProductOne = new ArrayList<String>();
        milkProductOne.add("Milk");
        milkProductOne.add("3.23");
        ArrayList<String> milkProductTwo = new ArrayList<String>();
        milkProductTwo.add("MiLK");
        milkProductTwo.add("3.23");
        expectedMilkProductList.add(milkProductOne);
        expectedMilkProductList.add(milkProductTwo);

        //When:
        ArrayList<ArrayList<String>> actualMilkProductList = Milk.parseListForMilkPriceKeyPair(productList);

        //Then:
        Assert.assertTrue(expectedMilkProductList.equals(actualMilkProductList));
    }

    @Test
    public void testParseForMilkPriceKeyPairReturnsAnError() {
        //Given:
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:;type:Food^expiration:1/11/2016##";
        ArrayList<String> productList = Main.createListOfFoodItems(rawData);
        ArrayList<ArrayList<String>> expectedMilkProductList = new ArrayList<ArrayList<String>>();
        ArrayList<String> milkProductOne = new ArrayList<String>();
        milkProductOne.add("Milk");
        milkProductOne.add("3.23");
        expectedMilkProductList.add(milkProductOne);
        int expectedErrorCount = 1;

        //When:
        ArrayList<ArrayList<String>> actualMilkProductList = Milk.parseListForMilkPriceKeyPair(productList);
        int actualErrorCount = ErrorCounter.getErrorCount();

        //Then:
        Assert.assertTrue(expectedMilkProductList.equals(actualMilkProductList));
        Assert.assertTrue(expectedErrorCount == actualErrorCount);
    }

    @Test
    public void testCorrectMilkPriceCount() {
        //Given:
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        ArrayList<String> foodList = Main.createListOfFoodItems(rawData);
        Main.checkForMissingNameErrors(foodList);
        ArrayList<ArrayList<String>> milkList = Milk.parseListForMilkPriceKeyPair(foodList);
        TreeMap<String, Integer> milkPriceCount = Milk.getMilkPriceList(milkList);
        int expectedCount = 5;

        //When:
        int actualCount = milkPriceCount.get("3.23");

        //Then:
        Assert.assertTrue(expectedCount == actualCount);
    }


}
