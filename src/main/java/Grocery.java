import java.text.SimpleDateFormat;

public class Grocery {
    String name;
    Double price;
    SimpleDateFormat date;

    public Grocery(){
    }

    public Grocery(String name, Double price, SimpleDateFormat date) {
        this.name = name;
        this.price = price;
        this.date = date;
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

    public SimpleDateFormat getDate() {
        return date;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
    }
}
