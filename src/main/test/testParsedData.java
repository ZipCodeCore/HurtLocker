import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testParsedData {
   private Parser parser;
   private Main main;

   @Before
   public void setup(){
       this.parser = new Parser();
       this.main = new Main();

   }

    @Test
    public void testMilkQty(){
        //given
        Integer expected = 8;
        //when
        Integer actual = main.countItem(parser.dataParser(), "Milk");

        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testMilkPricesCount(){

       //given
        Integer expectedPrice1 = 5;
        Integer expectedPrice2 = 1;
        //when
        Integer actualPrice1 = main.countItemAtPrice(parser.dataParser(), "Milk,price:3[.]23");
        Integer actualPrice2 = main.countItemAtPrice(parser.dataParser(), "Milk,price:1[.]23");
        //then
        Assert.assertEquals(expectedPrice1, actualPrice1);
        Assert.assertEquals(expectedPrice2, actualPrice2);
    }
    @Test
    public void testCookiesQty(){
        //given
        Integer expected = 8;
        //when
        Integer actual = main.countItem(parser.dataParser(), "Cookies");

        //then
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testCookiesPricesCount(){

        //given
        Integer expectedPrice1 = 8;
        //when
        Integer actualPrice1 = main.countItemAtPrice(parser.dataParser(), "Cookies,price:2[.]25");
        //then
        Assert.assertEquals(expectedPrice1, actualPrice1);

    }
    @Test
    public void testApplesQty(){
        //given
        Integer expected = 4;
        //when
        Integer actual = main.countItem(parser.dataParser(), "Apples");

        //then
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testApplesPricesCount(){

        //given
        Integer expectedPrice1 = 2;
        Integer expectedPrice2 = 2;
        //when
        Integer actualPrice1 = main.countItemAtPrice(parser.dataParser(), "Apples,price:0[.]25");
        Integer actualPrice2 = main.countItemAtPrice(parser.dataParser(), "Apples,price:0[.]23");
        //then
        Assert.assertEquals(expectedPrice1, actualPrice1);
        Assert.assertEquals(expectedPrice2, actualPrice2);
    }
    @Test
    public void testBreadQty(){
        //given
        Integer expected = 6;
        //when
        Integer actual = main.countItem(parser.dataParser(), "Bread");

        //then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testBreadPricesCount(){

        //given
        Integer expectedPrice1 = 6;
        //when
        Integer actualPrice1 = main.countItemAtPrice(parser.dataParser(), "Bread,price:1[.]23");

        //then
        Assert.assertEquals(expectedPrice1, actualPrice1);

    }

    @Test
    public void testErrorCount(){
       //given
        Integer expected = 4;
        //when
        Integer actual = main.errorCounter();
        //then
       Assert.assertEquals(expected, actual);
    }


}
