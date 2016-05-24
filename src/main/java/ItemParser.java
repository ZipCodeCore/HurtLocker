import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by zihaocastine on 5/24/16.
 */
public class ItemParser {
    private static int countException=0;

    public ArrayList<String> jerkSonParser(String jerkSon){

        String [] jerkSonArray=jerkSon.split("##");
        ArrayList<String> dataReadyForStore=new ArrayList<>();

        part1:for(String each: jerkSonArray){
            String [] dataSet=parseDataSet(each);
            StringBuilder items=new StringBuilder();
            for(String data: dataSet){
                try {
                    items.append(getValueFromName(data)).append(",");
                } catch (BadDataException e) {
                    countException++;
                    continue part1;
                }
            }
            dataReadyForStore.add((items.substring(0,items.length()-1).toString()));

        }

        return dataReadyForStore;
    }

    public ArrayList<Item> storeData(ArrayList<String> data){
        ArrayList<Item> itemArrayList=new ArrayList<>();

        for(String each:data){
            String [] datalist=each.split(",");
            switch (findName(datalist[0])){
                case "cookie":
                    itemArrayList.add(new Item("Cookie",Double.parseDouble(datalist[1]),datalist[2],datalist[3]));
                    break;
                case "milk":
                    itemArrayList.add(new Item("Milk",Double.parseDouble(datalist[1]),datalist[2],datalist[3]));
                    break;
                case "apple":
                    itemArrayList.add(new Item("Apple",Double.parseDouble(datalist[1]),datalist[2],datalist[3]));
                    break;
                case "bread":
                    itemArrayList.add(new Item("Bread",Double.parseDouble(datalist[1]),datalist[2],datalist[3]));
                    break;
                default: System.out.println("storeData has problem"+ each);
                    break;
            }
        }

        return itemArrayList;
    }

    private String findName(String data){
        String cookiesPattern="[Co|O|0|k|i|I|e|s|S]{7}";
        String applePattern="[ap|Ples]{6}";
        String milkPattern="([Ml|L][^aenE]){2,4}";
        String breadPattern="[Bre|Ea|AD]{5}";
        Pattern cookie=Pattern.compile(cookiesPattern);
        Pattern milk=Pattern.compile(milkPattern);
        Pattern apple=Pattern.compile(applePattern);
        Pattern bread=Pattern.compile(breadPattern);
        if(cookie.matcher(data).find()){
            return "cookie";
        }else if(milk.matcher(data).find()){
            return "milk";
        }else if(apple.matcher(data).find()){
            return "apple";
        }else if(bread.matcher(data).find()){
            return "bread";
        }

        return null;
    }


    private String [] parseDataSet(String dataset){
        String [] dataSet=dataset.split(";|\\^|%|\\*|!|@");
        return dataSet;
    }

    protected String getValueFromName(String data) throws BadDataException {
        String [] value=data.split(":");
        if(value.length>1){
            return value[1];
        }else {
            throw new BadDataException();
        }

    }

    public static int getCountException() {
        return countException;
    }

}

