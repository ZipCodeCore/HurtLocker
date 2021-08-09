import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    Main test = new Main();

//    @Test
//    public void findAlpha(){
//        String find = test.findAlphabetCharacters();
//        System.out.println(find);
//    }

//    @Test
//    public void listTest()  {
//        String formation = test.listEm();
//        System.out.println(formation);
//    }
//    @Test
//    public void milkCount(){
//        int actual = 8;
//        int expected = test.countMilk();
//
//        Assert.assertEquals(expected,actual);
//    }
//    @Test
//    public void separator(){
//        String finder = test.findSeparatorCorrected();
//        System.out.println(finder);
//    }
    @Test
    public void correctSeparation(){
        String finder = test.correctSeparator();
        System.out.println(finder);
    }
    @Test
    public void formatTest(){
        System.out.println(test.formatting());
    }

}
