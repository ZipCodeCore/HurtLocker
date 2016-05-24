/**
 * Created by zihaocastine on 5/24/16.
 */
public class Item {
    private String name;
    private double price;
    private String type;
    private String expiration;
    Item(){
        name=null;
        price=0;
        type=null;
        expiration=null;
    }
    Item(String name, double price, String type, String expiration){
        this.name=name;
        this.price=price;
        this.type=type;
        this.expiration=expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }



}
