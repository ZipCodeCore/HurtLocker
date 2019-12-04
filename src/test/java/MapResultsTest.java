import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class MapResultsTest {
    CleanTheJerk cleaner;
    FindPatterns finder;
    MapResults mapper;

    @Before
    public void setUp() throws Exception {
        cleaner = new CleanTheJerk();
        finder = new FindPatterns();
        mapper = new MapResults();
    }

    @Test
    public void checkMilk () {
       Map<String, Long> myMap = mapper.milkResultsMap();
        System.out.println(myMap.entrySet());
    }

    @Test
    public void checkApples () {
        Map<String, Long> myMap = mapper.applesResultsMap();
        System.out.println(myMap.entrySet());
    }

    @Test
    public void checkBread () {
        Map<String, Long> myMap = mapper.breadResultsMap();
        System.out.println(myMap.entrySet());
    }

    @Test
    public void checkCookies () {
        Map<String, Long> myMap = mapper.cookiesResultsMap();
        System.out.println(myMap.entrySet());
    }

    @Test
    public void countMilk() {
        Integer expected = 6;
        Integer actual = mapper.countMilk();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countBread() {
    }

    @Test
    public void countCookies() {
    }

    @Test
    public void countApples() {
    }
}
