import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johncollins on 2/8/17.
 */
public class testClass
{
    String raw;
    JerkSONparser testParser;

    @Before
    public void setUp() throws Exception
    {
        raw = (new Main()).readRawDataToString();
        testParser = new JerkSONparser();
    }

    @Test
    public void byGroupsTest()
    {
        testParser.byGroups(raw);
        System.out.println(testParser.byGroups(raw));
        int actual = testParser.byGroups(raw).size();
        int expected = 28;
        //int expected = -1;//fail test
        assertEquals("should return groups between ## without ##", expected, actual);
    }

    @Test
    public void extractItemsTest()
    {
        testParser.extractItems(testParser.byGroups(raw));
        System.out.println(testParser.extractItems(testParser.byGroups(raw)));
        int actual = testParser.extractItems(testParser.byGroups(raw)).size();
        int expected = 8;
        assertEquals("should return number of items...8?", expected, actual);


    }
}
