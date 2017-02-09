package mattern.william;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class GroceryReportFormatter {
    String drillDownBreak = "=============";
    String basicBreak = "-------------";
    String airGap = "          ";
    GroceryList gl;
    String drillDownLine = drillDownBreak + airGap + drillDownBreak;
    String basicBreakLine = basicBreak + airGap + basicBreak;

    public String formatSingleItemGroceryReport(TreeMap<String, Integer> singleItemData){
        StringBuilder singleItemString = new StringBuilder();
        int nameCount;
        String name;
        int priceCount;
        String price;

        for (Map.Entry<String,Integer> entry: singleItemData.entrySet()) {
            if (entry.getKey().equals("Milk") | entry.getKey().equals("Cookies") | entry.getKey().equals("Bread") | entry.getKey().equals("Apples")) {
                name = entry.getKey();
                nameCount = entry.getValue();
                String nameLine = formatNameLine(name, nameCount) + "\n";
                singleItemString.append(nameLine).append(drillDownLine).append("\n");
            }
        }

        for (Map.Entry<String, Integer> entry: singleItemData.entrySet()){
            if(entry.getKey().equals("Milk")| entry.getKey().equals("Cookies")| entry.getKey().equals("Bread")| entry.getKey().equals("Apples")) {
            }else{
                price = entry.getKey();
                priceCount = entry.getValue();
                String priceLine = formatPriceLine(price,priceCount) + "\n";
                singleItemString.append(priceLine).append(basicBreakLine).append("\n");
            }
        }
        return singleItemString.toString();
    }

    public String formatNameLine(String name, int count){
        String nameGap = "";
        String seenGap = "";
        String timeOrTimes;
        for (int i = 0; i < (drillDownBreak.length() - (5 + name.length())); i++){
            nameGap += " ";
        }
        if(count < 10){
            seenGap += " ";
        }
        if (count == 1){
            timeOrTimes = " time ";
        } else {
            timeOrTimes = " times";
        }
        return new StringBuilder().append("name:").append(nameGap).append(name)
                .append(airGap).append("seen:").append(seenGap).append(count)
                .append(timeOrTimes).toString();
    }

    public String formatPriceLine(String price, int count){
        String priceGap = "";
        String seenGap = "";
        String timeOrTimes;
        for (int i = 0; i < (drillDownBreak.length() - (6 + price.length())); i++){
            priceGap += " ";
        }
        if(count < 10){
            seenGap += " ";
        }
        if (count == 1){
            timeOrTimes = " time ";
        } else {
            timeOrTimes = " times";
        }
        return new StringBuilder().append("Price:").append(priceGap).append(price)
                .append(airGap).append("seen:").append(seenGap).append(count)
                .append(timeOrTimes).toString();
    }

    public TreeMap<String, Integer> nameAndPriceCountMapper(GroceryList groceryList, String name){
       TreeMap<String, Integer> dataMap = new TreeMap<String, Integer>();
       Integer countOfNameOccurences = 0;
       for (GroceryListItem gli: groceryList.list){
           if(gli.getName().equals(name)){
               countOfNameOccurences++;
               if(dataMap.keySet().contains(gli.getPrice())){
                   Integer countOfPriceOccurences = dataMap.get(gli.getPrice());
                   countOfPriceOccurences++;
                   dataMap.put(gli.getPrice(),countOfPriceOccurences);
               } else {
                   Integer countOfPriceOccurences = 1;
                   dataMap.put(gli.getPrice(), countOfPriceOccurences);
               }
           }
       }
       dataMap.put(name, countOfNameOccurences);
       return dataMap;
    }
}