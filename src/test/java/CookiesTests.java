import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by markbrown on 5/31/17.
 */
public class CookiesTests {

    @Test
    public void testParseForCookiesPriceKeyPair() {
        //Given:
        String rawData = "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##";
        ArrayList<String> productList = Main.createListOfFoodItems(rawData);
        ArrayList<ArrayList<String>> expectedCookiesProductList = new ArrayList<ArrayList<String>>();
        ArrayList<String> cookiesProductOne = new ArrayList<String>();
        cookiesProductOne.add("COokIes");
        cookiesProductOne.add("2.25");
        ArrayList<String> cookiesProductTwo = new ArrayList<String>();
        cookiesProductTwo.add("COOkieS");
        cookiesProductTwo.add("2.25");
        expectedCookiesProductList.add(cookiesProductOne);
        expectedCookiesProductList.add(cookiesProductTwo);

        //When:
        ArrayList<ArrayList<String>> actualCookiesProductList = Cookies.parseListForCookiesPriceKeyPair(productList);

        //Then:
        Assert.assertTrue(expectedCookiesProductList.equals(actualCookiesProductList));
    }

    @Test
    public void testParseForCookiesPriceKeyPairReturnsAnError() {
        //Given:
        String rawData = "naMe:COokIes;price:;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##";
        ArrayList<String> productList = Main.createListOfFoodItems(rawData);
        ArrayList<ArrayList<String>> expectedCookiesProductList = new ArrayList<ArrayList<String>>();
        ArrayList<String> cookiesProductTwo = new ArrayList<String>();
        cookiesProductTwo.add("COOkieS");
        cookiesProductTwo.add("2.25");
        expectedCookiesProductList.add(cookiesProductTwo);
        int expectedErrorCount = 1;

        //When:
        ArrayList<ArrayList<String>> actualCookiesProductList = Cookies.parseListForCookiesPriceKeyPair(productList);
        int actualErrorCount = ErrorCounter.getErrorCount();

        //Then:
        Assert.assertTrue(expectedCookiesProductList.equals(actualCookiesProductList));
        Assert.assertTrue(expectedErrorCount == actualErrorCount);
    }
    @Test
    public void testCorrectCookiePriceCount() {
        //Given:
        String rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        ArrayList<String> foodList = Main.createListOfFoodItems(rawData);
        Main.checkForMissingNameErrors(foodList);
        ArrayList<ArrayList<String>> cookiesList = Cookies.parseListForCookiesPriceKeyPair(foodList);
        TreeMap<String, Integer> cookiesPriceCount = Cookies.getCookiesPriceList(cookiesList);
        int expectedCount = 8;

        //When:
        int actualCount = cookiesPriceCount.get("2.25");

        //Then:
        Assert.assertTrue(expectedCount == actualCount);
    }

}
