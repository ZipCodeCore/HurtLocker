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
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public static void main(String[] args){
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

    public String findAlphabetCharacters(){
        String result = "";
        String jerkTest = readRawDataToString();
        Pattern pattern = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkTest);
        String horation = "";
        while(matcher.find()){
            horation = matcher.group();
            result+=horation;
        }


        return result;
    }

    public String getList(String input) {
//        String result = "";
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
            String jerk = readRawDataToString();
            Pattern pattern = Pattern.compile("[!@^%*]");
            Matcher matcher = pattern.matcher(jerk);
            String result = matcher.replaceAll(";");
            return result;
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String separateBySemicolon(){
        String list = correctSeparator();
        Pattern pattern = Pattern.compile(";");
        Matcher matcher = pattern.matcher(list);

        return matcher.replaceAll("\n");

    }

    public int countMilk(){
        List<Integer> indices = new ArrayList<>();

       String jerkText = readRawDataToString();
        //any instance of the name milk
        //find a price of 3.23
       Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
       Matcher matcher = pattern.matcher(jerkText);
        for(int i =0; matcher.find(); i++){
            indices.add(matcher.start());

        }
        return indices.size();
    }

    public String changeBread(String input){
        try{
            Pattern pattern = Pattern.compile("Bread", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String bread = matcher.replaceAll("Bread");
            return  bread;
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }

    }

    public String changeMilk(String input){
        try{
            Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String milk = matcher.replaceAll("Milk");
            return milk;
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String changeCookies(String input){
        try{
            Pattern pattern = Pattern.compile("c[o0][o0]kies", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String cookies = matcher.replaceAll("Cookies");
            return cookies;
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String changeApples(String input){
        try{
            Pattern pattern = Pattern.compile("apples", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String apples = matcher.replaceAll("Apples");
            return  apples;
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }


    public String nameChange(String input){
        try{
            Pattern pattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String nameCh = matcher.replaceAll("Name");

            return nameCh;
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }

    public String priceChange(String input){
        try{
            Pattern pattern = Pattern.compile("price", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            String pricCh = matcher.replaceAll("Price");

            return  pricCh;
        }catch (Exception e){
            throw new UnsupportedOperationException();
        }
    }


    public int findGroceries(String input){
        Integer holdingValue = 0;
        Boolean checkVal = false;
        Pattern pattern = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(readyForFormatting());
        while(!checkVal) {
            if(!matcher.find()){
                checkVal = true;
                continue;
            }
            holdingValue++;
        }
        return holdingValue;
    }

    public String doingFormatting(){
        String result =
                "name:   Milk         seen: " + findGroceries("milk") + " times\n" +
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
                           "Price:   2.25        seen: " + findGroceries("cookies") + " times\n\n" +
                           "---------------      ---------------\n" +

                           "name:    Apples      seen: " + findGroceries("apples") + " times\n" +
                           "===============      ===============\n" +
                           "Price:    0.25       seen: " + findGroceries("price:0.25") + " times\n" +
                           "---------------      ---------------\n" +
                           "Price:    0.23       seen: " + findGroceries("price:0.23") + " times\n\n" +

                           "Errors               seen: " + countingErrors() + " times";
        return result;
    }

    public int countingErrors(){
        int counter = 0;

            counter += findGroceries("Name:;");
            counter += findGroceries("milk") - (findGroceries("milk;price:3.23") + findGroceries("milk;price:1.23"));
            return  counter;
    }

    public String readyForFormatting(){
        String result = getList(correctSeparator());
        String result1 = changeApples(result);
        String result2 = changeBread(result1);
        String result3 = changeCookies(result2);
        String result4 = changeMilk(result3);
        String result5 = nameChange(result4);
        String result6 = priceChange(result5);
        return  result6;
    }


}
