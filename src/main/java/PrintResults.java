import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintResults {
    CleanTheJerk cleaner = new CleanTheJerk();
    FindPatterns finder = new FindPatterns();
    Map<String, Long> myMap = new HashMap();


    public Map resultsMap (){
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        for (int i = 0; i < list.size(); i++) {
                    myMap = list.stream().filter(x -> x.getName().equals("Milk")).collect(Collectors.groupingBy(GroceryObjects::getPrice, Collectors.counting()));
            }
        return myMap;
    }

}
