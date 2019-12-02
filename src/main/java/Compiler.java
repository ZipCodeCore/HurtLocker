import java.util.ArrayList;
import java.util.HashMap;

public class Compiler {
    ItemCounter itemCounter = new ItemCounter();
    PriceParser priceParser = new PriceParser();

    public String compiler(String[] listArray, String p, String item) throws Exception {
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> priceMap = priceParser.priceMapper(listArray,p);


        sb.append(itemCounter.itemCounter(listArray,p,item)).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));
        for(String s : priceMap.keySet()){
            if(!s.equals("")) {
                sb.append(String.format("%-15s %15s", "Price: $" + s, "Seen: ") + priceMap.get(s)).append("\n");
            }
        }
        sb.append(String.format("%-16s %16s", "=============", "========\n"));

        return sb.toString();
    }


}
