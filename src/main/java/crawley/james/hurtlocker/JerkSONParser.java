package crawley.james.hurtlocker;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamescrawley on 10/17/16.
 */
public class JerkSONParser {

    static final String EQUAL_SEPARATOR = "=============";
    static final String MINUS_SEPARATOR = "-------------";
    private String[] groceryList;
    private int errors = 0;
    private int current = 0;
    private  int max;
    private List<GroceryItem> groceryItems = new ArrayList<GroceryItem>();
    private Map<String, Map<String, Integer>> inventory = new HashMap<String, Map<String, Integer>>();

    public JerkSONParser (String raw) {
        groceryList = raw.split("##");
        max = groceryList.length;
    }

    public void parseItem () throws DataMissingException{

        List<String> formatter = new ArrayList<String>();
        Pattern pattern = Pattern.compile("[^:@^*%;!$]+[:@^*%;!$]?");
        Matcher matcher = pattern.matcher(groceryList[current]);

        while (matcher.find()) {
            formatter.add(matcher.group());
        }

        if (verifyErrors(formatter)) {

            groceryItems.add(new GroceryItem("", "", "", ""));
            throw new DataMissingException();


        } else {

            groceryItems.add(new GroceryItem(getItemName(formatter.get(1)), getItemPrice(formatter.get(3)), "Food", formatter.get(7)));
        }

    }

    public String getItemName (String name) {

        if (findMatch("c[o0]{1,2}[ck]ie[sz]", name)) {
            name = "Cookies";

        } else if (findMatch("br[3e][4a]d", name)) {
            name = "Bread";

        } else if (findMatch("m([1i]|il{1,2})[ck]", name)) {
            name = "Milk";

        } else if (findMatch("[a4]p{1,2}l{1,2}e{1,2}[sz]", name)) {
            name = "Apples";
        }

        return name;
    }

    public String getItemPrice (String price) {

        return price.substring(0, price.length() - 1);
    }


    public void putItem () {

        String name = groceryItems.get(current).getName();
        String price = groceryItems.get(current).getPrice();

        if (name.equals("") || price.equals("")) {
            return;
        }

        int occurrence;
        Map<String, Integer> prices = inventory.get(name);

        if (prices == null) {
            prices = new TreeMap<String, Integer>();
            prices.put(price, 1);
        } else if (prices.get(price) == null) {
            prices.put(price, 1);
        } else {
            occurrence = prices.get(price);
            prices.put(price, occurrence + 1);
        }

        inventory.put(name, prices);
    }


    public String printGroceryList () {

        Set<String> foods = inventory.keySet();
        StringBuilder formattedList = new StringBuilder();

        formattedList.append(printFoods(foods));
        formattedList.append(printErrors());

        return formattedList.toString();
    }

    public int getMapSize (Map<String, Integer> map) {

        int size = 0;
        Set<String> foods = map.keySet();

        for (String food: foods) {
            size += map.get(food);
        }

        return size;
    }


    public boolean hasNext () {

        return current < max;
    }

    public void next() {
        current++;
    }

    public Map<String, Map<String, Integer>> getInventory () {

        return inventory;
    }

    public List<GroceryItem> getGroceryItems() {

        return groceryItems;
    }

    public int getErrors () {

        return errors;
    }

    private StringBuilder printFoods (Set<String> foods) {

        int seenFood;
        StringBuilder formattedList = new StringBuilder();

        for (String food : foods) {
            seenFood = getMapSize(inventory.get(food));
            Set<String> prices = inventory.get(food).keySet();

            formattedList.append(String.format("name:%8s \t\t seen: %d", food, seenFood));
            formattedList.append((seenFood == 1) ? "  time\n" : " times\n");
            formattedList.append(EQUAL_SEPARATOR);
            formattedList.append(" \t\t ");
            formattedList.append(EQUAL_SEPARATOR);
            formattedList.append("\n");

            formattedList.append(printPrices(food, prices));
        }

        return formattedList;
    }

    private StringBuilder printPrices (String food, Set<String> prices) {

        StringBuilder formattedList = new StringBuilder();
        int seenPrice;

        for (String price : prices) {

            seenPrice = inventory.get(food).get(price);

            formattedList.append(String.format("Price:%7s \t\t seen: %d", price, seenPrice));
            formattedList.append((seenPrice == 1) ? "  time\n" : " times\n");
            formattedList.append(MINUS_SEPARATOR);
            formattedList.append(" \t\t ");
            formattedList.append(MINUS_SEPARATOR);
            formattedList.append("\n");
        }

        formattedList.append("\n");
        return formattedList;
    }

    private StringBuilder printErrors () {

        StringBuilder formattedList = new StringBuilder();

        formattedList.append(String.format("%-13s\t\t seen: ","Errors"));
        formattedList.append(errors);
        formattedList.append(" times");

        return formattedList;
    }

    private boolean findMatch (String regex, String parsedName) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(parsedName);

        return matcher.find();
    }

    private boolean verifyErrors (List items) {

        if (items.size() == 8) {
            return false;
        }

        errors++;

        return true;

    }

}
