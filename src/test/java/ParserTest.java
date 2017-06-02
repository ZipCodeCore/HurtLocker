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
        String actual = parser.matchPairPattern("(?<=[Nn][Aa][Mm][Ee].)[A-Za-z0-9]+",input);

        //Then
        Assert.assertEquals("Strings should be Milk", expected, actual);
    }

    @Test
    public void matchPricePatternTest(){
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expected = "3.23";

        //When
        String actual = parser.matchPairPattern("(?<=[Pp][Rr][Ii][Cc][Ee].)[0-9]+\\.[0-9]{2}", input);

        //Then
        Assert.assertEquals("Should be 3.23", expected, actual);
    }

    @Test
    public void matchTypePatternTest(){
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expected = "Food";

        //When
        String actual = parser.matchPairPattern("(?<=[Tt][Yy][Pp][Ee].)[A-Za-z0-9]+",input);

        //Then
        Assert.assertEquals("Should be Food", expected, actual);
    }

    @Test
    public void matchExpirationPatternTest(){
        //Given
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String expected = "1/25/2016";

        //When
        String actual = parser.matchPairPattern("(?<=[Ee][Xx][Pp][Ii][Rr][Aa][Tt][Ii][Oo][Nn].).+\\b",input);

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

    @Test
    public void findItemCountTest(){
        //Given
        String expected = "Name:\tCookies\t\tseen: 8 times";

        //When
        parser.parseString(result);
        parser.createItemList();

        String actual = parser.findItemCount("[Cc].+[sS]", "Cookies");

        //Then
        Assert.assertEquals("strings should be equal", expected, actual);
    }

    @Test
    public void priceCountTest(){
        //Given
        String expected = "Price:\t2.25\t\tseen: 8 times";

        //When
        parser.parseString(result);
        parser.createItemList();
        parser.findItemCount("[Cc].+[sS]", "Cookies");

        String actual = parser.priceCount();

        //Then
        Assert.assertEquals("strings should be equal", expected, actual);
    }

    @Test
    public void outputErrorTest(){
        //Given
        String expected = "Errors:\t\t\t\tseen: 4 times";

        //When
        parser.parseString(result);
        parser.createItemList();

        String actual = parser.outputErrors();

        //Then
        Assert.assertEquals("strings should be equal", expected, actual);
    }
}
