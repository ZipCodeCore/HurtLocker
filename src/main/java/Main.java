import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
     //   String actualResult = changeCookies(changeApples(changeBread(changeMilk(output))));
     //   System.out.println(actualResult);

    }

    public String changeMilk (String input) {
        try {
            Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Milk");

            return milk;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeBread (String input) {
        try {
            Pattern pattern = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Bread");

            return milk;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeCookies (String input) {
        try {
            Pattern pattern = Pattern.compile("c[o0][o0]kies", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Cookies");
            return milk;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeApples (String input) {
        try {
            Pattern pattern = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Apples");
            return milk;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String poundToNewLine(String input) {
        try {
            Pattern pattern = Pattern.compile("##");
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("\n");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String correctSeparator () {
        // "[!@^%*]"
        try {
            String jawn = readRawDataToString();
            Pattern patter = Pattern.compile("[!@^%*]");
            Matcher matcher = patter.matcher(jawn);
            String result = matcher.replaceAll(";");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String nameChange(String input) {
        try {
            Pattern pattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Name");
            return milk;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String priceChange(String input) {
        try {
            Pattern pattern = Pattern.compile("price", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Price");
            return milk;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public int findGroceries(String input) {
        Integer counter = 0;
        Boolean checkVal = false;
        Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(readyForFormatting());
        while(!checkVal) {
            if (!matcher.find()) {
                checkVal = true;
                continue;
            }
            counter++;
        }
        return counter;
    }


    public String doingTheFormatting() {
        String result =
                "name:    Milk        seen: " + findGroceries("milk") + " times\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: " + findGroceries("milk;price:3.23") + " times\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: " + findGroceries("milk;price:1.23") +  " times\n\n" +

                        "name:   Bread        seen: " + findGroceries("bread") + " times\n" +
                        "=============        =============\n" +
                        "Price:   1.23        seen: " + findGroceries("bread") + " times\n" +
                        "-------------        -------------\n\n" +

                        "name: Cookies        seen: " + findGroceries("cookies") + " times\n" +
                        "=============        =============\n" +
                        "Price:   2.25        seen: " + findGroceries("cookies") + " times\n" +
                        "-------------        -------------\n\n" +

                        "name:  Apples        seen: " + findGroceries("apples") + " times\n" +
                        "=============        =============\n" +
                        "Price:   0.25        seen: " + findGroceries("price:0.25") + " times\n" +
                        "-------------        -------------\n" +
                        "Price:   0.23        seen: " + findGroceries("price:0.23") + " times\n\n" +

                        "Errors               seen: " + countingErrors() + " times";
        return result;
    }

    public int countingErrors() {
        int counter = 0;
        // beware
        // receive 2 errors on 'milk' - milk shows more than the given prices (2 times)
             counter += findGroceries("Name:;");
             counter += findGroceries("milk") - (findGroceries("milk;price:3.23") + findGroceries("milk;price:1.23"));
        return counter;
    }

    public String readyForFormatting() {
        String result = poundToNewLine(correctSeparator());
        String result1 = changeApples(result);
        String result2 = changeBread(result1);
        String result3 = changeCookies(result2);
        String result4 = changeMilk(result3);
        String result5 = nameChange(result4);
        String result6 = priceChange(result5);
        return result6;
    }


















    public void parsingToObject(String input) {
     Pattern pattern = Pattern.compile(input);
     Matcher matcher = pattern.matcher(readyForFormatting());

    }
}
