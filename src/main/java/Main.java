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
        ArrayList<String> foodList = createListOfFoodItems(output);
        ArrayList<ArrayList<String>> milkList = Milk.parseListForMilkPriceKeyPair(foodList);
        ArrayList<ArrayList<String>> breadList = Bread.parseListForBreadPriceKeyPair(foodList);
        ArrayList<ArrayList<String>> cookiesList = Cookies.parseListForCookiesPriceKeyPair(foodList);
        ArrayList<ArrayList<String>> applesList = Apples.parseListForApplesPriceKeyPair(foodList);
        System.out.println(ErrorCounter.getErrorCount());
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

}
