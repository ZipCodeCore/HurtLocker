import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;


/**
 * Created by randallcrame on 2/8/17.
 */
public class JerkSonReader {
    HashMap<String, String> regexCodes = new HashMap<>();
    String data;
    int errors = 0;

    JerkSonReader(String data){
        this.data = data;
    }
    {
        regexCodes.put("Object" , "([# #]+)");
        regexCodes.put("Values", "([;^%*!@]+)");
        regexCodes.put("KeyAndValue", "([:]+)");
        regexCodes.put("Cookies", "c..kies");
    }

    private String[] finderToArray(String data, String regex) {
        return data.split(regex);
    }

    protected String[] ObjectValuesToArray(){
        return finderToArray(this.data,regexCodes.get("Object"));
    }

    protected String[] ValuesToArray(String data){
        return finderToArray(data, regexCodes.get("Values"));
    }

    protected String[] ValuesToKeyAndValue(String data){
        return finderToArray(data, regexCodes.get("KeyAndValue"));
    }

    protected GroceryItem createItem(String data) {
        String[] holder = ValuesToArray(data);
        String name = (ValuesToKeyAndValue(holder[0]).length == 1)? "":(ValuesToKeyAndValue(holder[0])[1]);
        String price = (ValuesToKeyAndValue(holder[1]).length == 1)? "":ValuesToKeyAndValue(holder[1])[1];
        String type = (ValuesToKeyAndValue(holder[2]).length == 1)? "":ValuesToKeyAndValue(holder[2])[1];
        String expiration = (ValuesToKeyAndValue(holder[3]).length == 1)? "":ValuesToKeyAndValue(holder[3])[1];

        name = name.toLowerCase();

        if (Pattern.matches(regexCodes.get("Cookies"), name))
            name = "cookies";

        switch(name){
            case "milk": return new GroceryItem("Milk", price, type, expiration);
            case "bread": return new GroceryItem("Bread", price, type, expiration);
            case "cookies": return new GroceryItem("Cookies", price, type, expiration);
            case "apples": return new GroceryItem("Apples", price, type, expiration);
            default : return null;
        }
    }
    protected ArrayList<GroceryItem> convertDataToGroceries() {
        ArrayList<GroceryItem> holder = new ArrayList<>();
        String[] splitByObject = ObjectValuesToArray();
        for (String item : splitByObject) {
            if (createItem(item) == null || createItem(item).getPrice().isEmpty())
                errors++;
            else
                holder.add(createItem(item));
        }
    return holder;
    }

    public int getErrors() {
        return errors;
    }
}
