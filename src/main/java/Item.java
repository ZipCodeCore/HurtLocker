import java.util.ArrayList;

/**
 * Created by andrewwong on 5/31/17.
 */
public class Item {
    private String name;
    private ArrayList<String> price;


    public Item(String name, long price, String type, String expiration) {
        this.name = name;
        this.price = price;
    }
}
