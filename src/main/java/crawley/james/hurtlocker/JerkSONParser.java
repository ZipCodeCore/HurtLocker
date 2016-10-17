package crawley.james.hurtlocker;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamescrawley on 10/17/16.
 */
public class JerkSONParser {

    private String separator0 = "=============";
    private String separator1 = "-------------";
    private String[] groceryList;
    private int errors = 0;
    private int current = 0;
    private  int max;
    private List<String> parsedItem;
    private Map<String, Map<String, Integer>> inventory = new HashMap<String, Map<String, Integer>>();

    public JerkSONParser (String raw) {
        groceryList = raw.split("##");
        max = groceryList.length;
    }

    public void parseItem () throws DataMissingException{

        List<String> formatter = new ArrayList<String>();
        Pattern pattern = Pattern.compile("[\\w\\d.]+([:@^*%;!]|/\\d{1,2}/\\d{4}$)");
        Matcher matcher = pattern.matcher(groceryList[current]);

        while (matcher.find()) {
            formatter.add(matcher.group());
        }

        if (verifyErrors(formatter)) {

            throw new DataMissingException();

        } else {

            parsedItem = formatter;
        }

        current++;

    }

    public String getItemName () {

        String parsedName = parsedItem.get(1);

        if (findMatch("c[o0]{1,2}[ck]ie[sz]", parsedName)) {
            parsedName = "Cookies";

        } else if (findMatch("br[3e][4a]d", parsedName)) {
            parsedName = "Bread";

        } else if (findMatch("m[1i]l{1,2}[ck]", parsedName)) {
            parsedName = "Milk";

        } else if (findMatch("[a4]p{1,2}l{1,2}e{1,2}[sz]", parsedName)) {
            parsedName = "Apples";
        }

        return parsedName;
    }

    public String getItemPrice () {

        String parsedPrice = parsedItem.get(3);
        StringBuilder price = new StringBuilder();
        int length;

        price.append(parsedPrice);
        length = price.length();

        price.delete(length - 1, length);

        return price.toString();
    }


    public void putItem () {

        int occurrence;
        String name = getItemName();
        String price = getItemPrice();
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

    public List<String> getParsedItem () {

        return parsedItem;
    }

    public int getErrors () {

        return errors;
    }

    private StringBuilder printFoods (Set<String> foods) {

        int seenItem;
        StringBuilder formattedList = new StringBuilder();

        for (String food : foods) {
            seenItem = getMapSize(inventory.get(food));
            Set<String> prices = inventory.get(food).keySet();

            formattedList.append(String.format("name:%8s", food));
            formattedList.append(" \t\t seen: ");
            formattedList.append(seenItem);
            formattedList.append(" times\n");
            formattedList.append(separator0);
            formattedList.append(" \t\t ");
            formattedList.append(separator0);
            formattedList.append("\n");

            formattedList.append(printPrices(food, prices));
        }

        return formattedList;
    }

    private StringBuilder printPrices (String food, Set<String> prices) {

        StringBuilder formattedList = new StringBuilder();
        int priceCount;

        for (String price : prices) {
            priceCount = inventory.get(food).get(price);
            formattedList.append(String.format("Price:%7s", price));
            formattedList.append(" \t\t seen: ");
            formattedList.append(priceCount);
            if (priceCount == 1) {
                formattedList.append("  time");
            } else {
                formattedList.append(" times");
            }
            formattedList.append("\n");
            formattedList.append(separator1);
            formattedList.append(" \t\t ");
            formattedList.append(separator1);
            formattedList.append("\n");
        }
        formattedList.append("\n");
        return formattedList;
    }

    private StringBuilder printErrors () {

        StringBuilder formattedList = new StringBuilder();

        formattedList.append(String.format("%-13s\t\tseen: ","Errors"));
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
