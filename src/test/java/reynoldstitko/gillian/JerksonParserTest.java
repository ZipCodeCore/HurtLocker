package reynoldstitko.gillian;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by gillianreynolds-titko on 2/8/17.
 */
public class JerksonParserTest {

    JerksonParser jerksonParser;

    @Before
    public void setUp(){

        jerksonParser = new JerksonParser();
    }


    @Test
    public void splitIncomingStringFileTest() {
        String input = "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        String[] expected = {"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016", "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016"};
        String[] actual = jerksonParser.splitIncomingStringFile(input, "##");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void findGroceryItemsTest(){
        String[] input = {"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016", "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016"};
        ArrayList<String> expected = new ArrayList<>();
        expected.add("B");
        expected.add("M"); //Expect an array with (B, M)
        ArrayList<String> actual = jerksonParser.findGroceryItems(input);
        assertEquals("Expect arrays to be equal", expected, actual);
    }

    @Test
    public void findItemPricesTest(){
        String[] input = {"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016", "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016"};
        ArrayList<String> expected = new ArrayList<>();
        expected.add("1.23");
        expected.add("3.23");
        ArrayList<String> actual = jerksonParser.findItemPrices(input);
        assertEquals("Expect the arrays to be equal",expected, actual);
    }

    @Test
    public void combineItemsAndPricesTest() throws StringMismatchException{
    ArrayList<String> inputPrices = new ArrayList<>();
    inputPrices.add("3.23");
    inputPrices.add("1.23");
    inputPrices.add("0.23");
    inputPrices.add("2.25");
    ArrayList<String> inputItems = new ArrayList<>();
    inputItems.add("M");
    inputItems.add("C");
    inputItems.add("a");
    inputItems.add("b");
    ArrayList<String> expected = new ArrayList<>();
    expected.add("Milk 3.23");
    expected.add("Cookies 1.23");
    expected.add("Apples 0.23");
    expected.add("Bread 2.25");
    ArrayList<GroceryItem> actual = jerksonParser.combineItemsAndPrices(inputItems, inputPrices);
    assertEquals("Expect the arrays to be equal",expected, actual);
    }

    @Test(expected = StringMismatchException.class) //expect an error
    public void combineNullPricesAndItemsTest() throws StringMismatchException{
        ArrayList<String> inputPrices = new ArrayList<>();
        inputPrices.add("3.23");
        inputPrices.add(null);
        inputPrices.add("0.23");
        inputPrices.add("2.25");
        ArrayList<String> inputItems = new ArrayList<>();
        inputItems.add("M");
        inputItems.add("C");
        inputItems.add("a");
        inputItems.add("b");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Milk 3.23");
        expected.add("Cookies 1.23");
        expected.add("Apples 0.23");
        expected.add("Bread 2.25");
        ArrayList<GroceryItem> actual = jerksonParser.combineItemsAndPrices(inputItems, inputPrices);
    }

    @Test(expected = StringMismatchException.class) //expect an error
    public void combineNullItemsAndPricesTest() throws StringMismatchException{
        ArrayList<String> inputPrices = new ArrayList<>();
        inputPrices.add("3.23");
        inputPrices.add("1.23");
        inputPrices.add("0.23");
        inputPrices.add("2.25");
        ArrayList<String> inputItems = new ArrayList<>();
        inputItems.add("M");
        inputItems.add(null);
        inputItems.add("a");
        inputItems.add("b");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Milk 3.23");
        //expected.add("Cookies 1.23");
        expected.add("Apples 0.23");
        expected.add("Bread 2.25");
        ArrayList<GroceryItem> actual = jerksonParser.combineItemsAndPrices(inputItems, inputPrices);
    }

    @Test
    public void findItemPricesMapTest(){

    }


    @Test
    public void createGroceryItemsArrayTest(){

    }

    @Test
    public void refactorNamesTest(){
        String input = "b";
        String actual = "Bread";
        String expected = jerksonParser.refactorNames(input);
        assertEquals("Expect to get 'Bread'", expected, actual);
    }

    @Test
    public void refactorNamesNonexistingLetterTest(){
        String input = "Z";
        String actual = "Z";
        String expected = jerksonParser.refactorNames(input);
        assertEquals("Expect to get 'Z'", expected, actual);
    }


}

