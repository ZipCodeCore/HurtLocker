import org.junit.Before;
import org.junit.Test;

public class PrintResultsTest {
    PrintResults printer;

    @Before
    public void setUp() throws Exception {
        printer = new PrintResults();
    }

    @Test
    public void printAllItems () {
        printer.printAllItems();
    }

    @Test
    public void printLines () {
        printer.printDoubleLines();
    }

    @Test
    public void printMilk() {
        printer.printMilk();
    }


}
