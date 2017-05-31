import java.util.ArrayList;
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
}
