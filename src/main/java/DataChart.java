import com.sun.javafx.binding.StringFormatter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataChart {
    ArrayList<ParsedItems> itemDock;


    public DataChart(List itemDock) {
        this.itemDock = new ArrayList<ParsedItems>();
    }


    public List<ParsedItems> get() {
        return itemDock;
    }


    public static Stream<ParsedItems> getFoodStream(DataChart itemDock, String itemType) {

        return itemDock.get().stream().filter(z -> z.getName() == itemType);
    }


    public static Integer getFoodCount(DataChart itemDock, String itemType) {
        Long foodcount = itemDock.get().stream().filter(z -> z.getName().equals(itemType)).count();
        return foodcount.intValue();
        // map(e -> 1).reduce(0, Integer::sum);

    }

    public static ArrayList<Double> getPrices(Stream<ParsedItems> stream) {
        ArrayList<Double> prices = new ArrayList<>(stream.map(ParsedItems::getPrice)
                .collect(Collectors.toSet()));
        return prices;
    }


    public static HashMap<Double, Integer> priceCount(ArrayList<ParsedItems> typeList) {
        HashMap<Double, Integer> prices = new HashMap<>();
        typeList.stream().forEach(t -> {
            Double currentPrice = t.getPrice();
            if (!prices.containsKey(currentPrice)) {
                prices.put(currentPrice, 1);
            } else {
                prices.put(currentPrice, prices.get(currentPrice) + 1);
            }
        });
        return prices;
        /* for (Double a: priceList){
            pCount.add(typeList.stream().filter(z -> z.getPrice() == a).map(e -> 1).reduce(0, Integer::sum));
        }
        return pCount:
    }*/
    }
}