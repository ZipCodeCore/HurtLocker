package crawley.james.hurtlocker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamescrawley on 10/17/16.
 */
public class JerkSONParser {

    private String separator0 = "=============\n";
    private String separator1 = "-------------\n";
    private String[] groceryList;
    private int errors = 0;
    private int current = 0;
    private  int max;
    private List<String> parsedItem;
    private Map<String, List<String>> inventory = new HashMap<String, List<String>>();

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
        StringBuilder name = new StringBuilder();
        int length;

        String first = parsedName.substring(0, 1).toUpperCase();
        String remaining = parsedName.substring(1).toLowerCase();

        name.append(first);
        name.append(remaining);
        length = name.length();

        name.delete(length - 1, length);

        return name.toString();
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
        String name = getItemName();
        String price = getItemPrice();
        List<String> prices = inventory.get(name);

        if (prices == null) {
            prices = new ArrayList<String>();
        }

        prices.add(price);
        inventory.put(name, prices);
    }

    public boolean hasNext () {

        return current < max;
    }

    public void next() {
        current++;
    }

    public Map<String, List<String>> getInventory () {

        return inventory;
    }

    public List<String> getParsedItem () {

        return parsedItem;
    }

    private boolean verifyErrors (List items) {

        if (items.size() == 8) {
            return false;
        }

        errors++;

        return true;

    }



}
