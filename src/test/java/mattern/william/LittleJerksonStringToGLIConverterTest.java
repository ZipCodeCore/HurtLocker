package mattern.william;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LittleJerksonStringToGLIConverterTest {
    LittleJerksonStringToGLIConverter littleJerksonStringToGLIConverter;
    String sampleLittleJerksonString1;
    String sampleLittleJerksonString2;
    String sampleLittleJerksonString3;
    String sampleLittleJerksonString4;


    @Before
    public void setUp(){
        littleJerksonStringToGLIConverter = new LittleJerksonStringToGLIConverter();
        sampleLittleJerksonString1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        sampleLittleJerksonString2 = "naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016";
        sampleLittleJerksonString3 = "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016";
        sampleLittleJerksonString4 = "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016";
    }

    @Test
    public void nameKVPairFinderTest(){
        String expected = "naMe:Milk;";
        String actual = littleJerksonStringToGLIConverter.nameKVPairFinder(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringNameParserTest1()   {
        String expected = "Milk";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringNameParser(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringNameParserTest2()   {
        String expected = "Cookies";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringNameParser(sampleLittleJerksonString2);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringNameParserTest3()   {
        String expected = "Milk";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringNameParser(sampleLittleJerksonString3);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringNameParserTest4()   {
        String expected = "Milk";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringNameParser(sampleLittleJerksonString4);
        assertEquals(expected,actual);
    }


    @Test
    public void littleJerksonStringPriceParserTest1()   {
        String expected = "3.23";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringPriceParser(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringPriceParserTest2()   {
        String expected = "2.25";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringPriceParser(sampleLittleJerksonString2);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringPriceParserTest3()   {
        String expected = "error";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringPriceParser(sampleLittleJerksonString3);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringPriceParserTest4()   {
        String expected = "3.23";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringPriceParser(sampleLittleJerksonString4);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringTypeParserTest1()   {
        String expected = "Food";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringTypeParser(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringTypeParserTest2()   {
        String expected = "Food";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringTypeParser(sampleLittleJerksonString2);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringTypeParserTest3()   {
        String expected = "Food";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringTypeParser(sampleLittleJerksonString3);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringTypeParserTest4()   {
        String expected = "Food";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringTypeParser(sampleLittleJerksonString4);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringExpirationDateParserTest1()   {
        String expected = "1/25/2016";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringExpirationDateParser(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringExpirationDateParserTest2()   {
        String expected = "1/25/2016";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringExpirationDateParser(sampleLittleJerksonString2);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringExpirationDateParserTest3()   {
        String expected = "1/11/2016";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringExpirationDateParser(sampleLittleJerksonString3);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringExpirationDateParserTest4()   {
        String expected = "1/17/2016";
        String actual = littleJerksonStringToGLIConverter.littleJerksonStringExpirationDateParser(sampleLittleJerksonString4);
        assertEquals(expected,actual);
    }
}