import org.junit.Assert;
import org.junit.Test;

public class MaintTest {

    Main main = new Main();

    @Test
    public void findAlPhaTest()  {
        //GIVEN

        //WHEN

        //THEN
        String look = main.findAlphabetCharacters();

        System.out.println(look);
    }

    @Test
    public void formList() {
        String look = main.getList();
        System.out.println(look);
    }


    @Test
    public void correctSeparatorTest(){
        String look = main.correctSeparator();

        System.out.println(look);
    }

    @Test
    public void testReadRawDataToString() throws Exception {
        String data = main.readRawDataToString();
        System.out.println(data);
    }

    @Test
    public void testChangeMilk() throws Exception {
        String data = main.changeMilk(main.readRawDataToString());
        System.out.println(data);
    }

    @Test
    public void testChangeBread() throws Exception {
        String data = main.changeBread(main.readRawDataToString());
        System.out.println(data);
    }

    @Test
    public void testChangeCookies() throws Exception {
        String data = main.changeCookies(main.readRawDataToString());
        System.out.println(data);
    }

    @Test
    public void testChangeApples() throws Exception {
        String data = main.changeApples(main.readRawDataToString());
        System.out.println(data);
    }

    @Test
    public void testPoundToNewLine() throws Exception {
        String data = main.poundToNewLine(main.readRawDataToString());
        System.out.println(data);
    }

    @Test
    public void testCorrectSeparator() throws Exception {
        String data = main.correctSeparator();
        System.out.println(data);
    }

    @Test
    public void testNameChange() throws Exception {
        String data = main.nameChange(main.readRawDataToString());
        System.out.println(data);
    }

    @Test
    public void testPriceChange() throws Exception {
        String data = main.priceChange(main.readRawDataToString());
        System.out.println(data);
    }

    @Test
    public void testFindGroceries() {
        //given
        int breadExpected = 6;
        int appleExpected = 4;
        int cookieExpected = 8;
        int milkExpected = 8;
        //when
        int breadCount = main.findGroceries("bread");
        int appleCount = main.findGroceries("apple");
        int cookieCount = main.findGroceries("cookie");
        int milkCount = main.findGroceries("milk");
        //then
        Assert.assertEquals(breadExpected, breadCount);
        Assert.assertEquals(appleExpected, appleCount);
        Assert.assertEquals(cookieExpected, cookieCount);
        Assert.assertEquals(milkExpected, milkCount);
        System.out.printf("Bread: %s, Apple: %s, Cookie: %s, Milk: %s", breadCount, appleCount, cookieCount, milkCount);
    }

    @Test
    public void testCountingErrors() {
        //given
        int expected = 4;
        //when
        int actual = main.countingErrors();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadyForFormatting() {
        System.out.println(main.readyForFormatting());
    }

    @Test
    public void testDoingTheFormatting() {
        System.out.println(main.doingTheFormatting());
    }


}
//
//    @Test
//    public void findMilkTest(){
//        int actual = test.countMilk();
//        int expected = 8;
//
//        Assert.assertEquals(expected, actual);
//
//    }

//    @Test
//    public void correctAndSeparateTest(){
//        String look = test.separateBySemiColon();
//
//        System.out.println(look);
//    }