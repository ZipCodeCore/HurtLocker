import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by prestonbattin on 2/9/17.
 */
public class JerkSonTest {

    JerkSon jerk;
    String[] kvPairs;
    String[] string;

    @Before
    public void setUp(){
        jerk = new JerkSon();
         string = jerk.delimiterSplit(RawDataLocation.rawData);
         kvPairs = jerk.kVLineSplitter(string[0]);

    }


    @Test
    public void delimiterSplitTest(){

        String expected = "That";
        String[] actual = jerk.delimiterSplit("Testing##That##it##works");
        Assert.assertEquals("Testing the split method", expected, actual[1]);
    }

    @Test
    public void kVLineSplitterTest(){

        String expected = "naMe:Milk";
        String[] actual = jerk.kVLineSplitter("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        Assert.assertEquals("Testing splitting KV pairs", expected, actual[0]);
    }

    @Test
    public void getFieldsTest(){

        String expected = "[Milk, 3.23, Food, 1/25/2016]";
        String[] actual = jerk.getFields(kvPairs, Regex.patternArray);
        Assert.assertEquals("Testing getting feilds", expected, Arrays.toString(actual));
    }

    @Test
    public void makeGroceryItemTest(){

        String[] fields = jerk.getFields(kvPairs, Regex.patternArray);
       GroceryItem actual = jerk.makeGroceryItem(fields);
       GroceryItem expected = new GroceryItem("Milk", "3.23", "Food", "1/25/2016");
       Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void makeGroceryItemArrayTest(){

      GroceryItem[] actual = jerk.makeGroceryItemsArray(jerk.makeList(RawDataLocation.rawData));
      int expected = 28;
      Assert.assertEquals("Tesing the array of grocery items", expected, actual.length);

    }

    @Test
    public void makeListTest(){

        int expected = 28;
        List actual = jerk.makeList(RawDataLocation.rawData);
        Assert.assertEquals("Testing the correct size list is made", expected, actual.size());
    }

}
