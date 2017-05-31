import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by markbrown on 5/31/17.
 */
public class Cookies {

    private Cookies() {}

    public static ArrayList<ArrayList<String>> parseListForCookiesPriceKeyPair(ArrayList<String> foodList) {
        ArrayList<ArrayList<String>> cookieList = new ArrayList<ArrayList<String>>();
        Pattern patternCorrect = Pattern.compile("(.{4}\\:)([C|c]([O|o]|0){2}[K|k][I|i][E|e][S|s])\\;.{5}\\:(\\d\\.\\d{2})");
        Pattern patternErrorOne = Pattern.compile("(.{4}\\:)([C|c]([O|o]|0){2}[K|k][I|i][E|e][S|s])\\;.{5}\\:\\;");
        for (String food : foodList) {
            ArrayList<String> cookieEntry = new ArrayList<String>();
            Matcher matcherCorrect = patternCorrect.matcher(food);
            if (matcherCorrect.find()) {
                cookieEntry.add(matcherCorrect.group(2));
                cookieEntry.add(matcherCorrect.group(4));
                cookieList.add(cookieEntry);
            }
            else {
                Matcher matcherErrorOne = patternErrorOne.matcher(food);
                if (matcherErrorOne.find()) {
                    ErrorCounter.increaseErrorCount();
                }
            }
        }
        return cookieList;
    }

    public static TreeMap<String, Integer> getCookiesPriceList (ArrayList<ArrayList<String>> cookiesList) {
        TreeMap<String, Integer> cookiesPriceList = new TreeMap<String,Integer>();
        for (int index = 0; index < cookiesList.size(); index++) {
            String price = cookiesList.get(index).get(1);
            if (!cookiesPriceList.containsKey(price)) {
                cookiesPriceList.put(price, 1);
            }
            else {
                int count = cookiesPriceList.get(price);
                cookiesPriceList.remove(price);
                cookiesPriceList.put(price, count+1);
            }
        }
        return cookiesPriceList;
    }
}
