import com.sun.media.sound.InvalidFormatException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexThis {
    //3 to 5 lines of regex
    public static List<Item> regexer(String raw){
        Pattern p = Pattern.compile("(?:##)?(?:name\\W)?([\\w]+)?(?:\\Wprice\\W)?([\\w\\.]+)?(?:\\Wtype\\W)?([\\w]+)?(?:\\Wexpiration\\W)?([\\w\\/]+)?"
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
                        .setName(m.group(0))
                        .setPrice(m.group(1))
                        .setType(m.group(2))
                        .setExpiration(m.group(3))
                        .build();
                items.add(newbie);
            }
        }
        return items;
    }
}
