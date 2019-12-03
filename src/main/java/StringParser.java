
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private String rawData;
    private int errorCount = 0;
    private List<String> printingLines = new ArrayList<>();
    private List<String> pairValues = new ArrayList<>();
    private Console console = new Console("Output.txt", true);
    private Set<String> uniqueValues = new HashSet<>();

//-------- constructor ----------------
    public StringParser(String dataIn) {
        rawData = dataIn;
    }

//-------- logic ----------------------

    public void processFile() {
        getEachLineAndStoreValues();
        getItemsCount();
        createPrintLine(errorCount, "Errors\t\t");

        try {
            console.writeToFile(printingLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getEachLineAndStoreValues() {
        //  naMe:Milk;		price:3.23;	type:Food;	expiration:1/25/2016##

        Scanner sc = new Scanner(rawData);
        sc.useDelimiter("##");

        while (sc.hasNext()) {
            String line = sc.next();
            getErrors(line);
            storeValues(line);
        }
    }

    private void storeValues(String lineToParse) {
        String name = "";
        String price = "";

        name = matchedString(lineToParse, "(?i)name:(.*?);");
        price = matchedString(lineToParse, "(?i)price:(.*?);");

        if (price.equals("") || name.equals("")) {
        } else {
            name = name.toLowerCase();
            pairValues.add(name + "-" + price + "-");
            uniqueValues.add(name);
            price = "";
            name = "";
        }
    }

    private void getItemsCount() {

        Collections.sort(pairValues);

        int counter = 0;
        for (String element : uniqueValues) {
            for (String each : pairValues) {
                if (each.matches("(.*)(?i)" + element + "(.*)") && each.matches("(.*)(?i)[0-9](.*)")) {
                    counter++;
                }
            }
            createPrintLine(counter, "name:" + padRight(element,10).toLowerCase());
            counter = 0;
            getPriceCount(element.toLowerCase());
        }


    }

    private void getPriceCount(String item) {
        String price = "";
        String previousPrice = "";
        int priceCounter = 0;

        for (String each : pairValues) {
            if (each.matches("(.*)(?i)" + item + "(.*)")) {

                if (priceCounter == 0) {
                    previousPrice = matchedString(each, "-(.*?)-");
                }
                price = matchedString(each, "-(.*?)-");

                if (price.equals(previousPrice)) {
                    priceCounter++;
                } else {
                    createPrintLine(priceCounter, "Price:" + padRight(previousPrice,9));
                    previousPrice = price;
                    priceCounter = 1;
                }

            } else if (priceCounter != 0) {
                createPrintLine(priceCounter, "Price:" + padRight(price,9));
                price = "";
                priceCounter = 0;
            }

        }
        if (priceCounter != 0) createPrintLine(priceCounter, "Price:\t" + price);

        addDividers("new");
    }

//------- error counting -------------------------

    private void getErrors(String lineIn) {
        // delimiter between key:value pairs ->    ; ^ % * ! @

        String pattern = "[;!%@^*]";
        Scanner sc = new Scanner(lineIn);
        sc.useDelimiter(pattern);

        while (sc.hasNext()) {
            String line = sc.next();
            if (findPattern(lineIn, ":") == false) {
                errorCount++;
            } else {
                getMissingValues(line);
            }
        }
    }

    private void getMissingValues(String input) {
        // delimiter for key values ->   :
        int count = 0;
        Scanner sc = new Scanner(input);
        sc.useDelimiter(":");

        while (sc.hasNext()) {
            String line = sc.next();
            count++;
        }

        if (count != 2) errorCount++;
    }


//-------- utilities ------------------------------------
    public Boolean findPattern(String textToSearch, String pattern) {
        Pattern pattern1 = Pattern.compile(pattern);
        return pattern1.matcher(textToSearch).find();
    }

    public String matchedString(String textToSearch, String pattern) {

        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(textToSearch);
        if (matcher.find()) return matcher.group(1);
        return "";
    }

    private void createPrintLine(Integer counter, String item) {
        printingLines.add(item + "\t\tseen: " + counter + " times\n");
        addDividers(item);
    }

    private void addDividers(String item) {

        if (findPattern(item, "name")) {
            String line = "===============\t\t=============\n";
            printingLines.add(line);
        } else if (findPattern(item,"Errors")) {

        } else if (findPattern(item,"new")){
            printingLines.add("\n");
        } else {
            String line = "---------------\t\t-------------\n";
            printingLines.add(line);
        }

    }

    private String padRight(String s, int n){
        return String.format("%" + n + "s",s);
    }
}
