package reynoldstitko.gillian;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by gillianreynolds-titko on 2/10/17.
 */
public class ItemPriceAndQuantity {

    Map<String, Integer> pricesAndQuantities;
    String name;
    Integer totalQuantity;

    public ItemPriceAndQuantity(String name, Map<String, Integer> pricesAndQuantities, Integer totalQuantity) {
        this.name = name;
        this.pricesAndQuantities = pricesAndQuantities;
        this.totalQuantity = totalQuantity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Map<String, Integer> getPriceAndQuantities() {
        return pricesAndQuantities;
    }
}
