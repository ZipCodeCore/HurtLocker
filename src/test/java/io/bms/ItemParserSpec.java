package io.bms;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by samhudgens on 5/24/16.
 */
public class ItemParserSpec {

    ItemParser itemParser;

    @Before
    public void initialize(){
        itemParser = new ItemParser();
    }

    @Test
    public void addItemTest(){
        String testItemCase = "name:cookies";
        String expectedValue = "cookies";
        String actualValue = itemParser.addItem(testItemCase);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void checkItemExistTest(){
        String testItemCase = "name:cookies";
        itemParser.addItem(testItemCase);
        assertTrue(itemParser.checkItemExist("cookies"));
    }

}
