package kim.chris.data;

import java.util.ArrayList;

public class Item {

    private String name;
    private double price;
    private String type;
    private String expiration;

    public Item(String name, double price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public Item(){
        name = "";
        this.price = 0;
        type = "";
        expiration = "";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
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

        return this.name.equals(otherItem1.getName()) && this.price == otherItem1.getPrice() && this.type.equals(otherItem1.getType()) && this.expiration.equals(otherItem1.getExpiration());
    }
}
