import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    Integer counter = 0;

    public static String readRawDataToString() throws Exception{
        ClassLoader classLoader = Main.class.getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        try {
            File outputFile = new File("groceryList.txt");
            if(outputFile.createNewFile()) {
                System.out.println("File created: " + outputFile.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        try {
            FileWriter outputText = new FileWriter("groceryList.txt");
            outputText.write(doingTheFormatting());
            outputText.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String changeMilk(String input) {
        try {
            Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Milk");

            return milk;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public static String changeBread(String input) {
        try {
            Pattern pattern = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String bread = matcher.replaceAll("Bread");

            return bread;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public static String changeCookies(String input) {
        try {
            Pattern pattern = Pattern.compile("c[o0][o0]kies", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String cookies = matcher.replaceAll("Cookies");

            return cookies;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public static String changeApples(String input) {
        try {
            Pattern pattern = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String apples = matcher.replaceAll("Apples");

            return apples;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public static String poundToNewLine(String input) {
        try {
            Pattern pattern = Pattern.compile("##");
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("\n");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public static String correctSeparator() {
        try {
            String s = readRawDataToString();
            Pattern patter = Pattern.compile("[!@^%*]");
            Matcher matcher = patter.matcher(s);
            String result = matcher.replaceAll(";");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public static String nameChange(String input) {
        try {
            Pattern pattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String name = matcher.replaceAll("Name");

            return name;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public static String priceChange(String input) {
        try {
            Pattern pattern = Pattern.compile("price", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String price = matcher.replaceAll("Price");

            return price;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }


    public static int findGroceries(String input) {
        Integer holdingValue = 0;
        Boolean checkVal = false;
        Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(readyForFormatting());
        while(!checkVal) {
            if (!matcher.find()) {
                checkVal = true;
                continue;
            }
            holdingValue++;
        }
        return holdingValue;
    }

    public static int countingErrors() {
        int counter = 0;

        counter += findGroceries("Name:;");
        counter += findGroceries("milk") - (findGroceries("milk;price:3.23") + findGroceries("milk;price:1.23"));
        return counter;
    }

    public static String readyForFormatting() {
        String result = poundToNewLine(correctSeparator());
        String result1 = changeApples(result);
        String result2 = changeBread(result1);
        String result3 = changeCookies(result2);
        String result4 = changeMilk(result3);
        String result5 = nameChange(result4);
        String result6 = priceChange(result5);
        return result6;
    }

    public static String doingTheFormatting() {
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

                        "name:  Apples        seen: " + (findGroceries("apples;price:0.25") + findGroceries("apples;price:0.23")) + " times\n" +
                        "=============        =============\n" +
                        "Price:   0.25        seen: " + findGroceries("price:0.25") + " times\n" +
                        "-------------        -------------\n" +
                        "Price:   0.23        seen: " + findGroceries("price:0.23") + " times\n\n" +

                        "Errors               seen: " + countingErrors() + " times";

        return result;
    }
}
