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
}
