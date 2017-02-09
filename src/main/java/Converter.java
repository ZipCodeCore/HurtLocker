import org.apache.commons.io.IOUtils;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by andresholland on 2/8/17.
 */
public class Converter {

    private ArrayList<Item> allItems  = new ArrayList<>();

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
    }

    public ArrayList<Item> execute (String rawData) {
        JerksonPattern jerksonPattern = new JerksonPattern();
        String[] rawDataArray = jerksonPattern.splitRawData(rawData);

        for (int i = 0; i < rawDataArray.length; i++) {
            String reformat1 = jerksonPattern.convertName(rawDataArray[i]);
            jerksonPattern.convertPrice(reformat1);
            jerksonPattern.convertType(rawDataArray[i]);
            jerksonPattern.convertExpiration(rawDataArray[i]);
            String name = jerksonPattern.getCurrentName();
            String price = jerksonPattern.getCurrentPrice();

            Item item = new Item(name, price);
            allItems.add(item);
        }
        return allItems;
    }

    public void printResult (ArrayList<Item> list) {
        int milk = 0, bread = 0, cookies = 0, apples = 0, errors = 0;
        ArrayList<String> milkPrice = new ArrayList<>();
        ArrayList<String> breadPrice = new ArrayList<>();
        ArrayList<String> cookiesPrice = new ArrayList<>();
        ArrayList<String> applesPrice = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals("INVALID") || list.get(i).getPrice().equals("INVALID")) {
                errors++;
            }
            else if(list.get(i).getName().equals("Milk")) {
                milk++;
                milkPrice.add(list.get(i).getPrice());
            }
            else if(list.get(i).getName().equals("Bread")) {
                bread++;
                breadPrice.add(list.get(i).getPrice());
            }
            else if(list.get(i).getName().equals("Cookies")) {
                cookies++;
                cookiesPrice.add(list.get(i).getPrice());
            }
            else if(list.get(i).getName().equals("Apples")) {
                apples++;
                applesPrice.add(list.get(i).getPrice());
            }
        }

        System.out.println("Name: Milk " + "-- Seen: " + milk );
        System.out.println("Price: 3.23 " + "-- Seen: " + Collections.frequency(milkPrice, "3.23"));
        System.out.println("Price: 1.23 " + "-- Seen: " + Collections.frequency(milkPrice, "1.23"));
        System.out.println();

        System.out.println("Name: Bread " + "-- Seen: " + bread );
        System.out.println("Price: 1.23 " + "-- Seen: " + Collections.frequency(breadPrice, "1.23"));
        System.out.println();

        System.out.println("Name: Cookies " + "-- Seen: " + cookies );
        System.out.println("Price: 2.25 " + "-- Seen: " + Collections.frequency(cookiesPrice, "2.25"));
        System.out.println();

        System.out.println("Name: Apples " + "-- Seen: " + apples );
        System.out.println("Price: 0.25 " + "-- Seen: " + Collections.frequency(applesPrice, "0.25"));
        System.out.println("Price: 0.23 " + "-- Seen: " + Collections.frequency(applesPrice, "0.23"));
        System.out.println();

        System.out.println("Errors " + "-- Seen: " + errors);
    }
}
