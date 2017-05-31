package kim.chris.data;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Before
    public void initialize() {


    }

    @Test
    public void addItemTest(){
        //Given
        Item item = new Item("Milk", 3.23, "Food", "1/25/2016");
        Double expected = 1.23;


        //When
        item.addPrice(1.23);
        Double actual = item.getPrices().get(1);

        //Then
        assertEquals("Price should be added to end of arraylist", expected, actual);

    }

    @Test
    public void equalsTest(){
        //Given
        Item item1 = new Item("Milk", 3.23, "Food", "1/25/2016");
        Item item2 = new Item("Milk", 3.23, "Food", "1/25/2016");


        //Then
        assertTrue(item1.equals(item2));
    }
}
