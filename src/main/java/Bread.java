import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by markbrown on 5/31/17.
 */
public class Bread {

    private Bread() {}

    public static ArrayList<ArrayList<String>> parseListForBreadPriceKeyPair(ArrayList<String> foodList) {
        ArrayList<ArrayList<String>> breadList = new ArrayList<ArrayList<String>>();
        Pattern patternCorrect = Pattern.compile("(.{4}\\:)([B|b][R|r][E|e][A|a][D|d])\\;.{5}\\:(\\d\\.\\d{2})");
        Pattern patternErrorOne = Pattern.compile("(.{4}\\:)([B|b][R|r][E|e][A|a][D|d])\\;.{5}\\:\\;");
        for (String food : foodList) {
            ArrayList<String> breadEntry = new ArrayList<String>();
            Matcher matcherCorrect = patternCorrect.matcher(food);
            if (matcherCorrect.find()) {
                breadEntry.add(matcherCorrect.group(2));
                breadEntry.add(matcherCorrect.group(3));
                breadList.add(breadEntry);
            }
            else {
                Matcher matcherErrorOne = patternErrorOne.matcher(food);
                if (matcherErrorOne.find()) {
                    ErrorCounter.increaseErrorCount();
                }
            }
        }
        return breadList;
    }

    public static TreeMap<String, Integer> getBreadPriceList (ArrayList<ArrayList<String>> breadList) {
        TreeMap<String, Integer> breadPriceList = new TreeMap<String,Integer>();
        for (int index = 0; index < breadList.size(); index++) {
            String price = breadList.get(index).get(1);
            if (!breadPriceList.containsKey(price)) {
                breadPriceList.put(price, 1);
            }
            else {
                int count = breadPriceList.get(price);
                breadPriceList.remove(price);
                breadPriceList.put(price, count+1);
            }
        }
        return breadPriceList;
    }

    public static String printBreadStats(int numberOfBreads, TreeMap<String, Integer> breadPriceCount) {
        String outputHeader = printBreadHeader(numberOfBreads);
        String outputPrices = printPrices(breadPriceCount);
        String output = outputHeader + outputPrices;
        return output;
    }

    public static String printBreadHeader(int numberOfBreads) {
        String output = "name:";
        output += String.format("%8s", "Bread");
        output += "            seen: ";
        output += numberOfBreads;
        if (numberOfBreads > 1) {
            output += String.format("%-6s", " times");
        }
        if (numberOfBreads == 1) {
            output += String.format("%-6s", " time");
        }
        output += "\n";
        output += "=============" + "            " + "=============";
        output += "\n";
        return output;
    }

    public static String printPrices(TreeMap<String, Integer> breadPriceCount) {
        String output = "Price:";
        output += String.format("%7s", breadPriceCount.lastKey());
        output += "            ";
        output += "seen: ";
        if (breadPriceCount.get(breadPriceCount.lastKey()) > 1) {
            output += String.format("%7s", breadPriceCount.get(breadPriceCount.lastKey()) + " times");
        }
        else {
            output += String.format("%7s", breadPriceCount.get(breadPriceCount.lastKey()) + " time");
        }
        breadPriceCount.remove(breadPriceCount.lastKey());
        while (!breadPriceCount.isEmpty()) {
            output += "\n";
            output += "-------------" + "            " + "-------------";
            output += "\n";
            output += "Price:";
            output += String.format("%7s", breadPriceCount.lastKey());
            output += "            ";
            output += "seen: ";
            if (breadPriceCount.get(breadPriceCount.lastKey()) > 1) {
                output += String.format("%7s", breadPriceCount.get(breadPriceCount.lastKey()) + " times");
            }
            else {
                output += String.format("%7s", breadPriceCount.get(breadPriceCount.lastKey()) + " time");
            }
            output += "\n";
            breadPriceCount.remove(breadPriceCount.lastKey());
        }
        output += "\n";
        return output;
    }
}
