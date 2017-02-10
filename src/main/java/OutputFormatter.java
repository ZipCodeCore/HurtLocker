/**
 * Created by prestonbattin on 2/9/17.
 */
public class OutputFormatter {

    String formatted;

    public String format(GroceryItem[] items){



         formatted = "name:    Milk \t\t seen: " + GroceryItem.milkCounter + " times\n" +
                 "============= \t \t =============\n" +
                 "Price: \t 3.23\t\t seen: " + GroceryItem.milkPriceOneCount + " times\n" +
                 "-------------\t\t -------------\n" +
                 "Price:   1.23\t\t seen: " + GroceryItem.milkPriceTwoCount + " time\n" +
                 "\n" +
                 "name:   Bread\t\t seen: " + GroceryItem.breadCounter + " times\n" +
                 "=============\t\t =============\n" +
                 "Price:   1.23\t\t seen: " + GroceryItem.breadPriceOneCount + " times\n" +
                 "-------------\t\t -------------\n" +
                 "\n" +
                 "name: Cookies     \t seen: " + GroceryItem.cookieCounter + " times\n" +
                 "=============     \t =============\n" +
                 "Price:   2.25        seen: " + GroceryItem.cookiePriceOneCount + " times\n" +
                 "-------------        -------------\n" +
                 "\n" +
                 "name:  Apples     \t seen: " + GroceryItem.appleCounter + " times\n" +
                 "=============     \t =============\n" +
                 "Price:   0.25     \t seen: " + GroceryItem.applePriceOneCount + " times\n" +
                 "-------------     \t -------------\n" +
                 "Price:   0.23  \t \t seen: " + GroceryItem.applePriceTwoCount + " times\n" +
                 "\n" +
                 "Errors         \t \t seen: " + GroceryItem.errorCount + " times\n";



         return formatted;

    }
}
