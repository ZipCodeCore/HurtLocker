package kim.chris.Parser;

import kim.chris.data.Item;
import kim.chris.exceptions.NameNotFoundException;
import kim.chris.exceptions.PriceNotFoundException;
import kim.chris.exceptions.TypeNotFoundException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    public static ArrayList<Item> parseJerk(String jerk){
        return new ArrayList<Item>();
    }

    public static Item parseItem(String line){
        return new Item();
    }

    public static String listToString(ArrayList<Item> theList){
        return "";
    }

    public static boolean contains(String input, String regex){
        return makeMatcher(regex, input).find();
    }

    public static String readName(String line) throws NameNotFoundException {
        Matcher milk = makeMatcher("[Mm][Ii][Ll][Kk]", line);
        Matcher bread = makeMatcher("[Bb][Rr][Ee][Aa][Dd]", line);
        Matcher cookies = makeMatcher("[Cc][Oo0][Oo0][Kk][Ii][Ee][Ss]", line);
        Matcher apples = makeMatcher("[Aa][Pp][Pp][Ll][Ee][Ss]", line);
        if(milk.find()) return "Milk";
        else if (bread.find()) return "Bread";
        else if (cookies.find()) return "Cookies";
        else if (apples.find()) return "Apples";
        else throw new NameNotFoundException();
    }

    private static Matcher makeMatcher(String regex, String input){
        return Pattern.compile(regex).matcher(input);
    }

    public static Double readPrice(String line) throws PriceNotFoundException {
        Matcher price = makeMatcher("([Pp][Rr][Ii][Cc][Ee]:)(\\d.\\d\\d)", line);
        if(price.find()){
            return (Double)Double.parseDouble(price.group(2));
        } else throw new PriceNotFoundException();
    }

    public static String readType(String line) throws TypeNotFoundException {
        return "";
    }

}
