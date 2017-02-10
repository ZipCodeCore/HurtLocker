import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by andresholland on 2/8/17.
 */
public class ConverterTest {

    Converter converter;

    @Before
    public void setup () {
        converter = new Converter();
    }

    @Test
    public void executeLengthTest () {
        int expected = 3;
        int actual = converter.execute("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##").size();
        assertEquals(expected, actual);
    }

    @Test
    public void executeNameTest () {
        String expected = "Bread";
        Item actualItem = converter.execute("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##").get(2);
        String actual = actualItem.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void executePriceTest () {
        String expected = "1.23";
        Item actualItem = converter.execute("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##").get(1);
        String actual = actualItem.getPrice();
        assertEquals(expected, actual);
    }
}
