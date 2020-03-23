import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//count exceptions
//all letters to lower
//## for new object
//map of objects

//try to add to parser utils if time
public class JerkSONParser {
    private String data;
    private int exceptionCount;
    private List<String> pairedValues;
    private List<String> linesToPrint;
    private Set<String> uniqueValues;
    private Writer console;


    public JerkSONParser(String rawData){
        this.data = rawData;
        pairedValues = new ArrayList<>();
        linesToPrint = new ArrayList<>();
        uniqueValues = new HashSet<>();
        console = new Writer();
    }

    public void processFile(){
        getAndSetLines();
        countItems();
        createPrintLine(exceptionCount, "errors\t\t");
        try {
            console.writeToFile(linesToPrint);
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
        String name = "";
        String price = "";

        name = matchedString(toParse, "(?i)name:(.*?);");
        price = matchedString(toParse, "(?i)price:(.*?);");

        if(price.equals("") || name.equals("")){
        }
        else{
            name = name.toLowerCase();
            pairedValues.add(name + "-" + price + "-");
            uniqueValues.add(name);
            price = "";
            name = "";
        }
    }



    public void getPriceCounter(String item){
        String price = "";
        String previousPrice = "";
        int priceCounter = 0;

        for(String s : pairedValues){
            if(s.matches("(.*)(?i)" + item + "(.*)")) {
                if (priceCounter == 0) {
                    previousPrice = matchedString(s, "-(.*?)-");
                }
                price = matchedString(s, "-(.*?)-");


                if (price.equals(previousPrice)) {
                    priceCounter++;
                } else {
                    createPrintLine(priceCounter, "price:" + printPadding(previousPrice, 9));
                    previousPrice = price;
                    priceCounter = 1;
                }
            }
            else if(priceCounter != 0){
                createPrintLine(priceCounter, "price:" + printPadding(price, 9));
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
            createPrintLine(counter, "name:" + printPadding(element,10).toLowerCase());
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
            if(!findPattern(lineIn, ":")){
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

    public String matchedString(String textToSearch, String pattern){
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(textToSearch);
        if(matcher.find()){
            return matcher.group(1);
        }
        return "";
    }

    public Boolean findPattern(String textToSearch, String pattern){
        Pattern pattern1 = Pattern.compile(pattern);
        return pattern1.matcher(textToSearch).find();
    }



    public String printPadding(String s, int  n){
        return String.format("%" + n + "s", s);
    }

    public void createPrintLine(Integer counter, String item){
        linesToPrint.add(item + "\t\tseen: " + counter + " times\n");
        printDividers(item);
    }

    public void printDividers(String item){
        if(findPattern(item, "name")){
            String line = "=================\t\t=================";
            linesToPrint.add(line);
        }
        else if(findPattern(item, "errors")){
        }
        else if(findPattern(item, "new")){
            linesToPrint.add("\n");
        }
        else{
            String line = "-------------------\t\t-------------------";
            linesToPrint.add(line);
        }
    }





}
