import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapResults {
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

    public Integer countMilk () {
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        Integer countMilk = 0;
        for (int i = 0; i < list.size(); i++) {
             if(list.get(i).getName().equals("Milk")){
                 countMilk++;
             }
        }
        return countMilk;
    }

    public Integer countBread () {
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        Integer countBread = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("Bread")){
                countBread++;
            }
        }
        return countBread;
    }

    public Integer countCookies () {
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        Integer countCookies = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("Cookies")){
                countCookies++;
            }
        }
        return countCookies;
    }

    public Integer countApples () {
        ArrayList<GroceryObjects> list = finder.createGroceryObjects();
        Integer countApples = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("Apples")){
                countApples++;
            }
        }
        return countApples;
    }



}
