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
        try {
            String initial = (new Main()).readRawDataToString();
            list = JerkSONUtils.breakIntoEntries(initial);

            for (int i = 0; i < list.length; i++)
                list[i] = JerkSONUtils.prepJ2(list[i]);
            list = JerkSONUtils.filterOutErrorEntries(list);
        } catch( Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBreakIntoEntries() {
        String initial = (new Main()).readRawDataToString();
        String[] entries = JerkSONUtils.breakIntoEntries(initial);
        Integer actualLen = entries.length;
        Integer expectedLen = 28;
        String actual = entries[0];
        String expected = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        Assert.assertEquals(expectedLen, actualLen);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBreakEntry() {
        String initial = (new Main()).readRawDataToString();
        String[] entries =  JerkSONUtils.breakIntoEntries(initial);
        String[] entry = JerkSONUtils.breakEntry(entries[2]);
        String actual = entry[0];
        String expected = "NAMe:BrEAD";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapping() {
        StringBuilder actual = new StringBuilder();
        Map<String, Integer> names = JerkSONUtils.getNameCounts(list);
        for (String key : names.keySet()) {
            actual.append("\nName\t" + key + "\tcount\t" + names.get(key) + "\n");
            Map<String, Integer> prices = JerkSONUtils.getPricesByName(list, key);
            for (String price : prices.keySet()) {
                actual.append("price\t" + price + "\tcount\t" + prices.get(price) + "\n");
            }
        }

        String expected = "\n" +
                "Name\tbread\tcount\t6\n" +
                "price\t1.23\tcount\t6\n" +
                "\n" +
                "Name\tmilk\tcount\t6\n" +
                "price\t1.23\tcount\t1\n" +
                "price\t3.23\tcount\t5\n" +
                "\n" +
                "Name\tapples\tcount\t4\n" +
                "price\t0.25\tcount\t2\n" +
                "price\t0.23\tcount\t2\n" +
                "\n" +
                "Name\tcookies\tcount\t8\n" +
                "price\t2.25\tcount\t8\n";
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void testGetNameCounts() {
        StringBuilder actual = new StringBuilder();
        Map<String, Integer> names = JerkSONUtils.getNameCounts(list);
        for (String name : names.keySet())
            actual.append(name + "\t" + names.get(name) + "\n");
        String expected =
                "bread\t6\n" +
                "milk\t6\n" +
                "apples\t4\n" +
                "cookies\t8\n";
        Assert.assertEquals(expected, actual.toString());

    }

    @Test
    public void testGetPricesByName() {
        StringBuilder actual = new StringBuilder();
        Map<String, Integer> prices = JerkSONUtils.getPricesByName(list, "Milk");
        actual.append("Milk" + "\n");
        for (String price : prices.keySet()) {
            actual.append(price + "\t" + prices.get(price) + "\n");
        }
        String expected =
                "Milk\n" +
                "1.23\t1\n" +
                "3.23\t5\n";
        Assert.assertEquals(expected, actual.toString());
    }
}
