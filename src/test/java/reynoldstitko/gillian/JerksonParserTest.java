package reynoldstitko.gillian;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by gillianreynolds-titko on 2/8/17.
 */
public class JerksonParserTest {

    JerksonParser jerksonParser;

    @Before
    public void setUp(){

        jerksonParser = new JerksonParser();
    }


    @Test
    public void splitIncomingStringFileTest() {
        String input = "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        String[] expected = {"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016", "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016"};
        String[] actual = jerksonParser.splitIncomingStringFile(input, "##");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void findGroceryItemTest(){
        String[] input = {"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016", "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016"};
        ArrayList<String> expected = new ArrayList<>();
        expected.add("NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016");
        //expected.add("naMe:MiLK;price:3.23;type:Food expiration:1/11/2016");

        ArrayList<String> actual = jerksonParser.findGroceryItem(input, "EA");
        assertEquals("Expect arrays to be equal", expected, actual);
    }

    @Test
    public void createIndividualGroceryItemsTest(){
        String[] incomingArray = {"name:Milk;price:1.23;type:Food;expiration:2/25/2016",
                "name:Cookies;price:2.25;type:Food;expiration:1/11/2016"};
        GroceryItem g1 = new GroceryItem("Milk", 1.23);
        GroceryItem g2 = new GroceryItem("Cookies", 2.25);
        GroceryItem[] expected = {g1, g2};
        GroceryItem[] actual = jerksonParser.createGroceryItemsArray(incomingArray, "##");
        assertSame(expected, actual);
    }

}

