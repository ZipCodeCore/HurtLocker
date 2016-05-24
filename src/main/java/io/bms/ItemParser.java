package io.bms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by samhudgens on 5/24/16.
 */
public class ItemParser {

    private HashMap<String,Item> groceryMap = new HashMap<>();

    public void engine(String input){
        String[] itemsArray = StringUtilities.parseStringArray(input);
        for(int i = 0; i < itemsArray.length; i++){
            String[] currentItemArray = StringUtilities.splitStringIntoKeyValuePairs(itemsArray[i]);
            String currentItemName = addItem(currentItemArray[0]);
            addPrice(currentItemName,currentItemArray[1]);
        }
        printGroceryMap();
        printErrors();
    }

    private void printErrors() {
        System.out.println(Error.formattedToString());
    }

    private void printGroceryMap() {
        for(HashMap.Entry<String,Item> entry : groceryMap.entrySet()){
            System.out.println(entry.getValue().formattedToString());
        }
    }

    public String addItem(String currentItem){
        String itemName;
        try{
            itemName = StringUtilities.grabValue(currentItem);

        }catch (Error e){itemName = null;}
        if(itemName!=null){
            itemName = StringUtilities.normalizeWord(itemName);
            itemName = StringUtilities.spellingCorrector(itemName);
            if(!checkItemExist(itemName)){
                Item item = new Item(itemName);
                groceryMap.put(itemName,item);
            }
        }
        return itemName;
    }

    private void addPrice(String itemName, String currentPrice){
        String price = null;
        try{
            price = StringUtilities.grabValue(currentPrice);

        }catch (Error e){itemName = null;}

        if((price!=null)&&(itemName!=null)){
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
