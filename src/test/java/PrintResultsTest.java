import org.junit.Before;
import org.junit.Test;

public class PrintResultsTest {
    PrintResults printer;

    @Before
    public void setUp() throws Exception {
        printer = new PrintResults();

    }

    @Test
    public void printMilk() {
        printer.printMilk();
    }

    @Test
    public void printLines () {
        printer.printDoubleLines();
    }
}
