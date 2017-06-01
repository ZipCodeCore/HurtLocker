import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
/**
 * Created by andrewwong on 5/31/17.
 */
public class TestReceipt {

    @Test
    public void addItemToReceipt() {
        // Given
        String expected = "name:    Milk \t\t seen: 6 times\n" +
                "============= \t \t =============\n" +
                "Price: \t 3.23\t\t seen: 5 times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: 1 time\n" +
                "\n" +
                "name:   Bread\t\t seen: 6 times\n" +
                "=============\t\t =============\n" +
                "Price:   1.23\t\t seen: 6 times\n" +
                "-------------\t\t -------------\n" +
                "\n" +
                "name: Cookies     \t seen: 8 times\n" +
                "=============     \t =============\n" +
                "Price:   2.25        seen: 8 times\n" +
                "-------------        -------------\n" +
                "\n" +
                "name:  Apples     \t seen: 4 times\n" +
                "=============     \t =============\n" +
                "Price:   0.25     \t seen: 2 times\n" +
                "-------------     \t -------------\n" +
                "Price:   0.23  \t \t seen: 2 times\n" +
                "\n" +
                "Errors         \t \t seen: 4 times";

        Stream<String> namesStream = Stream.of("milk", "cookies", "milk");
        Stream<String> pricesStream = Stream.of("3.23", "1.20", "3.00");

        HashMap<String, ArrayList<String>> itemMap = ItemFactory.createItemMap(namesStream, pricesStream, 3);
        Receipt receipt = new Receipt(itemMap);
        // When
        String actual = receipt.toString();

        // Then
        assertEquals(expected, actual);
    }
}
