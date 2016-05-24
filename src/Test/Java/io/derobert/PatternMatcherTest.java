package io.derobert;

import org.junit.Test;

import static io.derobert.PatternMatcher.*;
import static org.junit.Assert.*;

public class PatternMatcherTest {
    @Test
    public void foodIsMilkTest(){
        assertTrue( foodIsMilk("mILk") );
    }

    @Test
    public void foodIsMilkTestFalse(){
        assertFalse( foodIsMilk("mILkT") );
    }

    @Test
    public void foodIsBreadTest(){
        assertTrue( foodIsBread("BrEaD") );
    }

    @Test
    public void foodIsBreadTestFalse(){
        assertFalse( foodIsBread("BrEaDF") );
    }

    @Test
    public void foodIsCookieTest(){
        assertTrue( foodIsCookies("C00KIEs") );
    }

    @Test
    public void foodIsCookieTestFalse(){
        assertFalse( foodIsCookies("cookiesb") );
    }

    @Test
    public void foodIsAppleTest(){
        assertTrue( foodIsApples("AppLes") );
    }

    @Test
    public void foodIsAppleTestFalse(){
        assertFalse( foodIsApples("appleg") );
    }

    @Test
    public void stringIsNameTest(){
        assertTrue(stringIsName("NaMe"));
    }
    @Test
    public void stringIsPriceTest(){
        assertTrue(stringIsPrice("PrICE"));
    }

    @Test
    public void stringIsNameTestFalse(){
        assertFalse(stringIsName("NaMeD"));
    }
    @Test
    public void stringIsPriceTestFalse(){
        assertFalse(stringIsPrice("PrICED"));
    }
}