import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private  String rawData;
    private int errorCount = 0;
    private Map<String,String> allItems = new HashMap<>();


//-------- constructor ----------------
    public StringParser (String dataIn){
        rawData = dataIn;
    }

//-------- logic ----------------------

    public void processFile(){
        getEachLine();
        getCount();
        //System.out.println(errorCount);
    }

    private void getEachLine(){

        Scanner sc = new Scanner(rawData);

        sc.useDelimiter("##");
        while (sc.hasNext()) {
            String line = sc.next();
//            System.out.println(line);
            parseLine(line);
        }
    }


    private void parseLine(String lineIn){
        // delimiter between key:value pairs ->    ; ^ % * ! @

        String pattern = "[;!%@^*]";
        Scanner sc = new Scanner(lineIn);
        sc.useDelimiter(pattern);

        while (sc.hasNext()) {
            String line = sc.next();
//            System.out.println(line);
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
//            System.out.println(line);
            if (count == 0) {
                key = line.toLowerCase();
            } else {
                value = line.toLowerCase();
            }
            count++;
        }

        allItems.put(key,value);

        if (count !=2) errorCount++;
    }


    private void getCount (){
        for (String key : allItems.keySet()){
            System.out.println(key.toString());
        }
    }


    public String replaceString(String textToSearch, String pattern, String newWord){
        Pattern pattern1 = Pattern.compile(pattern.toLowerCase());
        Matcher matcher = pattern1.matcher(textToSearch.toLowerCase());

        String result = matcher.replaceAll(newWord);

        return result;
    }


}
