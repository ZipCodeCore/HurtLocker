import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class MapResultsTest {
    CleanTheJerk cleaner;
    FindPatterns finder;
    MapResults printer;

    @Before
    public void setUp() throws Exception {
        cleaner = new CleanTheJerk();
        finder = new FindPatterns();
        printer = new MapResults();
    }

    @Test
    public void checkMilk () {
       Map<String, Long> myMap = printer.milkResultsMap();
        System.out.println(myMap.entrySet());
    }

    @Test
    public void checkApples () {
        Map<String, Long> myMap = printer.applesResultsMap();
        System.out.println(myMap.entrySet());
    }

    @Test
    public void checkBread () {
        Map<String, Long> myMap = printer.breadResultsMap();
        System.out.println(myMap.entrySet());
    }

    @Test
    public void checkCookies () {
        Map<String, Long> myMap = printer.cookiesResultsMap();
        System.out.println(myMap.entrySet());
    }

    @Test
    public void countMilk() {
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
