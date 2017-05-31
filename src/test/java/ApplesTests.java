import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by markbrown on 5/31/17.
 */
public class ApplesTests {

    @Test
    public void testParseForApplesPriceKeyPair() {
        //Given:
        String rawData = "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##";
        ArrayList<String> productList = Main.createListOfFoodItems(rawData);
        ArrayList<ArrayList<String>> expectedApplesProductList = new ArrayList<ArrayList<String>>();
        ArrayList<String> ApplesProductOne = new ArrayList<String>();
        ApplesProductOne.add("apPles");
        ApplesProductOne.add("0.25");
        ArrayList<String> ApplesProductTwo = new ArrayList<String>();
        ApplesProductTwo.add("apPles");
        ApplesProductTwo.add("0.23");
        expectedApplesProductList.add(ApplesProductOne);
        expectedApplesProductList.add(ApplesProductTwo);

        //When:
        ArrayList<ArrayList<String>> actualApplesProductList = Apples.parseListForApplesPriceKeyPair(productList);

        //Then:
        Assert.assertTrue(expectedApplesProductList.equals(actualApplesProductList));
    }

    @Test
    public void testParseForApplesPriceKeyPairReturnsAnError() {
        //Given:
        String rawData = "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##";
        ArrayList<String> productList = Main.createListOfFoodItems(rawData);
        ArrayList<ArrayList<String>> expectedApplesProductList = new ArrayList<ArrayList<String>>();
        ArrayList<String> ApplesProductTwo = new ArrayList<String>();
        ApplesProductTwo.add("apPles");
        ApplesProductTwo.add("0.23");
        expectedApplesProductList.add(ApplesProductTwo);
        int expectedErrorCount = 1;

        //When:
        ArrayList<ArrayList<String>> actualApplesProductList = Apples.parseListForApplesPriceKeyPair(productList);
        int actualErrorCount = ErrorCounter.getErrorCount();

        //Then:
        Assert.assertTrue(expectedApplesProductList.equals(actualApplesProductList));
        Assert.assertTrue(expectedErrorCount == actualErrorCount);
    }

    @Test
    public void testCorrectApplesPriceCount() {
        //Given:
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        ArrayList<String> foodList = Main.createListOfFoodItems(rawData);
        Main.checkForMissingNameErrors(foodList);
        ArrayList<ArrayList<String>> applesList = Apples.parseListForApplesPriceKeyPair(foodList);
        TreeMap<String, Integer> applesPriceCount = Cookies.getCookiesPriceList(applesList);
        int expectedCount = 2;

        //When:
        int actualCount = applesPriceCount.get("0.25");

        //Then:
        Assert.assertTrue(expectedCount == actualCount);
    }

}
