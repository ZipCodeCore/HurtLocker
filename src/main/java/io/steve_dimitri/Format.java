package io.steve_dimitri;

/**
 * Created by stevejaminson on 5/24/16.
 */
public class Format {

    Counter counter = new Counter();
    ItemParser parser = new ItemParser();

    public void stringFormat(){

        String divider1 = "================           =============";
        String divider2 = "----------------           -------------";
        System.out.printf("%s %10s %15s %d %s %n", "name:", "Milk", "seen:", Counter.totalMilks, "times");
        System.out.println(divider1);
        System.out.printf("%s %9.2f %15s %d %s %n", "Price:",Counter.milkPrices.keySet().toArray()[1], "seen:", Counter.milkPrices.get(Counter.milkPrices.keySet().toArray()[1]), "times");
        System.out.println(divider2);
        System.out.printf("%s %9.2f %15s %d %s %n", "Price:",Counter.milkPrices.keySet().toArray()[0], "seen:", Counter.milkPrices.get(Counter.milkPrices.keySet().toArray()[0]), "times");
        System.out.println("\n");
        System.out.printf("%s %10s %15s %d %s %n", "name:", "Bread", "seen:", Counter.totalBread, "times");
        System.out.println(divider1);
        System.out.printf("%s %9.2f %15s %d %s %n", "Price:",Counter.breadPrices.keySet().toArray()[0], "seen:", Counter.breadPrices.get(Counter.breadPrices.keySet().toArray()[0]), "times");
        System.out.println(divider2);
        System.out.println("\n");
        System.out.printf("%s %10s %15s %d %s %n", "name:", "Cookies", "seen:", Counter.totalCookies, "times");
        System.out.println(divider1);
        System.out.printf("%s %9.2f %15s %d %s %n", "Price:",Counter.cookiePrices.keySet().toArray()[0], "seen:", Counter.cookiePrices.get(Counter.cookiePrices.keySet().toArray()[0]), "times");
        System.out.println(divider2);
        System.out.println("\n");
        System.out.printf("%s %10s %15s %d %s %n", "name:", "Apples", "seen:", Counter.totalApples, "times");
        System.out.println(divider1);
        System.out.printf("%s %9.2f %15s %d %s %n", "Price:",Counter.applePrices.keySet().toArray()[1], "seen:", Counter.applePrices.get(Counter.applePrices.keySet().toArray()[1]), "times");
        System.out.println(divider2);
        System.out.printf("%s %9.2f %15s %d %s %n", "Price:",Counter.applePrices.keySet().toArray()[0], "seen:", Counter.applePrices.get(Counter.applePrices.keySet().toArray()[0]), "times");
        System.out.println("\n");
        System.out.printf("%s %10s %14s %d %s %n", "Errors", "", "seen:", parser.getErrorCount(), "times");
    }
}
