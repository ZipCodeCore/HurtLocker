import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by johncollins on 2/8/17.
 */
public class testClass
{
    String raw;
    JerkSONparser testParser;
    ArrayList<String> groupArray;

    @Before
    public void setUp() throws Exception
    {
        raw = (new Main()).readRawDataToString();
        testParser = new JerkSONparser();
        groupArray = new ArrayList<String>();
        groupArray.add("naME:BreaD;price:1.23;type:Food@expiration:1/02/2016");

    }

    @Test
    public void byGroupsTest()
    {
        testParser.byGroups(raw);
        System.out.println(testParser.byGroups(raw));
        int actual = testParser.byGroups(raw).size();
        int expected = 28;
        //int expected = -1;//fail test
        assertEquals("should return arrays of groups between ##, without ##", expected, actual);
    }

    @Test
    public void formatItemsPunctuationTest()
    {
        //testParser.formatItemsPunctuation(groupArray);
        //System.out.println(testParser.formatItemsPunctuation(groupArray));

        String actual = testParser.formatItemsPunctuation(groupArray);
        String expected = "naME:BreaD,price:1.23,type:Food,expiration:1/02/2016";
        assertEquals("should return number of items...8?", expected, actual);
    }

    @Test
    public void correctKeysSpellingTest()
    {
        String actual = testParser.correctKeysSpelling(groupArray);
        String expected = "fail";//fail test
        //String expected = "name:BreaD;price:1.23;type:Food@expiration:1/02/2016";
        assertEquals("should return 'name' correct spelling & lower case", expected, actual);
    }

    @Test
    public void correctValuesSpellingTest()
    {
        String actual = testParser.correctValuesSpelling(groupArray);
        String expected = "fail";//fail test
        assertSame("should return with 'Bread' correct", expected, actual);
    }


    @Test
    public void itemXgroupParserTest()
    {
        testParser.itemXgroupParser(raw);
        System.out.println(testParser.itemXgroupParser(raw));

    }

    @Test
    public void errorCorrectorTest()
    {
        //System.out.println(testParser.errorCorrector(raw));

    }
}
