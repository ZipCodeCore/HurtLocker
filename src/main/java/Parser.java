import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sarahweisser on 5/31/17.
 */
public class Parser {

    public String[] itemStrings (String inputString) {
        String[] items = inputString.split("##");
        return items;
    }

    public String[] itemStringInfo(String inputString) {
        String [] itemInfo = inputString.split("[!@#$%^&*+,:;<=>?]");
        return itemInfo;
    }
}