import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by sarahweisser on 5/31/17.
 */
public class Parser {

    public String[] itemStrings (String inputString) {
        Stream<String> itemStream = Pattern.compile("##").splitAsStream(inputString);
        String[] groceryItemArr = itemStream.toArray(String[]::new);
        return groceryItemArr;
    }

    public String[] itemStringInfo(String groceryItemString) {
        Stream<String> groceryItemInfoStream = Pattern.compile("[!@#$%^&*+,:;<=>?]").splitAsStream(groceryItemString);
        String [] groceryItemInfo = groceryItemInfoStream.toArray(String[]::new);
        return groceryItemInfo;
    }

}