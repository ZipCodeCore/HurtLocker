import jdk.nashorn.internal.parser.DateParser;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public  String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        //System.out.println(output);

        List<String> shoppingList = (List<String>) Pattern.compile("RawData.txt", Pattern.UNIX_LINES)
                .splitAsStream(output).map(String::toLowerCase).collect(Collectors.toList());

       /* Map<String, Integer> shop = new LinkedHashMap<>();
        shoppingList.forEach(word ->
                shop.compute(word, (k, v) -> v != null ? v + 1 : 1));
        shop.forEach((k,v) -> System.out.println(String.format("%-20s Seen: %d", k, v))); */


    }

    private String uploadedFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }






}






