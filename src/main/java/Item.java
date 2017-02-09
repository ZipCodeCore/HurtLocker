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

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
