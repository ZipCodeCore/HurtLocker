import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by evanhitchings on 10/17/16.
 */
public class JerkSONParser {

    public static String[] splitJerkSONByItem(String string){
        String[] splitByItem = string.split("(##)");
        return splitByItem;
    }

    public static String[][] splitJerkSONByField(String[] items){
        int lengthOfItems = items.length;
        String[][] splitByField = new String[lengthOfItems][4];
        for(int i = 0; i < lengthOfItems; i++){
            splitByField[i] = items[i].split("(;|\\^|\\*|%|!|@)");
        }
        return splitByField;
    }

    public static String replaceZeroesWithOs(String string){
        Pattern pattern = Pattern.compile("[a-zA-Z]0[a-zA-Z]");
        Matcher matcher = pattern.matcher(string);
        String toReturn = matcher.replaceAll("ook");
        return toReturn;
    }

    public static String capitalizeFirstLetter(String string){
        Pattern pattern = Pattern.compile("(\\b[a-z]{1})");
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while(matcher.find()) {
            String toConvert = matcher.group();
            char replacement = toConvert.charAt(0);
            replacement -= 32;
            matcher.appendReplacement(stringBuffer, replacement + "");
        }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
    }

    public static String lowercaseNonFirstLetters(String string){
        Pattern pattern = Pattern.compile("(\\B[A-Z]{1})");
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while(matcher.find()) {
            String toConvert = matcher.group();
            char replacement = toConvert.charAt(0);
            replacement += 32;
            matcher.appendReplacement(stringBuffer, replacement + "");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }







}





