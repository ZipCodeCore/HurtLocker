import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

public class PrintResults {
    FindPatterns finder = new FindPatterns();
    MapResults mapResults = new MapResults();

    public void printAllItems () {
        printMilk();
        printBread();
        printCookies();
        printApples();
        printErrors();
    }


    public void printDoubleLines() {
        System.out.println(String.format("%-20s %28s", "====================", "==============="));
    }

    public void printSingleLine() {
        System.out.println(String.format("%-20s %28s", "--------------------", "---------------"));
    }

    public void printMilk() {
        Map<String, Integer> milkMap = mapResults.milkResultsMap();
        Integer numOfMilks = mapResults.countMilk();
        ArrayList<String> keys = new ArrayList<String>(mapResults.milkResultsMap().keySet());
        System.out.println(String.format("Grocery Item: Milk:               seen %d time(s)", numOfMilks));
        printDoubleLines();
        System.out.println(String.format("Price: %s                       seen %d time(s)", keys.get(1), milkMap.get(keys.get(1))));
        printSingleLine();
        System.out.println(String.format("Price: %s                       seen %d time(s)", keys.get(0), milkMap.get(keys.get(0))));
        printSingleLine();
    }

    public void printBread() {
        Map<String, Integer> breadMap = mapResults.breadResultsMap();
        Integer numOfBreads = mapResults.countBread();
        ArrayList<String> keys = new ArrayList<String>(mapResults.breadResultsMap().keySet());
        System.out.println(String.format("Grocery Item: Bread:              seen %d time(s)", numOfBreads));
        printDoubleLines();
        System.out.println(String.format("Price: %s                       seen %d time(s)", keys.get(0), breadMap.get(keys.get(0))));
        printSingleLine();

    }

    public void printCookies() {
        Map<String, Integer> cookiesMap = mapResults.cookiesResultsMap();
        Integer numOfCookies = mapResults.countCookies();
        ArrayList<String> keys = new ArrayList<String>(mapResults.cookiesResultsMap().keySet());
        System.out.println(String.format("Grocery Item: Cookies:            seen %d time(s)", numOfCookies));
        printDoubleLines();
        System.out.println(String.format("Price: %s                       seen %d time(s)", keys.get(0), cookiesMap.get(keys.get(0))));
        printSingleLine();
    }

    public void printApples() {
        Map<String, Integer> applesMap = mapResults.applesResultsMap();
        Integer numOfAppless = mapResults.countApples();
        ArrayList<String> keys = new ArrayList<String>(mapResults.applesResultsMap().keySet());
        System.out.println(String.format("Grocery Item: Apples:             seen %d time(s)", numOfAppless));
        printDoubleLines();
        System.out.println(String.format("Price: %s                       seen %d time(s)", keys.get(1), applesMap.get(keys.get(1))));
        printSingleLine();
        System.out.println(String.format("Price: %s                       seen %d time(s)", keys.get(0), applesMap.get(keys.get(0))));
        printSingleLine();
    }

    public void printErrors () {
        System.out.println(String.format("\nData Errors:                      seen %d time(s)", finder.errors()));
    }
}
