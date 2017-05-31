import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.TreeMap;
import java.util.Set;


/**
 * Created by markbrown on 5/31/17.
 */
public class Milk {

    private Milk () {}

    public static ArrayList<ArrayList<String>> parseListForMilkPriceKeyPair(ArrayList<String> foodList) {
        ArrayList<ArrayList<String>> milkList = new ArrayList<ArrayList<String>>();
        Pattern patternCorrect = Pattern.compile("(.{4}\\:)([M|m][I|i][L|l][K|k])\\;.{5}\\:(\\d\\.\\d{2})");
        Pattern patternErrorOne = Pattern.compile("(.{4}\\:)([M|m][I|i][L|l][K|k])\\;.{5}\\:\\;");
        for (String food : foodList) {
            ArrayList<String> milkEntry = new ArrayList<String>();
            Matcher matcherCorrect = patternCorrect.matcher(food);
            if (matcherCorrect.find()) {
                milkEntry.add(matcherCorrect.group(2));
                milkEntry.add(matcherCorrect.group(3));
                milkList.add(milkEntry);
            }
            else {
                Matcher matcherErrorOne = patternErrorOne.matcher(food);
                if (matcherErrorOne.find()) {
                    ErrorCounter.increaseErrorCount();
                }
            }
        }
        return milkList;
    }

    public static TreeMap<String, Integer> getMilkPriceList (ArrayList<ArrayList<String>> milkList) {
        TreeMap<String, Integer> milkPriceList = new TreeMap<String,Integer>();
        for (int index = 0; index < milkList.size(); index++) {
            String price = milkList.get(index).get(1);
            if (!milkPriceList.containsKey(price)) {
                milkPriceList.put(price, 1);
            }
            else {
                int count = milkPriceList.get(price);
                milkPriceList.remove(price);
                milkPriceList.put(price, count+1);
            }
        }
        return milkPriceList;
    }

    public static String printMilkStats(int numberOfMilks, TreeMap<String, Integer> milkPriceCount) {
        String output = "name:";
        output += String.format("%9s", "Milk");
        output += "            seen: ";
        output += numberOfMilks;
        if (numberOfMilks > 1) {
            output += String.format("%-5s", "times");
        }
        if (numberOfMilks == 1) {
            output += String.format("%-5s", "time");
        }
        output += "\n";
        output += "=============" + "            " + "=============";
        output += "Price:";
        output += String.format("%7s", milkPriceCount.firstKey());
        output += "            seen: ";
        System.out.println(milkPriceCount.get(0));
        //output += milkPriceCount.get(0).toString();
        if (milkPriceCount.get(0) > 1) {
            output += String.format("%-5s", "times");
        }
        if (milkPriceCount.get(0) == 1) {
            output += String.format("%-5s", "time");
        }
        output += "-------------" + "            " + "-------------";
        output += String.format("%7s", milkPriceCount.lastKey());
        output += "            seen: ";
        //output += (milkPriceCount.get(1).toString());
        if (milkPriceCount.get(0) > 1) {
            output += String.format("%-5s", "times");
        }
        if (milkPriceCount.get(0) == 1) {
            output += String.format("%-5s", "time");
        }
        output += "-------------" + "            " + "-------------";
        return output;
    }

}
