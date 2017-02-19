package ibikunle.tolani;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tolaniibikunle on 2/11/17.
 */
public class JerkSonParser {
    private final String stringPattern = "(\\w+:[a-z,A-Z,\\d+.\\d{2},c0\\d{1,2},\\d//\\d{2}//\\d{4}]+[;,#{2},^,*,@,!%])";
    public static int errorCount = 0;
    GroceryFactory groceryFactory = new GroceryFactory();

    public String[] splitStringIntoItems(String line) {
        return line.split("##");
    }

    public GroceryItem parseItem(String input) throws JerkSonException {
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(input);
        HashMap<String, String> inputMap = new HashMap<>();

        while (matcher.find()) {
            String output = matcher.group(1).toLowerCase();
            String[] outputArray = output.split(":");
            String key = outputArray[0];
            String value = outputArray[1].substring(0, outputArray[1].length() - 1);
            inputMap.put(key, value);
        }
        if (inputMap.size() < 4) throw new JerkSonException();
        return parseItemFromMap(inputMap);
    }

    public GroceryItem parseItemFromMap(HashMap inputMap) {
        GroceryItem groceryItem = groceryFactory.produceGrocery(inputMap);
        return groceryItem;
    }


    public ArrayList<GroceryItem> makeGroceryList(String passInString) {
        ArrayList<GroceryItem> temp = new ArrayList<>();
        String[] allObjects = splitStringIntoItems(passInString);
        for (String s : allObjects) {
            try {
                temp.add(parseItem(s));
            } catch (JerkSonException e) {
                e.printStackTrace();
                System.out.println("Item failed to create");
                errorCount++;
            }

        }
        return temp;
    }
}