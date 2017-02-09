package reynoldstitko.gillian;

/**
 * Created by gillianreynolds-titko on 2/9/17.
 */
public class GroceryItem {

    private String name;
    private Double price;
    private String type;
    private String expiration;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    //Constructor
    public GroceryItem(String name, Double price) {
        this.name = name;
        this.price = price;
        this.type = "Food";
    }

    //4. Calculate numeric data
    public Double[] calculatePriceSummaryData(Double priceData){ //get sum of prices

        return null;
    }

    public int calculateGroceryItemCount(GroceryItem groceryItem){ //get count of a grocery item
        return -1;
    }

}
