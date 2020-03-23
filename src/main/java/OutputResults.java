import java.util.ArrayList;
import java.util.Map;

public class OutputResults {

    PatternFinder finder = new PatternFinder();
    Mapping mapResults = new Mapping();

    public void printAllItems () {

        printApples();
        printBread();
        printCookies();
        printMilk();
        printErrors();
    }


    public void printStars() {

        System.out.println(String.format("%-20s %30s", "********************", "*****************"));
    }

    public void printSingleLine() {

        System.out.println(String.format("%-20s %30s", "--------------------", "-----------------"));
    }

    public void printApples() {

        Map<String, Integer> applesMap = mapResults.applesMap();
        Integer numApples = mapResults.countApples();
        ArrayList<String> keys = new ArrayList<String>(mapResults.applesMap().keySet());
        System.out.println(String.format("\nGrocery Item: Apples              appears %d time(s)", numApples));
        printStars();
        System.out.println(String.format("Price: %s                       appears %d time(s)", keys.get(1), applesMap.get(keys.get(1))));
        printSingleLine();
        System.out.println(String.format("Price: %s                       appears %d time(s)", keys.get(0), applesMap.get(keys.get(0))));
        printSingleLine();
    }

    public void printBread() {

        Map<String, Integer> breadMap = mapResults.breadMap();
        Integer numBreads = mapResults.countBread();
        ArrayList<String> keys = new ArrayList<String>(mapResults.breadMap().keySet());
        System.out.println(String.format("\nGrocery Item: Bread               appears %d time(s)", numBreads));
        printStars();
        System.out.println(String.format("Price: %s                       appears %d time(s)", keys.get(0), breadMap.get(keys.get(0))));
        printSingleLine();

    }

    public void printCookies() {

        Map<String, Integer> cookiesMap = mapResults.cookiesMap();
        Integer numCookies = mapResults.countCookies();
        ArrayList<String> keys = new ArrayList<String>(mapResults.cookiesMap().keySet());
        System.out.println(String.format("\nGrocery Item: Cookies             appears %d time(s)", numCookies));
        printStars();
        System.out.println(String.format("Price: %s                       appears %d time(s)", keys.get(0), cookiesMap.get(keys.get(0))));
        printSingleLine();
    }

    public void printMilk() {

        Map<String, Integer> milkMap = mapResults.milkMap();
        Integer numMilks = mapResults.countMilk();
        ArrayList<String> keys = new ArrayList<String>(mapResults.milkMap().keySet());
        System.out.println(String.format("\nGrocery Item: Milk                appears %d time(s)", numMilks));
        printStars();
        System.out.println(String.format("Price: %s                       appears %d time(s)", keys.get(1), milkMap.get(keys.get(1))));
        printSingleLine();
        System.out.println(String.format("Price: %s                       appears %d time(s)", keys.get(0), milkMap.get(keys.get(0))));
        printSingleLine();
    }

    public void printErrors () {

        System.out.println(String.format("\nData Errors:                      appears %d time(s)", finder.errors()));
    }
}
