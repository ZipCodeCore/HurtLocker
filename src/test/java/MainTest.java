import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {
    Main test = new Main();

    @Test
    public void findAlphaTest() {
        String look = test.findAlphabetCharacters();

        System.out.println(look);
    }

    @Test
    public void formatTest() {
        String input = new String();
        String look = test.getList(input);

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
        String look = test.separateBySemicolon();
        System.out.println(look);
    }
    @Test
    public void printTest(){
        System.out.println(test.doingFormatting());
    }
    @Test
    public void nameChangeTest(){

    }
}
