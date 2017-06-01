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

    public ArrayList<GroceryItem> createItems(String itemString) {
        String[] itemStrings = parser.itemStrings(itemString);
        for (int i = 0; i < itemStrings.length; i++) {
            String[] itemInfo = parser.itemStringInfo(itemStrings[i]);
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
        return listOfItems;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public ArrayList<String> itemNames() {
        ArrayList<String> itemNames = new ArrayList<>();
        for (int i = 0; i < listOfItems.size(); i++) {
            itemNames.add(listOfItems.get(i).getNameOfItem());
        }
        return itemNames;
    }
}
