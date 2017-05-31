package kim.chris;

import java.util.ArrayList;

public class Item {

    private String name;
    private ArrayList<Double> prices;
    private String type;
    private String expiration;

    public Item(String name, double prices, String type, String expiration) {
        this.name = name;
        this.prices = new ArrayList<Double>();
        this.prices.add(prices);
        this.type = type;
        this.expiration = expiration;
    }

    public Item(){
        name = "";
        this.prices = new ArrayList<Double>();
        type = "";
        expiration = "";
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getPrices() {
        return prices;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public boolean addPrice(Double price){
        if(!this.prices.contains(price)){
            this.prices.add(price);
            return true;
        } else return false;
    }

    @Override
    public boolean equals(Object otherItem){
        if(otherItem == this){
            return true;
        }

        if(!(otherItem instanceof Item)){
            return false;
        }

        Item otherItem1 = (Item)otherItem;

        return this.name.equals(otherItem1.name) && this.prices == otherItem1.prices && this.type.equals(otherItem1.prices) && this.expiration.equals(otherItem1.expiration);
    }
}
