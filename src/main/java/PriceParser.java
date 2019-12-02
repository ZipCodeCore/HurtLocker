import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceParser {

    public ArrayList<String> priceParser(String[] array, String p){
        ContainsRegex regex = new ContainsRegex();
        ArrayList<String> priceList = new ArrayList<String>();
        String pattern = p;
        Pattern pricePattern = Pattern.compile("(?<!(?:\\d|\\.))\\d+\\.\\d{2}(?!\\.)");
        for(String s : array){
            Matcher matcher = pricePattern.matcher(s);
            if(regex.containsRegex(s,pattern)){
                priceList.add(s.substring(12,25).replaceAll("[^\\d.]+", ""));
            }
        }
        return priceList;
    }

    public String priceCounter(ArrayList<String> parsedPrices, String price){
        Integer count = 0;
        for(String p : parsedPrices){
            if(p.equals(price)){
                count++;
            }
        }
        return String.format("%-15s %15s", "Price: $" + price, "Seen: ") + count;
    }
}
