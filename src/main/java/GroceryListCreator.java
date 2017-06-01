import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sarahweisser on 5/31/17.
 */
public class GroceryListCreator {
    private HashMap<String, GroceryItem> groceryList = new HashMap<String, GroceryItem>();
    private ArrayList<GroceryItem> listOfItems = new ArrayList<GroceryItem>();
    private Parser parser = new Parser();
    private int errorCount = 0;

    public ArrayList<GroceryItem> getItems() {
        return listOfItems;
    }

    public ArrayList<String> createItemKeys(String itemString) {
        String[] itemStrings = parser.itemStrings(itemString);
        ArrayList<String> itemNames = itemNames(itemStrings);
        String[] uniqueNames = findUniqueItemNames(itemNames);
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0; i < uniqueNames.length; i++) {
            keys.add(uniqueNames[i]);
        }
        return keys;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public ArrayList<String> itemNames(String[] itemStrings) {
        ArrayList<String> itemNames = new ArrayList<>();
        try {
            for (int i = 0; i < itemStrings.length; i++) {
                String[] infoAboutItem = parser.itemStringInfo(itemStrings[i]);
                String nameOfItem = infoAboutItem[1];
                itemNames.add(nameOfItem);
            }
        }
        catch (NullPointerException npe) {
            errorCount += 1;
        }
        return itemNames;
    }

    public String[] findUniqueItemNames(ArrayList<String> itemNames) {
        String[] uniqueItemNames = parser.checkIfSameItem(itemNames);
        return uniqueItemNames;
    }

    /*String[] itemInfo = parser.itemStringInfo(itemStrings[i]);
    boolean hasError = false;
            for (int j = 0; j < itemInfo.length; j++) {
        if (itemInfo[j].equals("")) {
            hasError = true;
            errorCount += 1;
        }
    }
            if (!hasError) {
        GroceryItem item = new GroceryItem(itemInfo);
        listOfItems.add(item);
    }
}
        return listOfItems;*/
}
