import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceParser {

    public HashMap<String, Integer> priceMapper(String[] array, String p) {
        HashMap<String, Integer> priceMap = new HashMap<>();
        ContainsRegex regex = new ContainsRegex();
        String pattern = p;
        for (String s : array) {
            if (regex.containsRegex(s, pattern) && !priceMap.containsKey(s) && !p.equals("")) {
                priceMap.put(s.substring(12, 25).replaceAll("[^\\d.]+", ""), 0);
            }
        }
        return getStringIntegerHashMap(array, p, priceMap);
    }

    private HashMap<String, Integer> getStringIntegerHashMap(String[] array, String p, HashMap<String, Integer> priceMap) {
        Pattern pricePattern = Pattern.compile(p);
        for (String s : priceMap.keySet()) {
            for(String text : array) {
                Matcher matcher = pricePattern.matcher(text);
                if (text.contains(s) && matcher.find()) {
                    priceMap.put(s, priceMap.get(s) + 1);
                }
            }
        }
        return priceMap;
    }
}
