import com.sun.javafx.tools.packager.PackagerException;
import jdk.nashorn.internal.runtime.ParserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.StringTokenizer;

public class TestJerkSONParser {
    JerkSONParser jp;
    String testData;


    @Before
    public void init() throws FileNotFoundException {
        testData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";
        jp = new JerkSONParser(testData);
    }

    @Test
    public void findPattern1(){
        String pattern = "##";
        Boolean actual = jp.findPattern(testData,pattern);
        Assert.assertTrue(actual);
    }

    @Test
    public void findPattern2(){
        String pattern = "qg";
        Boolean actual = jp.findPattern(testData,pattern);
        Assert.assertFalse(actual);
    }


    @Test
    public void matchedString(){
        String pattern = ":(.*?);";
        String test = "type:Food;";

        String expected = "Food";
        String actual = jp.matchedString(test, pattern);

        Assert.assertEquals(expected,actual);
    }


}






