import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anthonyjones on 5/31/17.
 */
public class Parser {


//    Parser(){
//
//    }

    public String patternMatch(String file) {
        ArrayList<String> lineBreaker = lineBreaker(file);
        System.out.println(lineBreaker);
        Pattern pattern = Pattern.compile("(\\w+.)([M|m].\\w+[k|K])|([B|b].\\w+[D|d])|([A|a].\\w+[S|s])|([C|c].\\w+[S|s])");
        Matcher matcher = pattern.matcher(file);

        while (matcher.find()) {
           if(matcher.find(1)){
               System.out.println("milk");
           }
        }
        System.out.println(lineBreaker);
        return "";
    }

    public ArrayList<String> lineBreaker(String file) {
        Pattern pattern = Pattern.compile("[^#]+");
        Matcher matcher = pattern.matcher(file);
        ArrayList<String> arrayListOfBrokenLines = new ArrayList<>();

        return arrayListOfBrokenLines;
    }

//    public String milk(){
//        ArrayList<String> lineBreaker = lineBreaker(file);
//        System.out.println(lineBreaker);
//        Pattern pattern = Pattern.compile("(^\\w+.?[M|m][i|I][l|L][k|K])");
//        Matcher matcher = pattern.matcher(file);
//
//        while (matcher.find()) {
//            lineBreaker.add(matcher.group());
//        }
//        System.out.println(lineBreaker);
//        return "";
//    }


}
