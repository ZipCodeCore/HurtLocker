
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class FindPatternTest {
FindPatterns finder;
CleanTheJerk cleaner;

    @Before
    public void setUp() throws Exception {
        finder = new FindPatterns();
        cleaner = new CleanTheJerk();
    }

    @Test
    public void fileLoadTest () {
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        String actual  = HurtLocker.loadFile();
        Assert.assertEquals(expected, actual);
        //System.out.println(actual);
    }

    @Test
    public void countTest(){
        Integer expected = 28;
        Integer actual = finder.count();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printRawData () {
        finder.splitToWordsArray();
    }


    @Test
    public void splitToItems () {
        cleaner.splitToItems();
    }

    @Test
    public void singleWordsTest () {
        finder.splitToWordsArray();
    }

    @Test
    public void errorTest () {
        Integer errorsExpected = 4;
        Integer actual = finder.errors();
        Assert.assertEquals(errorsExpected, actual);
    }

    @Test
    public void printResultsTest () {
        finder.printResults();
    }

    @Test
    public void createObjectsTest () {
        finder.createGroceryObjects();
    }

}
