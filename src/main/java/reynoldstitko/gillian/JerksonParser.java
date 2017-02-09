package reynoldstitko.gillian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

/**
 * Created by gillianreynolds-titko on 2/8/17.
 */
public class JerksonParser extends Exception {

    private ArrayList<String> cleanedStrings = new ArrayList<>();
    private Map<String, String> groceryItems = new HashMap<>();

    //1. split incoming file into individual rows of data
    public String[] splitIncomingStringFile(String inputStringFile, String matcher) {
        String input = inputStringFile;
        String[] splitFile = input.split(matcher);
        return splitFile;
    }

    //2. Get the various grocery item names; take a string array and go through each one (fix and prepare syntax for output)
    public ArrayList<String> findGroceryItem(String[] inputStringArray, String matcherText) {
        Pattern p = Pattern.compile(matcherText);

        //do first w/o a try/catch block
        for (String item : inputStringArray) {
            Matcher m = p.matcher(item);

            if(m.find()){
                String thisMatch = m.group();
                System.out.println("Match "+ item + thisMatch);
                cleanedStrings.add(item);
            }
        }
        return cleanedStrings;
    }

    //2. apply regex to each row of data - split into component (GroceryItem) objects;
    // catch errors (missing price, missing name)
    public GroceryItem[] createGroceryItemsArray(String[] string, String matcher){ //throw errors; get array of [food, price]
        return null;
    }

}
