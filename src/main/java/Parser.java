import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        



        Pattern milk = Pattern.compile("([M|m].\\w+[k|K])");
        Matcher milkMatcher = milk.matcher(file);
        int milkCounter=0;
        Pattern bread = Pattern.compile("([B|b].\\w+[D|d])");
        Matcher breadMatcher = bread.matcher(file);
        int breadCounter=0;
        Pattern cookies = Pattern.compile("([C|c].\\w+[S|s])");
        Matcher cookiesMatcher = cookies.matcher(file);
        int cookieCounter=0;
        Pattern apples = Pattern.compile("([A|a].\\w+[S|s])");
        Matcher applesMatcher = apples.matcher(file);
        int appleCounter=0;
        Pattern priceName = Pattern.compile("([P|p].\\w+[e].)");
        Matcher priceNameMatcher = priceName.matcher(file);
        int priceCounter=0;
        Pattern cost = Pattern.compile("(\\d\\.\\d+)");
        Matcher costMatcher = cost.matcher(file);
        int costCounter=0;

//        Pattern pattern = Pattern.compile("([N|n].\\w+[E|e].)|()([M|m].\\w+[k|K])|([B|b].\\w+[D|d])|([A|a].\\w+[S|s])|([C|c].\\w+[S|s])|([P|p].\\w+[e].)|(\\d\\.\\d+)");
//        Matcher matcher = pattern.matcher(file);
       // System.out.println(lineBreakerArray);


        while (milkMatcher.find()){
            System.out.println(milkMatcher.group(1));
            milkCounter++;

            while (costMatcher.find()){
                System.out.println(costMatcher.group(1));
                costCounter++;
            }
        }
        System.out.println(milkCounter);

        while (breadMatcher.find()){
            System.out.println(breadMatcher.group(1));
            breadCounter++;
        }

        while (cookiesMatcher.find()){
            System.out.println(cookiesMatcher.group(1));
            cookieCounter++;
        }

        while (applesMatcher.find()){
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


//    public String milk(){
//        ArrayList<String> lineBreaker = lineBreaker(file);
//        System.out.println(lineBreaker);
//        Pattern pattern = Pattern.compile("(^\\w+.?[M|m][i|I][l|L][k|K])");
//        Matcher matcher = pattern.matcher(file);
//
//        while (matcher.find()) {
//            lineBreaker.add(matcher.group());
//        }
//        System.out.println(lineBreaker);
//        return "";
//    }


}
