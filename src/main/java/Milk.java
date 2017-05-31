import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by markbrown on 5/31/17.
 */
public class Milk {

    private Milk () {}

    public static ArrayList<ArrayList<String>> parseListForMilkPriceKeyPair(ArrayList<String> foodList) {
        ArrayList<ArrayList<String>> milkList = new ArrayList<ArrayList<String>>();
        Pattern patternCorrect = Pattern.compile("([M|m][I|i][L|l][K|k])\\;price\\:(\\d\\.\\d{2})");
        Pattern patternError = Pattern.compile("([M|m][I|i][L|l][K|k])\\;price\\:");
        for (String food : foodList) {
            ArrayList<String> milkEntry = new ArrayList<String>();
            Matcher matcherCorrect = patternCorrect.matcher(food);
            if (matcherCorrect.find()) {
                milkEntry.add(matcherCorrect.group(1));
                milkEntry.add(matcherCorrect.group(2));
                milkList.add(milkEntry);
            }
            else {
                Matcher matcherError = patternError.matcher(food);
                if (matcherError.find()) {
                    ErrorCounter.increaseErrorCount();
                }
            }
        }
        return milkList;
    }
}
