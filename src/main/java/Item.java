/**
 * Created by andresholland on 2/8/17.
 */
public class Item {

    Item (String name, String price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private String price;

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
