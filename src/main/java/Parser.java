
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aurorabanuelos on 5/31/17.
 */
public class Parser {

    public static int exceptionCount = 0;
    private List<String> byLine;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    public List<String> parseString(String string) {

        byLine = Arrays.asList(string.split("##"));
        return byLine;
    }

    public String matchNamePattern(String string) {
        String name = "";
        Pattern findItemName = Pattern.compile("(?<=[Nn][Aa][Mm][Ee].)[A-Za-z0-9]+", Pattern.CASE_INSENSITIVE);
        Matcher itemMatcher = findItemName.matcher(string);

        try {
            if (itemMatcher.find() == false) {
                throw new NoPatternMatchedException("not found");
            } else {
                name = itemMatcher.group();
                return name;
            }
        } catch (NoPatternMatchedException e) {
            exceptionCount += 1;
            return null;
        }
    }

    public double matchPricePattern(String string) {
        double price = 0.0;
        Pattern findPriceAmount = Pattern.compile("(?<=[Pp][Rr][Ii][Cc][Ee].)[0-9]+\\.[0-9]{2}", Pattern.CASE_INSENSITIVE);
        Matcher priceMatcher = findPriceAmount.matcher(string);

        try {
            if (priceMatcher.find() == false) {
                throw new NoPatternMatchedException("not found");
            } else {
                price = Double.parseDouble(priceMatcher.group());
                return price;
            }
        } catch (NoPatternMatchedException e) {
            exceptionCount += 1;
            return 0;
        }
    }

    public String matchTypePattern(String string) {
        String type = "";
        Pattern findTypeName = Pattern.compile("(?<=[Tt][Yy][Pp][Ee].)[A-Za-z0-9]+", Pattern.CASE_INSENSITIVE);
        Matcher typeMatcher = findTypeName.matcher(string);

        try {
            if (typeMatcher.find() == false) {
                throw new NoPatternMatchedException("not found");
            } else {
                type = typeMatcher.group();
                return type;
            }
        } catch (NoPatternMatchedException e) {
            exceptionCount += 1;
            return null;
        }

    }

    public String matchExpirationPattern(String string) {

        String expiration = "";
        Pattern findExpiration = Pattern.compile("(?<=[Ee][Xx][Pp][Ii][Rr][Aa][Tt][Ii][Oo][Nn].).+\\b", Pattern.CASE_INSENSITIVE);
        Matcher expirationMatcher = findExpiration.matcher(string);

        try {
            if (expirationMatcher.find() == false) {
                throw new NoPatternMatchedException("not found");
            } else {
                expiration = expirationMatcher.group();
                return expiration;
            }
        } catch (NoPatternMatchedException e) {
            exceptionCount += 1;
            return null;
        }

    }

    public ArrayList<Item> createItemList(){

        for(int i =0; i < byLine.size(); i++){

                itemList.add(new Item(matchNamePattern(byLine.get(i)), matchPricePattern(byLine.get(i)),
                        matchTypePattern(byLine.get(i)), matchExpirationPattern(byLine.get(i))));
        }
        return itemList;
    }

    public int getItemListSize(){
        return itemList.size();
    }

}
