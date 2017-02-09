import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryangross on 2/9/17.
 */
public class DisplayTest {
    Display testDisplay;

    @Before
    public void setUp() {
        testDisplay = new Display();
    }

    @Test
    public void addSpacesTest() {
        String smallWordTest = testDisplay.addSpaces("fud");
        String milkTest = testDisplay.addSpaces("milk");
        Assert.assertEquals(8, milkTest.length());
        Assert.assertEquals(8, smallWordTest.length());
    }

    @Test
    public void priceSpaceTest() {
        String smallWordTest = testDisplay.priceSpaces("fud");
        String milkTest = testDisplay.priceSpaces("milk");
        Assert.assertEquals(7, milkTest.length());
        Assert.assertEquals(7, smallWordTest.length());
    }
}
