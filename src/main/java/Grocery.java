import java.text.SimpleDateFormat;

public class Grocery {
    private String name;
    private Double price;
    private SimpleDateFormat expirationDate;

    public Grocery() {
    }

    public Grocery(String name, Double price, SimpleDateFormat expirationDate) {
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
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

    public SimpleDateFormat getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(SimpleDateFormat expirationDate) {
        this.expirationDate = expirationDate;
    }
}
