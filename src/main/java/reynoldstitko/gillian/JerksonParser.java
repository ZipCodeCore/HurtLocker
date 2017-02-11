package reynoldstitko.gillian;

import java.util.*;
import java.util.regex.*;

/**
 * Created by gillianreynolds-titko on 2/8/17.
 */
public class JerksonParser extends Exception {

    //private ArrayList<String> cleanedStrings = new ArrayList<>();
    private Map<String, String> groceryItems = new HashMap<>();

    public int getCount() {
        return count;
    }

    int count=0;

    //1. split incoming file into individual rows of data
    public String[] splitIncomingStringFile(String inputStringFile, String matcher) {
        String input = inputStringFile;
        String[] splitFile = input.split(matcher);
        return splitFile;
    }


    //Matcher: An engine that performs match operations on a character sequence by interpreting a Pattern.
    //A matcher is created from a pattern by invoking the pattern's matcher method.
    //You have to create a matcher (RegEx) that captures ALL of the input string of interest. You also signify the
    // parts of interest (that you wnat to keep) by enclosing those sections fo the RegEx in (). These will be placed
    // in groups that you can assign to your output file.

    public ArrayList<String> findGroceryItems(String[] inputStringArray) {
        ArrayList<String> itemStrings = new ArrayList<>();
        String matcherText = "(?i)name:([a-z])?\\w*;price:(\\d\\.\\d\\d)?;[a-z]?\\w*:[a-z]?\\w*[\\;|\\^|\\%|\\*|\\!|\\@]\\w*:\\d?\\/\\d?\\d\\/\\d*";
        Pattern p = Pattern.compile(matcherText);
        //do first w/o a try/catch block
        for (String item : inputStringArray) {
            Matcher m = p.matcher(item); //attempt to match the entire input sequence against the pattern
            if(m.find()){
                itemStrings.add(m.group(1)); //Group 1 returns the item.
            }
        }
        return itemStrings;
    }

    public ArrayList<String> findItemPrices(String[] inputStringArray) {
        ArrayList<String> priceStrings = new ArrayList<>();
        String matcherText = "(?i)name:([a-z])?\\w*;price:(\\d\\.\\d\\d)?;[a-z]?\\w*:[a-z]?\\w*[\\;|\\^|\\%|\\*|\\!|\\@]\\w*:\\d?\\/\\d?\\d\\/\\d*";
        Pattern p = Pattern.compile(matcherText);
        //do first w/o a try/catch block
        for (String item : inputStringArray) {
            Matcher m = p.matcher(item); //attempt to match the entire input sequence against the pattern
            if(m.find()){
                priceStrings.add(m.group(2)); //Group 2 returns the item price; add that info to the array
            }
        }
        return priceStrings;
    }

    public Map<String, String> findItemPricesMap(String[] inputStringArray) {
        Map<String, String> groceryItems = new HashMap<>();
        String matcherText = "(?i)name:([a-z])?\\w*;price:(\\d\\.\\d\\d)?;[a-z]?\\w*:[a-z]?\\w*[\\;|\\^|\\%|\\*|\\!|\\@]\\w*:\\d?\\/\\d?\\d\\/\\d*";
        Pattern p = Pattern.compile(matcherText);
        //do first w/o a try/catch block
       for(int i =0; i < inputStringArray.length; i++){
           Matcher m = p.matcher(inputStringArray[i]); //attempt to match the entire input sequence against the pattern
           if(m.find()){
               groceryItems.put(m.group(1), m.group(2)); //Group 2 returns the item price; add that info to the array
           }
       }
        return groceryItems;
    }

    public ArrayList<GroceryItem> combineItemsAndPrices(ArrayList<String> item, ArrayList<String> price) throws StringMismatchException {
        ArrayList<GroceryItem> groceryItemList = new ArrayList<>();
        for (int i = 0; i < item.size(); i++) {
            try {

                if (item.get(i) == null || price.get(i) == null)
                    throw new StringMismatchException();
                groceryItemList.add(new GroceryItem(refactorNames(item.get(i)), price.get(i)));

            } catch (StringMismatchException e) {
                count = count + 1;
            }
            System.out.println(groceryItemList.size());
        } return groceryItemList;
    }

    //2. apply regex to each row of data - split into component (GroceryItem) objects;
    // catch errors (missing price, missing name)
    public GroceryItem[] createGroceryItemsArray(String[] string, String matcher){ //throw errors; get array of [food, price]

        return null;
    }


//    public int countRepeatItems(){
//        return Collections.frequency(groceryItems, "Milk");
//    }

    public String refactorNames(String letter){
        String refactoredNames = "";
        switch (letter.toLowerCase()){
            case "b":
                return "Bread";
            case "a":
                return "Apples";
            case "m":
                return "Milk";
            case "c":
                return "Cookies";
            default:
                return letter;
        }
    }


}
