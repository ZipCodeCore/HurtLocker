import org.junit.Assert;
import org.junit.Test;

public class LineSeparatorTest {

    @Test
    public void separateTextAtNewLinesTest() {
        String text = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";

        String[] expected = {"naMe:Milk;price:3.23;type:Food;expiration:1/25/2016",
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016",
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016"};

        String[] actual = LineSeparator.separateTextAtNewLines(text);

        Assert.assertArrayEquals(expected, actual);
    }
}
