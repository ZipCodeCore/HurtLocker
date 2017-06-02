
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by aurorabanuelos on 5/31/17.
 */
public class Parser {

    public static int exceptionCount = 0;
    private List<String> byLine;
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private ArrayList<String> findItemCountList = new ArrayList<String>();

    public List<String> parseString(String string) {

        byLine = Arrays.asList(string.split("##"));
        return byLine;
    }

    public String matchPairPattern(String regex, String byLineString) {

        String pairValue = "";
        Pattern findPairValue = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher pairValueMatcher = findPairValue.matcher(byLineString);

        try {
            if (pairValueMatcher.find() == false) {
                throw new NoPatternMatchedException("not found");
            } else {
                pairValue = pairValueMatcher.group();
                return pairValue;
            }
        } catch (NoPatternMatchedException e) {
            exceptionCount += 1;
            return null;
        }

    }

    public ArrayList<Item> createItemList() {

        for (int i = 0; i < byLine.size(); i++) {

            itemList.add(new Item(matchPairPattern("(?<=[Nn][Aa][Mm][Ee].)[A-Za-z0-9]+", byLine.get(i)),
                    matchPairPattern("(?<=[Pp][Rr][Ii][Cc][Ee].)[0-9]+\\.[0-9]{2}", byLine.get(i)),
                    matchPairPattern("(?<=[Tt][Yy][Pp][Ee].)[A-Za-z0-9]+", byLine.get(i)),
                    matchPairPattern("(?<=[Ee][Xx][Pp][Ii][Rr][Aa][Tt][Ii][Oo][Nn].).+\\b", byLine.get(i))));
        }
        return itemList;
    }

    public int getItemListSize() {
        return itemList.size();
    }


    public String findItemCount(String regex, String item) {

        Pattern findName = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        for (int i = 0; i < itemList.size(); i++) {

            if (itemList.get(i).getName() != null && itemList.get(i).getPrice() != null) {
                Matcher findItemCountMatcher = findName.matcher(itemList.get(i).getName());

                if (findItemCountMatcher.find() == true) {
                    findItemCountList.add(itemList.get(i).getPrice());
                }
            }
        }

        return "Name:\t" + item + "\t\tseen: " + findItemCountList.size() + " times";
    }

    public String priceCount() {
        String output = "";

        Set<String> priceCountSet = new HashSet<String>(findItemCountList);
        for (String price : priceCountSet) {
            output += "Price:\t"+ price + "\t\tseen: " + Collections.frequency(findItemCountList, price) + " times\n";
        }
        findItemCountList.clear();
        return output.trim();
    }

    public String outputErrors(){

        return "Errors:\t\t\t\tseen: "+ exceptionCount +" times";

    }

    public void createNewOutputFile(String input) throws Exception{
        PrintStream out = new PrintStream(new FileOutputStream("outputAfterParsing.txt"));

        Map<String, String> regexItem = new HashMap<String, String>();

        regexItem.put("[Cc].+[sS]", "Cookies");
        regexItem.put("[Mm].{2}[Kk]", "Milk");
        regexItem.put("[Bb].{3}[Dd]", "Bread");
        regexItem.put("[Aa][Pp].+[sS]", "Apples");


        parseString(input);
        createItemList();

        for(Map.Entry<String, String> entry : regexItem.entrySet()) {
            out.println(findItemCount(entry.getKey(), entry.getValue()));
            out.println(priceCount());
            out.println();
        }

        out.println(outputErrors());
    }

}
