import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by anthonyjones on 5/31/17.
 */
public class testParser {
    Parser parser;
    String output;

    @Before
    public void init() throws Exception {
        parser = new Parser();
        ClassLoader classLoader = getClass().getClassLoader();
        output = (new Main()).readRawDataToString();
    }


    @Test(expected = NoMatchFoundException.class)
    public void testPatternMatch() throws NoMatchFoundException {
        //Given
        String given = output;
        String expected = "name:\tMilk\t\t\tseen: 6 times\n" +
                "=============\t\t\t=============\n" +
                "Price:\t3.23\t\t\tseen: 5 times\n" +
                "-------------\t\t\t-------------\n" +
                "Price:\t1.23\t\t\tseen: 1 time\n" +
                "\n" +
                "name:\tBread\t\t\tseen: 6 times\n" +
                "=============\t\t\t=============\n" +
                "Price:\t1.23\t\t\tseen: 6 times\n" +
                "-------------\t\t\t-------------\n" +
                "\n" +
                "name: Cookies\t\t\tseen: 8 times\n" +
                "=============\t\t\t=============\n" +
                "Price:\t 2.25\t\t\tseen: 8 times\n" +
                "-------------\t\t\t-------------\n" +
                "\n" +
                "name:\tApples\t\t\tseen: 4 times\n" +
                "=============\t\t\t=============\n" +
                "Price:\t0.23\t\t\tseen: 2 times\n" +
                "-------------\t\t\t-------------\n" +
                "Price:\t0.25\t\t\tseen: 2 times\n" +
                "\n" +
                "Errors:\t\t\t\t\tseen: 4 times";
        //When
        String actual = parser.patternMatch(given);


        //Then
        Assert.assertEquals("This should return a String with the first product", expected, actual);
    }


    @Test
    public void testLineBreaker() {
        //Given
        String given = output;
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        //When
        ArrayList<String> arrayListOfBrokenLines = parser.lineBreaker(given);
        String actual = arrayListOfBrokenLines.get(0);
        //Then
        Assert.assertEquals("This should break the line right after two hashtags", expected, actual);
    }

    @Test
    public void testMilkBreakDown() {
        ///Given
        ArrayList<String> arrayListOfBrokenLines = new ArrayList<>();
        arrayListOfBrokenLines.add("[Milk;price:3.23;type:Food;expiration:1/25/2016, MiLK;price:3.23;type:Food^expiration:1/11/2016, MilK;price:3.23;type:Food;expiration:1/17/2016, MilK;price:1.23;type:Food!expiration:4/25/2016, Milk;price:3.23;type:Food;expiration:1/25/2016, MiLK;priCe:;type:Food;expiration:1/11/2016, MilK;price:3.23;type:Food;expiration:1/17/2016, MilK;priCe:;type:Food;expiration:4/25/2016]\n");
        String expected = "name:\tMilk\t\t\tseen: 6 times\n" +
                "=============\t\t\t=============\n" +
                "Price:\t3.23\t\t\tseen: 5 times\n" +
                "-------------\t\t\t-------------\n" +
                "Price:\t1.23\t\t\tseen: 1 time\n\n";
        //When
        String actual = parser.milkBreakDown(arrayListOfBrokenLines, 6);
        //Then
        Assert.assertEquals("This should break the line right after two hashtags", expected, actual);

    }

    @Test
    public void testBreadBreakDown() {
        ///Given
        ArrayList<String> arrayListOfBrokenLines = new ArrayList<>();
        arrayListOfBrokenLines.add("[[naME:BreaD;price:1.23;type:Food;expiration:1/02/2016, NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016,  NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016,  naME:BreaD;price:1.23;type:Food@expiration:1/02/2016, NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016,  NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016]\n");
        String expected = "name:\tBread\t\t\tseen: 6 times\n" +
                "=============\t\t\t=============\n" +
                "Price:\t1.23\t\t\tseen: 6 times\n" +
                "-------------\t\t\t-------------\n\n";
        //When
        String actual = parser.breadBreakDown(arrayListOfBrokenLines, 6);
        //Then
        Assert.assertEquals("This should break the line right after two hashtags", expected, actual);

    }

    @Test
    public void testCookieBreakDown() {
        ///Given
        ArrayList<String> arrayListOfBrokenLines = new ArrayList<>();
        arrayListOfBrokenLines.add("[ naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016, naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016, naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016, naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016,  naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016, naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016, naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016, naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016]\n");
        String expected = "name: Cookies\t\t\tseen: 8 times\n" +
                "=============\t\t\t=============\n" +
                "Price:\t 2.25\t\t\tseen: 8 times\n" +
                "-------------\t\t\t-------------\n\n";
        //When
        String actual = parser.cookieBreakDown(arrayListOfBrokenLines, 8);
        //Then
        Assert.assertEquals("This should break the line right after two hashtags", expected, actual);
    }

    @Test
    public void testAppleBreakDown() {
        ///Given
        ArrayList<String> arrayListOfBrokenLines = new ArrayList<>();
        arrayListOfBrokenLines.add("[naMe:apPles;price:0.25;type:Food;expiration:1/23/2016, naMe:apPles;price:0.23;type:Food;expiration:5/02/2016,  naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016, naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016]\n");
        String expected = "name:\tApples\t\t\tseen: 4 times\n" +
                "=============\t\t\t=============\n" +
                "Price:\t0.23\t\t\tseen: 2 times\n" +
                "-------------\t\t\t-------------\n" +
                "Price:\t0.25\t\t\tseen: 2 times\n\n";
        //When
        String actual = parser.appleBreakDown(arrayListOfBrokenLines, 4);
        //Then
        Assert.assertEquals("This should break the line right after two hashtags", expected, actual);
    }

    @Test
    public void testExceptionHandler() throws NoMatchFoundException {
        ///Given
        ArrayList<String> arrayListOfBrokenLines = new ArrayList<>();
        arrayListOfBrokenLines.add("[naMe:Milk;price:3.23;type:Food;expiration:1/25/2016, naME:BreaD;price:1.23;type:Food;expiration:1/02/2016, NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016, naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016, naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016, naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016, naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016, naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016, NAME:MilK;price:3.23;type:Food;expiration:1/17/2016, naMe:MilK;price:1.23;type:Food!expiration:4/25/2016, naMe:apPles;price:0.25;type:Food;expiration:1/23/2016, naMe:apPles;price:0.23;type:Food;expiration:5/02/2016, NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016, naMe:;price:3.23;type:Food;expiration:1/04/2016, naMe:Milk;price:3.23;type:Food;expiration:1/25/2016, naME:BreaD;price:1.23;type:Food@expiration:1/02/2016, NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016, naMe:MiLK;priCe:;type:Food;expiration:1/11/2016, naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016, naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016, naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016, naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016, NAME:MilK;price:3.23;type:Food;expiration:1/17/2016, naMe:MilK;priCe:;type:Food;expiration:4/25/2016, naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016, naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016, NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016, naMe:;price:3.23;type:Food^expiration:1/04/2016]");


        String expected = "[naMe:Milk;price:3.23;type:Food;expiration:1/25/2016, naME:BreaD;price:1.23;type:Food;expiration:1/02/2016, NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016, naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016, naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016, naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016, naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016, naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016, NAME:MilK;price:3.23;type:Food;expiration:1/17/2016, naMe:MilK;price:1.23;type:Food!expiration:4/25/2016, naMe:apPles;price:0.25;type:Food;expiration:1/23/2016, naMe:apPles;price:0.23;type:Food;expiration:5/02/2016, NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016, naMe:Milk;price:3.23;type:Food;expiration:1/25/2016, naME:BreaD;price:1.23;type:Food@expiration:1/02/2016, NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016, naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016, naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016, naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016, naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016, NAME:MilK;price:3.23;type:Food;expiration:1/17/2016, naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016, naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016, NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016]";
        //When
        ArrayList<String> actual = parser.exceptionHandler(arrayListOfBrokenLines);
        // ArrayList<String> arrayListOfBrokenLines = parser.lineBreaker(given);
        //String actual = exceptionHandler.get(0);
        //Then
        Assert.assertEquals("This should break the line right after two hashtags", expected, actual.toString());
    }
}


