package collins.john;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        //System.out.println(output);

        JerkSONparser parser = new JerkSONparser();
        DisplayFormatter formatter = new DisplayFormatter();

        ArrayList<String> groupArray = parser.separateByGroups(output);
        parser.correctStringsFromByGroups(groupArray);
        ArrayList<Map<String, String>> mapArrayList = parser.convertGroupsToMaps(groupArray);

        formatter.aggregateData(mapArrayList);
        formatter.countPrices(mapArrayList);

        formatter.printItAllOut(formatter.milkPrice, "Milk", formatter.milkCounter);
        formatter.printItAllOut(formatter.breadPrice, "Bread", formatter.breadCounter);
        formatter.printItAllOut(formatter.cookiesPrice, "Cookies", formatter.cookiesCounter);
        formatter.printItAllOut(formatter.applePrice, "Apple", formatter.applesCounter);
        System.out.println(formatter.formatForScreen("Errors", "", formatter.fakeErrorCounter));

    }
}
