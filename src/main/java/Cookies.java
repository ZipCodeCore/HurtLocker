import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by markbrown on 5/31/17.
 */
public class Cookies {

    private Cookies() {}

    public static ArrayList<ArrayList<String>> parseListForCookiesPriceKeyPair(ArrayList<String> foodList) {
        ArrayList<ArrayList<String>> cookieList = new ArrayList<ArrayList<String>>();
        Pattern patternCorrect = Pattern.compile("([C|c][O|o]{2}[K|k][I|i][E|e][S|s])\\;price\\:(\\d\\.\\d{2})");
        Pattern patternError = Pattern.compile("([C|c][O|o]{2}[K|k][I|i][E|e][S|s])\\;price\\:");
        for (String food : foodList) {
            ArrayList<String> cookieEntry = new ArrayList<String>();
            Matcher matcherCorrect = patternCorrect.matcher(food);
            if (matcherCorrect.find()) {
                cookieEntry.add(matcherCorrect.group(1));
                cookieEntry.add(matcherCorrect.group(2));
                cookieList.add(cookieEntry);
            }
            else {
                Matcher matcherError = patternError.matcher(food);
                if (matcherError.find()) {
                    ErrorCounter.increaseErrorCount();
                }
            }
        }
        return cookieList;
    }
}
