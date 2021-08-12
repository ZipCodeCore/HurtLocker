import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        }  catch(IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public String findAlphabetCharacters()  {
        StringBuilder result = new StringBuilder();
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE); //"/^[A-Z]+$/i"
        Matcher matcher = pattern.matcher(jerkText);
        String findee;
        while(matcher.find()) {
            findee = matcher.group();
            result.append(findee);
        }
        return result.toString();
    }

    public String nameChange(String input){
        try{
            Pattern pattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String nameString = matcher.replaceAll("Name");
            return nameString;
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String changeMilk(String input){
        try{
            Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Milk");
            return milk;
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String priceChange(String input){
        try{
            Pattern pattern = Pattern.compile("price", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String priceString = matcher.replaceAll("Price");
            return priceString;
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String changeApples(String input){
        try{
            Pattern pattern = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String apples = matcher.replaceAll("Apples");
            return apples;
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String changeBread(String input){
        try{
            Pattern pattern = Pattern.compile("bread", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String bread = matcher.replaceAll("Bread");
            return bread;
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String changeCookies(String input){
        try{
            Pattern pattern = Pattern.compile("c[o0][o0]kies", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String cookies = matcher.replaceAll("Cookies");
            return cookies;
        } catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

    public int countMilk(){
        List<Integer> index = new ArrayList<>();
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);

        for (int i = 0; matcher.find(); i++) {
            index.add(matcher.start());
        }
        return index.size();
    }


    public String getList(String input) {
        try {
            Pattern pattern = Pattern.compile("##");
            Matcher matcher = pattern.matcher(input);
            String result = matcher.replaceAll("\n");
            return result;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

        public String correctSeparator(){
            try{
                String jerkText = readRawDataToString();
                Pattern pattern = Pattern.compile("[!@^%*]");
                Matcher matcher = pattern.matcher(jerkText);
                String result = matcher.replaceAll(";");
                return result;
            } catch (Exception e) {
                throw new UnsupportedOperationException();
            }
        }

        public String readyForFormatting(){
            String result1 = getList(correctSeparator());
            String result2 = changeApples(result1);
            String result3 = changeBread(result2);
            String result4 = changeCookies(result3);
            String result5 = changeMilk(result4);
            String result6 = nameChange(result5);
            String result7 = priceChange(result6);
            return result7;
    }
        public int findGroceries(String input){
        int holdingValue = 0;
        boolean checkValue = false;
        Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(readyForFormatting());
        while (!checkValue) {
            if (!matcher.find()){
                checkValue = true;
                continue;
            }
            holdingValue++;
        }
        return holdingValue;
        }

        public int countingErrors(){
        int counter = 0;
        counter += findGroceries("Name:;");
        counter += findGroceries("milk") - (findGroceries("milk;price:3.23") + findGroceries("milk;price:1.23"));
        return counter;
        }

    public String formatting(){
        String result =
                "name:      Milk        seen: " + findGroceries("milk") + " times\n" +
                        "=============        =============\n" +
                        "Price:   3.23        seen: " + findGroceries("milk;price:3.23") + " times\n" +
                        "-------------        --------------\n" +
                        "Price:   1.23        seen: " + findGroceries("milk;price:1.23") + " times\n\n" +

                        "name:    Bread       seen: " + findGroceries("bread") + " times\n" +
                        "==============       ==============\n" +
                        "Price:   1.23        seen: " + findGroceries("bread") + " times\n\n" +
                        "--------------       ---------------\n" +

                        "name:   Cookies      seen: " + findGroceries("cookies") + " times\n" +
                        "===============      ===============\n" +
                        "Price:   2.25        seen: " + findGroceries("cookies") + " times\n" +
                        "---------------      ---------------\n" +

                        "name:    Apples      seen: " + findGroceries("apples") + " times\n" +
                        "===============      ===============\n" +
                        "Price:    0.25       seen: " + findGroceries("price:0.25") + " times\n" +
                        "---------------      ---------------\n" +
                        "Price:    0.23       seen: " + findGroceries("price:0.23") + " times\n\n" +

                        "Errors               seen: " + countingErrors() + " times";
        return result;
    }

//        String jerkText = readRawDataToString();
//
//        Pattern pattern = Pattern.compile("##");
//        Matcher matcher = pattern.matcher(jerkText);
//
//        return matcher.replaceAll("\n");
//    }
//
//    public String correctSeparator(){
//        String fix = getList();
//        Pattern pattern = Pattern.compile("[!@^%*]");
//        Matcher matcher = pattern.matcher(fix);
//
//        return matcher.replaceAll(";");
//    }
//
//    public String semiColonSeparator(){ // HELPER to find semiColon and puts each on a new line
//        String list = correctSeparator();
//        Pattern pattern = Pattern.compile(";");
//        Matcher matcher = pattern.matcher(list);
//
//        return matcher.replaceAll("\n");
//    }
//
//
//    /**
//     * any instance of the name milk
//     * anything with a price of 3.23
//     * anything with a price of 1.23 without name bread
//     */
//    public int countMilk(){
//        List<Integer> indices = new ArrayList<>();
//        String jerkText = readRawDataToString();
//        Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(jerkText);
//        for (int i = 0; matcher.find(); i++) {
//            indices.add(matcher.start());
//        }
//        return indices.size();
//    }
//
//    public int countCookies(){
//        List<Integer> ind;
//        return 0;
//    }


}
