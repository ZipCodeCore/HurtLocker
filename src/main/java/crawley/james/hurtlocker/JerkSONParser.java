package crawley.james.hurtlocker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jamescrawley on 10/17/16.
 */
public class JerkSONParser {

    private String separator0 = "=============\n";
    private String separator1 = "-------------\n";
    private int errors = 0;
    private List<String> parsedItem;

    public void parseItem (String item) {

        List<String> formatter = new ArrayList<String>();
        Pattern pattern = Pattern.compile("[\\w\\d.]+([:@^*%;!]|/\\d{1,2}/\\d{4}$)");
        Matcher matcher = pattern.matcher(item);

        while (matcher.find()) {
            formatter.add(matcher.group());
        }

        parsedItem = verifyErrors(formatter) ? null:formatter;
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

        int length;
        StringBuilder price = new StringBuilder();
        price.append(parsedItem.get(3));
        length = price.length();

        price.delete(length - 1, length);

        return price.toString();
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
