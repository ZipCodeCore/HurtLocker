package ibikunle.tolani;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by tolaniibikunle on 2/15/17.
 */
public class PrinterTest {
    Printer printer;
    GroceryFactory groceryFactory;
    JerkSonParser jerkSonParser;


    @Before
    public void setUp() {
        printer = new Printer();
        jerkSonParser = new JerkSonParser();
        ArrayList<GroceryItem> groceryItems = jerkSonParser.makeGroceryList(new Data().rawData); // making the data object and immediately
        //grabbing the raw data adn passing it to the method makeGrocery List

    }
    @Test
    public void printerTest(){
        String expected = "";
        String actual = printer.printOutput();
        System.out.println(actual);
        //Assert.assertEquals("I am expecting this format to print out",expected,actual);
    }
}
