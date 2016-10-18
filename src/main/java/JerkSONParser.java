import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by evanhitchings on 10/17/16.
 */
public class JerkSONParser {
    private HashMap<String, HashMap<String, Integer>> objectMap = new HashMap<String, HashMap<String, Integer>>();
    private int errors = 0;
    private List<GroceryItem> objectsCreated = new ArrayList<GroceryItem>();
    private String formattedString;
    private String[][] splitJerkson;

    public JerkSONParser(String string) {
        this.formattedString = string;
        runAll();

    }
    public JerkSONParser(){}

    public String getFormattedString() {
        return formattedString;
    }

    public void setFormattedString(String formattedString) {
        this.formattedString = formattedString;
    }


    public List<GroceryItem> getObjectsCreated() {
        return objectsCreated;
    }

    public void setObjectsCreated(List<GroceryItem> objectsCreated) {
        this.objectsCreated = objectsCreated;
    }

    public String[][] getSplitJerkson() {
        return splitJerkson;
    }

    public void setSplitJerkson(String[][] splitJerkson) {
        this.splitJerkson = splitJerkson;
    }

    protected String[] splitJerkSONByItem(){
        String[] splitByItem = this.formattedString.split("(##)");
        return splitByItem;
    }

    protected void splitJerkSONByField(String[] items){
        int lengthOfItems = items.length;
        String[][] splitByField = new String[lengthOfItems][4];
        for(int i = 0; i < lengthOfItems; i++){
            splitByField[i] = items[i].split("(;|\\^|\\*|%|!|@)");
        }
        this.splitJerkson = splitByField;
    }

    protected void replaceZeroesWithOs(){

        Pattern pattern = Pattern.compile("[a-zA-Z]0[a-zA-Z]");
        Matcher matcher = pattern.matcher(this.formattedString);
        this.formattedString = matcher.replaceAll("ook");
    }

    protected void capitalizeFirstLetter(){
        Pattern pattern = Pattern.compile("(\\b[a-z]{1})");
        Matcher matcher = pattern.matcher(this.formattedString);
        StringBuffer stringBuffer = new StringBuffer();
        while(matcher.find()) {
            String toConvert = matcher.group();
            char replacement = toConvert.charAt(0);
            replacement -= 32;
            matcher.appendReplacement(stringBuffer, replacement + "");
        }
            matcher.appendTail(stringBuffer);
            this.formattedString = stringBuffer.toString();
    }

    protected void lowercaseNonFirstLetters(){
        Pattern pattern = Pattern.compile("(\\B[A-Z]{1})");
        Matcher matcher = pattern.matcher(this.formattedString);
        StringBuffer stringBuffer = new StringBuffer();
        while(matcher.find()) {
            String toConvert = matcher.group();
            char replacement = toConvert.charAt(0);
            replacement += 32;
            matcher.appendReplacement(stringBuffer, replacement + "");
        }
        matcher.appendTail(stringBuffer);
        this.formattedString = stringBuffer.toString();
    }



         protected int matchesOfType(String patternToMatch){

             Pattern pattern = Pattern.compile("("+patternToMatch+")");
             Matcher matcher = pattern.matcher(this.formattedString);
             int count = 0;
             while(matcher.find()){
                 count++;
             }
             return count;
         }

         protected void removeFieldName(String toRemove, int indexOfField){
             Pattern pattern = Pattern.compile("("+toRemove+")");
             for(String[] items : this.splitJerkson){
                 Matcher matcher = pattern.matcher(items[indexOfField]);
                 items[indexOfField] = matcher.replaceAll("");

             }
             return;
         }

         protected void removeAllFieldNames(){
             int numOfFields = this.splitJerkson[0].length;
             for(int i = 0; i < numOfFields; i++){
                 Pattern pattern = Pattern.compile("[a-zA-Z]+?:");
                 Matcher matcher = pattern.matcher(this.splitJerkson[0][i]);
                 matcher.find();
                 String toRemove = matcher.group();

                 removeFieldName(toRemove, i);
             }
         }
         protected void fillMapWithKeys(String[][] values){
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

         public void runAll(){

             replaceZeroesWithOs();
             capitalizeFirstLetter();
             lowercaseNonFirstLetters();
             String[] splitByItem = splitJerkSONByItem();
             splitJerkSONByField(splitByItem);
             removeAllFieldNames();
             createObjects();
         }

         public void createObjects(){

             for(String[] items : this.splitJerkson){
                 try{
                     this.objectsCreated.add(GroceryItem.groceryItemFactory(items));
                 } catch(JerkSONException e){
                     this.errors += 1;
                     continue;
                 }
             }
         }


    public int getErrors() {
        return errors;
    }
}





