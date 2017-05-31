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

    public HashMap<String, GroceryItem> getItems() {
        return groceryList;
    }

    public ArrayList<GroceryItem> createItems(String itemString) {
        String[] itemStrings = parser.itemStrings(itemString);
        for (int i = 0; i < itemStrings.length; i++) {
            String[] itemInfo = parser.itemStringInfo(itemStrings[i]);
            for (int j = 0; j < itemInfo.length; j++) {
                if (itemInfo.equals("")) {
                    errorCount += 1;
                }
            }
            GroceryItem item = new GroceryItem(itemInfo);
            System.out.println(item.getNameOfItem());
            listOfItems.add(item);
            System.out.println(listOfItems.get(i));
        }
        return listOfItems;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public HashMap<String, GroceryItem> createList() {
        try {
            for (int i = 0; i < listOfItems.size(); i++) {
                if (!listOfItems.get(i).getNameOfItem().equalsIgnoreCase("")) {
                    boolean inMapAlready = listOfItems.get(i).getNameOfItem().matches()
                    if (!groceryList.containsKey(""))
                    groceryList.put(listOfItems.get(i).getNameOfItem(), listOfItems.get(i));
                }
            }
        }
        catch(NullPointerException npe) {
            errorCount += 1;
        }
        return groceryList;
    }
}
