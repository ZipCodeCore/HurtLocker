import java.util.Comparator;

/**
 * Created by randallcrame on 2/8/17.
 */
public class GroceryItem implements  Comparator<GroceryItem>{
    private String name;
    private String price;
    private String type;
    private String expiration;

    GroceryItem(String name, String price, String type, String expiration){
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() { return name; }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public static Comparator<GroceryItem> priceComparator = (g1, g2) -> g1.getPrice().compareTo(g2.getPrice());


    @Override
    public int compare(GroceryItem g1, GroceryItem g2) {
        return 0;
    }
}
