package mattern.william;

import java.util.Date;

/**
 * Created by williammattern on 2/8/17.
 */
public class GroceryListItem {
    String name;
    String price;
    String type;
    String expirationDate;

    public GroceryListItem(String name, String price, String type, String expirationDate) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    public GroceryListItem(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
