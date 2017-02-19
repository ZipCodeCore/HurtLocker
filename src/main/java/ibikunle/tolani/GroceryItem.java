package ibikunle.tolani;

/**
 * Created by tolaniibikunle on 2/11/17.
 */
public class GroceryItem {
    private String name;
    private String price;
    private String type;
    private String expiration;

    public GroceryItem(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }


    public String getPrice() {
        return price;
    }
    public String toString(){
        return this.name + " " + this.price;
    }

    public String getType() {
        return type;
    }


    public String getExpiration() {
        return expiration;
    }

    }

