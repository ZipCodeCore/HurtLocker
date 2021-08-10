
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);
        String actualResult = (new Main().doingTheFormatting());
        System.out.println(actualResult);

        try {
            FileWriter editor = new FileWriter("fixedList.txt");
            editor.write(actualResult);
            editor.close();

        } catch (IOException e) {
            System.out.println("No groceries for you!");
        }


    }

    public String findAlphabetCharacters() {
        String result = "";
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);
        String horation = "";
        while (matcher.find()) {
            horation = matcher.group();
            result+= horation;

        }
        return result;
    }

    public String getList() {
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("##");
        Matcher matcher = pattern.matcher(jerkText);

        return matcher.replaceAll("\n");
    }

    public String correctSeparator(){
        String fix = getList();
        Pattern pattern = Pattern.compile("[!@^%*]");
        Matcher matcher = pattern.matcher(fix);

        return matcher.replaceAll(";");

    }

    public String separateBySemiColon(){
        String list = correctSeparator();
        Pattern pattern = Pattern.compile(";");
        Matcher matcher = pattern.matcher(list);

        return matcher.replaceAll("\n");


    }


    public int countMilk(){
        List<Integer>  indices = new ArrayList<>();

        String jerkText = readRawDataToString();
        //any instance of the name milk
        Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);
        for (int i = 0; matcher.find(); i++) {
            indices.add(matcher.start());
        }
        return indices.size();
    }

    public int countCookies(){
//        List<Integer> ind
        return 0;
    }

    public String formatName(String input){
        try {
            Pattern pattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String edit = matcher.replaceAll("Name");
            return edit;

        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    public String formatPrice(String input){
        try {
            Pattern pattern = Pattern.compile("price", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String edit = matcher.replaceAll("Price");
            return edit;

        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
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



    public int findGroceries(String input) {
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
        String result = correctSeparator();
        String result1 = changeApples(result);
        String result2 = changeBread(result1);
        String result3 = changeCookies(result2);
        String result4 = changeMilk(result3);
        String result5 = formatName(result4);
        String result6 = formatPrice(result5);
        return result6;
    }


}
