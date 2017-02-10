package collins.john;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by johncollins on 2/10/17.
 */
public class DisplayFormatterTest
{
    String raw;
    JerkSONparser testParser;
    DisplayFormatter testFormatter;
    ArrayList<Map<String, String>> testFinalArray;


    @Before
    public void setUp() throws Exception
    {
        raw = (new Main()).readRawDataToString();
        testParser = new JerkSONparser();
        testFormatter = new DisplayFormatter();
        ArrayList<String> tempTestArray = testParser.separateByGroups(raw);
        testParser.correctStringsFromByGroups(tempTestArray);
        testFinalArray = testParser.convertGroupsToMaps(tempTestArray);
        System.out.println(tempTestArray.toString());
    }

    @Test
    public void aggragateDataTest()
    {
        testFormatter.aggregateData(testFinalArray);
        for (Map<String, String> item : testFinalArray
                )
        {
            System.out.println(item.entrySet());
        }
        System.out.println(testFormatter.applesCounter);
        System.out.println(testFormatter.breadCounter);
        System.out.println(testFormatter.cookiesCounter);
        System.out.println(testFormatter.milkCounter);
        System.out.println(testFormatter.errorCounter);

        System.out.println(testFormatter.applePrice);
        System.out.println(testFormatter.breadPrice);
        System.out.println(testFormatter.cookiesPrice);
        System.out.println(testFormatter.milkPrice);


        int actual = testFormatter.errorCounter;
        //int expected = -1;//fail test
        int expected = 4;
        assertEquals("should return...", expected, actual);
    }
}
