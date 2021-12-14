
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
    public static List<Item> beautifier(List<Item> raw){
        for(Item item: raw){
            String a = item.getName();
            if(a != null) {
                Matcher cookie = Pattern.compile("cookies", Pattern.CASE_INSENSITIVE).matcher(a);
                Matcher milk = Pattern.compile("milk", Pattern.CASE_INSENSITIVE).matcher(a);
                Matcher bread = Pattern.compile("bread", Pattern.CASE_INSENSITIVE).matcher(a);
                Matcher apples = Pattern.compile("apples", Pattern.CASE_INSENSITIVE).matcher(a);
                if (cookie.matches()) {
                    item.setName("COOKIES");
                } else if (milk.matches()) {
                    item.setName("MILK");
                } else if (bread.matches()) {
                    item.setName("BREAD");
                } else if (apples.matches()) {
                    item.setName("APPLES");
                }
            }
        }
        return raw;
    }
}
//TODO:
//nicely formatted summary(kind of)
//replace inconsistent casing with regular casing

