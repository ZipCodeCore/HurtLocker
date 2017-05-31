import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by anthonyjones on 5/31/17.
 */
public class Parser {


//    Parser(){
//
//    }

    // 28 take away the count of other items should equal the amount of error

    public String patternMatch(String file) {
        ArrayList<String> lineBreakerArray = lineBreaker(file);
        // System.out.println(lineBreakerArray);

        Pattern milk = Pattern.compile("([M|m].\\w+[k|K][^,]+)");
        Matcher milkMatcher = milk.matcher(lineBreakerArray.toString());
        ArrayList<String> milkArray = new ArrayList<>();
        String milkOutput = "";
        int milkCounter = 0;

        Pattern bread = Pattern.compile("([B|b].\\w+[D|d])");
        Matcher breadMatcher = bread.matcher(file);
        int breadCounter = 0;
        Pattern cookies = Pattern.compile("([C|c].\\w+[S|s])");
        Matcher cookiesMatcher = cookies.matcher(file);
        int cookieCounter = 0;
        Pattern apples = Pattern.compile("([A|a].\\w+[S|s])");
        Matcher applesMatcher = apples.matcher(file);
        int appleCounter = 0;
        Pattern priceName = Pattern.compile("([P|p].\\w+[e].)");
        Matcher priceNameMatcher = priceName.matcher(file);
        int priceCounter = 0;
        Pattern cost = Pattern.compile("(\\d\\.\\d+)");
        Matcher costMatcher = cost.matcher(file);
        int costCounter = 0;

        while (milkMatcher.find()) {
            milkCounter++;
            milkArray.add(milkMatcher.group(1));
        }
//        milkOutput
        milkBreakDown(milkArray, milkCounter);

        while (breadMatcher.find()) {
            System.out.println(breadMatcher.group(1));
            breadCounter++;
        }

        while (cookiesMatcher.find()) {
            System.out.println(cookiesMatcher.group(1));
            cookieCounter++;
        }

        while (applesMatcher.find()) {
            System.out.println(applesMatcher.group(1));
            appleCounter++;
        }


        return "";
    }

    public ArrayList<String> lineBreaker(String file) {
        Pattern pattern = Pattern.compile("[^#]+");
        Matcher matcher = pattern.matcher(file);
        ArrayList<String> arrayListOfBrokenLines = new ArrayList<>();
        while (matcher.find()) {
            arrayListOfBrokenLines.add(matcher.group());
        }
        return arrayListOfBrokenLines;
    }


    public String milkBreakDown(ArrayList<String> arrayOfMilk, int milkCounter) {
        Pattern pattern = Pattern.compile("(\\d\\.\\d+)");
        Matcher matcher = pattern.matcher(arrayOfMilk.toString());
        ArrayList<String> price = new ArrayList<>();

        while (matcher.find()) {
            price.add(matcher.group(1));
        }
        Collections.sort(price, Collections.reverseOrder());

        Map<String, Long> counted = price.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String formattedForOutput = String.format("name:\tMilk\t\t\tseen: %s times\n=============\t\t\t=============\nPrice:\t%s\t\t\tseen: %s times\n-------------\t\t\t-------------\nPrice:\t%s\t\t\tseen: %s time\n",
                milkCounter,
                counted.keySet().toArray()[1],
                counted.values().toArray()[1],
                counted.keySet().toArray()[0],
                counted.values().toArray()[0]);

        return formattedForOutput;
    }


}
