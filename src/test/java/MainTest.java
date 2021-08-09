import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    Main test = new Main();

    @Test
    public void findAlphaTest()  {

        String look = test.findAlphabetCharacters();

        System.out.println(look);
    }

    @Test
    public void formatListTest()  {

        String look = test.getList();
        System.out.println(look);
    }

    @Test
    public void findMilkTest(){
        int actual = test.countMilk();
        int expected = 8;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void correctSeparatorTest(){
        String look = test.correctSeparator();
        System.out.println(look);
    }

    @Test
    public void correctAndSeparateTest(){
        String look = test.separateBySemiColon();
        System.out.println(look);
    }
}
