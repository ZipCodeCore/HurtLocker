import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

/**
 * Created by randallcrame on 2/8/17.
 */
public class GroceryList {
    TreeMap<String, ArrayList<GroceryItem>> groceryList = new TreeMap<>();

    public void add(GroceryItem item) {
            String name = item.getName();
            String price = item.getPrice();
            ArrayList<GroceryItem> holder = groceryList.get(name);
            if (holder == null) {
                holder = new ArrayList<>();
                groceryList.put(name, holder);
            }
            holder.add(item);
            groceryList.put(name, holder);
    }

    public void addToGroceryList(ArrayList<GroceryItem> list){
        for (GroceryItem item : list) {
            this.add(item);
        }
    }

    public TreeMap<String, ArrayList<GroceryItem>> getGroceryList() {
        return groceryList;
    }
}
