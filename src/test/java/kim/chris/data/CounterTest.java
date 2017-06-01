package kim.chris.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void toStringTest(){
        //Given
        Counter milk = new Counter("Milk");
        Item item = new Item("Milk", 3.23, "Food", "1/25/2016");
        milk.addItem(item);
        String expected = "name:    Milk\t\tseen: 1 time\n" +
                "=============\t\t=============\n" +
                "Price:   3.23\t\tseen: 1 time\n\n";
        //When
        String actual = milk.toString();

        //Then
        assertEquals("Strings should match", expected, actual);
    }
}
