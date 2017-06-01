import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anthonyjones on 5/31/17.
 */
public class LineBreaker {



    public String lineBreaker(String file) {
        Pattern pattern = Pattern.compile("([^#]+)");
        Matcher matcher = pattern.matcher(file);

        while (matcher.find( )) {

            System.out.println(matcher.group(0));
        }
        return matcher.group(1);
    }


}
