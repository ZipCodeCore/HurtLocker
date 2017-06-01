import java.util.ArrayList;

/**
 * Created by andrewwong on 5/31/17.
 */
public class Item {
    private String name;
    private ArrayList<String> prices;
    private int timesSeen;

    public Item(String name, String price) {
        this.prices = new ArrayList<>();
        this.name = name;
        this.prices.add(price);
        this.timesSeen = 1;
    }

    public void addPriceToItem(String price) {
        prices.add(price);
    }

    public void isSeenAgain() {
        timesSeen++;
    }

    public String getName() {

        return name;
    }

    public ArrayList<String> getPrices() {
        return prices;
    }

    public int getTimesSeen() {
        return timesSeen;
    }
}
