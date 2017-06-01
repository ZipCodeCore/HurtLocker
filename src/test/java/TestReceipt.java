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
    public void testToString() {
        // Given
        String expected = "name:    milk\t\tseen: 2 times\n" +
                "=============\t\t=============\n" +
                "price:   3.23\t\tseen: 1 times\n" +
                "=============\t\t=============\n" +
                "price:   3.00\t\tseen: 1 times\n" +
                "=============\t\t=============\n" +
                "name: cookies\t\tseen: 2 times\n" +
                "=============\t\t=============\n" +
                "price:   1.20\t\tseen: 2 times\n" +
                "=============\t\t=============\n" +
                "Errors       \t\tseen: 1 times";

        Stream<String> namesStream = Stream.of("milk", "cookies", "milk", "cookies", null, "milk");
        Stream<String> pricesStream = Stream.of("3.23", "1.20", "3.00", "1.20", "33.33", null);

        HashMap<String, ArrayList<String>> itemMap = MapFactory.createItemMap(namesStream, pricesStream, 5);
        Receipt receipt = new Receipt(itemMap);
        // When
        String actual = receipt.toString();
        System.out.println(actual);

        // Then
        assertEquals(expected, actual);
    }
}
