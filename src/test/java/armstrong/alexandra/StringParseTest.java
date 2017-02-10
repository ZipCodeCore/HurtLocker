package armstrong.alexandra;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static armstrong.alexandra.StringParse.*;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class StringParseTest {

    String test = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";


    @Before
    public void setUp(){
    }

    @Test
    public void cutStringTest(){

    }

    @Test
    public void regExTest(){
        int expected = 2;
        int actual = StringParse.regEx(cutString(test)).size();
        assertEquals(expected, actual);
    }

    @Test
    public void whichItemTest(){
        GroceryItem item = whichItem("b", "2.34");
        String expected = "Bread";
        String actual = item.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void duplicateCheckTest(){
        ArrayList<GroceryItem> item = new ArrayList<>();
        item.add(whichItem("a", "4.32"));
        if(duplicateCheck(item, "b", "2.32") == false) {
            item.add(whichItem("b", "2.32"));
        }
        int actual = item.size();
        int expected = 2;
        assertEquals(expected, actual);
    }
}
