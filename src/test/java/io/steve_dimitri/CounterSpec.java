package io.steve_dimitri;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by stevejaminson on 5/24/16.
 */
public class CounterSpec {

    @Test
    public void getMilkInfoTestNumber(){
        Counter counter = new Counter();
        ItemParser parser = new ItemParser();
        try {
           parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setNameData(parser.rawArray);
        parser.setPriceData(parser.rawArray);
        counter.getMilkInfo(parser.itemList);
        int expected = 6;
        int actual = counter.totalMilks;
        assertEquals(expected,actual);
    }

    @Test
    public void getMilkInfoTestPrice(){
        Counter.milkPrices = new TreeMap<Double, Integer>();
        Counter counter = new Counter();
        ItemParser parser = new ItemParser();
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setNameData(parser.rawArray);
        parser.setPriceData(parser.rawArray);
        counter.getMilkInfo(parser.itemList);
        int expected = 5;
        int actual = counter.milkPrices.get(3.23);
        assertEquals(expected,actual);
    }

    @Test
    public void getBreadInfoTestPrice(){
        Counter counter = new Counter();
        ItemParser parser = new ItemParser();
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setNameData(parser.rawArray);
        parser.setPriceData(parser.rawArray);
        counter.getBreadInfo(parser.itemList);
        int expected = 6;
        int actual = counter.breadPrices.get(1.23);
        assertEquals(expected,actual);
    }

    @Test
    public void getCookieInfoTestPrice(){
        Counter counter = new Counter();
        ItemParser parser = new ItemParser();
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setNameData(parser.rawArray);
        parser.setPriceData(parser.rawArray);
        counter.getCookieInfo(parser.itemList);
        int expected = 8;
        int actual = counter.cookiePrices.get(2.25);
        assertEquals(expected,actual);
    }

    @Test
    public void getApplePricesTest(){
        Counter counter = new Counter();
        ItemParser parser = new ItemParser();
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setNameData(parser.rawArray);
        parser.setPriceData(parser.rawArray);
        counter.getAppleInfo(parser.itemList);
        int expected = 2;
        int actual = counter.applePrices.get(0.23);
        assertEquals(expected,actual);
    }
}
