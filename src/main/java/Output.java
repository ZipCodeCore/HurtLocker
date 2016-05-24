import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by zihaocastine on 5/24/16.
 */
public class Output {

    public void printTable(ArrayList<Item> data){
        HashMap<String,HashMap<Double,Integer>> nameAndPriceMap=findNameAndPrice(data);
        for(String key: nameAndPriceMap.keySet()){
            String s =String.format("%-6s %6s %12s %1d %5s", "name:",key,"seen:", findNumberFood(nameAndPriceMap.get(key).values().toString()), "times");
            System.out.println(s);
            System.out.printf( "%-18s %15s %n","=============", "=============");

            for(Double price: nameAndPriceMap.get(key).keySet()){

                s =String.format("%-9s%-12s%5s%-2d%5s", "Price" + ":",price,"seen" +": ", nameAndPriceMap.get(key).get(price), "times");
                System.out.println(s);
                System.out.printf( "%-18s %15s %n","-------------", "-------------");
            }
            System.out.println();

        }
        System.out.printf("%-6s %19s %1d %5s", "Errors","seen:", ItemParser.getCountException(), "times" );
    }

    private HashMap<String,HashMap<Double,Integer>> findNameAndPrice(ArrayList<Item> items){
        HashMap<String,HashMap<Double,Integer>> nameAndPriceMap=new HashMap<>();

        for(Item item: items){
            nameAndPriceMap=placePriceAndNum(nameAndPriceMap,item);
        }

        return nameAndPriceMap;
    }

    private HashMap<String,HashMap<Double,Integer>> placePriceAndNum(HashMap<String,HashMap<Double,Integer>> nameAndPriceMap, Item item ){
        HashMap<Double,Integer> priceMap;
        if(!nameAndPriceMap.containsKey(item.getName())){
            priceMap=new HashMap<>();
            priceMap.put(item.getPrice(),1);
            nameAndPriceMap.put(item.getName(),priceMap);
        }else {
            priceMap=nameAndPriceMap.get(item.getName());
            if(priceMap.containsKey(item.getPrice())){
                priceMap.put(item.getPrice(),priceMap.get(item.getPrice())+1);
                nameAndPriceMap.put(item.getName(),priceMap);
            }else {
                priceMap.put(item.getPrice(),1);
                nameAndPriceMap.put(item.getName(),priceMap);
            }
        }

        return nameAndPriceMap;

    }


    private int findNumberFood(String s){
        int total=0;
        Pattern numPattern=Pattern.compile("\\d");
        Matcher m=numPattern.matcher(s);
        while(m.find()){
            total+=Integer.parseInt(m.group());
        }
        return total;
    }

}
