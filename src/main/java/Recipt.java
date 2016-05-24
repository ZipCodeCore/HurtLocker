import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by markhauenstein on 5/24/16.
 */
public class Recipt{
    int errorCounter =0;
    StringBuilder Milk = new StringBuilder();
    int milkCounter = 0;
    HashSet milkPrices = new HashSet();
    int breadCounter = 0;
    StringBuilder bread = new StringBuilder();
    HashSet breadPrices = new HashSet();
    int cookieCounter = 0;
    StringBuilder cookies = new StringBuilder();
    HashSet cookiePrices = new HashSet();
    int appleCounter = 0;
    StringBuilder apple = new StringBuilder();
    HashSet applePrices = new HashSet();


    ShoppingList shoppingList = new ShoppingList();
    String rawJerkson = shoppingList.readRawDataToString();
    String[] madeList = shoppingList.listMaker(rawJerkson);
    ArrayList listOfItems = shoppingList.itemCreator(madeList);
    int listSize = listOfItems.size();
    void countTheItems() throws IncompleteItemException {
        for(int i=0;i<listSize;i++){
           try {
               Item itemWeAreLookingAt = (Item) listOfItems.get(i);
               if (itemWeAreLookingAt.name.equals("milk")) {
                   milkCounter++;
                   milkPrices.add(itemWeAreLookingAt.price);
               }
               if (itemWeAreLookingAt.name.equals("bread")) {
                   breadCounter++;
                   breadPrices.add(itemWeAreLookingAt.price);
               }
               if (itemWeAreLookingAt.name.equals("cookies")) {
                   cookieCounter++;
                   cookiePrices.add(itemWeAreLookingAt.price);
               }
               if (itemWeAreLookingAt.name.equals("apples")) {
                   appleCounter++;
                   applePrices.add(itemWeAreLookingAt.price);
               }
               if (itemWeAreLookingAt.name.equals("")||itemWeAreLookingAt.price.equals("")||itemWeAreLookingAt.type.equals("")||itemWeAreLookingAt.expiration.equals("")) {
                   throw new IncompleteItemException();
               }
           }catch (IncompleteItemException e){
               errorCounter++;
           }
        }
        Milk.append("Name: \t");
        Milk.append("Milk\t\t\t");
        Milk.append("seen: \t");
        Milk.append(milkCounter);
        Milk.append("\n");
        Milk.append("==========\t\t\t=========");


        bread.append("Name: \t");
        bread.append("Bread\t\t\t");
        bread.append("seen: \t");
        bread.append(breadCounter);
        bread.append("\n");
        bread.append("==========\t\t\t=========");


        cookies.append("Name: \t");
        cookies.append("Cookies\t\t\t");
        cookies.append("seen: \t");
        cookies.append(cookieCounter);
        cookies.append("\n");
        cookies.append("==========\t\t\t=========");


        apple.append("Name: \t");
        apple.append("Apple\t\t\t");
        apple.append("seen: \t");
        apple.append(appleCounter);
        apple.append("\n");
        apple.append("==========\t\t\t=========");

        System.out.println(Milk);
        System.out.println(apple);
        System.out.println(bread);
        System.out.println(cookies);
        System.out.println("Errors\t\t\t"+"seen:\t"+errorCounter);
    }


    public Recipt() throws Exception {
    }
}
