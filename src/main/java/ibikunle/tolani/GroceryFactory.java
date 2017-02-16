package ibikunle.tolani;

import java.util.HashMap;

/**
 * Created by tolaniibikunle on 2/15/17.
 */
public class GroceryFactory {
    static int milkNameCount ;
    static int breadNameCount;
    static int cookiesNameCount;
    static int applesNameCount;
    static int milkPriceCount1;
    static int milkPriceCount2;
    static int breadPriceCount;
    static int cookiePriceCount;
    static int applePriceCount1;
    static int applePriceCount2;


    public GroceryItem produceGrocery(HashMap inputMap) {


        GroceryItem groceryItem = new GroceryItem((String) inputMap.get("name"), (String) inputMap.get("price"), (String) inputMap.get("type"), (String) inputMap.get("expiration"));

        countGroceries(groceryItem);  //each time i make a grocery item i pass into the countGrocery method.
        return groceryItem;
    }

    private void countGroceries(GroceryItem groceryItem) {
        countGroceryName(groceryItem);
        countGroceryPrices(groceryItem);
    }


    private void countGroceryName(GroceryItem groceryItem) {
        if (groceryItem.getName().equalsIgnoreCase("milk")) {
            milkNameCount++;
        } else if (groceryItem.getName().equalsIgnoreCase("bread")) {
            breadNameCount++;
        } else if (groceryItem.getName().equalsIgnoreCase("cookies") || groceryItem.getName().equals("co0kies")) {
            cookiesNameCount++;
        } else if (groceryItem.getName().equalsIgnoreCase("apples")) {
            applesNameCount++;
        }
    }

    private void countGroceryPrices(GroceryItem groceryItem) {
        if (groceryItem.getPrice().equalsIgnoreCase("3.23")) {
            milkPriceCount1++;
        } else if (groceryItem.getPrice().equalsIgnoreCase("1.23") && groceryItem.getName().equalsIgnoreCase("milk")) {
            milkPriceCount2++;
        } else if (groceryItem.getPrice().equalsIgnoreCase("1.23")) {
            breadPriceCount++;
        } else if (groceryItem.getPrice().equalsIgnoreCase("2.25")) {
            cookiePriceCount++;
        } else if (groceryItem.getPrice().equalsIgnoreCase("0.25")) {
            applePriceCount1++;
        } else if (groceryItem.getPrice().equalsIgnoreCase("0.23")) {
            applePriceCount2++;
        }

    }
}