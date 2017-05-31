import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by andrewwong on 5/31/17.
 */
public class TestItem {

    @Test
    public void testAddPriceToItem(){
        // Given
        String expectedPriceOne = "3.23";
        String expectedPriceTwo = "1.23";
        Item item = new Item("milk", expectedPriceOne);

        // When
        item.addPriceToItem("1.23");
        String actualPriceOne = item.getPrices().get(0);
        String actualPriceTwo = item.getPrices().get(1);
        // Then
        assertEquals(expectedPriceOne, actualPriceOne);
        assertEquals(expectedPriceTwo, actualPriceTwo);
    }

    @Test
    public void testIsSeenAgain() {
        // Given
        Item item = new Item("milk", "3.23");

        // When
        item.isSeenAgain();

        // Then
        assertEquals(2, item.getTimesSeen());
    }
}
