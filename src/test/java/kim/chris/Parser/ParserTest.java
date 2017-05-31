package kim.chris.Parser;

import kim.chris.data.Item;
import kim.chris.exceptions.ValueNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static kim.chris.Parser.Parser.*;
import static org.junit.Assert.*;

public class ParserTest {
    String rawData;
    String output;
    String milkLine;
    String breadLine;
    String cookiesLine;
    String applesLine;

    @Before
    public void initialize() {
        rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        output = "name:    Milk       seen: 6 times\n" +
                "=============       =============\n" +
                "Price: \t 3.23       seen: 5 times\n" +
                "-------------       -------------\n" +
                "Price:   1.23       seen: 1 time\n" +
                "\n" +
                "name:   Bread       seen: 6 times\n" +
                "=============\t\t=============\n" +
                "Price:   1.23       seen: 6 times\n" +
                "-------------       -------------\n" +
                "\n" +
                "name: Cookies       seen: 8 times\n" +
                "=============       =============\n" +
                "Price:   2.25       seen: 8 times\n" +
                "-------------       -------------\n" +
                "\n" +
                "name:  Apples       seen: 4 times\n" +
                "=============       =============\n" +
                "Price:   0.25       seen: 2 times\n" +
                "-------------       -------------\n" +
                "Price:   0.23       seen: 2 times\n" +
                "\n" +
                "Errors seen: 4 times";
        milkLine = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        breadLine = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
        cookiesLine = "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##";
        applesLine = "naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##";

    }

    @Test
    public void parseJerkTest(){
        //Given
        String expected = "name:    Milk\t\tseen: 1 time\n" +
                "=============\t\t=============\n" +
                "Price:   3.23\t\tseen: 1 time\n" +
                "\n" +
                "Errors seen: 0 times";

        //When
        String actual = parseJerk(milkLine);

        //Then
        assertEquals("Strings should match", expected, actual);
    }

    @Test
    public void parseJerkForRealTest(){
        //Given
        String expected = "name:    Milk\t\tseen: 6 times\n" +
                "=============\t\t=============\n" +
                "Price:   3.23\t\tseen: 5 times\n" +
                "-------------\t\t-------------\n" +
                "Price:   1.23\t\tseen: 1 time\n" +
                "\n" +
                "name:   Bread\t\tseen: 6 times\n" +
                "=============\t\t=============\n" +
                "Price:   1.23\t\tseen: 6 times\n" +
                "-------------\t\t-------------\n" +
                "\n" +
                "name: Cookies\t\tseen: 8 times\n" +
                "=============\t\t=============\n" +
                "Price:   2.25\t\tseen: 8 times\n" +
                "-------------\t\t-------------\n" +
                "\n" +
                "name:  Apples\t\tseen: 4 times\n" +
                "=============\t\t=============\n" +
                "Price:   0.25\t\tseen: 2 times\n" +
                "-------------\t\t-------------\n" +
                "Price:   0.23\t\tseen: 2 times\n" +
                "\n" +
                "Errors seen: 4 times";

        //When
        String actual = parseJerk(rawData);

        //Then
        assertEquals(expected, actual);
    }

    @Test
    public void parseLineTest() throws ValueNotFoundException {
        //Given
        Item expected = new Item("Milk", 3.23, "Food", "1/25/2016");

        //When
        Item actual = parseLine(milkLine);

        //Then
        assertEquals("Line one of the file should be parsed correctly to Item(Milk, 3.23, Food, 1/25/2016)", expected, actual);
    }

    @Test
    public void containsTest(){
        //When
        boolean actual = contains(milkLine, "[nN][aA][mM][eE]:");

        //Then
        assertTrue("Input should contain name: ", actual);
    }

    @Test
    public void readNameTest() throws ValueNotFoundException {
        //Given
        String expected1 = "Milk";
        String expected2 = "Bread";
        String expected3 = "Cookies";
        String expected4 = "Apples";

        //When
        String actual1 = readName(milkLine);
        String actual2 = readName(breadLine);
        String actual3 = readName(cookiesLine);
        String actual4 = readName(applesLine);


        //Then
        assertEquals("Should return Milk", expected1, actual1);
        assertEquals("Should return Bread", expected2, actual2);
        assertEquals("Should return Cookies", expected3, actual3);
        assertEquals("Should return Apples", expected4, actual4);
    }

    @Test (expected = ValueNotFoundException.class)
    public void readNameFailTest() throws ValueNotFoundException {
        String actual = readName("naMe:;price:3.23;type:Food^expiration:1/04/2016##");
    }

    @Test
    public void readTypeTest() throws ValueNotFoundException {
        //Given
        String expected = "Food";
        
        //When
        String actual1 = readType(milkLine);
        String actual2 = readType(breadLine);
        String actual3 = readType(cookiesLine);
        String actual4 = readType(applesLine);


        //Then
        assertEquals("The Type of milk should be Food", expected, actual1);
        assertEquals("The Type of bread should be Food", expected, actual2);
        assertEquals("The Type of cookies should be Food", expected, actual3);
        assertEquals("The Type of apples should be Food", expected, actual4);
    }
    
    @Test (expected = ValueNotFoundException.class)
    public void readTypeFailTest() throws ValueNotFoundException {
        readType("naMe:MilK;Type:;type:;expiration:4/25/2016##\n");
    }

    @Test
    public void readExpirationTest() throws ValueNotFoundException {
        //Given
        String expected1 = "1/25/2016";
        String expected2 = "1/02/2016";
        String expected3 = "1/25/2016";
        String expected4 = "5/02/2016";

        //When
        String actual1 = readExpiration(milkLine);
        String actual2 = readExpiration(breadLine);
        String actual3 = readExpiration(cookiesLine);
        String actual4 = readExpiration(applesLine);

        //Then
        assertEquals("The exp date should be 1/25/2016", expected1, actual1);
        assertEquals("The exp date should be 1/02/2016", expected2, actual2);
        assertEquals("The exp date should be 1/25/2016", expected3, actual3);
        assertEquals("The exp date should be 5/02/2016", expected4, actual4);
    }

    @Test (expected = ValueNotFoundException.class)
    public void readExpirationFailTest() throws ValueNotFoundException {
        readExpiration("naMe:MilK;Type:;type:;expiration:##\n");
    }

    @Test
    public void splitByLineTest(){
        //Given
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        expected.add("naME:BreaD;price:1.23;type:Food;expiration:1/02/2016");

        //When
        ArrayList<String> actual = splitByLine("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");

        //Then
        assertEquals("The two strings returned by splitByLine should equal the expected values", expected, actual);
    }
    
}
