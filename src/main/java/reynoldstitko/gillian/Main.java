package reynoldstitko.gillian;

import org.apache.commons.io.IOUtils;

import java.util.*;

public class Main {



    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws StringMismatchException, Exception{

        JerksonParser jerksonParser = new JerksonParser();
        GroceryItem groceryItem;
        DataPrintout dataPrintout = new DataPrintout();

        String output = (new Main()).readRawDataToString();

        String[] result = jerksonParser.splitIncomingStringFile(output, "##");


        ArrayList<String> output2 = jerksonParser.findItemPrices(result);
        ArrayList<String> output3 = jerksonParser.findGroceryItems(result);
        ArrayList output4 = jerksonParser.combineItemsAndPrices(output3, output2);

        Set<GroceryItem> set = new HashSet<GroceryItem>(output4); //Create a new set

        System.out.print(dataPrintout.printSummaryTable(set, output4, jerksonParser.getCount()));

    }

}
