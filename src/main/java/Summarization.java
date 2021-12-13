
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Summarization {
    public static String summarize(List<Item> items){
        StringBuilder sb = new StringBuilder();
        Map<String,Map<String,Integer>> headcount = new HashMap<>();
        for(Item item: items){
            //make this non case-sensitive
            if(!headcount.containsKey(item.getName())){
                headcount.put(item.getName(),(new HashMap<String, Integer>()));
                if(item.getName() == null){
                    headcount.get(item.getName()).put("-1",1);
                }
                else{
                    headcount.get(item.getName()).put(item.getPrice(),1);
                }
            }
            else{
                if(!headcount.get(item.getName()).containsKey(item.getPrice())){
                    headcount.get(item.getName()).put(item.getPrice(),1);
                }
                else{
                    Integer temp = headcount.get(item.getName()).get(item.getPrice());
                    headcount.get(item.getName()).replace(item.getPrice(),temp + 1);
                }
            }
        }
        int errorCount = 0;
        for(String name: headcount.keySet()){
            //error if
            if(name == null){
                errorCount = headcount.get(null).get("-1");
            }
            else{
                int total = 0;
                for(String price: headcount.get(name).keySet()){
                    total+=headcount.get(name).get(price);
                }
                sb.append(String.format("name:%4s \t \t seen: %s times\n",name,total));
                sb.append("============= \t \t =============\n");
                for(String price: headcount.get(name).keySet()){
                    sb.append(String.format("Price:%4s \t \t seen: %s times\n",price,headcount.get(name).get(price)));
                    sb.append("-------------\t\t -------------\n");
                }
                sb.append("\n");
            }
        }
        sb.append(String.format("Errors \t \t seen: %s times",errorCount));
        return sb.toString();
    }
}
