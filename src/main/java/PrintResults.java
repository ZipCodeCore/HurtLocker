import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintResults {
    CleanTheJerk cleaner = new CleanTheJerk();
    FindPatterns finder = new FindPatterns();



    public Map milkResultsMap (){
        Map<String, Long> myMap = new HashMap();
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        for (int i = 0; i < list.size(); i++) {
                    myMap = list.stream().filter(x -> x.getName().equals("Milk")).collect(Collectors.groupingBy(GroceryObjects::getPrice, Collectors.counting()));
            }
        return myMap;
    }

    public Map applesResultsMap (){
        Map<String, Long> myMap = new HashMap();
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        for (int i = 0; i < list.size(); i++) {
            myMap = list.stream().filter(x -> x.getName().equals("Apples")).collect(Collectors.groupingBy(GroceryObjects::getPrice, Collectors.counting()));
        }
        return myMap;
    }

    public Map breadResultsMap (){
        Map<String, Long> myMap = new HashMap();
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        for (int i = 0; i < list.size(); i++) {
            myMap = list.stream().filter(x -> x.getName().equals("Bread")).collect(Collectors.groupingBy(GroceryObjects::getPrice, Collectors.counting()));
        }
        return myMap;
    }

    public Map cookiesResultsMap (){
        Map<String, Long> myMap = new HashMap();
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        for (int i = 0; i < list.size(); i++) {
            myMap = list.stream().filter(x -> x.getName().equals("Cookies")).collect(Collectors.groupingBy(GroceryObjects::getPrice, Collectors.counting()));
        }
        return myMap;
    }



}
