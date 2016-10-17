/**
 * Created by evanhitchings on 10/17/16.
 */
public class JerkSONParser {

    public static String[] splitJerkSONByItem(String string){
        String[] splitByItem = string.split("(##)");
        return splitByItem;
    }

    public static String[][] splitJerkSONByField(String[] items){
        int lengthOfItems = items.length;
        String[][] splitByField = new String[lengthOfItems][4];
        for(int i = 0; i < lengthOfItems; i++){
            splitByField[i] = items[i].split("(;|\\^|\\*|%|!|@)");
        }
        return splitByField;
    }




}
