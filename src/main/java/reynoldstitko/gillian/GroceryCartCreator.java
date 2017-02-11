package reynoldstitko.gillian;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by gillianreynolds-titko on 2/10/17.
 */
public class GroceryCartCreator {
    int milkCounter = 0;
    int cookieCounter = 0;
    int breadCounter = 0;
    int appleCounter = 0;
    int milkPriceCounter = 0;
    int milkPriceCounter2 = 0;
    int applePriceCounter = 0;
    int applePriceCounter2 = 0;
    int breadPriceCounter = 0;
    int cookiePriceCounter = 0;

    public void createGroceryCart(ArrayList<GroceryItem> groceryItems) {
        //GroceryCart groceryCart = new GroceryCart();

        for (int i = 0; i < groceryItems.size(); i++) {
            switch (groceryItems.get(i).getName()) {
                case "Milk":
                    milkCounter += 1;
                    if (groceryItems.get(i).getPrice().equals("3.23")) {
                        milkPriceCounter += 1;
                    } else milkPriceCounter2 += 1;
                    break;
                    case "Apples":
                        appleCounter += 1;
                        if (groceryItems.get(i).getPrice().equals("0.25")) {
                            applePriceCounter += 1;
                        } else applePriceCounter2 += 1;
                        break;
                case "Bread":
                    breadCounter +=1;
                    breadPriceCounter +=1;
                    break;
                case "Cookies":
                    cookieCounter +=1;
                    cookiePriceCounter +=1;
                    break;
                    default:
                        break;
            }
        }
    }

    public ArrayList<GroceryItem name, GroceryItem price> addNamesAndPricesToCart(ArrayList<GroceryItem> groceryItems, ArrayList<GroceryItem> groceryItemNames){
        ArrayList<GroceryItem name, GroceryItem price> finalCart = new ArrayList<>();
        for(int i = 0; i<groceryItems.size(); i++){
            finalCart.add(groceryItems.get(i).getName()
        }

        return null;
    }
}
