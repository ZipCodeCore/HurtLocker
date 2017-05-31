import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by andrewwong on 5/31/17.
 */
public class TestItemFactory {

    @Test
    public void testCreateItemList() {
        // Given
        Stream<String> namesStream = Stream.of("milk", "cookies");
        Stream<String> pricesStream = Stream.of("3.23", "1.20");

        // When
        ArrayList<Item> items = ItemFactory.createItemList(namesStream, pricesStream);

        // Then
        assertEquals("milk", items.get(0).getName());
        assertEquals("cookies", items.get(1).getName());

    }
}
