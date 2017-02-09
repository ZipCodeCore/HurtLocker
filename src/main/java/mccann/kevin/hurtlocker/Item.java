package mccann.kevin.hurtlocker;

/**
 * Created by kevinmccann on 2/8/17.
 */
public class Item {
    private String name;
    private String price;
//    private String type;
//    private String expiration;

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
//        this.type = type;
//        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }

}
