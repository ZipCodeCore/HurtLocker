import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemCounter {

    public String itemCounter(String[] array, String p, String item){
        ContainsRegex regex = new ContainsRegex();
        String pattern = p;
        Integer count = 0;

        Pattern pricePattern = Pattern.compile("(?<!(?:\\d|\\.))\\d+\\.\\d{2}(?!\\.)");

        for (String s : array) {
            Matcher matcher = pricePattern.matcher(s);
            if (regex.containsRegex(s, pattern) && matcher.find()) {
                count++;
            }
        }
        return String.format("%-15s %15s", "Name: " + item, "Seen: ") + count;
    }
}
