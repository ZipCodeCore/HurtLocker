package reynoldstitko.gillian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

/**
 * Created by gillianreynolds-titko on 2/8/17.
 */
public class JerksonParser extends Exception {

    //private ArrayList<String> cleanedStrings = new ArrayList<>();
    private Map<String, String> groceryItems = new HashMap<>();
    int count=0;

    //1. split incoming file into individual rows of data
    public String[] splitIncomingStringFile(String inputStringFile, String matcher) {
        String input = inputStringFile;
        String[] splitFile = input.split(matcher);
        return splitFile;
    }


    //Matcher: An engine that performs match operations on a character sequence by interpreting a Pattern.
    //A matcher is created from a pattern by invoking the pattern's matcher method.
    //2. Get the various grocery item names; take a string array and go through each one (fix and prepare syntax for output)

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
                priceStrings.add(m.group(2)); //Group 2 returns the item price.
            }
        }
        return priceStrings;
    }

    //2. apply regex to each row of data - split into component (GroceryItem) objects;
    // catch errors (missing price, missing name)
    public GroceryItem[] createGroceryItemsArray(String[] string, String matcher){ //throw errors; get array of [food, price]

        return null;
    }

    public int missingItemsErrorCount(String[] input, String matcherText){
        Pattern p = Pattern.compile(matcherText);
        //do first w/o a try/catch block
        int length = input.length;
        System.out.println(length);
        for (String item : input) {
            Matcher m = p.matcher(item); //attempt to match the entire input sequence against the pattern
            if(!m.find()){

            } else {
                count += count;
            }
        }
        return length-count;
    }
}
