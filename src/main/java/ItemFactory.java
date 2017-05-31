import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by andrewwong on 5/31/17.
 */
public class ItemFactory {
    public static ArrayList<Item> createItemList(Stream<String> names, Stream<String> prices) {
        ArrayList<Item> itemList = new ArrayList<>();
        ArrayList<String> nameList = names.collect(Collectors.toCollection(ArrayList::new));
        ArrayList<String> priceList = prices.collect(Collectors.toCollection(ArrayList::new));
        String itemName;
        String itemPrice;
        for (int itemNumber = 0; itemNumber <= names.count(); itemNumber++) {
            itemName = nameList.get(itemNumber);
            itemPrice = priceList.get(itemNumber);
            // create item with that name and price
            // if itemList has an item with that name, add price to that item
            if(itemList.)
        }

    }
}
