
import org.apache.commons.io.IOUtils;

import java.io.File;
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
        //find a price of 3.23
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
}
