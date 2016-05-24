package io.steve_dimitri;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by stevejaminson on 5/24/16.
 */
public class Counter {
    ItemParser parser = new ItemParser();

    static int totalApples = 0;
    static int totalBread = 0;
    static int totalMilks = 0;
    static int totalCookies = 0;
    static TreeMap<Double,Integer> milkPrices = new TreeMap<Double, Integer>();
    static TreeMap<Double,Integer> breadPrices = new TreeMap<Double, Integer>();
    static TreeMap<Double,Integer> cookiePrices = new TreeMap<Double, Integer>();
    static TreeMap<Double,Integer> applePrices = new TreeMap<Double, Integer>();
    ArrayList<Double> priceOfMilk = new ArrayList<Double>();

    public void getMilkInfo(ArrayList<Item> items){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equalsIgnoreCase("milk")) {
                if(milkPrices.containsKey(Double.parseDouble(items.get(i).getPrice()))){
                    milkPrices.put(Double.parseDouble(items.get(i).getPrice()),
                            milkPrices.get(Double.parseDouble(items.get(i).getPrice()))+1);

                } else {
                    milkPrices.put(Double.parseDouble(items.get(i).getPrice()),1);
                }
                totalMilks++;
            }
        }
    }

    public void getBreadInfo(ArrayList<Item> items){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equalsIgnoreCase("bread")) {
                if(breadPrices.containsKey(Double.parseDouble(items.get(i).getPrice()))){
                    breadPrices.put(Double.parseDouble(items.get(i).getPrice()),
                            breadPrices.get(Double.parseDouble(items.get(i).getPrice()))+1);
                } else {
                    breadPrices.put(Double.parseDouble(items.get(i).getPrice()),1);
                }
                totalBread++;
            }
        }
    }

    public void getCookieInfo(ArrayList<Item> items){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equalsIgnoreCase("cookies")) {
                if(cookiePrices.containsKey(Double.parseDouble(items.get(i).getPrice()))){
                    cookiePrices.put(Double.parseDouble(items.get(i).getPrice()),
                            cookiePrices.get(Double.parseDouble(items.get(i).getPrice()))+1);
                } else {
                    cookiePrices.put(Double.parseDouble(items.get(i).getPrice()),1);
                }
                totalCookies++;
            }
        }
    }

    public void getAppleInfo(ArrayList<Item> items){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getName().equalsIgnoreCase("apples")) {
                if(applePrices.containsKey(Double.parseDouble(items.get(i).getPrice()))){
                    applePrices.put(Double.parseDouble(items.get(i).getPrice()),
                            applePrices.get(Double.parseDouble(items.get(i).getPrice()))+1);
                } else {
                    applePrices.put(Double.parseDouble(items.get(i).getPrice()),1);
                }
                totalApples++;
            }
        }
    }

    public void setMilkPrices(){
        System.out.println(applePrices.keySet().toArray()[0]);
        System.out.println(applePrices.get(applePrices.keySet().toArray()[0]));
        }

}
