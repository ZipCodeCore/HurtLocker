import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainsRegex {
    Main main = new Main();


    public Boolean containsRegex(String s, String p){
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);

        Integer count = 0;
        while(matcher.find()){
            count++;
        }
        return count == 1;
    }




}
