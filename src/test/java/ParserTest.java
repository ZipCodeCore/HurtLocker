import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aurorabanuelos on 5/31/17.
 */
public class ParserTest {
    Parser parser;
    String result;

    @Before
    public void setUp() throws Exception{
        parser = new Parser();

        ClassLoader classLoader = getClass().getClassLoader();
        result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));

    }


    @Test
    public void parseStringTest(){
        //Given
        List<String> expected = Arrays.asList("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016",
        "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016",
        "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016",
        "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016",
        "naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016",
        "naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016",
        "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016",
        "naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016",
        "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016",
        "naMe:MilK;price:1.23;type:Food!expiration:4/25/2016",
        "naMe:apPles;price:0.25;type:Food;expiration:1/23/2016",
        "naMe:apPles;price:0.23;type:Food;expiration:5/02/2016",
        "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016",
        "naMe:;price:3.23;type:Food;expiration:1/04/2016",
        "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016",
        "naME:BreaD;price:1.23;type:Food@expiration:1/02/2016",
        "NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016",
        "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016",
        "naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016",
        "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016",
        "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016",
        "naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016",
        "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016",
        "naMe:MilK;priCe:;type:Food;expiration:4/25/2016",
        "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016",
        "naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016",
        "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016",
        "naMe:;price:3.23;type:Food^expiration:1/04/2016");

        //When
        List<String> actual = parser.parseString(result);

        //Then
        Assert.assertEquals("Arrays should be equal", expected, actual);
    }

    @Test
    public void matchNamePatternTest(){
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expected = "Milk";

        //When
        String actual = parser.matchNamePattern(input);

        //Then
        Assert.assertEquals("Strings should be Milk", expected, actual);
    }

    @Test
    public void matchPricePatternTest(){
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        double expected = 3.23;

        //When
        double actual = parser.matchPricePattern(input);

        //Then
        Assert.assertEquals("Should be 3.23", expected, actual, 0.1);
    }

    @Test
    public void matchTypePatternTest(){
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expected = "Food";

        //When
        String actual = parser.matchTypePattern(input);

        //Then
        Assert.assertEquals("Should be Food", expected, actual);
    }

    @Test
    public void matchExpirationPatternTest(){
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expected = "1/25/2016";

        //When
        String actual = parser.matchExpirationPattern(input);

        //Then
        Assert.assertEquals("Should be 3.23", expected, actual);
    }

    @Test
    public void createItemListTest(){
        //Given
        int expected = 28;

        //When
        parser.parseString(result);
        parser.createItemList();
        int actual = parser.getItemListSize();

        //Then
        Assert.assertEquals("list size should be 28", expected, actual);
    }
}
