/**
 * Created by andrewwong on 5/31/17.
 */
public class Item {
    private String name;
    private long price;
    private String type;
    private String expiration;

    public Item(String name, long price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }
}
