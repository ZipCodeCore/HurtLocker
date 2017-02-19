package ibikunle.tolani;

import ibikunle.tolani.JerkSonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static ibikunle.tolani.JerkSonParser.*;

/**
 * Created by tolaniibikunle on 2/11/17.
 */
public class JerkSonParserTest {
    JerkSonParser jerkSonParser;
    String sampleInput;
    GroceryItem item;
    String sampleInput1;


    @Before
    public void setUp(){
        sampleInput = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##\n";
        jerkSonParser = new JerkSonParser();
        item = new GroceryItem("BreaD","1,23","Food","1/02/2016");
        sampleInput1 =  "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##\n" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##\n" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##";
    }

    @Test
    public void splitterTest(){
        int expected = 3;
        int actual = jerkSonParser.splitStringIntoItems(sampleInput1).length;
        Assert.assertEquals("Not the correct number of indexes",expected,actual);
    }

    @Test
    public void parseItemTest() throws JerkSonException {
        String expected = item.getName().toLowerCase();
        String actual = jerkSonParser.parseItem(sampleInput).getName();
        Assert.assertEquals("Wrong value for name",expected,actual);
    }

    @Test(expected = JerkSonException.class)
    public void parseItemTestException() throws JerkSonException {
        String brokenInput = "naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        jerkSonParser.parseItem(brokenInput);
        System.out.println(brokenInput);
    }

    @Test
    public void parseItemFromMapTest(){
        HashMap<String,String> inputMap = new HashMap<>();
        inputMap.put("name","BreaD");
        inputMap.put("price","1.23");
        inputMap.put("type","food");
        inputMap.put("expiration","1/23/2016");
        String expected = item.getName();
        String actual = jerkSonParser.parseItemFromMap(inputMap).getName();
        Assert.assertEquals("",expected,actual);
    }

   @Test
    public void makeAGroceryListTest(){
       ArrayList<GroceryItem> testList = jerkSonParser.makeGroceryList(new Data().rawData);
       for (GroceryItem g:testList) {
           System.out.println(g.toString());

       }
       String expectedGroceryName = "bread";
       String actualGroceryName = jerkSonParser.makeGroceryList(sampleInput1).get(2).getName();
       Assert.assertEquals("I am expecting bread",expectedGroceryName,actualGroceryName);


   }


}
