package io.steve_dimitri;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by stevejaminson on 5/24/16.
 */
public class ItemParser {

    Pattern namePattern = Pattern.compile("(?i)name");
    Pattern cookiePattern = Pattern.compile("(?i)c(o|0)(o|0)k(i|l)(e|3)s");
    Pattern milkPattern = Pattern.compile("(?i)milk");
    Pattern breadPattern = Pattern.compile("(?i)bread");
    Pattern applePattern = Pattern.compile("(?i)apples");
    Pattern pricePattern =  Pattern.compile("(?i)price");
    Pattern decimalPattern = Pattern.compile("(\\d+\\.\\d+)");
    Pattern expirationPattern = Pattern.compile("(?i)expiration");
    Pattern datePattern = Pattern.compile("([\\d]{1})\\/([\\d]{2})\\/([\\d]{4})");

    ArrayList<Item> itemList = new ArrayList<Item>();
    ArrayList<String> rawArray =new ArrayList<String>();

    private static int errorCount = 0;

    public int getErrorCount() {
        return errorCount;
    }

    public static void setErrorCount(int errorCount) {
        ItemParser.errorCount = errorCount;
    }

    /**
     * Get raw string from file.
     * @return
     * @throws Exception
     */
    public String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    /**
     * Split raw string into an array of strings.
     * @param rawData
     * @return
     */
    public ArrayList<String> splitRawData(String rawData){
        String[] tempArr = rawData.split("##");
        for (int i = 0; i < tempArr.length; i++){
            rawArray.add(tempArr[i]);
        }
        return rawArray;
    }

    /**
     * Generates an array list of item objects from the string array.
     * @param strArray
     * @return
     */
    public ArrayList<Item> itemGenerator(ArrayList<String> strArray){
        for(int i = 0; i < strArray.size(); i++) {
            Matcher milkMatch = milkPattern.matcher(strArray.get(i));
            Matcher cookieMatch = cookiePattern.matcher(strArray.get(i));
            Matcher breadMatch = breadPattern.matcher(strArray.get(i));
            Matcher appleMatch = applePattern.matcher(strArray.get(i));
            Matcher priceMatch = decimalPattern.matcher(strArray.get(i));
            if ((milkMatch.find() || cookieMatch.find() || breadMatch.find() || appleMatch.find()) && priceMatch.find()) {
                itemList.add(new Item());
            } else{
                rawArray.remove(i);
                rawArray.add(i,"error");
                errorCount++;
            }
        }
        return itemList;
    }

    public void setPriceData(ArrayList<String> strArray){
        int count = 0;
        for(int i = 0; i < strArray.size(); i++){
            Matcher priceMatch = decimalPattern.matcher(strArray.get(i));
            if(priceMatch.find() && !strArray.get(i).equals("error")){
                itemList.get(count).setPrice(priceMatch.group());
                count++;
            }
        }
    }

    public void setNameData(ArrayList<String> strArray){
        int count = 0;
        for(int i = 0; i < strArray.size(); i++){
            Matcher milkMatch = milkPattern.matcher(strArray.get(i));
            Matcher cookieMatch = cookiePattern.matcher(strArray.get(i));
            Matcher breadMatch = breadPattern.matcher(strArray.get(i));
            Matcher appleMatch = applePattern.matcher(strArray.get(i));
            if(milkMatch.find() && !strArray.get(i).equals("error")){
                itemList.get(count).setName(milkMatch.group());
                count++;
            } else if(cookieMatch.find() && !strArray.get(i).equals("error")){
                itemList.get(count).setName("cookies");
                count++;
            } else if(breadMatch.find() && !strArray.get(i).equals("error")){
                itemList.get(count).setName(breadMatch.group());
                count++;
            } else if(appleMatch.find() && !strArray.get(i).equals("error")){
                itemList.get(count).setName(appleMatch.group());
                count++;
            }
        }
    }

    public void setExpireData(ArrayList<String> strArray){
        int count = 0;
        for(int i = 0; i < strArray.size(); i++){
            Matcher expireMatch = datePattern.matcher(strArray.get(i));
            if(expireMatch.find() && !strArray.get(i).equals("error")){
                itemList.get(count).setExpiration(expireMatch.group());
                count++;
            }
        }
    }

    public void setTypeData(ArrayList<Item> itemList){
        for(int i = 0; i < itemList.size(); i++){
            itemList.get(i).setType("Food");
        }
    }


}
