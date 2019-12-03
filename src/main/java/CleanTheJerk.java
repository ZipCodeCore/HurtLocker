import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanTheJerk {
    //private FindPatterns finder = new FindPatterns();
    ArrayList<String> results;

    public String[] splitToItems() {
        Pattern pattern = Pattern.compile("##");
        String[] itemsArray = pattern.split(replaceApples());
//        for (int i = 0; i < itemsArray.length; i++) {
//            String s = itemsArray[i];
//            System.out.println(s);
//        }
        return itemsArray;
    }

    public ArrayList<String> itemsList () {
        String [] items = splitToItems();
        results = new ArrayList<String>(Arrays.asList(items));
        return results;
    }


    public String replaceMilk () {
        String dirtyText = HurtLocker.loadFile();
        Pattern milkPattern = Pattern.compile("(milk)", Pattern.CASE_INSENSITIVE);
        Matcher milkMatcher = milkPattern.matcher(dirtyText);
        String milkClean = milkMatcher.replaceAll("Milk");
        return milkClean;
    }

    public String replaceBread () {
        String dirtyText = replaceMilk();
        Pattern breadPattern = Pattern.compile("(bread)", Pattern.CASE_INSENSITIVE);
        Matcher breadMatcher = breadPattern.matcher(dirtyText);
        String breadClean = breadMatcher.replaceAll("Bread");
        return breadClean;
    }

    public String replaceCookies () {
        String dirtyText = replaceBread();
        Pattern cookiePattern = Pattern.compile("(cookies)|(co0kies)", Pattern.CASE_INSENSITIVE);
        Matcher cookieMatcher = cookiePattern.matcher(dirtyText);
        String cookieClean = cookieMatcher.replaceAll("Cookies");
        return cookieClean;
    }

    public String replaceApples () {
        String dirtyText = replaceCookies();
        Pattern applePattern = Pattern.compile("(apples)", Pattern.CASE_INSENSITIVE);
        Matcher appleMatcher = applePattern.matcher(dirtyText);
        String appleClean = appleMatcher.replaceAll("Apples");
        return appleClean;
    }
}


