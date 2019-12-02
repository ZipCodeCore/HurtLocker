import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private  String rawData;
    private Set<String> items = new HashSet<>();
    private List<String> allItems = new ArrayList<>();
    private int errorCount = 0;


//-------- constructor ----------------
    public StringParser (String dataIn){
        rawData = dataIn;
    }

//-------- logic ----------------------

    public void processFile(){
        getEachLine();
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
            System.out.println(line);
            if (findPattern(lineIn, ":") == false) {
                errorCount++;
            } else {
                parseKeyValues(line);
            }
        }
    }

    public Boolean findPattern (String textToSearch, String pattern){
        Pattern pattern1 = Pattern.compile(pattern.toLowerCase());
        return pattern1.matcher(textToSearch.toLowerCase()).find();
    }

    private void parseKeyValues(String value){
        // delimiter for key values ->   :
        int count = 0;
        Scanner sc = new Scanner(value);
        sc.useDelimiter(":");

        while (sc.hasNext()){
            String line = sc.next();
//            System.out.println(line);
            count++;
        }

        if (count !=2) errorCount++;
    }

    public String replaceString(String textToSearch, String pattern, String newWord){
        Pattern pattern1 = Pattern.compile(pattern.toLowerCase());
        Matcher matcher = pattern1.matcher(textToSearch.toLowerCase());

        String result = matcher.replaceAll(newWord);

        return result;
    }

}
