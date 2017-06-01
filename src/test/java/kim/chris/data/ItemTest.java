package kim.chris.data;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {


    @Test
    public void equalsTest(){
        //Given
        Item item1 = new Item("Milk", 3.23, "Food", "1/25/2016");
        Item item2 = new Item("Milk", 3.23, "Food", "1/25/2016");

        //Then
        assertTrue(item1.equals(item2));
    }
}
