
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexThis {
    //3 to 5 lines of regex
    public static List<Item> regexer(String raw){
        Pattern p = Pattern.compile("(?:name\\W)?(?<NAME>[\\w]+)?(?:\\Wprice\\W)?(?<PRICE>[\\w\\.]+)?(?:\\Wtype\\W)?(?<TYPE>[\\w]+)?(?:\\Wexpiration\\W)?(?<EXPIRATION>[\\w\\/]+)?(?:##)"
        ,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(raw);
        //matches gotten
        List<Item> items = new ArrayList<Item>();
        //encapsulate entries
        while(m.find()){
            Item newbie = new Item.ItemBuilder()
                    .setName(m.group("NAME") != null ? (Pattern.compile("0")).matcher(m.group("NAME")).replaceAll("o") : null)
                    .setPrice(m.group("PRICE"))
                    .setType(m.group("TYPE"))
                    .setExpiration(m.group("EXPIRATION"))
                    .build();
            items.add(newbie);
        }
        return items;
    }
}
//TODO:
//nicely formatted summary
//replace inconsistent casing with regular casing

