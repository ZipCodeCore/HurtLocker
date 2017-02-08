import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kevinmccann on 2/8/17.
 */
public class ItemParser {

    private int errorCount = 0;
    int[] counters = new int[4];

    private String itemSplit = "((##))";
    private String stringSplit = "([:;^@%*!])";
    private String fieldSplit = "([A-Za-z0-9//.]+)";

    Pattern field = Pattern.compile(fieldSplit);

    ArrayList<Item> itemList = new ArrayList<Item>();
    ArrayList<String> itemStringList = new ArrayList<String>();
    HashSet<String> itemSet = new HashSet<String>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    void addItemToList(Item item) {
        itemList.add(item);
    }

    String[] splitItems(String list) {
        return list.split(itemSplit);
    }

    String[] splitStrings(String singleItem) {
        return singleItem.split(stringSplit);
    }

    String getItemField(String string, int index) throws NoValueFoundException {
        try {
            Matcher match = field.matcher(splitStrings(string)[index]);
            if (match.find())
                return sanitizeName(match.group());
            else
                throw new NoValueFoundException();
        } catch (NoValueFoundException e) {
            errorCount++;
            return null;
        }
    }

    void createItemFromFields(String string) throws NoValueFoundException {
        for(String s : string.split(itemSplit)) {
            addItemToList(new Item(getItemField(s,1), getItemField(s,3)));
        }
    }

    String sanitizeName(String name) {
        if(name.toLowerCase().charAt(0) == 'm')
            return "Milk";
        if(name.toLowerCase().charAt(0) == 'c')
            return "Cookies";
        if(name.toLowerCase().charAt(0) == 'a')
            return "Apples";
        if (name.toLowerCase().charAt(0) == 'b')
            return "Bread";
        else
            return name;
        }

    public int getErrorCount() {
        return errorCount;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    int[] countCreator () {
        int[] counts = new int[itemSet.size()];
        for (int i = 0; i<itemSet.size();i++) {
            counts[i] = Collections.frequency(itemStringList, itemSet.iterator().next());
        }
        return counts;
    }

    void makeListIntoSet() {
        for(Item item: itemList)
            if(!(item.getName()==null||item.getPrice()==null))
                itemSet.add(item.toString());
        }

    void makeListIntoString() {
        for(Item item:itemList) {
            itemStringList.add(item.toString());
        }
    }

    int getCount(String name) {
        return Collections.frequency(itemStringList, "((milk))*");
    }

    Map listAsMap() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String string : itemStringList){
            Integer count = map.get(string);
            map.put(string, (count==null) ? 1: count + 1);
        }
        this.map = map;
        return map;
    }

    String outputCreator() {
        StringBuilder s = new StringBuilder();
        Object[] set = itemSet.toArray();
        s.append("name:    Milk \t\t seen: ");
        s.append(map.get(set[1])+map.get(set[0]) + " times\n");
        s.append("============= 	 	 =============\n");
        s.append("Price: \t " + set[0].toString().substring(5,9));
        s.append("\t\t seen: " + map.get(set[0]) + " times\n");
        s.append("-------------\t\t -------------\n");
        s.append("Price: \t " + set[1].toString().substring(5,9));
        s.append("\t\t seen: " + map.get(set[1]) + " times\n\n");
        s.append("name: Cookies \t\t seen: ");
        s.append(map.get(set[2]) + " times\n");
        s.append("============= 	 	 =============\n");
        s.append("Price: \t " + set[2].toString().substring(8,12));
        s.append("\t\t seen: " + map.get(set[2]) + " times\n");
        s.append("-------------\t\t -------------\n\n");
        s.append("name:  Apples \t\t seen: ");
        s.append(map.get(set[3])+map.get(set[4]) + " times\n");
        s.append("============= 	 	 =============\n");
        s.append("Price: \t " + set[3].toString().substring(7,11));
        s.append("\t\t seen: " + map.get(set[3]) + " times\n");
        s.append("-------------\t\t -------------\n");
        s.append("Price: \t " + set[4].toString().substring(7,11));
        s.append("\t\t seen: " + map.get(set[4]) + " times\n\n");
        s.append("name:   Bread \t\t seen: ");
        s.append(map.get(set[5]) + " times\n");
        s.append("============= 	 	 =============\n");
        s.append("Price: \t " + set[5].toString().substring(6,10));
        s.append("\t\t seen: " + map.get(set[5]) + " times\n");
        s.append("-------------\t\t -------------\n\n");
        s.append("Errors\t\t\t\t seen: "+errorCount+" times\n");

        return s.toString();
    }

}
