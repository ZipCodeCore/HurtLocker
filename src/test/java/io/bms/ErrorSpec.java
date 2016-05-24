package io.bms;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by samhudgens on 5/24/16.
 */
public class ErrorSpec {

    @Test
    public void formattedToStringTest(){
        Error error = new Error("Item not found");
        String expectedString = "Errors\t\tseen: 1 times";
        String actualString = error.formatedToString();
        assertEquals(expectedString,actualString);
    }
}
