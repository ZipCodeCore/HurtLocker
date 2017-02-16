package armstrong.alexandra;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static armstrong.alexandra.StringParse.*;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringParseTest {

    String test = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";


    @Before
    public void setUp(){
    }

    @Test
    public void cutStringTest(){
        String[] expected = {"Test", "Cut", "String"};
        String[] actual = StringParse.cutString("Test##Cut##String");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void regExTest(){
        StringParse.regEx(cutString(test));
        int expected = 2;
        int actual = StringParse.items.size();
        assertEquals(expected, actual);
    }

    @Test
    public void whichItemTest(){
        String expected = "Bread";
        String actual = StringParse.whichItem("b");
        assertEquals(expected, actual);
    }

    @Test
    public void addItemToListTest(){
        StringParse.addItemToList("m", "3.14");
        StringParse.addItemToList("m", "3.14");
        StringParse.addItemToList("b", "3.14");
        StringParse.addItemToList("b", "3.14");
        int actual = StringParse.items.size();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void checkForInvalidEntryTest(){
        assertTrue(StringParse.checkForInvalidEntry("milk", "3.12"));
    }

    @Test
    public void checkForInvalidEntryFalseTest(){
        StringParse.checkForInvalidEntry(null, null);
        int actual = StringParse.errorCounter;
        int expected = 1;
    }

    @Test
    public void checkForDuplicateNameTest(){
        GroceryItem item = new GroceryItem("Milk", "3.12");
        assertFalse(StringParse.checkForDuplicateName(item, "Bread", "3.22"));
        assertTrue(StringParse.checkForDuplicateName(item, "Milk", "3.12"));
    }
}
