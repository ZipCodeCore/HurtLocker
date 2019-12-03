import java.time.LocalDate;
import java.util.Date;

public class ParsedItems {
    private String name;
    private Double price;
    private String foodType;


    public ParsedItems(String name, Double price) {
        this.name = name;
        this.price = price;
        this.foodType = null;
    }

    public ParsedItems(String name, String price, String foodType) {
        this.name = name;
        this.price = Double.parseDouble(price);
        this.foodType = foodType;
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

    @Override
    public String toString() {
        return "ParsedItems{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
