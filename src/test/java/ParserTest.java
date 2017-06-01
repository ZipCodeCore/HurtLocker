import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by sarahweisser on 5/31/17.
 */
public class ParserTest {

    String itemString;
    Parser parser;
    String singleItemString;
    String missingInfoString;

    @Before
    public void setUpTests() {
        itemString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##";;
        parser = new Parser();
        singleItemString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        missingInfoString = "naMe:;price:3.23;type:Food;expiration:1/04/2016##";
    }

    @Test
    public void doubleHashSplitterTest(){
        //given
        int expected = 3;

        //when
        int actual = parser.itemStrings(itemString).length;

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itemInfoSplitter() {
        //given
        String[] expected = {"naMe", "Milk", "price", "3.23", "type", "Food", "expiration", "1/25/2016"};

        //when
        String[] actual = parser.itemStringInfo(singleItemString);

        //then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void itemInfoSplitterWithMissingInfo() {
        //given
        String[] expected = {"naMe", "", "price", "3.23", "type", "Food", "expiration", "1/04/2016"};

        //when
        String[] actual = parser.itemStringInfo(missingInfoString);

        //then
        Assert.assertArrayEquals(expected, actual);
    }


}
