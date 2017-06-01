import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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

    public String[] checkIfSameItem(ArrayList<String> itemNames) {
        String[] uniqueItemNames;
        Pattern pattern = Pattern.compile("((([a-z]|[0-9]){2})([a-z]|[0-9]+)(\\w\\b))", Pattern.CASE_INSENSITIVE);
        String[] arrayOfItemNames = new String[itemNames.size()];
        for (int i = 0; i < itemNames.size(); i++) {
            arrayOfItemNames[i] = itemNames.get(i);
        }
        Stream<String> names = Arrays.stream(arrayOfItemNames).map(String::toLowerCase);
        names = names.map(s -> s.replaceAll("0", "o"));
        uniqueItemNames = names.filter(pattern.asPredicate()).distinct().toArray(String[]:: new);
        System.out.println(Arrays.toString(uniqueItemNames));
        return uniqueItemNames;
    }
}