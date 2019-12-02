package jerkson.utils;

import org.junit.Assert;
import org.junit.Test;

public class TestStringUtils {
    @Test
    public void testToUpper() {
        String tester = "abcde";
        String out = StringUtils.toUpper(tester);
        System.out.println(tester + " " + out);
        Assert.assertEquals("ABCDE", out);
    }

    @Test
    public void testToUpper2() {
        String tester = "aBdcGehD";
        String out = StringUtils.toUpper(tester);
        System.out.println(tester + " " + out);
        Assert.assertEquals("ABDCGEHD", out);
    }

    @Test
    public void testToLower() {
        String tester = "ABCDEG";
        String out = StringUtils.toLower(tester);
        System.out.println(tester + " " + out);
        Assert.assertEquals("abcdeg", out);
    }

    @Test
    public void testToLower2() {
        String tester = "aBdcGehD";
        String out = StringUtils.toLower(tester);
        System.out.println(tester + " " + out);
        Assert.assertEquals("abdcgehd", out);
    }
}
