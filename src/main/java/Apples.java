import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by markbrown on 5/31/17.
 */
public class Apples {

    private Apples() {}

    public static ArrayList<ArrayList<String>> parseListForApplesPriceKeyPair(ArrayList<String> foodList) {
        ArrayList<ArrayList<String>> appleList = new ArrayList<ArrayList<String>>();
        Pattern patternCorrect = Pattern.compile("(.{4}\\:)([A|a][P|p]{2}[L|l][E|e][S|s])\\;.{5}\\:(\\d\\.\\d{2})");
        Pattern patternErrorOne = Pattern.compile("(.{4}\\:)([A|a][P|p]{2}[L|l][E|e][S|s])\\;.{5}\\:\\;");

        for (String food : foodList) {
            ArrayList<String> appleEntry = new ArrayList<String>();
            Matcher matcherCorrect = patternCorrect.matcher(food);
            if (matcherCorrect.find()) {
                appleEntry.add(matcherCorrect.group(2));
                appleEntry.add(matcherCorrect.group(3));
                appleList.add(appleEntry);
            }
            else {
                Matcher matcherErrorOne = patternErrorOne.matcher(food);
                if (matcherErrorOne.find()) {
                    ErrorCounter.increaseErrorCount();
                }
            }
        }
        return appleList;
    }

    public static TreeMap<String, Integer> getApplesPriceList (ArrayList<ArrayList<String>> applesList) {
        TreeMap<String, Integer> applesPriceList = new TreeMap<String,Integer>();
        for (int index = 0; index < applesList.size(); index++) {
            String price = applesList.get(index).get(1);
            if (!applesPriceList.containsKey(price)) {
                applesPriceList.put(price, 1);
            }
            else {
                int count = applesPriceList.get(price);
                applesPriceList.remove(price);
                applesPriceList.put(price, count+1);
            }
        }
        return applesPriceList;
    }

    public static String printApplesStats(int numberOfApples, TreeMap<String, Integer> applePriceCount) {
        String outputHeader = printAppleHeader(numberOfApples);
        String outputPrices = printPrices(applePriceCount);
        String output = outputHeader + outputPrices;
        return output;
    }

    public static String printAppleHeader(int numberOfApples) {
        String output = "name:";
        output += String.format("%8s", "Apples");
        output += "            seen: ";
        output += numberOfApples;
        if (numberOfApples > 1) {
            output += String.format("%-6s", " times");
        }
        if (numberOfApples == 1) {
            output += String.format("%-6s", " time");
        }
        output += "\n";
        output += "=============" + "            " + "=============";
        output += "\n";
        return output;
    }

    public static String printPrices(TreeMap<String, Integer> applePriceCount) {
        String output = "Price:";
        output += String.format("%7s", applePriceCount.lastKey());
        output += "            ";
        output += "seen: ";
        if (applePriceCount.get(applePriceCount.lastKey()) > 1) {
            output += String.format("%7s", applePriceCount.get(applePriceCount.lastKey()) + " times");
        }
        else {
            output += String.format("%7s", applePriceCount.get(applePriceCount.lastKey()) + " time");
        }
        applePriceCount.remove(applePriceCount.lastKey());
        while (!applePriceCount.isEmpty()) {
            output += "\n";
            output += "-------------" + "            " + "-------------";
            output += "\n";
            output += "Price:";
            output += String.format("%7s", applePriceCount.lastKey());
            output += "            ";
            output += "seen: ";
            if (applePriceCount.get(applePriceCount.lastKey()) > 1) {
                output += String.format("%7s", applePriceCount.get(applePriceCount.lastKey()) + " times");
            }
            else {
                output += String.format("%7s", applePriceCount.get(applePriceCount.lastKey()) + " time");
            }
            output += "\n";
            applePriceCount.remove(applePriceCount.lastKey());
        }
        output += "\n";
        return output;
    }
}
