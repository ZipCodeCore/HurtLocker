package io.derobert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static io.derobert.PatternMatcher.*;

public class ItemParser {
    private static ItemInventory inventory = new ItemInventory();
    private static Pattern keyValuePattern = Pattern.compile("([^:@^*%;!]*)(:)([^:@^*%;!]*)");
    private static int errorCount = 0;
    private static boolean nameFound = false;
    private static Item currentItem;

    public static Item getCurrentItem(){
        return currentItem;
    }

    public static String formatErrorCount(){
        return "Errors               seen: " + errorCount +" times";
    }

    public static void checkForError(String key, String value) throws EmptyKeyValueException{
        if( key.equals("") || value.equals("") ){
            errorCount++;
            throw new EmptyKeyValueException();
        }

    }

    public static void checkItemName(String name){
        if(foodIsMilk(name)) {
            currentItem = inventory.getMilk();
        }else if(foodIsBread(name)){
            currentItem = inventory.getBread();
        }else if(foodIsCookies(name)){
            currentItem = inventory.getCookies();
        }else if(foodIsApples(name)){
            currentItem = inventory.getApples();
        }
        currentItem.increaseNameCounter();
        nameFound = true;
    }

    public static String parseItems(String data) {
        String[] dataLines = data.split("##");

        for(String line: dataLines){
            Matcher matcher = keyValuePattern.matcher(line);
            nameFound = false;
            while(matcher.find()){
                String key = matcher.group(1);
                String value = matcher.group(3);
                try{
                    checkForError(key, value);
                }catch (EmptyKeyValueException e){
                    if(nameFound){
                        currentItem.decreaseNameCounterForError();
                    }
                    break;
                }

                if(stringIsName(key)) checkItemName(value);
                if(stringIsPrice(key)) currentItem.addPrice(value);
            }
        }

        return inventory.displayInventory();
    }
}
