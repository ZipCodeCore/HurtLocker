import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by markbrown on 5/31/17.
 */
public class Apples {

    private Apples() {}

    public static ArrayList<ArrayList<String>> parseListForApplesPriceKeyPair(ArrayList<String> foodList) {
        ArrayList<ArrayList<String>> appleList = new ArrayList<ArrayList<String>>();
        Pattern patternCorrect = Pattern.compile("([A|a][P|p]{2}[L|l][E|e][S|s])\\;price\\:(\\d\\.\\d{2})");
        Pattern patternError = Pattern.compile("([A|a][P|p]{2}[L|l][E|e][S|s])\\;price\\:");
        for (String food : foodList) {
            ArrayList<String> appleEntry = new ArrayList<String>();
            Matcher matcherCorrect = patternCorrect.matcher(food);
            if (matcherCorrect.find()) {
                appleEntry.add(matcherCorrect.group(1));
                appleEntry.add(matcherCorrect.group(2));
                appleList.add(appleEntry);
            }
            else {
                Matcher matcherError = patternError.matcher(food);
                if (matcherError.find()) {
                    ErrorCounter.increaseErrorCount();
                }
            }
        }
        return appleList;
    }
}
