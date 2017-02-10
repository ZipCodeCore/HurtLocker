package armstrong.alexandra;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class StringParse {
    public static String[] cutString(String raw){
        return raw.split("##");
    }



    public static ArrayList<GroceryItem> regEx(String[] info){
        Pattern p = Pattern.compile("name[:;*@!]([a-z])?\\w*[:;*@!]price[:;*@!](\\d\\.\\d{2})?[:;*@!]type[:;*@!]food[:;*@!%^]expiration[:;*@!]\\d\\/\\d{2}\\/\\d{4}", Pattern.CASE_INSENSITIVE);
        ArrayList<GroceryItem> items = new ArrayList<>();
        for(int i = 0; i < info.length; i++) {
            Matcher m = p.matcher(info[i]);
            //while (m.matches()) {
            if (m.matches()==true){
                if (items.size() == 0){
                    items.add(whichItem(m.group(1), m.group(2)));
                }
                else if (duplicateCheck(items, m.group(1), m.group(2)) == false) {
                    items.add(whichItem(m.group(1), m.group(2)));
                }
            }
        }
        return items;
    }

    public static boolean duplicateCheck(ArrayList<GroceryItem> items, String name, String price){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).equals(name, price) == false){
                return false;
            }
        }
        return true;
    }

    public static GroceryItem whichItem(String name, String price){
        switch(name.charAt(0)){
            case 'm':
            case 'M': return new GroceryItem("Milk", price);
            case 'c':
            case 'C': return new GroceryItem("Cookies", price);
            case 'b':
            case 'B': return new GroceryItem("Bread", price);
            case 'a':
            case 'A': return new GroceryItem("Apples", price);
        }
        return null;
    }

    public static void main(String[] args){
        ArrayList<GroceryItem> stuff = regEx(cutString("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##"));
        System.out.println(stuff.size());
        for(int i = 0; i < stuff.size(); i++){
            System.out.println(stuff.get(i).getName());
            System.out.println(stuff.get(i).getPrice());
        }
    }
}

