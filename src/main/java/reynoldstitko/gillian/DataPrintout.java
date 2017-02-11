package reynoldstitko.gillian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Created by gillianreynolds-titko on 2/9/17.
 */
public class DataPrintout {

    //5. print results
    public String printSummaryTable(Set<GroceryItem> setOfItems, ArrayList<GroceryItem> arrayOfItems, int errorCounter){
        StringBuilder stringBuilder = new StringBuilder();
        for (GroceryItem item: setOfItems) {
            stringBuilder.append("name:\t").append(item.getName()).append("\t\t").append("seen: ")
                    .append(Collections.frequency(arrayOfItems, item)).append(" times\n");
            stringBuilder.append("============\t\t").append("============\n");
            stringBuilder.append("Price: \t").append(item.getPrice()).append("\t\t").append("seen: ")
                    .append(Collections.frequency(arrayOfItems, item)).append(" times\n");
            stringBuilder.append("------------\t\t").append("------------\n\n");
        }
        stringBuilder.append("Errors\t\t\t\t").append("seen: ").append(errorCounter).append(" times");
        return stringBuilder.toString();
    }

    public String printGroceryCart(GroceryCart groceryCart) {
        ArrayList<ItemPriceAndQuantity> items = groceryCart.getItems();
        StringBuilder sb = new StringBuilder();
        for(ItemPriceAndQuantity item : items) {
            sb.append(printGroceryItem(item));
        }

        return null;
    }

    public String printGroceryItem(ItemPriceAndQuantity itemPriceAndQuantity) {
        String itemName = itemPriceAndQuantity.getName();
        Integer totalQuantity = itemPriceAndQuantity.getTotalQuantity();

        Map<String, Integer> pricesAndQuantities = itemPriceAndQuantity.getPriceAndQuantities();

        StringBuilder sb = new StringBuilder();
        sb.append(printNameAndTotalQuantity(itemName, totalQuantity));
        sb.append(printItemDivider());

        for(Map.Entry<String,Integer> entry : pricesAndQuantities.entrySet()) {
            String price = entry.getKey();
            Integer quantity = entry.getValue();
            sb.append(printPriceAndQuantity(price, quantity));
            sb.append(priceDivider());
        }
        return sb.toString();
    }

    public String groceryItemName(ArrayList<GroceryCartCreator> groceryItems, ){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< groceryItems.size(); i++){
            sb.append(printNameAndTotalQuantity(groceryItems.get(i).);
        }

        return null;
    }

    public String printPriceAndQuantity(String price, int quantity){
        if(quantity > 1){
            return(String.format("Price: %s\t\t seen: %d times", price, quantity));
        }
        return(String.format("Price: %s\t\t seen: %d time", price, quantity));
    }

    public String printNameAndTotalQuantity(String name, int quantity){
        return(String.format("name: %s\t\t seen: %d times", name, quantity));
    }

    public String printErrors(int error){

        return(String.format("Errors: \t\t\t\t seen: %d times", error));
    }

    public String printItemDivider(){

        return (String.format("=============\t\t============="));
    }

    public String priceDivider(){
        return (String.format("-------------\t\t-------------"));
    }

}

