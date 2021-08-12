import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    Main test = new Main();

    @Test
    public void findAlphabetsTest() {
        // When
        String seeker = test.findAlphabetCharacters();
        System.out.println(seeker);
    }

//    @Test
//    public void getListTest() {
//        // When
//        String seeker = test.getList();
//        System.out.println(seeker);
//    }
//
//    @Test
//    public void countMMilkTest() {
//        // When
//        int actualCount = test.countMilk();
//        int expectedCount = 8;
//        Assert.assertEquals(expectedCount, actualCount);
//    }
//
//    @Test
//    public void correctSeparatorTest(){
//        // When
//        String seeker = test.correctSeparator();
//        System.out.println(seeker);
//    }
//
//
//    @Test
//    public void semiColonSeparatorTest() { // HELPER to find semiColon and puts each on a new line
//        // When
//        String seeker = test.semiColonSeparator();
//        System.out.println(seeker);
//    }



}
