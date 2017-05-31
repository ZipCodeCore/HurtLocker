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
        Pattern patternCorrect = Pattern.compile("(.{4}\\:)([A|a][P|p]{2}[L|l][E|e][S|s])\\;price\\:(\\d\\.\\d{2})");
        Pattern patternErrorOne = Pattern.compile("(.{4}\\:)([A|a][P|p]{2}[L|l][E|e][S|s])\\;price\\:");
        Pattern patternErrorTwo = Pattern.compile("(.{4}\\:)\\;price\\:");

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
                Matcher matcherErrorTwo = patternErrorTwo.matcher(food);
                if (matcherErrorOne.find()) {
                    ErrorCounter.increaseErrorCount();
                }
                if (matcherErrorTwo.find()) {
                    ErrorCounter.increaseErrorCount();
                }
            }
        }
        return appleList;
    }
}
