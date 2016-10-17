package crawley.james.hurtlocker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 10/17/16.
 */
public class HurtLockerTests {

    private JerkSONParser parser = new JerkSONParser();
    private Main main = new Main ();
    private String raw;
    private String[] groceryList;
    private String separator0 = "=============\n";
    private String separator1 = "-------------\n";

    @Before
    public void initialize () {

        try {
            raw = main.readRawDataToString();
        } catch (Exception e) {
            raw = "";
        }

        groceryList = raw.split("##");
    }

    @Test
    public void parseItemTest () {

        parser.parseItem(groceryList[0]);
        String actual =  parser.getParsedItem().toString();
        String expected =  "[naMe:, Milk;, price:, 3.23;, type:, Food;, expiration:, 1/25/2016]";

        assertEquals("", expected, actual);

    }

    @Test
    public void getItemNameTest () {

    }

    @Test
    public void getItemPriceTest () {

    }
}