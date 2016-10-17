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
                "Milk=[3.23, 3.23, 3.23, 1.23, 3.23, 3.23], " +
                "Bread=[1.23, 1.23, 1.23, 1.23, 1.23, 1.23]}";

        while (parser.hasNext()) {
            try {
                parser.parseItem();
                parser.putItem();
            } catch (DataMissingException e) {
                parser.next();
            }

        }

        String actual = parser.getInventory().toString();

        assertEquals("The Map should be printed out as {Apples=[0.25, 0.23, 0.25, 0.23], " +
                "Cookies=[2.25, 2.25, 2.25, 2.25, 2.25, 2.25, 2.25, 2.25], " +
                "Milk=[3.23, 3.23, 3.23, 1.23, 3.23, 3.23], " +
                "Bread=[1.23, 1.23, 1.23, 1.23, 1.23, 1.23]}", expected, actual);

    }

    @Test
    public void formatGroceryListTest () {

        String expected = "name:  Apples \t\t seen: 4 times\n" +
                "============= \t \t =============\n" +
                "Price: \t 3.23\t\t seen: 5 times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: 1 time\n" +
                "\n" +
                "name:  Cookies\t\t seen: 8 times\n" +
                "=============\t\t =============\n" +
                "Price:   1.23\t\t seen: 6 times\n" +
                "-------------\t\t -------------\n" +
                "\n" +
                "name:    Milk     \t seen: 6 times\n" +
                "=============     \t =============\n" +
                "Price:   2.25        seen: 8 times\n" +
                "-------------        -------------\n" +
                "\n" +
                "name:   Bread     \t seen: 6 times\n" +
                "=============     \t =============\n" +
                "Price:   0.25     \t seen: 2 times\n" +
                "-------------     \t -------------\n" +
                "Price:   0.23  \t \t seen: 2 times\n" +
                "\n" +
                "Errors         \t \t seen: 4 times";

        while (parser.hasNext()) {
            try {
                parser.parseItem();
                parser.putItem();
            } catch (DataMissingException e) {
                parser.next();
            }

        }

        System.out.println(parser.getErrors());

        assertEquals("Grocery ,ist should be formatted as it is in output.txt", expected, parser.printGroceryList());

    }
}