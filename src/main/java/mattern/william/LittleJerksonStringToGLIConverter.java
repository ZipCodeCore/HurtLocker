package mattern.william;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by williammattern on 2/8/17.
 */
public class LittleJerksonStringToGLIConverter {
    GroceryListItem groceryListItem;
    String name;
    String price;
    String type; //Will always be "Food"
    String expDate;

    public String littleJerksonStringNameParser(String littleJerksonString){
        return null;
    }

    public String littleJerksonStringPriceParser(String littleJerksonString){
        return priceFinder(littleJerksonString);
    }

    public String littleJerksonStringTypeParser(String littleJerksonString){ //Will always return "Food"
        return "Food";
    }

    public String littleJerksonStringExpirationDateParser(String littleJerksonString){
        return dateFinder(littleJerksonString);
    }

    public String dateFinder(String littleJerksonString){
        String dateRegex = "([1-9]|0[1-9]|1[012])[ /]([1-9]|0[1-9]|[12][0-9]|3[01])[ /](19|20)\\d\\d";
        Pattern pattern = Pattern.compile(dateRegex);
        Matcher matcher = pattern.matcher(littleJerksonString);
        matcher.find();
        String dateMatch = matcher.group();
        return dateMatch;
    }

    public String priceFinder(String littleJerksonString){
        String priceRegex = "\\d\\.\\d\\d";
        Pattern pattern = Pattern.compile(priceRegex);
        Matcher matcher = pattern.matcher(littleJerksonString);
        matcher.find();
        String priceMatch = matcher.group();
        return priceMatch;
    }

    public String nameKeyValuePairFinder(String littleJerksonString){
        String nameKeyValuePairRegex = "[nN][aA][mM][eE]:\\w*[;:]";
        Pattern pattern = Pattern.compile(nameKeyValuePairRegex);
        Matcher matcher = pattern.matcher(littleJerksonString);
        String nameKeyValuePair = matcher.group();
        return nameKeyValuePair;

    }
}
