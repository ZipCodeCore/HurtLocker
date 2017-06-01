import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by andrewwong on 5/31/17.
 */
public class MapFactory {
    public static HashMap<String, ArrayList<String>> createItemMap(Stream<String> names, Stream<String> prices, int numOfPrices) {
        HashMap<String, ArrayList<String>> itemMap = new HashMap<>();
        ArrayList<String> nameList = names.collect(Collectors.toCollection(ArrayList::new));
        ArrayList<String> priceList = prices.collect(Collectors.toCollection(ArrayList::new));
        String itemName;
        String itemPrice;
        for (int itemNumber = 0; itemNumber < numOfPrices; itemNumber++) {
            itemName = nameList.get(itemNumber);
            itemPrice = priceList.get(itemNumber);
            // create item with that name and price
            // if itemList has an item with that name, add price to that item
            if(itemMap.containsKey(itemName)) {
                itemMap.get(itemName).add(itemPrice);
            } else {
                itemMap.put(itemName, new ArrayList<>());
                itemMap.get(itemName).add(itemPrice);
            }
        }
        return itemMap;
    }

    public static HashMap<String, Integer> createPriceMap(ArrayList<String> prices) {
        HashMap<String, Integer> priceMap = new HashMap<>();
        String priceKey;
        int timesPriceSeen;
        for(int i = 0; i < prices.size(); i++) {
            priceKey = prices.get(i);
            if(!priceMap.containsKey(priceKey)) {
                priceMap.put(priceKey, 1);
            } else {
                timesPriceSeen = priceMap.get(priceKey);
                timesPriceSeen++;
                priceMap.put(priceKey, timesPriceSeen);
            }
        }
        return priceMap;
    }
}
