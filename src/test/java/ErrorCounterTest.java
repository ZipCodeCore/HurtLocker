import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ErrorCounterTest {

    @Test
    public void errorCounterTest() throws Exception {
        ErrorCounter errorCounter = new ErrorCounter();
        String[] strings = {"235827658274:;", "23857287562", "2938572875:;"};
        String expected = "Number of errors: 2";
        String actual = errorCounter.errorCounter(strings);

        Assert.assertEquals(expected,actual);
    }
}