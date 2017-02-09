import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.regex.Pattern;

/**
 * Created by randallcrame on 2/8/17.
 */
public class JerkSonReader {
    HashMap<String, String> regexCodes = new HashMap<>();
    String data;

    JerkSonReader(String data){
        this.data = data;
    }
    {
        regexCodes.put("Object" , "([##]+)");
        regexCodes.put("Values", "([;]+)");
        regexCodes.put("KeyAndValue", "([:]+)");
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

    protected GroceryItem createItem(String[] data){
        String[] holder = ValuesToArray(data[0]);
        String name = ValuesToKeyAndValue(holder[0])[1];
        String price = ValuesToKeyAndValue(holder[1])[1];
        String type = ValuesToKeyAndValue(holder[2])[1];
        String expiration = ValuesToKeyAndValue(holder[3])[1];

        switch(name.toLowerCase()){
            case "milk": return new Milk(price, type, expiration);
            case "bread": return new Bread(price, type, expiration);
            default : return null;

        }
    }
}
