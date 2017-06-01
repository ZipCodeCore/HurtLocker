import org.apache.commons.io.IOUtils;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        //String output = (new Main()).readRawDataToString();
       // System.out.println(output);

        Map<String, String> regexItem = new HashMap<String, String>();

        regexItem.put("[Cc].+[sS]", "Cookies");
        regexItem.put("[Mm].{2}[Kk]", "Milk");
        regexItem.put("[Bb].{3}[Dd]", "Bread");
        regexItem.put("[Aa][Pp].+[sS]", "Apples");

        Parser parser = new Parser();
        parser.parseString((new Main()).readRawDataToString());
        parser.createItemList();

        System.out.println(parser.findItemCount("[Aa][Pp].+[sS]", "Apples"));
        System.out.println(parser.priceCount());

//        for(Map.Entry<String, String> entry : regexItem.entrySet()) {
//            System.out.println(parser.findItemCount(entry.getKey(), entry.getValue()));
//            System.out.println(parser.priceCount());
//            System.out.println();
//        }



    }
}
