import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by andrewwong on 5/31/17.
 */
public class TestMapFactory {

    @Test
    public void testCreateItemMap() {
        // Given
        Stream<String> namesStream = Stream.of("milk", "cookies", "milk");
        Stream<String> pricesStream = Stream.of("3.23", "1.20", "3.00");

        // When
        HashMap<String, ArrayList<String>> itemMap = MapFactory.createItemMap(namesStream, pricesStream, 3);

        // Then
        assertEquals("3.23", itemMap.get("milk").get(0));
        assertEquals("3.00", itemMap.get("milk").get(1));
        assertEquals("1.20", itemMap.get("cookies").get(0));

    }

    @Test
    public void testCreatePriceMap() {
        // Given
        ArrayList<String> prices = new ArrayList<>();
        prices.add("4.20");
        prices.add("3.00");
        prices.add("4.20");
        prices.add("3.00");
        prices.add("4.20");
        HashMap<String, Integer> expectedPriceMap = new HashMap<>();
        expectedPriceMap.put("4.20", 3);
        expectedPriceMap.put("3.00", 2);

        // When
        HashMap<String, Integer> actualPriceMap = MapFactory.createPriceMap(prices);

        // Them
        assertEquals(expectedPriceMap, actualPriceMap);
    }
}
