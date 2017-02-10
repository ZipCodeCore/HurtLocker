package marwamilton;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mkulima on 2/8/17.
 */
public class HurtLocker {

    MakeString makeString = new MakeString();
    GroceryRegexEngine groceryRegexEngine = new GroceryRegexEngine();

    // function to iterate over substrings and return key-value pairs
    String[] getPairs(String dumbString){
        //return dumbString.split(";|@|\\^|!|%|\\*");
        return dumbString.split(";|\\^|@|\\*|%|!");
    }

    // internal getLabel pairs
    String[] getLabels(String dumbString){
        return dumbString.split(":");
    }

    // convert String[] to List<String[]>
    public List<String[]> bagGroceries(String[] unSortedGroceries){
        List<String[]> groceryBag = new ArrayList<String[]>();
        int countBaggedGroceries = 0;
        for(String s : unSortedGroceries){
            groceryBag.add(getPairs(s));
            countBaggedGroceries++;
        }
        return groceryBag;
    }

    // in bagged groceries, split into name and value
    public List<String[]> splitLabelPairs(String[] unpaired){
        List<String[]> pairs = new ArrayList<String[]>();
        for(String s: unpaired){
            pairs.add(getLabels(s));
        }
        return pairs;
    }

    // after splitting into name-value pairs, make new grocery list
    public List<List<String[]>> labelTheGroceries(List<String[]> baggedGroceries){
        List<List<String[]>> labelledGroceries = new ArrayList<List<String[]>>();
        for(String[] strarr : baggedGroceries){
            labelledGroceries.add(splitLabelPairs(strarr));
        }
        return labelledGroceries;
    }

    // group the groceries by type
    public List<List<String[]>> groupGroceries(Pattern pattern, List<List<String[]>> groceries){
        List<List<String[]>> groupedGroceries = new ArrayList<List<String[]>>();
        String oneGrocery = "";
        for (List<String[]> strarr : groceries){
            oneGrocery = handleMissing(strarr);
            Matcher m = pattern.matcher(oneGrocery);
            if (m.find()) {
                groupedGroceries.add(strarr);
            }
        }
        return groupedGroceries;
    }

    String handleMissing(List<String[]> strarr){
        String toReturn = "";
        try{
            toReturn = strarr.get(0)[1];
        } catch(Exception e) {
            toReturn = "BAD";
        }
        return toReturn;
    }

    // merge grouped groceries into single string array where first position is name.
    // the other indices are filled with prices found
    public String[] mergedPrices(List<List<String[]>> groupedGroceries){

        String[] prices = new String[groupedGroceries.size() + 1];
        prices[0] = ((groupedGroceries.get(0)).get(0))[1];

        for(int b=0; b<groupedGroceries.size(); b++){
            try {
                prices[b+1] = ((groupedGroceries.get(b)).get(1))[1];
            } catch (Exception e){
                prices[b+1] = "BAD";
            }
        }
        return prices;
    }
    /* */

    // call merged prices method on grouped groceries
    public List<String[]> finalizeGroceries(){
        String unSortedString = makeString.dumb;  // get derrty string
        String[] unSortedStringSplit = unSortedString.split("[(##)]");  // split derrty string
        List<String[]> baggedGroceries = bagGroceries(unSortedStringSplit);   // split each string in string into K-V pairs
        List<List<String[]>> labelledGroceries = labelTheGroceries(baggedGroceries); // further split the actual K-V pairs
        List<String[]> finalizedGroceries = new ArrayList<String[]>();

        for(Pattern p : groceryRegexEngine.GroceryPatterns){
            List<List<String[]>> groupedGroceries1 = groupGroceries(p, labelledGroceries);
            finalizedGroceries.add(mergedPrices(groupedGroceries1));
        }
        return finalizedGroceries;
    }

    public List<String[]> removeBadPrices(List<String[]> finalizedGroceries){
        List<String[]> noRepeatPrices = new ArrayList<String[]>();
        Set<String> namePrices = new HashSet<String>();
        String[] setToString;
        for(String[] sarr : finalizedGroceries){
            Collections.addAll(namePrices, sarr);
            setToString = namePrices.stream().toArray(String[]::new);
            Arrays.sort(setToString, Collections.reverseOrder());
            noRepeatPrices.add(setToString);
            namePrices.clear();
        }
        return noRepeatPrices;
    }

    // prepare output for printing
    public String makePrintable( String[] ls, String[] hasBad){

        ArrayList<String > sizer = new ArrayList<>();
        Collections.addAll(sizer, hasBad);
        Arrays.sort(ls);
        String toPrint1 = String.format("name: %7s", ls[ls.length-1]);
        toPrint1 += "             ";
        toPrint1 += String.format("seen: %d times", sizer.size()-1);
        toPrint1 += "\n==============            =============\n";
        for(int d=ls.length-2; d>=0; d--)
        if(!matchBad(ls[d])) {
            {
                toPrint1 += String.format("Price: %7s", ls[d]);
                toPrint1 += "            ";
                toPrint1 += String.format("seen: %d times", matchPrice(groceryRegexEngine.Prices, hasBad));
                toPrint1 += "\n______________            _____________\n";
            }
        }
        //toPrint1 += "\n\nErrors                    seen: " + countNullElements(finalizeGroceries()) + " times";
        return toPrint1;
    }

    boolean matchBad(String x){
        Matcher m = groceryRegexEngine.BAD.matcher(x);
        return m.find();
    }
    /* */

    int matchPrice(Pattern[] pricePatterns, String[] groceryGroup){
        int numMatches = 0;
        for(int z=0; z<pricePatterns.length; z++){
            numMatches=0;
            for(String s : groceryGroup) {
                Matcher m = pricePatterns[z].matcher(s);
                if (m.find()) {
                    numMatches++;
                }
            }
            if(numMatches>0) return numMatches;
        }
        return numMatches;
    }

    int countNullElements(List<String[]> finalizedGroceries){
        String unSortedString = makeString.dumb;  // get derrty string
        String[] unSortedStringSplit = unSortedString.split("[(##)]");  // split derrty string
        List<String[]> baggedGroceries = bagGroceries(unSortedStringSplit);   // split each string in string into K-V pairs
        List<List<String[]>> labelledGroceries = labelTheGroceries(baggedGroceries); // further split the actual K-V pairs

        int foundNull = 0;
        for(List<String[]> lsarr : labelledGroceries) {
            for (String[] sarr : lsarr) {
                if(sarr.length==1 && (sarr[0].split("[a-z]")).length > 1){
                    //System.out.println(Arrays.toString(sarr));
                    foundNull++;
                }

            }
        }
        return  foundNull;
    }













}
