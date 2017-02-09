import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryangross on 2/8/17.
 */
public class JSONFixerTest {

    JSONFixer aJSONFixer;
    String testFeed = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
    String testLine = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
    @Before
    public void setUp() {
        aJSONFixer = new JSONFixer();
    }

    @Test
    public void breakLinesTest() {
        Assert.assertEquals(3, aJSONFixer.breakLines(testFeed).size());
        Assert.assertEquals("naME:BreaD;price:1.23", aJSONFixer.breakLines(testLine).get(0));
    }

    @Test
    public void wholeLineTest() {
        Assert.assertEquals(3, aJSONFixer.wholeLength(testFeed));
    }


}
