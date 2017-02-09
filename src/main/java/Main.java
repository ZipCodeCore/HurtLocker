import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;

public class Main {



    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        JSONFixer aFix = new JSONFixer();
        GroceryList aList = new GroceryList();
        Display aDisplay = new Display();
        int originalLength = aFix.wholeLength(output);
        aList.convertAllToList(aFix.breakLines(output));
        aList.setUniqueGroceries();
        System.out.println(aDisplay.printMilk(aList));
        System.out.println(aDisplay.printBread(aList));
        System.out.println(aDisplay.printCookies(aList));
        System.out.println(aDisplay.printApples(aList));
        System.out.println(aDisplay.printErrors(aList, originalLength));

    }
}
