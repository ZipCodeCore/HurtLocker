import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapping {

    PatternFinder finder = new PatternFinder();

    public Map applesMap (){

        Map<String, Long> myMap = new HashMap();
        ArrayList<Grocery> list = finder.createGroceryList();
        for (int i = 0; i < list.size(); i++) {
            myMap = list.stream().filter(x -> x.getName().equals("Apples")).collect(Collectors.groupingBy(Grocery::getPrice, Collectors.counting()));
        }
        return myMap;
    }

    public Map breadMap (){

        Map<String, Long> myMap = new HashMap();
        ArrayList<Grocery> list = finder.createGroceryList();
        for (int i = 0; i < list.size(); i++) {
            myMap = list.stream().filter(x -> x.getName().equals("Bread")).collect(Collectors.groupingBy(Grocery::getPrice, Collectors.counting()));
        }
        return myMap;
    }

    public Map cookiesMap (){

        Map<String, Long> myMap = new HashMap();
        ArrayList<Grocery> list = finder.createGroceryList();
        for (int i = 0; i < list.size(); i++) {
            myMap = list.stream().filter(x -> x.getName().equals("Cookies")).collect(Collectors.groupingBy(Grocery::getPrice, Collectors.counting()));
        }
        return myMap;
    }

    public Map milkMap (){

        Map<String, Long> myMap = new HashMap();
        ArrayList<Grocery> list = finder.createGroceryList();
        for (int i = 0; i < list.size(); i++) {
            myMap = list.stream().filter(x -> x.getName().equals("Milk")).collect(Collectors.groupingBy(Grocery::getPrice, Collectors.counting()));
        }
        return myMap;
    }

    public Integer countApples () {
        ArrayList<Grocery> list = finder.createGroceryList();
        Integer countApples = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("Apples")){
                countApples++;
            }
        }
        return countApples;
    }

    public Integer countBread () {
        ArrayList<Grocery> list = finder.createGroceryList();
        Integer countBread = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("Bread")){
                countBread++;
            }
        }
        return countBread;
    }

    public Integer countCookies () {
        ArrayList<Grocery> list = finder.createGroceryList();
        Integer countCookies = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("Cookies")){
                countCookies++;
            }
        }
        return countCookies;
    }

    public Integer countMilk () {

        ArrayList<Grocery> list = finder.createGroceryList();
        Integer countMilk = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals("Milk")){
                countMilk++;
            }
        }
        return countMilk;
    }

}