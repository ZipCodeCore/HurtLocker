package mattern.william;

/**
 * Created by williammattern on 2/8/17.
 */
public class GroceryListItemBuilder {
    String name;
    String price;
    String type;
    String expirationDate;

    public GroceryListItemBuilder setName(String name){
        this.name = name;
        return this;
    }

    public GroceryListItemBuilder setPrice(String price){
        this.price = price;
        return this;
    }

    public GroceryListItemBuilder setType(String type){
        this.type = type;
        return this;
    }

    public GroceryListItemBuilder setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
        return this;
    }

    public GroceryListItem createGroceryListItem(){
        return new GroceryListItem(name,price,type,expirationDate);
    }
}
