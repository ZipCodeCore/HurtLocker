import java.util.ArrayList;

public class ExpirationDateParser {

    public ArrayList<String> expirationDateParser(String[] array, String p){
        ContainsRegex regex = new ContainsRegex();
        ArrayList<String> priceList = new ArrayList<String>();
        String pattern = p;
        for(String s : array){
            if(regex.containsRegex(s,pattern)){
                priceList.add(s.substring(25).replaceAll("[^\\d/]+", ""));
            }
        }
        return priceList;
    }

    public String expirationDateCounter(ArrayList<String> parsedDates, String date){
        Integer count = 0;
        for(String p : parsedDates){
            if(p.equals(date)){
                count++;
            }
        }
        return String.format("%-15s %15s", "Expiration date: " + date, "Seen: ") + count;
    }
}
