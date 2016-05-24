package io.HandroHoxtah;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by alejandrolondono on 5/24/16.
 */
public class PriceSpec {

    Price priceObj;
    double thePrice;


    @Before
    public void setup(){
        thePrice = 24.99;
        priceObj = new Price(thePrice);
    }

    @Test
    public void incrementTest(){
        int expected =2;
        priceObj.increment();
        int actualInc = priceObj.getHowMany();
        assertEquals(expected,actualInc);
    }

}
