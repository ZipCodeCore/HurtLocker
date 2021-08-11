import java.text.SimpleDateFormat;

public class Products {
    String name;
    Double price;
    String type;
    SimpleDateFormat expiration;

public Products(){}
    public Products(String name, Double price, String type,SimpleDateFormat expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SimpleDateFormat getExpiration() {
        return expiration;
    }

    public void setExpiration(SimpleDateFormat expiration) {
        this.expiration = expiration;
    }
}
