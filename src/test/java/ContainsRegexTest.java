import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsRegexTest {

    @Test
    public void containsRegexTrueTest() {
        ContainsRegex containsRegex = new ContainsRegex();
        String string = "tTTt";
        String pattern = "[tT][tT][tT][tT]";

        Assert.assertTrue(containsRegex.containsRegex(string, pattern));
    }

    @Test
    public void containsRegexFalseTest() {
        ContainsRegex containsRegex = new ContainsRegex();
        String string = "tTTt";
        String pattern = "[tT][tT][cC][tT]";

        Assert.assertFalse(containsRegex.containsRegex(string, pattern));
    }
}