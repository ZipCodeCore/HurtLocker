import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

/**
 * Created by randallcrame on 2/8/17.
 */
public class GroceryList {
    TreeMap<String, ArrayList<GroceryItem>> groceryList = new TreeMap<>();

    public String lookUp(String K){
        if (groceryList.isEmpty())
            return "List Empty";
        else if (groceryList.containsKey(K)){
            String list = "";
            for (GroceryItem value : groceryList.get(K))
                list += value +"\n";
            return list;
        }
        return "Name not listed";
    }
    private String getKeyClassToString(GroceryItem name){
        return name.getClass().getSimpleName().toString();
    }

    public void add(GroceryItem K){
        String name = getKeyClassToString(K);
        ArrayList<GroceryItem> holder = groceryList.get(name);
        if (holder == null){
            holder= new ArrayList<GroceryItem>();
            groceryList.put(name, holder);
        }
        holder.add(K);
        groceryList.put(name, holder);
    }

    public String printList(){

            return null;

    }

}
