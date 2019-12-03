import org.apache.commons.io.IOUtils;
import sun.tools.jstat.Token;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.IntToDoubleFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    public static HashMap<Double, String> getPrices(ArrayList<ParsedItems> list) {

        HashMap<Double, String> foodPrices = new HashMap<>();
        for (ParsedItems i : list) {
            foodPrices.put(i.getPrice(), i.getName());
        }

        return foodPrices;

    }
    public static Integer getFoodCount(ArrayList<ParsedItems>list, String itemType) {
        return list.stream().filter(z -> z.getName() == itemType).map(e -> 1).reduce(0, Integer::sum);

    }
    public Integer priceCount(HashMap<Double,String>price){
        return null;
    }



    public static String itemChart(ArrayList<ParsedItems>list, String itemtype) {
        return "name:"+"    "+itemtype+" "+" \t\t seen: "+ getFoodCount(list,itemtype)+" times\n" +
                "============= \t \t =============\n" +
                "Price: \t "+getPrices(list) +" \t\t seen: 5 times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: 1 time\n";

}
}


