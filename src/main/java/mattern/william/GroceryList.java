package mattern.william;

import java.util.*;

/**
 * Created by williammattern on 2/8/17.
 */
public class GroceryList {

    public List<GroceryListItem> list = new ArrayList<GroceryListItem>();

    public Collection<GroceryListItem> getAllGroceryListItems(){
        return this.list;
    }

    public void addGroceryListItemToList(GroceryListItem g){
        this.list.add(g);
    }

}
