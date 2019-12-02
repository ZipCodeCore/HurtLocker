package jerkson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
    make map of Name, nameFreq, prices {price, priceFreq}


*/
public class TestJerkSONUtils {
    List<String> list;

    @Before
    public void setUp() {
        Integer errorCount = 0;
        try {
            String initial = (new Main()).readRawDataToString();
            initial = JerkSONUtils.parseGobble(initial);
            list = JerkSONUtils.stringToList(initial);
            Integer before = list.size();
            for (int i = 0; i < list.size(); i++) {
                String json = JerkSONUtils.prepJ2(list.get(i));
                list.set(i, json);
//                System.out.println(json);
            }
            list = JerkSONUtils.filterOutErrorEntries(list);
            errorCount = before - list.size();
        } catch( Exception e) {
            e.printStackTrace();
        }
        System.out.println(errorCount);
    }

    @Test
    public void testMapping() {
        Map<String, Integer> names = JerkSONUtils.getNameCounts(list);
        for (String key : names.keySet()) {
            System.out.println("\nName\t" + key + "\tcount\t" + names.get(key));
            Map<String, Integer> prices = JerkSONUtils.getPricesByName(list, key);
            for (String price : prices.keySet()) {
                System.out.println("price\t" + price + "\tcount\t" + prices.get(price));
            }
        }
    }
//
//    @Test
//    public void testGetOccurrancesOfName1() {
//        Long actual = JerkSONUtils.getOccurancesOfName(list, "Milk");
//        Long expected = 8L;
//        Assert.assertEquals(expected, actual);
//    }
//    @Test
//    public void testGetOccurrancesOfName2() {
//        Long actual = JerkSONUtils.getOccurancesOfName(list, "Cookies");
//        Long expected = 7L;
//        Assert.assertEquals(expected, actual);
//    }
//    @Test
//    public void testGetOccurrancesOfName3() {
//        Long actual = JerkSONUtils.getOccurancesOfName(list, "Apples");
//        Long expected = 4L;
//        Assert.assertEquals(expected, actual);
//    }
//    @Test
//    public void testGetOccurrancesOfName4() {
//        Long actual = JerkSONUtils.getOccurancesOfName(list, "Bread");
//        Long expected = 6L;
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGetOccurrancesOfPriceForName() {
//        Long actual = JerkSONUtils.getOccurancesOfPriceForName(list, "Milk", "3.23");
//        Long expected = 5L;
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGetNames() {
//        List<String> names = JerkSONUtils.getNames(list);
//        for (String name : names) {
//            System.out.println(name);
//        }
//    }

    @Test
    public void testGetNameCounts() {
        Map<String, Integer> names = JerkSONUtils.getNameCounts(list);
        for (String name : names.keySet()) {
            System.out.println(name + " " + names.get(name));
        }
    }

    @Test
    public void testGetPricesByName() {
//        List<String> names = JerkSONUtils.filterListByName(list, "Milk");
        Map<String, Integer> prices = JerkSONUtils.getPricesByName(list, "Milk");
        System.out.println("Milk");
        for (String price : prices.keySet()) {
            System.out.println(price + " " + prices.get(price));
        }
    }
}
