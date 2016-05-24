package io.bms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by bms on 5/24/16.
 */
public class ErrorSpec {

    Error error;

    @Before
    public void initialize(){
        error = new Error("Item not found");

    }
    @Test
    public void formattedToStringTest(){
        String expectedString = "Errors\t\t\t\tseen: 1 times";
        String actualString = Error.formattedToString();
        assertEquals(expectedString,actualString);
    }
}
