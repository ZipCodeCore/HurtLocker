package io.HandroHoxtah;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/24/16.
 */
public class Item {

    private String name;
    private ArrayList<Price> prices= new ArrayList<>();


    public int sumTotalItems(){
        int totalItems = 0;
        for(Price price : getPrices()){
            totalItems += price.getHowMany();
        }
        return totalItems;
    }

    public void addPrice(double price){
        getPrices().add(new Price(price));
    }

    public ArrayList<Price> getPrices() {
        return prices;
    }

    public Item(String name, double price){
        this.name = name;
        this.getPrices().add(new Price(price));
    }

    public String getName() {
        return name;
    }
}
