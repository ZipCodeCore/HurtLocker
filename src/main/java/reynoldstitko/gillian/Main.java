package reynoldstitko.gillian;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;

public class Main {



    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws StringMismatchException, Exception{

        JerksonParser jerksonParser = new JerksonParser();

        String output = (new Main()).readRawDataToString();

        String[] result = jerksonParser.splitIncomingStringFile(output, "##");

        //print out the string file after the split
//        for(String value: result){
//            System.out.println("Initial" + value);
//        }

        ArrayList<String> output2 = jerksonParser.findItemPrices(result);
        ArrayList<String> output3 = jerksonParser.findGroceryItems(result);

//        int missingPricesError = jerksonParser.missingItemsErrorCount(result, "[pP][rR][iI][cC][eE]:\\d");
//        System.out.println(missingPricesError);
        //ArrayList<String> sepsRemoved = jerksonParser.findGroceryItems(result, "[\\;|\\^|\\%|\\*|\\:]");

        // /name:([a-z])?\w*;price:(\d\.\d\d)?;[a-z]?\w*:[a-z]?\w*[\;|\^|\%|\*|\!|\@]\w*:\d?\/\d?\d\/\d.*

//        ArrayList<String> apples = jerksonParser.findGroceryItems(appleSearcher, "([pP][pP][lL][eE][sS])");
//        System.out.println(apples);

        //ArrayList<String> test = jerksonParser.findGroceryItems(result, "([^@\\|^\\!|^\\^|^\\%])");
        for(String value: output2){
            System.out.println(value);
        }

        for(String value: output3){
            System.out.println(value);
        }


//         ArrayList<String> cookies = jerksonParser.findGroceryItems(result, "([cC][oO][oO][kK][iI][eE][sS]|[cC][oO][0][kK][iI][eE][sS])");
//         System.out.println(cookies);
//
//        ArrayList<String> apples = jerksonParser.findGroceryItems(result, "([pP][pP][lL][eE][sS])");
//        System.out.println(apples);
//
//        ArrayList<String> milk = jerksonParser.findGroceryItems(result,"([mM][iI][lL][kK])" );
//        System.out.println(milk);


    }

}
