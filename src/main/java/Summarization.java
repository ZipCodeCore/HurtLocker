
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Summarization {
    public static String Summarizer(List<Item> items){
        StringBuilder sb = new StringBuilder();
        Map<String,Map<String,Integer>> headcount = new HashMap<>();
        for(Item item: items){
            //make this non case-sensitive
            if(!headcount.containsKey(item.getName())){
                headcount.put(item.getName(),(new HashMap<String, Integer>()));
                headcount.get(item.getName()).put(item.getPrice(),1);
            }
            else{
                if(headcount.get(item.getName()).containsKey(item.getPrice())){
                    headcount.get(item.getName()).put(item.getPrice(),1);
                }
                else{
                    headcount.get(item.getName()).replace(item.getPrice(),
                            headcount.get(item.getName()).get(item.getPrice())+ 1);
                }
            }
        }
        int errorCount = 0;
        for(String name: headcount.keySet()){
            //error if
            if(name.equals("error")){
                for(String price: headcount.get("error").keySet()){
                    errorCount++;
                    //can prob just get size
                }
            }
            else{
                int total = 0;
                for(String price: headcount.get(name).keySet()){
                    total+=headcount.get(name).get(price);
                }
                sb.append(String.format("name:%4s%9s%s times\n",name,"seen: ",total));
                sb.append("============= \t \t =============\n");
                for(String price: headcount.get(name).keySet()){
                    sb.append(String.format("Price:%4s%9s%s times\n",price,"seen: ",headcount.get(name).get(price)));
                    sb.append("-------------\t\t -------------\n");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
