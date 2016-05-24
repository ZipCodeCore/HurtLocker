package io.HandroHoxtah;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/24/16.
 */
public class Display {


    public void output(ArrayList<Item> items, int errors){
        StringBuilder output = new StringBuilder();
        for(Item item : items){
            output.append("name:    "+item.getName()+" \t\t seen:"+ item.sumTotalItems() +" times\n");
            System.out.println("============= \t \t =============");
            for(Price price : item.getPrices()) {
                output.append("Price: \t " + price.getPrice() + "\t\t seen: " + price.getHowMany() + " times");
                System.out.println("-------------\t\t -------------");
            }
            System.out.println("\n");
        }
        System.out.println("Errors         \t \t seen: "+errors+" times\n");
    }
}
