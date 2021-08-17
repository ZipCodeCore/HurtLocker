import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    Main test = new Main();

    @Test
    public  void findAlphaTest() {

        String look = test.findAlphabetCharacters();

        System.out.println(look);
    }

    @Test
    public void formatTest() {
        String look = test.formatting();

        System.out.println(look);
    }

//    @Test
//    public void findMilkTest() {
//        int actual = test.countMilk();
//        int expected = 8;
//
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void correctSeparatorTest() {
        String look = test.correctSeparator();
        System.out.println(look);
    }

    @Test
    public void correctAndSeparateTest() {
        String look = test.correctBySemicolon();
        System.out.println(look);
    }


}
