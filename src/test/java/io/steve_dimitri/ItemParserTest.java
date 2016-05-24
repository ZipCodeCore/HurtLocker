package io.steve_dimitri;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by stevejaminson on 5/24/16.
 */
public class ItemParserTest {

    ItemParser parser;

    @Before
    public void initiate(){
        parser = new ItemParser();
    }

    @Test
    public void splitRawDataTest(){
        String expected = "Parsed";
        String actual = parser.splitRawData("Parsed##Test##").get(0);
        assertEquals(expected,actual);
    }

    @Test
    public void itemGeneratorTest(){
        int expected = 24;
        int actual = 0;
        try {
            actual = parser.itemGenerator(parser.splitRawData(parser.readRawDataToString())).size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expected,actual);
    }

    @Test
    public void errorTest(){
        ItemParser.setErrorCount(0);
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int expected = 4;
        int actual = parser.getErrorCount();
        assertEquals(expected,actual);
    }

    @Test
    public void setPriceDataTestSize(){
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setPriceData(parser.rawArray);
        int expected = 24;
        int actual = parser.itemList.size();
        assertEquals(expected,actual);
    }

    @Test
    public void setPriceDataTestPrice(){
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setPriceData(parser.rawArray);
        String expected = "1.23";
        String actual = parser.itemList.get(23).getPrice();
        assertEquals(expected,actual);
    }

    @Test
    public void setExpireDataTest(){
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setExpireData(parser.rawArray);
        String expected = "1/25/2016";
        String actual = parser.itemList.get(23).getExpiration();
        assertEquals(expected,actual);
    }

    @Test
    public void setNameDataTest(){
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setNameData(parser.rawArray);
        String expected = "apples";
        String actual = parser.itemList.get(22).getName();
    }

    @Test
    public void setTypeDataTest(){
        try {
            parser.itemGenerator(parser.splitRawData(parser.readRawDataToString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        parser.setTypeData(parser.itemList);
        String expected = "Food";
        String actual = parser.itemList.get(13).getType();
    }

}
