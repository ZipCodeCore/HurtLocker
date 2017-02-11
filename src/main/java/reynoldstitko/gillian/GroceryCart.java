package reynoldstitko.gillian;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by gillianreynolds-titko on 2/10/17.
 */
public class GroceryCart {

    ArrayList<ItemPriceAndQuantity> items;

    public GroceryCart(ArrayList<ItemPriceAndQuantity> items) {
        this.items = items;
    }

    public ArrayList<ItemPriceAndQuantity> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemPriceAndQuantity> items) {
        this.items = items;
    }
}
