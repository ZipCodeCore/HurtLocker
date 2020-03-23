import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtils {
    public static String matchedString(String textToSearch, String pattern){
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(textToSearch);
        if(matcher.find()){
            return matcher.group(1);
        }
        return "";
    }

    public static Boolean findPattern(String textToSearch, String pattern){
        Pattern pattern1 = Pattern.compile(pattern);
        return pattern1.matcher(textToSearch).find();
    }
    public static String printPadding(String s, int  n){
        return String.format("%" + n + "s", s);
    }

}
