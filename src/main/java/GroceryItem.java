import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sarahweisser on 5/31/17.
 */
public class GroceryItem {
    private String nameOfItem;
    private BigDecimal priceOfItem;
    private String typeOfItem;
    private String expirationDate;
    private int pricesCount = 0;
    private int itemCount = 0;
    private ArrayList<BigDecimal> prices = new ArrayList<BigDecimal>();

    public GroceryItem(String[] itemInfo) {
        this.nameOfItem = itemInfo[1];
        this.priceOfItem =  new BigDecimal(itemInfo[3]);
        this.typeOfItem = itemInfo[5];
        this.expirationDate = itemInfo[7];
        prices.add(this.priceOfItem);
    }

    public GroceryItem() {

    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public BigDecimal getPriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(BigDecimal priceOfItem) {
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

    public ArrayList<BigDecimal> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<BigDecimal> prices) {
        this.prices = prices;
    }




}
