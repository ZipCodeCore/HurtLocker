import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();
        // System.out.println(output);

    }

    public String replaceHash(String input) {
        try {
            Pattern pattern = Pattern.compile("##");
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("\n");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String correctSeparator() {

        try {
            String str = readRawDataToString();
            Pattern pattern = Pattern.compile("[!@^%*]");
            Matcher matcher = pattern.matcher(str);
            String result = matcher.replaceAll(";");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeName(String input) {
        try {
            Pattern pattern = Pattern.compile("naMe", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("Name");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changePrice(String input) {
        try {
            Pattern pattern = Pattern.compile("price", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("Price");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeExpiration(String input) {
        try {
            Pattern pattern = Pattern.compile("expiration", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("Expiration");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeType(String input) {
        try {
            Pattern pattern = Pattern.compile("type", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("Type");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeBread(String input) {
        try {
            Pattern pattern = Pattern.compile("BreaD", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("Bread");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeMilk(String input) {
        try {
            Pattern pattern = Pattern.compile("MILK", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("Milk");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeCookies(String input) {
        try {
            Pattern pattern = Pattern.compile("CoOkieS", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("Cookies");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String changeApples(String input) {
        try {
            Pattern pattern = Pattern.compile("apPles", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("Apples");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public int findProducts(String input) {
        Integer holdingValue = 0;
        Boolean checkVal = false;
        Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(formatting());
        while (!checkVal) {
            if (!matcher.find()) {
                checkVal = true;
                continue;
            }
            holdingValue++;
        }
        return holdingValue;
    }

    public String formatting() {
        String result = replaceHash(correctSeparator());
        String result1 = changeApples(result);
        String result2 = changeBread(result1);
        String result3 = changeCookies(result2);
        String result4 = changeMilk(result3);
        String result5 = changeName(result4);
        String result6 = changePrice(result5);
        return result6;
    }


    public String formatting1() {
        String result =
                "name:    Milk        seen: " + findProducts("milk") + " times\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: " + findProducts("milk;price:3.23") + " times\n" +
                        "-------------        -------------\n" +
                        "Price:   1.23        seen: " + findProducts("milk;price:1.23") + " times\n\n" +

                        "name:   Bread        seen: " + findProducts("bread") + " times\n" +
                        "=============        =============\n" +
                        "Price:   1.23        seen: " + findProducts("bread") + " times\n" +
                        "-------------        -------------\n\n" +

                        "name: Cookies        seen: " + findProducts("cookies") + " times\n" +
                        "=============        =============\n" +
                        "Price:   2.25        seen: " + findProducts("cookies") + " times\n" +
                        "-------------        -------------\n\n" +

                        "name:  Apples        seen: " + findProducts("apples") + " times\n" +
                        "=============        =============\n" +
                        "Price:   0.25        seen: " + findProducts("price:0.25") + " times\n" +
                        "-------------        -------------\n" +
                        "Price:   0.23        seen: " + findProducts("price:0.23") + " times\n\n" +

                        "Errors               seen: " + countingErrors() + " times";
        return result;

    }

    public int countingErrors() {
        int counter = 0;
        // beware
        // receive 2 errors on 'milk' - milk shows more than the given prices (2 times)
        counter += findProducts("Name:;");
        counter += findProducts("milk") - (findProducts("milk;price:3.23") + findProducts("milk;price:1.23"));
        return counter;
    }

    public void parsingToObject(String input) {
        Pattern pattern = Pattern.compile(input);
        Matcher matcher = pattern.matcher(formatting());
    }

}
