package kim.chris.data;

import java.util.HashMap;

public class Counter {

    private String name;
    private HashMap<Double, Integer> priceCounts;
    int count;

    public Counter(String name) {
        this.name = name;
        this.priceCounts = new HashMap<Double, Integer>();
        count = 0;
    }

    public void addItem(Item item){
        int count = this.priceCounts.containsKey(item.getPrice()) ? this.priceCounts.get(item.getPrice()) : 0;
        this.priceCounts.put(item.getPrice(), count + 1);
        this.count++;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(1000);
        sb.append(header());
        for(Double key: priceCounts.keySet()){
            sb.append("Price:   " + key + "\t\tseen: " + priceCounts.get(key));
            if(priceCounts.get(key) > 1 ){
                sb.append(" times\n");
            } else sb.append(" time\n");
            sb.append("-------------\t\t-------------\n");
        }
        if(priceCounts.keySet().size() > 1) sb.delete(sb.length()-29, sb.length());
        sb.append("\n");
        return sb.toString();
    }

    private String header(){
        StringBuilder sb = new StringBuilder(1000);
        sb.append("name:");
        if(name.equals("Milk")){
            sb.append("    Milk\t\tseen: ");
        } else if(name.equals("Bread")){
            sb.append("   Bread\t\tseen: ");
        } else if(name.equals("Cookies")){
            sb.append(" Cookies\t\tseen: ");
        } else {
            sb.append("  Apples\t\tseen: ");
        }
        if(count > 1){
            sb.append(count + " times\n");
        } else sb.append("1 time\n");
        sb.append("=============\t\t=============\n");
        return sb.toString();
    }
}
