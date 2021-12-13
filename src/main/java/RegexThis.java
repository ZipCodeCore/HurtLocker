
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexThis {
    //3 to 5 lines of regex
    public static List<Item> regexer(String raw){
        Pattern p = Pattern.compile("(?:name\\W)?([\\w]+)?(?:\\Wprice\\W)?([\\w\\.]+)?(?:\\Wtype\\W)?([\\w]+)?(?:\\Wexpiration\\W)?([\\w\\/]+)?(?:##)"
        ,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(raw);
        //matches gotten
        List<Item> items = new ArrayList<Item>();
        //encapsulate entries
        while(m.find()){
            Item newbie = new Item.ItemBuilder()
                    .setName(m.group(1) != null ? (Pattern.compile("0")).matcher(m.group(1)).replaceAll("o") : null)
                    .setPrice(m.group(2))
                    .setType(m.group(3))
                    .setExpiration(m.group(4))
                    .build();
            items.add(newbie);
        }
        return items;
    }
}
//TODO:
//nicely formatted summary
//give each group a fitting name
//replace inconsistent casing with regular casing

