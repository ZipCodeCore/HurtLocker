package collins.john;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by johncollins on 2/8/17.
 */
public class JerkSONParserTest
{
    String raw;
    JerkSONparser testParser;
    ArrayList<String> groupArray;
    ArrayList<String> valuesArray;

    @Before
    public void setUp() throws Exception
    {
        raw = (new Main()).readRawDataToString();
        testParser = new JerkSONparser();
        groupArray = new ArrayList<String>();
        valuesArray = new ArrayList<String>();
        groupArray.add("naME:BreaD;price:1.23;type:Food@expiration:1/02/2016");
        valuesArray.add("bRood,malK,fiid,c00klos");

    }

    @Test
    public void separateByGroupsTest()
    {
        testParser.separateByGroups(raw);
        //System.out.println(testParser.separateByGroups(raw));
        int actual = testParser.separateByGroups(raw).size();
        int expected = 28;
        //int expected = -1;//fail test
        assertEquals("should return arrays of String groups between ##, without ##", expected, actual);
    }

    @Test
    public void correctStringsFromSeparateByGroupsTest()
    {
        ArrayList<String> tempTestArray = testParser.separateByGroups(raw);
        testParser.correctStringsFromByGroups(tempTestArray);
        String actual = (tempTestArray.get(0) + " " + tempTestArray.get(1)).toString();
        //System.out.println(tempTestArray);
        //String expected = "fail";//fail test
        String expected = "name:Milk,Price:3.23,type:Food,expiration:1/25/2016 name:Bread,Price:1.23,type:Food,expiration:1/02/2016";
        assertEquals("should return all corrected, ready for toMap", expected, actual);
    }

    @Test
    public void convertGroupsToMapsTest()
    {
        ArrayList<Map<String, String>> testFinalArray;
        ArrayList<String> tempTestArray = testParser.separateByGroups(raw);
        testParser.correctStringsFromByGroups(tempTestArray);
        testFinalArray = testParser.convertGroupsToMaps(tempTestArray);
        System.out.println(tempTestArray.toString());
        int actual = testFinalArray.size();
        //int expected = -1;//fail test
        int expected = 28;
        assertEquals("should return 28", expected, actual);
    }

    /*
    @Test
    public void formatItemsPunctuationTest()
    {
        //testParser.formatItemsPunctuation(groupArray);
        //System.out.println(testParser.formatItemsPunctuation(groupArray));
        System.out.println(groupArray.toString());
        testParser.formatItemsPunctuation(groupArray);
        String actual = groupArray.toString();

        String expected = "naME:BreaD,price:1.23,type:Food,expiration:1/02/2016";
        assertEquals("should return number of items...8?", expected, actual);
    }
*/
    /*
        @Test
        public void correctKeysSpellingTest()
        {
            String actual = testParser.correctKeysSpelling(groupArray);
            String expected = "fail";//fail test
            //String expected = "name:BreaD;price:1.23;type:Food@expiration:1/02/2016";
            assertEquals("should return 'name' correct spelling & lower case", expected, actual);
        }
    */
    /*
    @Test
    public void correctValuesSpellingTest()
    {
        String actual = testParser.correctValuesSpelling(valuesArray);
        //String expected = "fail";//fail test
        String expected = "Bread,Milk,Food,Cookies";
        assertEquals("should return with 'Bread' etc correct", expected, actual);
    }




    @Test
    public void itemXgroupParserTest()
    {
        testParser.itemXgroupParser(raw);
        System.out.println(testParser.itemXgroupParser(raw));

    }
*/

}
