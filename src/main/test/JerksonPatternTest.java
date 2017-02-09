import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andresholland on 2/8/17.
 */
public class JerksonPatternTest {

    JerksonPattern jerksonPattern;

    @Before
    public void setupTest () {
        jerksonPattern = new JerksonPattern();
    }

    @Test
    public void splitRawDataTest () {
    String actual = jerksonPattern.splitRawData("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;pr")[0];
    String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
    assertEquals(expected, actual);
    }

    @Test
    public void convertNameTest () {
        jerksonPattern.convertName("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        String actual = jerksonPattern.getCurrentName();
        String expected = "Milk";
        assertEquals(expected, actual);
    }

    @Test
    public void convertNameReturnTest () {
        String actual = jerksonPattern.convertName("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        String expected = "price:3.23;type:Food;expiration:1/25/2016";
        assertEquals(expected, actual);
    }

    @Test
    public void convertPriceTest () {
        jerksonPattern.convertPrice("price:3.23;type:Food;expiration:1/25/2016");
        String actual = jerksonPattern.getCurrentPrice();
        String expected = "3.23";
        assertEquals(expected, actual);
    }

    @Test
    public void convertPriceReturnTest () {
        String actual = jerksonPattern.convertPrice("price:3.23;type:Food;expiration:1/25/2016");
        String expected = "type:Food;expiration:1/25/2016";
        assertEquals(expected, actual);
    }

    @Test
    public void convertTypeTest () {
        jerksonPattern.convertType("type:Food;expiration:1/25/2016");
        String actual = jerksonPattern.getCurrentType();
        String expected = "Food";
        assertEquals(expected, actual);
    }

    @Test
    public void convertTypeReturnTest () {
        String actual = jerksonPattern.convertType("type:Food;expiration:1/25/2016");
        String expected = "expiration:1/25/2016";
        assertEquals(expected, actual);
    }

    @Test
    public void convertExpirationTest () {
        jerksonPattern.convertExpiration("expiration:1/25/2016");
        String actual = jerksonPattern.getCurrentExpiration();
        String expected = "1/25/2016";
        assertEquals(expected, actual);
    }

    @Test
    public void fixSpellingChangeNeededTest () {
        String actual = jerksonPattern.fixSpelling("C00kies");
        String expected = "Cookies";
        assertEquals(expected, actual);
    }

    @Test
    public void fixSpellingChangeNotNeededTest () {
        String actual = jerksonPattern.fixSpelling("C00kie");
        String expected = "C00kie";
        assertEquals(expected, actual);
    }

}
