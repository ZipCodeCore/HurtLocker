package reynoldstitko.gillian;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by gillianreynolds-titko on 2/9/17.
 */
public class DataPrintoutTest {

    DataPrintout dataPrintout = new DataPrintout();

//    @Test
//    public void printSummaryTableTest(){
//    String inputString = "name: Milk";
//        Set<GroceryItem> groceryItems;
//        ArrayList<GroceryItem> grocery = new ArrayList<>();
//
//        GroceryItem groceryItem1 = new GroceryItem("Milk", "3.23");
//        GroceryItem groceryItem2 = new GroceryItem("Bread", "1.23");
//        String expected = "name:         \tMilk 		 	 seen: 6 times\n"+
//                      "=============  \t                 =============\n"+
//                      "Price: \t 3.23 \t                 seen: 5 times\n"+
//
//                      "name: Bread    \t                 seen: 6 times\n"+
//                      "Price: \t 1.23 \t                 seen: 6 times\n";
//        String actual = dataPrintout.printSummaryTable(groceryItems);
//        assertEquals("Expect strings to be equal", expected, actual);
//    }



    @Test
    public void printPriceAndQuantityTest() {
        String expected = "Price: 3.23\t\t seen: 6 times";
        String actual = dataPrintout.printPriceAndQuantity("3.23", 6);
        assertEquals("Expected string...", expected, actual);
    }

    @Test
    public void printNameAndTotalQuantityTest(){
        String expected = "name: Cookies\t\t seen: 2 times";
        String actual = dataPrintout.printNameAndTotalQuantity("Cookies", 2);
        assertEquals("Expect equal strings", expected, actual);
    }

    @Test
    public void printErrorsTest(){
        String expected = "Errors: \t\t\t\t seen: 5 times";
        String actual = dataPrintout.printErrors(5);
        assertEquals("Expected equal strings", expected, actual);
    }

    @Test
    public void printItemDividerTest(){
        String expected = "=============\t\t=============";
        String actual = dataPrintout.printItemDivider();
        assertEquals("Expected equal strings", expected, actual);
    }

    @Test
    public void printPriceDividerTest(){
        String expected = "-------------\t\t-------------";
        String actual = dataPrintout.printPriceDivider();
        assertEquals("Expected equal strings", expected, actual);
    }

}
