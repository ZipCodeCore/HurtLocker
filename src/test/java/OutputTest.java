import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by zihaocastine on 5/24/16.
 */
public class OutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    @Test
    public void printTableTest(){
        ItemParser itemParser=new ItemParser();
        Output output=new Output();
        ArrayList<String> data = itemParser.jerkSonParser("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        ArrayList<Item> items=itemParser.storeData(data);
        String expectedPrintOut="name:    Milk        seen: 1 times\n" +
                "=============        ============= \n" +
                "Price:   3.23        seen: 1 times\n" +
                "-------------        ------------- \n" +
                "\n" +
                "name:   Bread        seen: 1 times\n" +
                "=============        ============= \n" +
                "Price:   1.23        seen: 1 times\n" +
                "-------------        ------------- \n" +
                "\n" +
                "Errors               seen: 0 times";
        output.printTable(items);
        Assert.assertEquals(expectedPrintOut,outContent.toString());

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
