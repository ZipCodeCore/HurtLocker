import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString(){
        ClassLoader classLoader = getClass().getClassLoader();
        String result = null;
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        Main newMain = new Main();
        String output = newMain.readRawDataToString();
        System.out.println(newMain.getList(output));
    }

    public String findAlphabetical() throws Exception {
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("/^[A-Z]",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);
        return null;
    }

    public String getList(String input) {
        Pattern pattern = Pattern.compile("##");
        Matcher matcher = pattern.matcher(input);
        String result = matcher.replaceAll("\n");
        return result;
    }

    public String correctSeparator(){

        String correctMe = readRawDataToString();
        Pattern pattern = Pattern.compile("[!@^%*]");
        Matcher matcher = pattern.matcher(correctMe);
        return matcher.replaceAll(";");
    }

    public String findSeparatorCorrected(){
        String list = correctSeparator();
        Pattern pattern = Pattern.compile(";");
        Matcher matcher = pattern.matcher(list);
        return matcher.replaceAll("\n");
    }

    public String reformatAfterCorrectSeparator(){
        String list = findSeparatorCorrected();
        Pattern pattern = Pattern.compile("2016");
        Matcher matcher = pattern.matcher(list);
        return  matcher.replaceAll("2016\n");
    }

    public Integer countMilk323(){
        List<Integer> indexes = new ArrayList<>();
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("milk",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);
        while(matcher.find()){
            indexes.add(matcher.start());
        }
        return indexes.size();
    }

    public Integer countCookies(){
        List<Integer> indexes = new ArrayList<>();
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("c[oO0][oO0]kies",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);
        while(matcher.find()){
            indexes.add(matcher.start());
        }
        return indexes.size();
    }

    public Integer countBread(){
        List<Integer> indexes = new ArrayList<>();
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("bread",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);
        while(matcher.find()){
            indexes.add(matcher.start());
        }
        return indexes.size();
    }

    public Integer countApple(){
        List<Integer> indexes = new ArrayList<>();
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("apples",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);
        while(matcher.find()){
            indexes.add(matcher.start());
        }
        return indexes.size();
    }

//-------------Formatting String Into Correct List----------------
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

    public String readyForFormatting() {
        String result = getList(correctSeparator());
        String result1 = changeApples(result);
        String result2 = changeBread(result1);
        String result3 = changeCookies(result2);
        String result4 = changeMilk(result3);
        String result5 = nameChange(result4);
        String result6 = priceChange(result5);
        return result6;
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

                        "name:  Apples        seen: " + (findGroceries("apples;price:0.25") + findGroceries("apples;price:0.23")) + " times\n" +
                        "=============        =============\n" +
                        "Price:   0.25        seen: " + findGroceries("price:0.25") + " times\n" +
                        "-------------        -------------\n" +
                        "Price:   0.23        seen: " + findGroceries("price:0.23") + " times\n\n" +

                        "Errors               seen: " + countingErrors() + " times";
        return result;
    }


    // we can use a "scanner" something to check when the (';' <- those bois) come up

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

    public int countingErrors() {
        int counter = 0;
        // beware
//             counter += findGroceries("apples") - (findGroceries("apples;price:0.25") + findGroceries("apples;price:0.23"));
        counter += findGroceries("Name:;");
        counter += findGroceries("milk") - (findGroceries("milk;price:3.23") + findGroceries("milk;price:1.23"));
        return counter;
    }






}
