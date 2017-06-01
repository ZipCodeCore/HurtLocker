import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * Created by andrewwong on 5/31/17.
 */
public class TestItemFactory {

    @Test
    public void testCreateItemMap() {
        // Given
        Stream<String> namesStream = Stream.of("milk", "cookies", "milk");
        Stream<String> pricesStream = Stream.of("3.23", "1.20", "3.00");

        // When
        HashMap<String, ArrayList<String>> itemMap = ItemFactory.createItemMap(namesStream, pricesStream, 3);

        // Then
        assertEquals("3.23", itemMap.get("milk").get(0));
        assertEquals("3.00", itemMap.get("milk").get(1));
        assertEquals("1.20", itemMap.get("cookies").get(0));

    }
}
