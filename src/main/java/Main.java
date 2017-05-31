import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.TreeMap;
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
        checkForMissingNameErrors(foodList);
        ArrayList<ArrayList<String>> milkList = Milk.parseListForMilkPriceKeyPair(foodList);
        ArrayList<ArrayList<String>> breadList = Bread.parseListForBreadPriceKeyPair(foodList);
        ArrayList<ArrayList<String>> cookiesList = Cookies.parseListForCookiesPriceKeyPair(foodList);
        ArrayList<ArrayList<String>> applesList = Apples.parseListForApplesPriceKeyPair(foodList);
        int numberOfMilks = getNumberOfProductAppearances(milkList);
        int numberOfBreads = getNumberOfProductAppearances(breadList);
        int numberOfCookies = getNumberOfProductAppearances(cookiesList);
        int numberOfApples = getNumberOfProductAppearances(applesList);
        TreeMap<String, Integer> milkPriceCount = Milk.getMilkPriceList(milkList);
        TreeMap<String, Integer> breadPriceCount = Milk.getMilkPriceList(breadList);
        TreeMap<String, Integer> cookiesPriceCount = Milk.getMilkPriceList(cookiesList);
        TreeMap<String, Integer> applesPriceCount = Milk.getMilkPriceList(applesList);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("newOutput.txt");
            writer.println(Milk.printMilkStats(numberOfMilks, milkPriceCount));
            writer.println(Bread.printBreadStats(numberOfBreads, breadPriceCount));
            writer.println(Cookies.printCookieStats(numberOfCookies, cookiesPriceCount));
            writer.print(Apples.printApplesStats(numberOfApples, applesPriceCount));
            writer.print(printErrorInfo());
        } catch (IOException e) {
            System.out.println("Exception");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                System.out.println("Exception");
            }
        }
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

    public static void checkForMissingNameErrors(ArrayList<String> foodList) {
        ArrayList<ArrayList<String>> tempFoodList = new ArrayList<ArrayList<String>>();
        Pattern patternError = Pattern.compile("[N|n][A|a][M|m][E|e]\\:\\;");
        for (String food : foodList) {
            Matcher matcherError = patternError.matcher(food);
            if (matcherError.find()) {
                ErrorCounter.increaseErrorCount();
            }
        }
    }

    public static int getNumberOfProductAppearances(ArrayList<ArrayList<String>> productList) {
        return productList.size();
    }

    public static String printErrorInfo() {
        String output = "Errors:";
        output += "                  ";
        output += "seen: ";
        output += ErrorCounter.getErrorCount();
        if (ErrorCounter.getErrorCount() > 1) {
            output += String.format("%-6s", " times");
        }
        if (ErrorCounter.getErrorCount() == 1) {
            output += String.format("%-6s", " time");
        }
        return output;
    }



}
