package io.bms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by samhudgens on 5/24/16.
 */
public class Item {

    private String name;
    private int totalNumberOfOccurences;
    private HashMap<String, Integer> priceOccurences;

    public Item(String name){
        this.name = name;
        priceOccurences = new HashMap<>();
        totalNumberOfOccurences = 0;
    }

    public void addPriceOccurence(String price){
        priceOccurences.put(price, new Integer(1));
        totalNumberOfOccurences++;
    }

    public void addCounter(String price){
        priceOccurences.put(price,new Integer(priceOccurences.get(price).intValue()+1));
        totalNumberOfOccurences++;
    }

    public boolean checkPriceExists(String price){
        return priceOccurences.containsKey(price);
    }
    public int getNumberOfOccurence(String price){
        return priceOccurences.get(price).intValue();
    }

    public String formattedToString(){


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name:\t"+name)
                .append("\t\tseen: "+totalNumberOfOccurences+" times\n")
                .append("=============\t\t=============\n");

        for(HashMap.Entry<String,Integer> entry : priceOccurences.entrySet()){

            stringBuilder.append("Price:\t"+entry.getKey())
                    .append("\t\tseen: "+entry.getValue().intValue()+" times\n")
                    .append("-------------\t\t-------------\n");
        }



        return stringBuilder.toString();
    }



}
