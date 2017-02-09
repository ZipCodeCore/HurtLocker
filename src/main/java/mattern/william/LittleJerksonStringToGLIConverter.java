package mattern.william;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by williammattern on 2/8/17.
 */
public class LittleJerksonStringToGLIConverter {
    String name;
    String price;
    String type; //Will always be "Food"
    String expDate;



    public GroceryListItem convertLittleJerksonStringToGLI(String littleJerksonString) throws GroceryItemNotFoundException {
        try{
            name = littleJerksonStringNameParser(littleJerksonString);
            price = littleJerksonStringPriceParser(littleJerksonString);
            type = littleJerksonStringTypeParser(littleJerksonString);
            expDate = littleJerksonStringExpirationDateParser(littleJerksonString);
            return new GroceryListItemBuilder().setName(name).setPrice(price).setType(type).setExpirationDate(expDate).createGroceryListItem();
        } catch (GroceryItemNotFoundException e){
            throw new GroceryItemNotFoundException();
        }
    }

    public String littleJerksonStringNameParser(String littleJerksonString) throws GroceryItemNotFoundException{
        String keyValuePair = nameKeyValuePairFinder(littleJerksonString);
        if(applesFinder(keyValuePair))
            return "Apples";
        else if(breadFinder(keyValuePair))
            return "Bread";
        else if(cookieFinder(keyValuePair))
            return "Cookies";
        else if(milkFinder(keyValuePair))
            return "Milk";
        else
            InputHandler.jerksonExceptions++;
            throw new GroceryItemNotFoundException();
    }

    public String littleJerksonStringPriceParser(String littleJerksonString) throws GroceryItemNotFoundException{
        String parsedPrice;
        try {
            return parsedPrice = priceFinder(littleJerksonString);
        } catch (PriceNotFoundException e) {                                            //Catches the price not found exception from the price parser
            throw new GroceryItemNotFoundException();
        }
    }

    public String priceFinder(String littleJerksonString) throws PriceNotFoundException {
        String priceRegex = "\\d\\.\\d\\d";
        Pattern pattern = Pattern.compile(priceRegex);
        Matcher matcher = pattern.matcher(littleJerksonString);
        if(matcher.find()) {
            String priceMatch = matcher.group();
            return priceMatch;
        }else {
            InputHandler.jerksonExceptions++;
            throw new PriceNotFoundException();
        }
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



    public String nameKeyValuePairFinder(String littleJerksonString){
        String nameKeyValuePairRegex = "[nN][aA][mM][eE]:\\w*[;:]";
        Pattern pattern = Pattern.compile(nameKeyValuePairRegex);
        Matcher matcher = pattern.matcher(littleJerksonString);
        matcher.find();
        String nameKeyValuePair = matcher.group();
        return nameKeyValuePair;
    }

    public boolean cookieFinder(String nameKeyValuePair){
        String cookieRegex = "[cC]\\w\\w[kK][iI][eE][sS]";
        Pattern pattern = Pattern.compile(cookieRegex);
        Matcher matcher = pattern.matcher(nameKeyValuePair);
        return matcher.find();
    }

    public boolean milkFinder(String nameKeyValuePair){
        String milkRegex = "[mM][iI1][lL1][kKcC]";
        Pattern pattern = Pattern.compile(milkRegex);
        Matcher matcher = pattern.matcher(nameKeyValuePair);
        return matcher.find();
    }


    public boolean breadFinder(String nameKeyValuePair){
        String breadRegex = "[bBdD][rR][eE][aA4][dDbB]";
        Pattern pattern = Pattern.compile(breadRegex);
        Matcher matcher = pattern.matcher(nameKeyValuePair);
        return matcher.find();
    }

    public boolean applesFinder(String nameKeyValuePair){
        String applesRegex = "[aA][pP][pP][lL][eE][sS]";
        Pattern pattern = Pattern.compile(applesRegex);
        Matcher matcher = pattern.matcher(nameKeyValuePair);
        return matcher.find();
    }
}
