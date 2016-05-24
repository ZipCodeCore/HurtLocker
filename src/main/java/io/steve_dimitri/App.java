package io.steve_dimitri;

import java.util.Map;

/**
 * Created by stevejaminson on 5/24/16.
 */
public class App {

    ItemParser parser = new ItemParser();
    Counter counter = new Counter();
    Format format = new Format();

    public void run(){
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        parser.setNameData(parser.rawArray);
        parser.setPriceData(parser.rawArray);
        parser.setExpireData(parser.rawArray);
        parser.setTypeData(parser.itemList);
        counter.getAppleInfo(parser.itemList);
        counter.getMilkInfo(parser.itemList);
        counter.getCookieInfo(parser.itemList);
        counter.getBreadInfo(parser.itemList);
//        System.out.println("Apples : " + counter.totalApples + "\n");
//        for(Map.Entry<Double,Integer> entry : counter.applePrices.entrySet()){
//            String key = entry.getKey().toString();
//            String value = entry.getValue().toString();
//            System.out.println("Key: " + key + " " + "Value: " + value);
        format.stringFormat();
        }
    }

