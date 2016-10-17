package crawley.james.hurtlocker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 10/17/16.
 */
public class HurtLockerTests {

    private Main main = new Main ();
    private String raw;
    private JerkSONParser parser;
    private String separator0 = "=============\n";
    private String separator1 = "-------------\n";

    @Before
    public void initialize () {

        try {
            raw = main.readRawDataToString();
        } catch (Exception e) {
            raw = "";
        }
        parser = new JerkSONParser(raw);
        try {
            parser.parseItem();

        } catch (DataMissingException e) {
            parser.next();

        }
        parser.putItem();
    }

    @Test
    public void parseItemTest () {

        String actual =  parser.getParsedItem().toString();
        String expected =  "[naMe:, Milk;, price:, 3.23;, type:, Food;, expiration:, 1/25/2016]";

        assertEquals("The array should be printed out as " +
                "[naMe:, Milk;, price:, 3.23;, type:, Food;, expiration:, 1/25/2016]", expected, actual);

    }

    @Test
    public void getItemNameTest () {

        String actual = parser.getItemName();

        assertEquals("The name should be Milk", "Milk", actual);

    }

    @Test
    public void getItemPriceTest () {

        String actual = parser.getItemPrice();

        assertEquals("The price should be 3.23", "3.23", actual);

    }

    @Test
    public void putItemTest () {


        String expected = "{Apples=[0.25, 0.23, 0.25, 0.23], " +
                "Cookies=[2.25, 2.25, 2.25, 2.25, 2.25, 2.25, 2.25, 2.25], " +
                "Milk=[3.23, 3.23, 3.23, 1.23, 3.23, 3.23, 3.23], " +
                "Bread=[1.23, 1.23, 1.23, 1.23, 1.23, 1.23, 1.23, 1.23, 1.23]}";

        while (parser.hasNext()) {
            try {
                parser.parseItem();
            } catch (DataMissingException e) {
                parser.next();
            }
            parser.putItem();
        }

        String actual = parser.getInventory().toString();

        assertEquals("The Map should be printed out as {Apples=[0.25, 0.23, 0.25, 0.23], " +
                "Cookies=[2.25, 2.25, 2.25, 2.25, 2.25, 2.25, 2.25, 2.25], " +
                "Milk=[3.23, 3.23, 3.23, 1.23, 3.23, 3.23, 3.23], " +
                "Bread=[1.23, 1.23, 1.23, 1.23, 1.23, 1.23, 1.23, 1.23, 1.23]}", expected, actual);

    }
}