package kim.chris;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static kim.chris.JerkSONParser.*;
import static org.junit.Assert.*;

public class JerkSONParserTest {
    String rawData;
    String output;
    String firstLine;

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
        firstLine = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
    }

    @Test
    public void parseJerkTest(){
        //Given
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(new Item("Milk", 3.23, "Food", "1/25/2016"));

        //When
        ArrayList<Item> actual = parseJerk(firstLine);

        //Then
        assertEquals("Generated list should match", expected, actual);
    }

    @Test
    public void parseItemTest(){
        //Given
        Item expected = new Item("Milk", 3.23, "Food", "1/25/2016");

        //When
        Item actual = parseItem(firstLine);

        //Then
        assertEquals("Line one of the file should be parsed correctly to Item(Milk, 3.23, Food, 1/25/2016)", expected, actual);
    }

    @Test
    public void listToStringTest(){
        //Given
        Item item = new Item("Milk", 3.23, "Food", "1/25/2016");
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(item);
        String expected = "name:    Milk \t\t seen: 1 time\n" +
                "============= \t\t =============\n" +
                "Price: \t 3.23\t\t seen: 1 times\n" +
                "-------------\t\t -------------\n";

        //When
        String actual = listToString(list);

        //Then
        assertEquals("Output strings should match", expected, actual);
    }
}
