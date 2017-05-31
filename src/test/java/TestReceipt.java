import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by andrewwong on 5/31/17.
 */
public class TestReceipt {

    @Test
    public void addItemToReceipt() {
        // Given
        Receipt receipt = new Receipt();
        String expectedNameOfItemOne = "milk";
        String expectedNameOfItemTwo = "cookies";

        // When
        receipt.addItemToReceipt(new Item("milk", "3.23"));
        receipt.addItemToReceipt(new Item("cookies", "1.23"));

        String actualNameOfItemOne = receipt.getItem(0).getName();
        String actualNameOfItemTwo = receipt.getItem(1).getName();

        // Then
        assertEquals(expectedNameOfItemOne, actualNameOfItemOne);
        assertEquals(expectedNameOfItemTwo, actualNameOfItemTwo);
    }
}
