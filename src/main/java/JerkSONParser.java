import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by evanhitchings on 10/17/16.
 */
public class JerkSONParser {
    private HashMap<String, HashMap<String, Integer>> objectMap = new HashMap<String, HashMap<String, Integer>>();
    private int errors = 0;

    public JerkSONParser(String string){
        this.runAll(string);
    }

    public JerkSONParser(){}



    protected String[] splitJerkSONByItem(String string){
        String[] splitByItem = string.split("(##)");
        return splitByItem;
    }

    protected String[][] splitJerkSONByField(String[] items){
        int lengthOfItems = items.length;
        String[][] splitByField = new String[lengthOfItems][4];
        for(int i = 0; i < lengthOfItems; i++){
            splitByField[i] = items[i].split("(;|\\^|\\*|%|!|@)");
        }
        return splitByField;
    }

    protected String replaceZeroesWithOs(String string){
        Pattern pattern = Pattern.compile("[a-zA-Z]0[a-zA-Z]");
        Matcher matcher = pattern.matcher(string);
        String toReturn = matcher.replaceAll("ook");
        return toReturn;
    }

    protected String capitalizeFirstLetter(String string){
        Pattern pattern = Pattern.compile("(\\b[a-z]{1})");
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while(matcher.find()) {
            String toConvert = matcher.group();
            char replacement = toConvert.charAt(0);
            replacement -= 32;
            matcher.appendReplacement(stringBuffer, replacement + "");
        }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
    }

    protected String lowercaseNonFirstLetters(String string){
        Pattern pattern = Pattern.compile("(\\B[A-Z]{1})");
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while(matcher.find()) {
            String toConvert = matcher.group();
            char replacement = toConvert.charAt(0);
            replacement += 32;
            matcher.appendReplacement(stringBuffer, replacement + "");
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }



         protected int matchesOfType(String string, String patternToMatch){
             Pattern pattern = Pattern.compile("("+patternToMatch+")");
             Matcher matcher = pattern.matcher(string);
             int count = 0;
             while(matcher.find()){
                 count++;
             }
             return count;
         }

         protected int errors(String[][] string){
             int toReturn = 0;
             for(String[] items : string){
                 for(String fields : items){
                     toReturn += this.matchesOfType(fields, ":$");
                 }
             }


             return toReturn;
         }

//         protected String[][] removeNamesAfterErrorChecking(String[][] string){
//             Pattern pattern = Pattern.compile("(Name:)");
//             for(String [] items : string){
//                 for(int i = 0; i < 1; i++){
//                     Matcher matcher = pattern.matcher(items[i]);
//                     items[0] = matcher.replaceAll("");
//                 }
//             }
//             return string;
//         }
//
//         protected String[][] removePricesAfterErrorChecking(String[][] string){
//             Pattern pattern = Pattern.compile("(Price:)");
//             for(String [] items : string){
//                 for(int i = 0; i < 4; i++){
//                     Matcher matcher = pattern.matcher(items[i]);
//                     items[i] = matcher.replaceAll("");
//                 }
//             }
//             return string;
//         }

         protected String[][] removeFieldName(String[][] jerkson, String toRemove){

             Pattern pattern = Pattern.compile("("+ toRemove+")");
             for(String [] items : jerkson){
                 for(int i = 0; i < 4; i++){
                     Matcher matcher = pattern.matcher(items[i]);
                     items[i] = matcher.replaceAll("");
                 }
             }
             return jerkson;
         }





         protected void fillMapWithKeys(String[][] values){
             //HashMap<String, HashMap<String, String>> toReturn = new HashMap<String, HashMap<String, String>>();
             for(String[] field: values ){
                 if(field[0].length() > 0){
                     objectMap.put(field[0], new HashMap<String, Integer>());
                 }
             }
         }



         @Override
         public String toString(){
             StringBuilder stringBuilder = new StringBuilder();
             for(String key : this.objectMap.keySet()){
                 int keySeen = this.objectMap.get(key).get(key);
                 String keyToAppend = "";
                 if(keySeen > 1){
                     keyToAppend = String.format("Name:%8s\t\t\t\tseen: %d times\n", key, keySeen);
                 } else {
                     keyToAppend = String.format("Name:%8s\t\t\t\tseen: %d time \n", key, keySeen);
                 }
                 stringBuilder.append(keyToAppend);
                 stringBuilder.append("=============\t\t\t\t=============\n");

                 for(String secondKey : this.objectMap.get(key).keySet()){
                     if(secondKey.equals(key) || secondKey.length() == 0){
                         continue;
                     }
                    String priceToAppend = "";
                    int valueSeen = this.objectMap.get(key).get(secondKey);
                     if(valueSeen > 1){
                         priceToAppend = String.format("Price:%7s\t\t\t\tseen: %d times\n", secondKey, valueSeen);
                     } else {
                         priceToAppend = String.format("Price:%7s\t\t\t\tseen: %d time \n", secondKey, valueSeen);
                     }
                     stringBuilder.append(priceToAppend);
                     stringBuilder.append("-------------\t\t\t\t-------------\n");

                 }
             }
             stringBuilder.append(String.format("Errors%7s\t\t\t\tsee: %d times", "", this.errors));
             return stringBuilder.toString();

         }

         protected void fillmapwithValues(String[][] string){
             for(String key : this.objectMap.keySet()){
                 HashMap<String, Integer> toFill = this.objectMap.get(key);
                 for(String[] items : string){
                     if(!(items[0].equalsIgnoreCase(key))){
                         continue;
                     }
                     for(int i = 0; i < 2; i++){
                         if(toFill.containsKey(items[i])){
                             Integer toPlus = toFill.get(items[i]) + 1;
                             toFill.put(items[i], toPlus);
                         } else {
                             toFill.put(items[i], 1);
                         }
                     }

                     }
                 }
         }

         protected void runAll(String jerkString){

             String noZeroes = replaceZeroesWithOs(jerkString);
             String firstCapital = capitalizeFirstLetter(noZeroes);
             String noUpperCaseInMiddleOfWords = lowercaseNonFirstLetters(firstCapital);
             String[] byItem = splitJerkSONByItem(noUpperCaseInMiddleOfWords);
             String[][] byField = splitJerkSONByField(byItem);
             this.errors = errors(byField);
//             String[][] noPrices = removePricesAfterErrorChecking(byField);
//             String[][] noNames = removeNamesAfterErrorChecking(noPrices);

//             this.fillMapWithKeys(noNames);
//             this.fillmapwithValues(noNames);
         }


    public HashMap<String, HashMap<String, Integer>> getObjectMap() {
        return objectMap;
    }

    public int getErrors() {
        return errors;
    }
}





