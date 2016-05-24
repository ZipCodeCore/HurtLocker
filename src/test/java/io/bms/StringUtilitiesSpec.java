package io.bms;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by samhudgens on 5/24/16.
 */
public class StringUtilitiesSpec {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void parseStringArrayTest(){
        String testCase = "bryant##min##sam##";
        String[] expectedValue = {"bryant","min","sam"};
        String[] actualValue = StringUtilities.parseStringArray(testCase);
        assertArrayEquals(expectedValue,actualValue);
    }

    @Test
    public void splitStringIntoKeyValuePairsTest(){
        String testCase = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        String[] expectedValue = {"naMe:Milk", "price:3.23", "type:Food", "expiration:1/25/2016"};
        String[] actualValue = StringUtilities.splitStringIntoKeyValuePairs(testCase);
        assertArrayEquals(expectedValue, actualValue);
    }
    @Test
    public void grabKeyTest() throws Error{
        String testCase = "naMe:Milk";
        String expectedValue = "naMe";
        String actualValue = StringUtilities.grabKey(testCase);
        assertEquals(expectedValue,actualValue);

    }

    @Test
    public void grabValueTest() throws Error{
        String testCase = "naMe:COokIes";
        String expectedValue = "COokIes";
        String actualValue = StringUtilities.grabValue(testCase);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void errorValueExceptionTest() throws Error{
        thrown.expect(Error.class);
        thrown.expectMessage("Missing Value");
        StringUtilities.grabValue("naMe:");
        int expectedCount = 1;
        int actualCount =Error.returnCount();
        assertEquals(expectedCount,actualCount);
    }

    @Test
    public void spellingCorrectorTest(){
        String testCase = "c0okies";
        String expectedValue = "cookies";
        String actualValue = StringUtilities.spellingCorrector(testCase);
        assertEquals(expectedValue,actualValue);
    }

}
