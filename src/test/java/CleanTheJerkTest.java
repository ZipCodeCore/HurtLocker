import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CleanTheJerkTest {
    //FindPatterns finder;
    CleanTheJerk cleaner;


    @Before
    public void setUp() throws Exception {
        //finder = new FindPatterns();
        cleaner = new CleanTheJerk();
    }

    @Test
    public void testMilkCleaner (){
        cleaner.replaceMilk();
    }

    @Test
    public void testBreadCleaner() {
        cleaner.replaceBread();
    }

    @Test
    public void replaceCookies() {
        cleaner.replaceCookies();
    }

    @Test
    public void replaceApples() {
        cleaner.replaceApples();
    }


//    @Test
//    public void countMilk () {
//        Integer expected = 6;
//        //Integer actual = cleaner.replaceMilk();
//        Assert.assertEquals(expected, actual);
//    }
}
