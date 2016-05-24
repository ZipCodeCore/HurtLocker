package io.hurtlocker;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by taiseerhabib on 5/24/16.
 */
public class ItemParser {

    ArrayList<Item> itemList = new ArrayList<Item>();

    String nameValue = "[mM][iIlLkK]{3}|[bB][rReEaAdD]{4}|[cC][oO0kKiIeEsS]{6}|[aA][pPlLeEsS]{5}";
    String priceValue = "\\d\\.\\d{2}";
    String dateValue = "\\d{1,2}[/]\\d{1,2}[/]\\d{2,4}";

    int breadCount;
    int breadPriceCount;
    int cookieCount;
    int cookiePriceCount;
    int appleCount;
    int applePriceHighCount;
    int applePriceLowCount;
    int milkCostLowCount;
    int milkCount;
    int milkCostHighCount;
    static int errorCounter;

    ItemParser(String rawData) {
        JerkSON(rawData);
        instanceCounter(itemList);
        System.out.println("There were " + errorCounter + " blank fields");
    }

    ItemParser() {

    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    /**
     *           Method to match our regular expressions with content passed
     */
    public static String regexMatcher(String expression, String content){

        Pattern expressionCheck = Pattern.compile(expression);
        Matcher expressionMatched = expressionCheck.matcher(content);
        String matchedContent = null;
        while (expressionMatched.find()){
            if(expressionMatched.group().length() != 0) {
                matchedContent = expressionMatched.group().trim();
            }
        }
        return matchedContent;
    }

    /**
     *          Sets up ArrayList of Items
     */
    public void JerkSON(String dataRaw){
        String [] dataArray = dataRaw.split("##");
        for (int i=0; i<dataArray.length; i++){
            itemList.add(i, new Item());
            itemList.get(i).setName(regexMatcher(nameValue, dataArray[i]));
            itemList.get(i).setPrice(regexMatcher(priceValue, dataArray[i]));
            itemList.get(i).setDate(regexMatcher(dateValue, dataArray[i]));
        }
    }

    /**
     *          Counts instances of items and prices
     */
    public void instanceCounter(ArrayList <Item> fullItemList){
        for(int i=0; i<fullItemList.size(); i++) {
            milkCHecker(itemList.get(i).getName(),itemList.get(i).getPrice());
            cookieChecker(itemList.get(i).getName(),itemList.get(i).getPrice());
            appleChecker(itemList.get(i).getName(),itemList.get(i).getPrice());
            breadChecker(itemList.get(i).getName(),itemList.get(i).getPrice());
        }

    }

    public void milkCHecker(String name, String cost){
        String milkRegex = "[Mm][Ii][lL][kK]";

        if (name == null || cost == null) {
            try{
                throw new NoValueExceptions();
            }
            catch (NoValueExceptions e){
                e.printStackTrace();
            }
        } else if(name.matches(milkRegex)){
            milkCount++;
            if(cost.equals("3.23")){
                milkCostHighCount++;
            } else if(cost.equals("1.23")) {
                milkCostLowCount++;
            }
        }
    }

    public void breadChecker(String name, String cost) {
        String breadRegex = "[bB][rR][eE][aA][dD]";

        if (name == null || cost == null) {
            try{
                throw new NoValueExceptions();
            }
            catch (NoValueExceptions e){
                e.printStackTrace();
            }
        } else if(name.matches(breadRegex)){
            breadCount++;
            if(cost.equals("1.23")){
                breadPriceCount++;
            }
        }
    }


    public void cookieChecker(String name, String cost) {
        String cookieRegex = "[cC][oO0]{2}[kK][iI][eE][sS]";

        if (name == null || cost == null) {
            try{
                throw new NoValueExceptions();
            }
            catch (NoValueExceptions e){
                e.printStackTrace();
            }
        } else if(name.matches(cookieRegex)) {
            cookieCount++;
            if(cost.equals("2.25")) {
                cookiePriceCount++;
            }
        }
    }

    public void appleChecker(String name, String cost) {
        String appleRegex = "[aA][pP]{2}[lL][eE][sS]";

        if (name == null || cost == null) {
            try{
                throw new NoValueExceptions();
            }
            catch (NoValueExceptions e){
                e.printStackTrace();
            }
        } else if(name.matches(appleRegex)) {
            appleCount++;
            if(cost.equals("0.25")) {
                applePriceHighCount++;
            }
            else if(cost.equals("0.23")){
                applePriceLowCount++;
            }
        }
    }

    /**
     *             Setters and Getters
     * @return
     */
    public static int getErrorCounter() {
        return errorCounter;
    }

    public static void setErrorCounter(int errorCounter) {
        ItemParser.errorCounter = errorCounter;
    }

    public int getMilkCount() {
        return milkCount;
    }

    public int getMilkCostLow() {
        return milkCostLowCount;
    }

    public int getMilkCostHighCount() {
        return milkCostHighCount;
    }

    public int getBreadCount() {
        return breadCount;
    }

    public int getAppleCount() {
        return appleCount;
    }

    public int getBreadPriceCount() {
        return breadPriceCount;
    }

    public int getCookiePriceCount() {
        return cookiePriceCount;
    }

    public int getApplePriceHighCount() {
        return applePriceHighCount;
    }

    public int getApplePriceLowCount() {
        return applePriceLowCount;
    }


}
