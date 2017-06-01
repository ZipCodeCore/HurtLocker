import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by andrewwong on 5/31/17.
 */
public class Receipt {
    HashMap<String, ArrayList<String>> itemMap;

    public Receipt(HashMap<String, ArrayList<String>> itemMap) {
        this.itemMap = itemMap;
    }

    public String toString() {
        // get set of keys (names)
        // print name: key
        // print seen: timeSeen
        // print price and number of times that price occurs in the arraylist of prices
        StringBuilder sb = new StringBuilder();
        int numOfItems = itemMap.size();
        String[] nameArray = new String[numOfItems];
        itemMap.keySet().toArray(nameArray);

        int numOfSpaces;
        int lengthOfName;
        for(int i = 0; i < numOfItems; i++) {
            lengthOfName = nameArray[i].length();
            numOfSpaces = 8 - lengthOfName;
            sb.append("name:");
            for(int j = 0; j < numOfSpaces; j++) {
                sb.append(" ");
            }
            sb.append(nameArray[i]);
            sb.append("\t\tseen: ");
            sb.append(itemMap.get(nameArray[i]).size());
            sb.append(" times");
            sb.append("\n=============\t\t=============\n");
            sb.append("price:   ")
        }
        return sb.toString();
    }

}
