package ibikunle.tolani;

/**
 * Created by tolaniibikunle on 2/15/17.
 */
public class Printer {
    GroceryFactory groceryFactory = new GroceryFactory();
    JerkSonParser jerkSonParser = new JerkSonParser();





    public String printOutput(){
        return
                "name:    Milk \t\t seen: "+ GroceryFactory.milkNameCount +" times\n" +
                "============= \t \t =============\n" +
                "Price: \t 3.23\t\t seen: "+ GroceryFactory.milkPriceCount1+" times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: "+GroceryFactory.milkPriceCount2+" time\n" +
                "\n" +
                "name:   Bread\t\t seen: "+GroceryFactory.breadNameCount+" times\n" +
                "=============\t\t =============\n" +
                "Price:   1.23\t\t seen: "+GroceryFactory.breadPriceCount+" times\n" +
                "-------------\t\t -------------\n" +
                "\n" +
                "name: Cookies     \t seen: "+GroceryFactory.cookiesNameCount+" times\n" +
                "=============     \t =============\n" +
                "Price:   2.25        seen: "+GroceryFactory.cookiePriceCount+" times\n" +
                "-------------        -------------\n" +
                "\n" +
                "name:  Apples     \t seen: "+GroceryFactory.applesNameCount+" times\n" +
                "=============     \t =============\n" +
                "Price:   0.25     \t seen: "+GroceryFactory.applePriceCount1+" times\n" +
                "-------------     \t -------------\n" +
                "Price:   0.23  \t \t seen: "+GroceryFactory.applePriceCount2+" times\n" +
                "\n" +
                "Errors         \t \t seen: "+jerkSonParser.errorCount+" times";
    }
}
