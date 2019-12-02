import java.time.LocalDate;

public class ParsedItems {
    private String name;
    private Double price;
    private String foodType;
    private LocalDate expiration;


    public ParsedItems(String name, Double price, String foodType, LocalDate expiration) {
        this.name = name;
        this.price = price;
        this.foodType = foodType;
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

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }
}
