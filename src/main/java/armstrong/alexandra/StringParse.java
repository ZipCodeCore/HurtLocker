package armstrong.alexandra;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class InvalidEntryException extends Exception{}

public class StringParse {
    public static int errorCounter = 0;
    public static ArrayList<GroceryItem> items = new ArrayList<>();

    public static String[] cutString(String raw){
        return raw.split("##");
    }

    public static void regEx(String[] info){
        Pattern p = Pattern.compile("name[:;*@!]([a-z])?\\w*[:;*@!]price[:;*@!](\\d\\.\\d{2})?[:;*@!]type[:;*@!]food[:;*@!%^]expiration[:;*@!]\\d\\/\\d{2}\\/\\d{4}", Pattern.CASE_INSENSITIVE);
        for(int i = 0; i < info.length; i++) {
            Matcher m = p.matcher(info[i]);
            if (m.matches() == true) {
                String name = m.group(1);
                String price = m.group(2);
                if(checkForInvalidEntry(name, price)) {
                    name = whichItem(name);
                    addItemToList(name, price);
                }
            }
        }
    }

    public static void addItemToList(String name, String price){
        boolean matched = false;
        if (items.size() == 0) {
            items.add(new GroceryItem(name, price));
        } else {
            for (int j = 0; j < items.size(); j++) {
                if (checkForDuplicateName(items.get(j), name, price)) {
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                GroceryItem temp = new GroceryItem(name, price);
                items.add(temp);
            }
        }
    }

    public static boolean checkForInvalidEntry(String name, String price){
        try{
            if(name == null || price == null){
                throw new InvalidEntryException();
            } else {
                return true;
            }
        } catch (InvalidEntryException e){
            errorCounter++;
            return false;
        }
    }

    public static boolean checkForDuplicateName(GroceryItem itemInList, String name, String price){
        if(itemInList.getName().equals(name)) {
            itemInList.duplicateName();
            checkForDuplicatePrice(itemInList, price);
            return true;
        } else {
            return false;
        }
    }

    public static void checkForDuplicatePrice(GroceryItem itemInList, String price){
        if (itemInList.getPrice(0).equals(price)) {
            itemInList.duplicate1Price();
        } else if (itemInList.getPrice(1) != null && itemInList.getPrice(1).equals(price)) {
            itemInList.duplicate2Price();
        }else{
            itemInList.price[1] = price;
            itemInList.duplicate2Price();
        }
    }

    public static String whichItem(String name){
        switch(name.toUpperCase().charAt(0)){
            case 'M': return "Milk";
            case 'C': return "Cookies";
            case 'B': return "Bread";
            case 'A': return "Apples";
        }
        return "no";
    }

    /*public static void main(String[] args){
        ArrayList<GroceryItem> stuff = regEx(cutString("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##"));
        System.out.println(stuff.size());
        for(int i = 0; i < stuff.size(); i++){
            System.out.println(stuff.get(i).getName());
            System.out.println(stuff.get(i).getPrice());
        }
    }*/
}

