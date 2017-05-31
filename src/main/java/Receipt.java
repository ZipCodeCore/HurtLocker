import java.util.ArrayList;

/**
 * Created by andrewwong on 5/31/17.
 */
public class Receipt {
    private ArrayList<Item> items;

    public Receipt() {
        this.items = new ArrayList<>();
    }

    public void addItemToReceipt(Item item) {
        items.add(item);
    }

    public Item getItem(int index) {
        return items.get(index);
    }
}
