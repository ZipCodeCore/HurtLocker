import com.sun.javafx.binding.StringFormatter;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataChart {
    private DataCleaner cleaner;
    public DataChart() {
        this.cleaner = new DataCleaner();
    }

    public ArrayList<ParsedItems> listByFood(ArrayList<ParsedItems> list, String itemType) {

        return (ArrayList<ParsedItems>) list.stream().filter(z -> z.getName().equals(itemType)).collect(Collectors.toList());
    }

    public ArrayList<Double> getPrices(ArrayList<ParsedItems> items) {
        ArrayList<Double> prices = new ArrayList<>(items.stream().map(ParsedItems::getPrice)
                .collect(Collectors.toSet()));
        return prices;
    }

    public Set<String> foodLabel(ArrayList<ParsedItems> list) {
        HashSet<String> foodNames = (HashSet<String>) list.stream().map(ParsedItems::getName)
                .collect(Collectors.toSet());
        return foodNames;
    }

    public HashMap<Double, Integer> priceOccurence(ArrayList<ParsedItems> typeList) {
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
    }

    public void itemFormatter(Set<String> names, ArrayList<ParsedItems> typeList) {
        for (String name : names) {
            String label = name;
            ArrayList<ParsedItems> objList = listByFood(typeList, name);
            ArrayList<Double> prices = getPrices(objList);
            HashMap<Double, Integer> priceMap = priceOccurence(objList);
            Double price = prices.get(0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("name:\t" + name)
                    .append("\t\tseen: " + objList.size() + " times\n")
                    .append("=============\t\t=============\n");
            for (Double listing : prices) {
                Integer occurence = priceMap.get(listing);

                stringBuilder.append("Price:\t" + listing)
                        .append("\t\tseen: " + occurence + " times\n")
                        .append("-------------\t\t-------------\n");
            }
            System.out.println(stringBuilder);
        }
        System.out.println("Errors:\t \t\t\tseen: " + cleaner.getErrorCount()+("Errors") + " times\n");
    }
}