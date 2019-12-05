import org.apache.commons.io.IOUtils;
import sun.tools.jstat.Token;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.function.IntToDoubleFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public String readRawDataToString() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String pepper = DataCleaner.jerkSeasoning(result);
        String cinnamon = DataCleaner.jerkSeasoning2(pepper);
        String tumeric = DataCleaner.jerkSeasoning3(cinnamon);
        String thyme = DataCleaner.jerkSeasoning4(tumeric);
        String lemon = DataCleaner.jerkSeasoning5(thyme);
        String cumin = DataCleaner.jerkSeasoning6(lemon);
        String chicken = DataCleaner.jerkSeasoning7(cumin);
        String cloves = DataCleaner.jerkSeasoning8(chicken);
        ArrayList<ParsedItems> pairedList = DataCleaner.pairParser(cloves);
        ArrayList<ParsedItems> appleList = listByFood(pairedList, "Apples");
        ArrayList<Double> applePrices = getPrices(appleList);
         HashMap<Double,Integer> price = priceOccurence(appleList);
        System.out.println(price);
        DataChart chart = new DataChart(pairedList);
        getPrices(pairedList);



        return null;


        /*return DataChart.itemChart(chart,"Milk") +
        DataChart.itemChart(chart, "Bread") +
        DataChart.itemChart(chart,"Cookies") +
        DataChart.itemChart(chart, "Apple");*/


    }

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }
    public static ArrayList<ParsedItems> listByFood (ArrayList<ParsedItems> list, String itemType) {

        return (ArrayList<ParsedItems>) list.stream().filter(z -> z.getName().equals(itemType)).collect(Collectors.toList());
    }






    public static Integer getFoodCount(ArrayList<ParsedItems>list, String itemType) {
        return list.stream().filter(z -> z.getName().equals(itemType)).map(e -> 1).reduce(0, Integer::sum);

    }
    public static ArrayList<Double> getPrices(ArrayList<ParsedItems>items)  {
        ArrayList<Double> prices = new ArrayList<>(items.stream().map(ParsedItems::getPrice)
                .collect(Collectors.toSet()));
        return prices;
    }
    public static HashMap<Double, Integer> priceOccurence(ArrayList<ParsedItems> typeList) {
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
 /*   public static ArrayList<Integer> priceCount(ArrayList<ParsedItems>typeList, ArrayList<Double> priceList, int index) {
        ArrayList<Integer> pCount = new ArrayList<>();
        for (Double a : priceList) {
            pCount.add(typeList.stream().filter(z -> z.getPrice() == a).map(e -> 1).reduce(0, Integer::sum));
        }
        return pCount;
    }*/

    }


    public static String itemChart(ArrayList<ParsedItems>list, String itemtype) {
        return "name:"+"    "+itemtype+" "+" \t\t seen: "+ getFoodCount(list,itemtype)+" times\n" +
                "============= \t \t =============\n" +
                "Price: \t "+getPrices(list) +" \t\t seen: 5 times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: 1 time\n";

}
}


