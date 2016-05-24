package io.HandroHoxtah;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by alejandrolondono on 5/24/16.
 */
public class ItemSpec {
    String name;
    double price;

    String type;
    String expiration;
    Item item;

    @Before
    public void setup(){
        name = "Randy";
        price = 24.99;

        type = "FOOD";
        expiration = "1/12/1991";
        item = new Item(name, price);

    }

    @Test
    public void addPriceTest(){
        int expectedSize = 2;
        item.addPrice(50.99);
        int actualsize = item.getPrices().size();
        assertEquals(expectedSize, actualsize);
    }

    @Test
    public void sumTotalItemsTest(){
        int expectedItemsCount = 3;
        item.addPrice(price);
        item.addPrice(50.99);
        int actualItemsCount = item.sumTotalItems();
        assertEquals(expectedItemsCount, actualItemsCount);
    }
}
