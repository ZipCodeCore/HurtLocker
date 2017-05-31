package kim.chris.Parser;

import kim.chris.data.Counter;
import kim.chris.data.Item;
import kim.chris.exceptions.ValueNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String parseJerk(String input) {
        //split into Items
        ArrayList<String> lines = splitByLine(input);
        //go through and count each item type
        Counter milkCounter = new Counter("Milk");
        Counter breadCounter = new Counter("Bread");
        Counter cookieCounter = new Counter("Cookies");
        Counter appleCounter = new Counter("Apples");
        int exceptions = 0;
        Item currentItem;
        for(String line: lines){
            try{
                currentItem = parseLine(line);
                if(currentItem.getName().equals("Milk")){
                    milkCounter.addItem(currentItem);
                } else if(currentItem.getName().equals("Bread")){
                    breadCounter.addItem(currentItem);
                } else if(currentItem.getName().equals("Cookies")){
                    cookieCounter.addItem(currentItem);
                } else if(currentItem.getName().equals("Apples")){
                    appleCounter.addItem(currentItem);
                }
            } catch(ValueNotFoundException vnfe) {
                exceptions++;
            }

        }

        //return output String
        StringBuilder sb = new StringBuilder(2000);
        sb.append(milkCounter);
        sb.append(breadCounter);
        sb.append(cookieCounter);
        sb.append(appleCounter);
        sb.append("Errors              seen: " + exceptions + " times");
        return sb.toString();
    }

    public static Item parseLine(String line) throws ValueNotFoundException {
        String name = readName(line);
        Double price = readPrice(line);
        String type = readType(line);
        String expiration = readExpiration(line);
        return new Item(name, price, type, expiration);
    }

    public static boolean contains(String input, String regex){
        return makeMatcher(regex, input).find();
    }

    public static String readName(String line) throws ValueNotFoundException {
        Matcher milk = makeMatcher("[Mm][Ii][Ll][Kk]", line);
        Matcher bread = makeMatcher("[Bb][Rr][Ee][Aa][Dd]", line);
        Matcher cookies = makeMatcher("[Cc][Oo0][Oo0][Kk][Ii][Ee][Ss]", line);
        Matcher apples = makeMatcher("[Aa][Pp][Pp][Ll][Ee][Ss]", line);
        if(milk.find()) return "Milk";
        else if (bread.find()) return "Bread";
        else if (cookies.find()) return "Cookies";
        else if (apples.find()) return "Apples";
        else throw new ValueNotFoundException();
    }

    private static Matcher makeMatcher(String regex, String input){
        return Pattern.compile(regex).matcher(input);
    }

    public static Double readPrice(String line) throws ValueNotFoundException {
        Matcher price = makeMatcher("([Pp][Rr][Ii][Cc][Ee]:)(\\d.\\d\\d)", line);
        if(price.find()){
            return (Double)Double.parseDouble(price.group(2));
        } else throw new ValueNotFoundException();
    }

    public static String readType(String line) throws ValueNotFoundException {
        Matcher type = makeMatcher("(type):(\\w+)", line);
        if(type.find()){
            return type.group(2);
        } else throw new ValueNotFoundException();
    }

    public static String readExpiration(String line) throws ValueNotFoundException {
        Matcher expiration = makeMatcher("(expiration:)(\\d{0,1}\\/\\d\\d\\/\\d{4})", line);
        if(expiration.find()){
            return expiration.group(2);
        } else throw new ValueNotFoundException();
    }

    public static ArrayList<String> splitByLine(String input){
        ArrayList<String> result = new ArrayList<String>();
        String[] splitArray = Pattern.compile("##").split(input, 0);
        for(String str: splitArray){
            result.add(str);
        }
        return result;
    }

}
