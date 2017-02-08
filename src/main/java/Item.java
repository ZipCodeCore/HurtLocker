import java.util.ArrayList;
import java.util.Set;

/**
 * Created by kevinmccann on 2/8/17.
 */
public class Item {
    private String name;
    private String price;
//    private String type;
//    private String expiration;
    ArrayList<String> priceList;
    Set<String> uniquePriceList;

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
//        this.type = type;
//        this.expiration = expiration;
    }

    boolean priceListContainsPrice(String price) {
        return priceList.contains(price);
    }

    void addPriceToPriceList(String price) {
        priceList.add(price);
        uniquePriceList.add(price);
    }

    public Set<String> getUniquePriceList() {
        return uniquePriceList;
    }

    //
//    Item() {
//        this.name = "?";
//        this.price = "0.00";
//        this.type = "?";
//        this.expiration = "0/00/0000";
//    };

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

    @Override
    public String toString() {
        return name + " " + price;
    }

}
