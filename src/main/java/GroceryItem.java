import java.util.Date;

/**
 * Created by sarahweisser on 5/31/17.
 */
public class GroceryItem {
    private String nameOfItem;
    private String priceOfItem;
    private String typeOfItem;
    private String expirationDate;
    private int pricesCount = 0;
    private int itemCount = 0;
    private long[] prices;

    public GroceryItem(String[] itemInfo) {
        this.nameOfItem = itemInfo[1];
        this.priceOfItem =  itemInfo[3];
        this.typeOfItem = itemInfo[5];
        this.expirationDate = itemInfo[7];
    }


    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public String getPriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(String priceOfItem) {
        this.priceOfItem = priceOfItem;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    public void setTypeOfItem(String typeOfItem) {
        this.typeOfItem = typeOfItem;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPricesCount() {
        return pricesCount;
    }

    public void setPricesCount(int pricesCount) {
        this.pricesCount = pricesCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public long[] getPrices() {
        return prices;
    }

    public void setPrices(long[] prices) {
        this.prices = prices;
    }




}
