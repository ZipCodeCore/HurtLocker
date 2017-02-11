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


//        Iterator<GroceryItem> it = set.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        //System.out.println(set.size());

        //http://learnfromexamples.com/how-to-find-the-occurrences-of-a-particular-element-in-an-arraylist-in-java/
        //Overwrite equals method in the GroceryItem class


//        int result2 = Collections.frequency(output4, new GroceryItem("Milk", "3.23"));
//
//        int result3 = Collections.frequency(output4, new GroceryItem("Milk", "1.23"));
//        System.out.println(result2);
//        System.out.println(result3);
//        System.out.println(output3);
//        System.out.println(output2);


        //Map<String, String> output4 = jerksonParser.findItemPricesMap(result);

//        for(String value: output2){
//            System.out.println(value);
//        }
//
//        for(String value: output3){
//            System.out.println(value);
//        }

//        for (Map.Entry<String, String> entry: output4.entrySet())  {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key + " " + value);
//        }
        //output the hash map

    }

}
