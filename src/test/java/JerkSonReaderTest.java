import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;


/**
 * Created by randallcrame on 2/8/17.
 */
public class JerkSonReaderTest {

    JerkSonReader reader, reader2, reader3;
    String text, text2, text3;

    @Before
    public void setUp(){
        text = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
        text2 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
                "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##" +
                "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##" +
                "naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##" +
                "naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##" +
                "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##" +
                "naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##" +
                "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##" +
                "naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##" +
                "naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##" +
                "naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##" +
                "naMe:;price:3.23;type:Food;expiration:1/04/2016##" +
                "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##" +
                "naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##" +
                "NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##" +
                "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##" +
                "naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##" +
                "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##";
        text3 = "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##";

        reader3 = new JerkSonReader(text);
        reader = new JerkSonReader(text2);
        reader2 = new JerkSonReader(text3);
    }

    @Test
    public void ObjectValuesToArrayTest(){
        String expected ="[naMe:Milk;price:3.23;type:Food;expiration:1/25/2016, naME:BreaD;price:1.23;type:Food;expiration:1/02/2016]";
        String actual = Arrays.toString(reader3.ObjectValuesToArray());
        Assert.assertEquals("Expected string prior to ## to return", expected, actual);
    }

    @Test
    public void ValuesToArrayTest(){
        String[] holder = reader.ObjectValuesToArray();
        String expected ="[naMe:Milk, price:3.23, type:Food, expiration:1/25/2016]";
        String actual = Arrays.toString(reader.ValuesToArray(holder[0]));
        Assert.assertEquals("Expected string prior to ; to return", expected, actual);
    }
    @Test
    public void ValuesToArray2Test(){
        String[] holder = reader.ObjectValuesToArray();
        String expected ="[naME:BreaD, price:1.23, type:Food, expiration:1/02/2016]";
        String actual = Arrays.toString(reader.ValuesToArray(holder[1]));
        Assert.assertEquals("Expected string prior to ; to return", expected, actual);
    }

    @Test
    public void ValuesToKeyAndValueTest(){
        String[] holder = reader.ObjectValuesToArray();
        String[] vholder = reader.ValuesToArray(holder[1]);
        String expected ="[naME, BreaD]";
        String actual = Arrays.toString(reader.ValuesToKeyAndValue(vholder[0]));
        Assert.assertEquals("Expected string prior to : to return", expected, actual);
    }

    @Test
    public void createItemTest(){
        String[] holder = reader.ObjectValuesToArray();
        String expected = "Milk";
        String actual = reader.createItem(holder[0]).getName();
        Assert.assertEquals("Expected Class name Milk to return", expected, actual);
    }

    @Test
    public void convertDataToGroceriesTest(){
        int expected = 18;
        int actual = reader.convertDataToGroceries().size();
        Assert.assertEquals("Expect a ArrayList size of 18", expected, actual);
    }

    @Test
    public void convertDataToGroceriesContentTest(){
        String expected = "Milk";
        String actual = reader.convertDataToGroceries().get(3).getName();
        Assert.assertEquals("Expect a ArrayList 4th item's name to be Milk", expected, actual);
    }

    @Test
    public void convertDataToGroceriesContentCarrotTest(){
        String expected = "Food";
        String actual = reader.convertDataToGroceries().get(3).getType();
        Assert.assertEquals("Expect a ArrayList 4th item's type to be Food, ^ split worked", expected, actual);
    }

    @Test
    public void convertDataToGroceriesContentPercentTest(){
        String expected = "Food";
        String actual = reader.convertDataToGroceries().get(4).getType();
        Assert.assertEquals("Expect a ArrayList 5th item's type to be Food, % split worked", expected, actual);
    }

    @Test
    public void convertDataToGroceriesContentAsteriskTest(){
        String expected = "Food";
        String actual = reader.convertDataToGroceries().get(5).getType();
        Assert.assertEquals("Expect a ArrayList 5th item's type to be Food, * split worked", expected, actual);
    }

    @Test
    public void convertDataToGroceriesContentExclamationTest(){
        String expected = "Food";
        String actual = reader.convertDataToGroceries().get(9).getType();
        Assert.assertEquals("Expect a ArrayList 5th item's type to be Food, ! split worked", expected, actual);
    }

    @Test
    public void convertDataToGroceriesContentAtTest(){
        String expected = "Food";
        String actual = reader.convertDataToGroceries().get(14).getType();
        Assert.assertEquals("Expect a ArrayList 5th item's type to be Food, ! split worked", expected, actual);
    }
    @Test
    public void createItemNullTest(){
        String[] holder = reader.ObjectValuesToArray();
        GroceryItem actual = reader.createItem(holder[13]);
        Assert.assertNull("Expect a null to be returned since there is no name", actual);
    }

    @Test
    public void convertDataToGroceriesContentEmptyNotAddedTest(){
        int expected = 18;
        int actual = reader.convertDataToGroceries().size();
        Assert.assertEquals("Expect size of array generated to be 16, 2 errors", expected, actual);
    }

    @Test
    public void convertDataToGroceriesContentErrorCounterTest(){
        reader.convertDataToGroceries();
        int expected = 2;
        int actual = reader.getErrors();
        Assert.assertEquals("Expect a null to be returned since there is no name and another with no price", expected, actual);
    }

    @Test
    public void convertDataToGroceriesContentCookieRegexTest(){
        String expected = "Cookies";
        String actual = reader2.convertDataToGroceries().get(0).getName();
        Assert.assertEquals("Expect a ArrayList 5th item's type to be Food, ! split worked", expected, actual);
    }
}
