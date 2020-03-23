import java.io.*;
import java.util.*;

public class JerkSONParser {
    private String data;
    private int exceptionCount;
    private List<String> pairedValues;
    private List<String> linesToPrint;
    private Set<String> uniqueValues;
    private Writer writer;


    public JerkSONParser(String data){
        this.data = data;
        pairedValues = new ArrayList<>();
        linesToPrint = new ArrayList<>();
        uniqueValues = new HashSet<>();
        writer = new Writer();
    }

    public void processFile(){
        getAndSetLines();
        countItems();
        createPrintLine(exceptionCount, "errors\t\t");
        try {
            writer.writeToFile(linesToPrint);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void getAndSetLines(){
        Scanner sc = new Scanner(data);
        sc.useDelimiter("##");

        while(sc.hasNext()){
            String line = sc.next();
            getErrors(line);
            storeValues(line);
        }
    }

    public void storeValues(String toParse){
        String name;
        String price;

        name = ParserUtils.matchedString(toParse, "(?i)name:(.*?);");
        price = ParserUtils.matchedString(toParse, "(?i)price:(.*?);");

        if(price.equals("") || name.equals("")){
        }
        else{
            name = name.toLowerCase();
            pairedValues.add(name + "-" + price + "-");
            uniqueValues.add(name);
        }
    }



    public void getPriceCounter(String item){
        String price = "";
        String previousPrice = "";
        int priceCounter = 0;

        for(String s : pairedValues){
            if(s.matches("(.*)(?i)" + item + "(.*)")) {
                if (priceCounter == 0) {
                    previousPrice = ParserUtils.matchedString(s, "-(.*?)-");
                }
                price = ParserUtils.matchedString(s, "-(.*?)-");


                if (price.equals(previousPrice)) {
                    priceCounter++;
                } else {
                    createPrintLine(priceCounter, "price:" + ParserUtils.printPadding(previousPrice, 9));
                    previousPrice = price;
                    priceCounter = 1;
                }
            }
            else if(priceCounter != 0){
                createPrintLine(priceCounter, "price:" + ParserUtils.printPadding(price, 9));
                price = "";
                priceCounter = 0;
            }
        }
        if(priceCounter != 0) {
            createPrintLine(priceCounter, "price:\t" + price);
        }
        printDividers("new");

    }

    public void countItems(){
        Collections.sort(pairedValues);

        int counter = 0;
        for(String element : uniqueValues){
            for(String s : pairedValues){
                if(s.matches("(.*)(?i)" + element + "(.*)") && s.matches("(.*)(?i)[0-9](.*)")){
                    counter++;
                }
            }
            createPrintLine(counter, "name:" + ParserUtils.printPadding(element,10).toLowerCase());
            counter = 0;
            getPriceCounter(element.toLowerCase());
        }
    }

    public void getErrors(String lineIn){
        String pattern = "[;!%@^*]";
        Scanner sc = new Scanner(lineIn);
        sc.useDelimiter(pattern);

        while (sc.hasNext()){
            String line = sc.next();
            if(!ParserUtils.findPattern(lineIn, ":")){
                exceptionCount++;
            }
            else{
                findMissingVals(line);
            }
        }
    }

    public void findMissingVals(String input){
        int count = 0;
        Scanner sc = new Scanner(input);
        sc.useDelimiter(":");

        while (sc.hasNext()){
            String line = sc.next();
            count++;
        }
        if(count != 2){
            exceptionCount++;
        }
    }



    public void createPrintLine(Integer counter, String item){
        linesToPrint.add(item + "\t\tseen: " + counter + " times\n");
        printDividers(item);
    }

    public void printDividers(String item){
        if(ParserUtils.findPattern(item, "name")){
            String line = "=================\t\t=================";
            linesToPrint.add(line);
        }
        else if(ParserUtils.findPattern(item, "errors")){
        }
        else if(ParserUtils.findPattern(item, "new")){
            linesToPrint.add("\n");
        }
        else{
            String line = "-------------------\t\t-------------------";
            linesToPrint.add(line);
        }
    }
}
