import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCleaner {
    int errorCount = 0;


    public static String jerkSeasoning(String string) {
        Pattern p1 = Pattern.compile("[;*^%!@]");
        Matcher m1 = p1.matcher(string);
        m1.find();
        return m1.replaceAll(" ");

    }

    public static String jerkSeasoning2(String string) {
        Pattern p2 = Pattern.compile("#{2}");
        Matcher m2 = p2.matcher(string);
        m2.find();
        int count = 0;
        while (m2.find()) {
            count++;
        }
        System.out.println(count);
        return m2.replaceAll("},\n");
    }

    public static String jerkSeasoning3(String string) {
        Pattern p3 = Pattern.compile("/");
        Matcher m3 = p3.matcher(string);
        m3.find();
        return m3.replaceAll("-");
    }

    public static String jerkSeasoning4(String string) {
        Pattern p4 = Pattern.compile("^(?i)name", Pattern.MULTILINE);
        Matcher m4 = p4.matcher(string);
        m4.find();
        return m4.replaceAll("name");
    }

    public static String jerkSeasoning5(String string) {
        Pattern p5 = Pattern.compile("(?i)m[1i!]lk");
        Matcher m5 = p5.matcher(string);
        m5.find();
        return m5.replaceAll("Milk");
    }

    public static String jerkSeasoning6(String string) {
        Pattern p6 = Pattern.compile("(?i)c[o0][o0]kies");
        Matcher m6 = p6.matcher(string);
        m6.find();
        return m6.replaceAll("Cookies");
    }

    public static String jerkSeasoning7(String string) {

        Pattern p7 = Pattern.compile("(?i)bread");
        Matcher m7 = p7.matcher(string);
        m7.find();
        return m7.replaceAll("Bread");
    }

    public static String jerkSeasoning8(String string) {

        Pattern p8 = Pattern.compile("(?i)Apples");
        Matcher m8 = p8.matcher(string);
        m8.find();
        return m8.replaceAll("Apples");
    }

    public static ArrayList<ParsedItems> pairParser(String string) {
        Pattern p8 = Pattern.compile("(\\S+):(\\S*)\\s(\\S+):(\\S*)\\s(\\S+):(\\S*)\\s(\\S+):(\\S*)\\s(?:\\b(?!:)|$)");
        Matcher m8 = p8.matcher(string);
        ArrayList food = new ArrayList<ParsedItems>();
        while (m8.find()) {
            String price = m8.group(4);
            String type = m8.group(2) ;
            if ("".equals(price)||"".equals(type)){

            } else {
                System.out.println(type + " " + price);
                ParsedItems item = new ParsedItems(type, Double.valueOf(price));
                food.add(item);
            }

        }

        return food;
    }
}


