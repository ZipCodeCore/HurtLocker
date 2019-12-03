import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;

public class PrintResults {
    FindPatterns finder = new FindPatterns();
    MapResults mapResults = new MapResults();

    public void printDoubleLines () {
        System.out.println(String.format("%-20s %28s", "====================", "==============="));
    }

    public void printSingleLine () {
        System.out.println(String.format("%-20s %28s", "--------------------", "---------------"));
    }

    public void printMilk () {
        Map<String, Integer> milkMap = mapResults.milkResultsMap();
        Integer numOfMilks =  mapResults.countMilk();
        ArrayList<String> keys = new ArrayList<String> (mapResults.milkResultsMap().keySet());
        System.out.println(String.format("Grocery Item: Milk:               seen %d time(s)", numOfMilks));
        printDoubleLines();
        System.out.println(String.format("Price: %s                       seen %d time(s)", keys.get(1), milkMap.get("3.23")));
        printSingleLine();
        System.out.println(String.format("Price: %s                       seen %d time(s)", keys.get(0), milkMap.get("1.23")));

    }
}
