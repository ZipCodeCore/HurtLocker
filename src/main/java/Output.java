import java.util.*;

/**
 * Created by randallcrame on 2/8/17.
 */
public class Output {


    public String outputName(String K){

        String name = String.format("Name:%8s", K);
            return name;
    }

    public String outputSeen(int seen){
        return String.format("    seen: %d times", seen);
    }

    public String itemUnderLines(){
        return "=============    =============";
    }

    public String outputPrice(String K){

        String name = String.format("Price:%7s", K);
        return name;
    }

    public String priceUnderLines(){
        return "-------------    -------------";
    }

    public String outputErrors(){
        return String.format("%-13s", "Error");
    }

    public void outputFormattedItemList(ArrayList<GroceryItem> list){
        System.out.println(outputName(list.get(0).getClass().getSimpleName())+outputSeen(list.size()));
        System.out.println(itemUnderLines());
        list.sort(GroceryItem.priceComparator);
        int occurrence = 0;
        String currentPrice = list.get(0).getPrice();
        for (GroceryItem item: list) {
            if (item.getPrice().equals(currentPrice))
                occurrence++;
            else {
                System.out.println(outputPrice(currentPrice)+outputSeen(occurrence));
                System.out.println(priceUnderLines());
                currentPrice = item.getPrice();
                occurrence = 1;
            }
        }
        System.out.println(outputPrice(currentPrice)+outputSeen(occurrence));
        System.out.println();
    }

    public void outputFullList(TreeMap list){
        Set keys = list.keySet();
        for(Iterator i = keys.iterator();i.hasNext();){
            String key = i.next().toString();
            ArrayList<GroceryItem> values = (ArrayList<GroceryItem>) list.get(key);
            outputFormattedItemList(values);
        }


    }
}
