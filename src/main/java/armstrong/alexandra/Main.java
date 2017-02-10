package armstrong.alexandra;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;

import static armstrong.alexandra.Display.displayItem;
import static armstrong.alexandra.StringParse.cutString;
import static armstrong.alexandra.StringParse.regEx;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        String[] trimmed = cutString(output);
        ArrayList<GroceryItem> items = regEx(trimmed);
        for(int i = 0; i < items.size(); i++){
            displayItem(items.get(i));
        }

    }
}
