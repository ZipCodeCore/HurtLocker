import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private  String rawData;
    private Set<String> items = new HashSet<>();
    private int errorCount = 0;


//-------- constructor ----------------
    public StringParser (String dataIn){
        rawData = dataIn;
    }

//-------- logic ----------------------

    public void processFile(){
        getRawData();
    }

    private void getRawData(){

        Scanner sc = new Scanner(rawData);

        sc.useDelimiter("##");
        while (sc.hasNext()) {
            System.out.println(sc.next());
            parseLine(sc.next());
        }
    }


    private void parseLine(String lineIn){
        // delimiter between key:value pairs ->    ; ^ % * ! @
        // delimiter for key values ->   :

        Scanner sc = new Scanner(lineIn);

        // check for missing :

        if (findPattern(lineIn,";") == false){
            errorCount++;
        }

    }

    public Boolean findPattern (String textToSearch, String pattern){
        Pattern pattern1 = Pattern.compile(pattern.toLowerCase());

        return pattern1.matcher(textToSearch.toLowerCase()).find();
    }

    public String replaceString(String textToSearch, String pattern, String newWord){
        Pattern pattern1 = Pattern.compile(pattern.toLowerCase());
        Matcher matcher = pattern1.matcher(textToSearch.toLowerCase());

        String result = matcher.replaceAll(newWord);

        return result;
    }

}
