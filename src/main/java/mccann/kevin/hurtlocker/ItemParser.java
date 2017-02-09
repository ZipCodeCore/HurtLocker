package mccann.kevin.hurtlocker;

import com.sun.javafx.binding.StringFormatter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by kevinmccann on 2/8/17.
 */
public class ItemParser {

    private int errorCount = 0;

    private String itemSplit = "((##))";
    private String stringSplit = "([:;^@%*!])";
    private String fieldSplit = "([A-Za-z0-9/.]+)";

    Pattern field = Pattern.compile(fieldSplit);

    ArrayList<Item> itemList = new ArrayList<Item>();
    ArrayList<String> itemStringList = new ArrayList<String>();
    ArrayList<String> justNamesOfItems = new ArrayList<String>();
    HashSet<String> itemSet = new HashSet<String>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    void addItemToList(Item item) {
        itemList.add(item);
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

    Map listAsMapAsCounter() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String string : itemStringList){
            Integer count = map.get(string);
            map.put(string, (count==null) ? 1: count + 1);
        }
        this.map = map;
        return map;
    }

    ArrayList<String> listAsJustNames() {
        for(Item item : itemList) {
            if(!(justNamesOfItems.contains(item.getName())))
                justNamesOfItems.add(item.getName());
        }
        return justNamesOfItems;
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
        s.append("Errors\t\t\t\t seen: "+getErrorCount()+" times\n");

        return s.toString();
    }

//    String outputCreatorScalable() {
//        StringBuilder n = new StringBuilder();
//        Object[] set = itemSet.toArray();
//        for(int i = 0; i<justNamesOfItems.size(); i++) {
//            n.append("name:    " + justNamesOfItems.get(i) + " \t\t seen: ");
//            n.append(map.get(justNamesOfItems.get(i))+ " times\n");
//            n.append("============= 	 	 =============\n");
//        }
//        return n.toString();
//    }

    public void run(String s) throws NoValueFoundException{
        createItemFromFields(s);
        makeListIntoSet();
        makeListIntoString();
        listAsMapAsCounter();
        System.out.println(outputCreator());
    }
}
