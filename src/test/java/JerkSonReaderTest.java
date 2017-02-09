import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;


/**
 * Created by randallcrame on 2/8/17.
 */
public class JerkSonReaderTest {

    JerkSonReader reader;
    String text;

    @Before
    public void setUp(){
        text = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
        reader = new JerkSonReader(text);
    }

    @Test
    public void ObjectValuesToArrayTest(){
        String expected ="[naMe:Milk;price:3.23;type:Food;expiration:1/25/2016, naME:BreaD;price:1.23;type:Food;expiration:1/02/2016]";
        String actual = Arrays.toString(reader.ObjectValuesToArray());
        Assert.assertEquals("Expected string prior to ## to return", expected, actual);
    }

    @Test
    public void ValuesToArrayTest(){
        String[] holder = reader.ObjectValuesToArray();
        String expected ="[naMe:Milk, price:3.23, type:Food, expiration:1/25/2016]";
        String actual = Arrays.toString(reader.ValuesToArray(holder[0]));
        Assert.assertEquals("Expected string prior to ; to return", expected, actual);
    }
    @Test
    public void ValuesToArray2Test(){
        String[] holder = reader.ObjectValuesToArray();
        String expected ="[naME:BreaD, price:1.23, type:Food, expiration:1/02/2016]";
        String actual = Arrays.toString(reader.ValuesToArray(holder[1]));
        Assert.assertEquals("Expected string prior to ; to return", expected, actual);
    }

    @Test
    public void ValuesToKeyAndValueTest(){
        String[] holder = reader.ObjectValuesToArray();
        String[] vholder = reader.ValuesToArray(holder[1]);
        String expected ="[naME, BreaD]";
        String actual = Arrays.toString(reader.ValuesToKeyAndValue(vholder[0]));
        Assert.assertEquals("Expected string prior to : to return", expected, actual);
    }

    @Test
    public void createItemTest(){
        String[] holder = reader.ObjectValuesToArray();
        String expected = "Milk";
        String actual = reader.createItem(holder).getClass().getSimpleName();
        Assert.assertEquals("Expected Class name Milk to return", expected, actual);
    }
}
