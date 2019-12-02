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
    String[] list;

    @Before
    public void setUp() {
        Integer errorCount = 0;
        try {
            String initial = (new Main()).readRawDataToString();
            initial = JerkSONUtils.parseGobble(initial);
            list = JerkSONUtils.stringToList(initial);
            Integer before = list.length;
            for (int i = 0; i < list.length; i++) {
                String json = JerkSONUtils.prepJ2(list[i]);
                list[i] = json;
//                System.out.println(json);
            }
            list = JerkSONUtils.filterOutErrorEntries(list);
            errorCount = before - list.length;
        } catch( Exception e) {
            e.printStackTrace();
        }
        System.out.println(errorCount);
    }

    @Test
    public void testBreakIntoEntries() {
        String initial = (new Main()).readRawDataToString();
        for (String s : JerkSONUtils.breakIntoEntries(initial)) {
            System.out.println(s);
        }
    }

    @Test
    public void testBreakEntry() {
        String initial = (new Main()).readRawDataToString();
        String[] entries =  JerkSONUtils.breakIntoEntries(initial);
        for (String entry : entries) {
            String[] list = JerkSONUtils.breakEntry(entry);
            System.out.println("\nENTRY");
            for (int i = 0; i < list.length; i++) {
                JerkSONUtils.getKeyValuePair(list[i]);
//                System.out.println("\t"+list[i]);
            }
        }
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
