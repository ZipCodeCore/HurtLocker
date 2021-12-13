
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexThis {
    //3 to 5 lines of regex
    public static List<Item> regexer(String raw){
        Pattern p = Pattern.compile("(?:name\\W)?([\\w]+)?(?:\\Wprice\\W)?([\\w\\.]+)?(?:\\Wtype\\W)?([\\w]+)?(?:\\Wexpiration\\W)?([\\w\\/]+)?(?:##)"
        ,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(raw);
        List<Item> items = new ArrayList<Item>();
        while(m.find()){
            if(m.groupCount() != 4){
                Item defect = new Item.ItemBuilder()
                        .denoteError()
                        .build();
                items.add(defect);
            }
            else{
                Item newbie = new Item.ItemBuilder()
                        .setName(m.group(1))
                        .setPrice(m.group(2))
                        .setType(m.group(3))
                        .setExpiration(m.group(4))
                        .build();
                items.add(newbie);
            }
        }
        //TODO:
        //find a way to enforce error (maybe think about checking if any of the groups are null)(could be a one and done command for this)
        //nicely formatted summary

        //MAYBE:
        //replace inconsistent casing with regular casing
        return items;
    }
}
