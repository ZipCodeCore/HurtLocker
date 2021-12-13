import java.text.SimpleDateFormat;

public class GroceryList {
    private String name;
    private String type;
    private Double price;
    private SimpleDateFormat expiration;

     public GroceryList(){

     }

    public GroceryList(String name, String type, Double price, SimpleDateFormat expiration) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.expiration = expiration;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public SimpleDateFormat getExpiration() {
        return expiration;
    }

    public void setExpiration(SimpleDateFormat expiration) {
        this.expiration = expiration;
    }
}
