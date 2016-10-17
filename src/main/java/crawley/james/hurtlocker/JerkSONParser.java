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


        return null;
    }

    public String getItemPrice () {


        return null;
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
