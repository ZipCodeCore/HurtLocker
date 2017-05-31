import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

    public static ArrayList<String> createListOfFoodItems(String rawData) {
        ArrayList<String> foodList = new ArrayList<String>();
        Pattern pattern = Pattern.compile("([^#]{0,}#{2})");
        Matcher matcher = pattern.matcher(rawData);
        while (matcher.find()) {
            foodList.add(matcher.group());
        }
        return foodList;
    }

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
