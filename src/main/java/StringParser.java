import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private  String rawData;
    private int errorCount = 0;
    //private List<String> items = new ArrayList<>();
    private List<String> printingLines = new ArrayList<>();
    private List<String> pairValues = new ArrayList<>();
    private Console console = new Console("Output.txt",true);


//-------- constructor ----------------
    public StringParser (String dataIn){
        rawData = dataIn;
    }

//-------- logic ----------------------

    public void processFile(){
        getEachLine();
        getCount();
        createPrintLine(errorCount,"Errors\t\t");
        try {
            console.writeToFile(printingLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getEachLine(){
        //  naMe:Milk;		price:3.23;	type:Food;	expiration:1/25/2016##

        Scanner sc = new Scanner(rawData);
        sc.useDelimiter("##");

        while (sc.hasNext()) {
            String line = sc.next();
            parseLine(line);
            storeValues(line);
        }
    }


    private void parseLine(String lineIn){
        // delimiter between key:value pairs ->    ; ^ % * ! @

        String pattern = "[;!%@^*]";
        Scanner sc = new Scanner(lineIn);
        sc.useDelimiter(pattern);

        while (sc.hasNext()) {
            String line = sc.next();
            if (findPattern(lineIn, ":") == false) {
                errorCount++;
            } else {
                parseKeyValues(line);
            }
        }
    }

    public Boolean findPattern (String textToSearch, String pattern){
        Pattern pattern1 = Pattern.compile(pattern);
        return pattern1.matcher(textToSearch).find();
    }

    private void parseKeyValues(String input){
        // delimiter for key values ->   :
        int count = 0;
        Scanner sc = new Scanner(input);
        sc.useDelimiter(":");
        String key = "";
        String value = "";

        while (sc.hasNext()){
            String line = sc.next();
            //items.add(line);
            count++;
        }

        if (count !=2) errorCount++;
    }


    private void getCount (){

      Collections.sort(pairValues);

      for (int i = 1; i < pairValues.size(); i++){
          System.out.println(pairValues.get(i));
      }

        int counter = 0;

        for (String each : pairValues){
            if (each.matches("(.*)(?i)milk(.*)") && each.matches("(.*)(?i)[0-9](.*)")) {
                counter ++;
            }
        }
        createPrintLine(counter,"name:\tMilk");
        counter = 0;

        for (String each : pairValues){
            if (each.matches("(.*)(?i)bread(.*)")  && each.matches("(.*)(?i)[0-9](.*)")) {
                counter ++;
            }
        }
        createPrintLine(counter,"name:\tBread");
        counter = 0;

        for (String each : pairValues){
            if (each.matches("(.*)(?i)cookies(.*)")  && each.matches("(.*)(?i)[0-9](.*)")) {
                counter ++;
            }
        }
        createPrintLine(counter,"name:\tCookies");
        counter = 0;

        for (String each : pairValues){
            if (each.matches("(.*)(?i)apples(.*)")  && each.matches("(.*)(?i)[0-9](.*)")) {
                counter ++;
            }
        }
        createPrintLine(counter,"name:\tApples");

    }

    private void createPrintLine(Integer counter, String item){
        printingLines.add(item + "\t\tseen: " + counter + " times\n");
    }

    private void storeValues (String lineToParse){
        String name = "";

        if (lineToParse.matches("(.*)(?i)milk(.*)")) name = "Milk";
        if (lineToParse.matches("(.*)(?i)bread(.*)")) name = "Bread";
        if (lineToParse.matches("(.*)(?i)cookies(.*)")) name = "Cookies";
        if (lineToParse.matches("(.*)(?i)apples(.*)")) name = "Apples";

        String pattern = "(?i)price:(.*?);";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(lineToParse);
        if (matcher.find()){
            pairValues.add(name + "-" + matcher.group(1) + "-");
        }

    }

}
