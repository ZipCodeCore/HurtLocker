import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ryangross on 2/8/17.
 */
public class GroceryList {

    private List<GroceryItem> allGroceries = new ArrayList<GroceryItem>();
    private List<GroceryItem> uniqueGroceries = new ArrayList<GroceryItem>();
    private static String foodConverter = "(\\w+)\\W(\\w{3,10})";
    private static String priceConverter = "(\\d+\\W\\d+)";


    public boolean alreadyHas(GroceryItem anItem) {

        for (GroceryItem item : uniqueGroceries) {
            if ( (anItem.getName().equals(anItem.getName())) && (anItem.getPrice().equals(item.getPrice()))) {
                return true;
            }
        }
        return false;
    }

    public void setUniqueGroceries() {
        for (GroceryItem item : allGroceries) {
        for (int i = 0; i < allGroceries.size(); i++) {

            if (!alreadyHas(item)) {
                uniqueGroceries.add(item);
            }
        }
    }
}


    public int uniqueCounter(GroceryItem anItem) {
        int total = 0;
        for(int i = 0; i < allGroceries.size(); i++) {
            if ( (allGroceries.get(i).getName().equals(anItem.getName())) && (allGroceries.get(i).getPrice().equals(anItem.getPrice()))) {
                total++;
            }
        }
        return total;
    }

    public List<GroceryItem> getUniqueGroceries() {
        return uniqueGroceries;
    }

    public List<GroceryItem> getAllGroceries() {
        return allGroceries;
    }

    public int counter(String aName) {
        int total = 0;
        for(GroceryItem item : allGroceries) {
            if (item.getName().equals(aName)) {
                total++;
            }
        }
        return total;

    }


    public void convertAllToList(ArrayList<String> aStringList) {
        for (String aString : aStringList) {
            allGroceries.add(convertToGroceryItem(aString));
        }
    }


    public GroceryItem convertToGroceryItem(String aString) {

        GroceryItem newItem = new GroceryItem(convertFoodType(aString), convertPrice(aString));
        return newItem;
    }

    public String convertFoodType(String aString) {
        String foodType = "";
        Matcher matchLines = Pattern.compile(foodConverter).matcher(aString);
        while(matchLines.find()) {
            foodType += matchLines.group(2);
        }
      return foodType.toLowerCase();
    }

    public String convertPrice(String aString) {
        String price = "";
        Matcher matchLines = Pattern.compile(priceConverter).matcher(aString);
        while(matchLines.find()) {
            price += matchLines.group();
        }
        return price;
    }

}



