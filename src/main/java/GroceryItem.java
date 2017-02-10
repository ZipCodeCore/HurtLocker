import java.util.regex.Matcher;

/**
 * Created by prestonbattin on 2/9/17.
 */
public class GroceryItem {

    String name;
    String price;
    String type;
    String expiration;
    public static int milkCounter, appleCounter, breadCounter, cookieCounter;
    Matcher matcher;
    int nameCount;
    static int milkPriceOneCount;
    static int milkPriceTwoCount;
    static int applePriceOneCount;
    static int applePriceTwoCount;
    static int cookiePriceOneCount;
    static int breadPriceOneCount;
    static int errorCount;


    GroceryItem(String name, String price, String type, String expiration){
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
        nameCounter();
        priceCounter();
        setErrorCount();
    }

    @Override
    public boolean equals(Object g){

        GroceryItem i = (GroceryItem)g;

       return (name.equals(i.name) && price.equals(i.price)
               && type.equals(i.type) && expiration.equals(i.expiration));
    }

    @Override
    public String toString(){


        return name + " " + price + " " + type + " " + expiration;
    }

    private void nameCounter(){

        matcher = Regex.apples.matcher(name);
        if (matcher.find()) {
            appleCounter++;
            nameCount = appleCounter;

        }
        matcher = Regex.bread.matcher(name);
        if (matcher.find()) {
            breadCounter++;
            nameCount = breadCounter;
        }
        matcher = Regex.cookies.matcher(name);
        if(matcher.find()) {
            cookieCounter++;
            nameCount = cookieCounter;
        }
        matcher = Regex.milk.matcher(name);
        if(matcher.find()) {
            milkCounter++;
            nameCount = milkCounter;
        }
    }

    public void priceCounter(){

        if(name.equalsIgnoreCase("Milk")){

            Matcher m = Regex.price323.matcher(price);
            if(m.find())
                milkPriceOneCount++;
            else
                milkPriceTwoCount++;
        }

        if(name.equalsIgnoreCase("Apples")){

            Matcher m = Regex.price25.matcher(price);
            if(m.find())
                applePriceOneCount++;
            else
                applePriceTwoCount++;
        }

        if(name.equalsIgnoreCase("Bread")){

            Matcher m = Regex.price123.matcher(price);
            if(m.find())
                breadPriceOneCount++;
        }

        if(name.equalsIgnoreCase("cookies")){

            Matcher m = Regex.price225.matcher(price);
            if(m.find())
                cookiePriceOneCount++;
        }

    }

    public void setErrorCount(){

        if(name.equalsIgnoreCase("bad"))
            errorCount++;
        if(price.equalsIgnoreCase("Bad"))
            errorCount++;
        if(type.equalsIgnoreCase("bad"))
            errorCount++;
        if(expiration.equalsIgnoreCase("bad"))
            errorCount++;
    }

}
