package io.derobert;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Item {
    private String name;
    private int nameSeenCounter;
    private TreeMap<String, Integer> pricesSeen = new TreeMap<>();

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getNameSeenCounter(){
        return nameSeenCounter;
    }

    public void increaseNameCounter(){
        nameSeenCounter++;
    }

    public void decreaseNameCounterForError(){
        nameSeenCounter--;
    }

    public void addPrice(String price){
        if(pricesSeen.get(price) != null){
            pricesSeen.put(price, pricesSeen.get(price) + 1);
        }else{
            pricesSeen.put(price, 1);
        }
    }


    public String foodTitle(){
        String times = "times";
        if(nameSeenCounter == 1){
            times = "time";
        }

        if(name.equals("Cookies")){
            return "name: Cookies        seen: " + nameSeenCounter + " " + times +
                    "\n=============        =============";
        }else if(name.equals("Milk")){
            return "name:    Milk        seen: " + nameSeenCounter + " " + times +
                    "\n=============        =============";
        }else if(name.equals("Bread")){
            return "name:   Bread        seen: " + nameSeenCounter + " " + times +
                    "\n=============        =============";
        }else if(name.equals("Apples")){
            return "name:  Apples        seen: " + nameSeenCounter + " " + times +
                    "\n=============        =============";
        }

        return null;
    }

    public String formatItem(){
        NavigableMap<String, Integer> sortedMap = pricesSeen.descendingMap();
        int mapCounter = 1;
        String formattedString = foodTitle();

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            String times = "times";
            if(entry.getValue() == 1){
                times = "time";
            }
            formattedString += "\nPrice:   " + entry.getKey() + "        seen: " + entry.getValue() + " " + times;
            if(mapCounter != sortedMap.size()){
                formattedString += "\n-------------        -------------";
            }
            mapCounter++;
        }

        return formattedString;
    }
}
