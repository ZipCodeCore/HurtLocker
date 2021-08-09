import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    Main test = new Main();

    /**
     * //System.out.println(newMain.countMilk323());
     *         //System.out.println(newMain.correctSeparator());
     *         //System.out.println(newMain.findSeparatorCorrected());
     *         System.out.println(newMain.reformatAfterCorrectSeparator());
     */
    @Test
    public void testPoundToNewLine(){
        System.out.println(test.getList(test.readRawDataToString()));
    }
    @Test
    public void testCorrectSeparator(){
        System.out.println(test.correctSeparator());

    }
    @Test
    public void testFindSeparatorCorrected(){
        System.out.println(test.findSeparatorCorrected());
    }

    @Test
    public void testReformatAfterCorrectSeparator(){
        System.out.println(test.reformatAfterCorrectSeparator());
    }

    @Test
    public void testCountMilk323(){
        //given
        Integer expected = 8;
        //when
        Integer actual = test.countMilk323();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testReadyForFormatting(){
        System.out.println(test.readyForFormatting());
    }

    @Test
    public void testFinal(){
        System.out.println(test.doingTheFormatting());
    }




}
