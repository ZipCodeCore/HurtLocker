import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringParserTest {

    StringParser parser;
    String data;

    @Before
    public void setUp() throws Exception {
        data = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##N";
        parser = new StringParser(data);
    }

    @Test
    public void findPattern() {
        String pattern = "##";
        Boolean actual = parser.findPattern(data,pattern);
        Assert.assertTrue(actual);

        pattern = "jj";
        actual = parser.findPattern(data,pattern);
        Assert.assertFalse(actual);

    }

    @Test
    public void matchedString() {
        String pattern = ":(.*?);";
        String text = "name:Milk;";

        String expected = "Milk";
        String actual = parser.matchedString(text,pattern);

        Assert.assertEquals(expected,actual);
    }
}