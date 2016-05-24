package io.bms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by samhudgens on 5/24/16.
 */
public class ItemParser {

    HashMap<String,Item> groceryMap = new HashMap<>();
    String currentItemKey;

    public void engine(String input){
        String[] itemsArray = StringUtilities.parseStringArray(input);
        for(int i = 0; i < itemsArray.length; i++){
            String[] currentItemArray = StringUtilities.splitStringIntoKeyValuePairs(itemsArray[i]);
            addItem(currentItemArray[0],currentItemArray[1]);
        }
        printGroceryMap();
        printErrors();
    }

    private void printErrors() {
        System.out.println(Error.formatedToString());
    }

    private void printGroceryMap() {
        for(HashMap.Entry<String,Item> entry : groceryMap.entrySet()){
            System.out.println(entry.getValue().formattedToString());
        }
    }

    public void addItem(String currentItem, String currentPrice){
        String price = null;
        String itemName;


        try{
            itemName = StringUtilities.grabValue(currentItem);

        }catch (Error e){itemName = null;}

        try{
            price = StringUtilities.grabValue(currentPrice);

        }catch (Error e){itemName = null;}



        if(itemName!=null){
            itemName = StringUtilities.normalizeWord(itemName);

            itemName = StringUtilities.spellingCorrector(itemName);
            if(!checkItemExist(itemName)){
                Item item = new Item(itemName);
                groceryMap.put(itemName,item);
            }
        }
        if((price!=null)&&(itemName!=null)){
            price = StringUtilities.normalizeWord(price);

            if(groceryMap.get(itemName).checkPriceExists(price)){
                groceryMap.get(itemName).addCounter(price);
            }
            else{
                groceryMap.get(itemName).addPriceOccurence(price);
            }
        }







    }

    public boolean checkItemExist(String itemName){
        return groceryMap.containsKey(itemName);
    }
}
