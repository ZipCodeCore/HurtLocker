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
}
