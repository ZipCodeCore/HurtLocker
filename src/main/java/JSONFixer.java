import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ryangross on 2/8/17.
 */
public class JSONFixer {
    private static String lineBreakerPattern = "[A-Za-z]+\\W{1,2}[A-Za-z]+\\W{1,2}[A-Za-z]+\\W{1,2}\\d{1}\\.\\d+";
    private static String wholeLines = "[A-Za-z]+\\W{1,2}[A-Za-z0-9]{0,8}\\W{1,2}[A-Za-z]+\\W{1,2}[A-Za-z0-9:;^\\.]{0,5}[A-Za-z]+\\W{1,2}[A-Za-z]+\\W{1,2}[A-Za-z]+\\W{1,2}\\d{1}\\W{1}\\d{2}\\W{1}\\d{4}";


    public ArrayList<String> breakLines(String aString) {
        ArrayList<String> answer = new ArrayList<String>();
        Matcher matchLines = Pattern.compile(lineBreakerPattern).matcher(aString);
        while(matchLines.find()) {
                answer.add(matchLines.group());

        }
        return answer;
    }

    public int wholeLength(String aString) {
        ArrayList<String> answer = new ArrayList<String>();
        Matcher matchLines = Pattern.compile(wholeLines).matcher(aString);
        while(matchLines.find()) {
            answer.add(matchLines.group());

        }
        return answer.size();
    }
    }




