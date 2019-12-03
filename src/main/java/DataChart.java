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
        return itemDock.get().stream().filter(z -> z.getName() == itemType).map(e -> 1).reduce(0, Integer::sum);

    }

    public static ArrayList getPrices(Stream<ParsedItems> stream) {
        ArrayList<Double> prices = new ArrayList<>(stream.map(ParsedItems::getPrice)
                .collect(Collectors.toSet()));
        return prices;
    }

    public static Integer priceCount(Stream<ParsedItems> stream, ArrayList list, int index) {
        return stream.filter(z -> z.getPrice() == list.get(index)).map(e -> 1).reduce(0, Integer::sum);
    }


}