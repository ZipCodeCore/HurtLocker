package io.MMJ;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by matthewb on 5/24/16.
 */
public class ItemParser {

    int exceptionsCaught = 0;
    int numMilk =0;
    int numBread=0;
    int numCookies=0;
    int numApples=0;
    ArrayList<ArrayList<String>> allPrices= new ArrayList<>();
    ArrayList<String> milkPrices = new ArrayList<>();
    ArrayList<String> breadPrices = new ArrayList<>();
    ArrayList<String> cookiesPrices = new ArrayList<>();
    ArrayList<String> applesPrices = new ArrayList<>();


    public void checkForMissingField(Item item)throws FieldMissingException{
        if(item.getName().equals("")){
            throw new FieldMissingException();
        }
        if(item.getPrice().equals("")){
            throw new FieldMissingException();
        }
        if(item.getType().equals("")){
            throw new FieldMissingException();
        }
        if(item.getExpiration().equals("")){
            throw new FieldMissingException();
        }
    }

    public String correctName(String input){
        String pattern = "[nameNAME]{4}";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"name");
        }
        input = buffer.toString();
        return input;
    }
    public String correctType(String input){
        String pattern = "[typeTYPE]{4}";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"type");
        }
        input = buffer.toString();
        return input;
    }
    public String correctPrice(String input){
        String pattern = "[pricePRICE]{5}";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"price");
        }
        input = buffer.toString();
        return input;
    }
    public String correctExpiration(String input){
        String pattern = "[expriationEXPIRATION]{10}";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"expiration");
        }
        input = buffer.toString();
        return input;
    }

    public String correctBread(String input){
        String pattern = "[breadBREAD]{5}";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Bread");
        }
        input = buffer.toString();
        return input;
    }

    public String correctMilk(String input){
        String pattern = "[milkMILK]{4}";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Milk");
        }
        input = buffer.toString();
        return input;
    }

    public String correctCookies(String input){
        String pattern = "[0cokiesCOKIES]{7}";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Cookies");
        }
        input = buffer.toString();
        return input;
    }
    public String correctApples(String input){
        String pattern ="[@applesAPPLES]{6}";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Apples");
        }
        input = buffer.toString();
        return input;
    }

    public String correctFood(String input){
        String pattern = "([0fodFOD]{4})+.";
        StringBuilder buffer = new StringBuilder(input);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(buffer);
        while(m.find()){
            buffer.replace(m.start(),m.end(),"Food;");
        }
        input = buffer.toString();
        return input;
    }

    public ArrayList<Item> deserializeItem(String serialMessage){
        ArrayList<Item> listOfItems = new ArrayList<>();
        Item newItem = new Item();
        String[] splitMessage = serialMessage.split(";|:|\\n|##");
        for(int i =0;i<splitMessage.length;i++){
            switch(i%8){
                case 1: newItem.setName(splitMessage[i]);
                    break;
                case 3: newItem.setPrice(splitMessage[i]);
                    break;
                case 5: newItem.setType(splitMessage[i]);
                    break;
                case 7: newItem.setExpiration(splitMessage[i]);
                    try{checkForMissingField(newItem);
                    }catch (FieldMissingException e){
                        exceptionsCaught++;
                        break;
                    }
                    listOfItems.add(newItem);
                    newItem = new Item();
                    break;
                default:
                    break;
            }
        }return listOfItems;
    }

    public void countObjects(Item item){
        String name = item.getName();
        switch (name){
            case "Apples":
                numApples++;
                applesPrices.add(item.getPrice());
                break;
            case "Milk":
                numMilk++;
                milkPrices.add(item.getPrice());
                break;
            case "Bread":
                numBread++;
                breadPrices.add(item.getPrice());
                break;
            case "Cookies":
                numCookies++;
                cookiesPrices.add(item.getPrice());
                break;
            default:
                break;
        }
    }

    public void printResults(ArrayList<Item> itemArrayList){
        for(Item item : itemArrayList){
/*
            System.out.println("name: "+item.getName());
            System.out.println("price: "+item.getPrice());
            System.out.println("type: "+item.getType());
            System.out.println("expiration: "+item.getExpiration());
*/
            countObjects(item);
        }
/*
        System.out.println("Exceptions Caught: "+ exceptionsCaught);
        System.out.println("apples: " + numApples);
        System.out.println("bread: " + numBread);
        System.out.println("cookies: " + numCookies);
        System.out.println("milk: " + numMilk);
*/
    }
    public void runItemParser(String input){
        //System.out.println(currenttext);
        //currenttext=itemParser.regexTest(currenttext);
        //currenttext=itemParser.correctSpelling(currenttext);

        input=correctName(input);
        input=correctExpiration(input);
        input=correctType(input);
        input=correctPrice(input);

        input=correctMilk(input);
        input=correctBread(input);
        input=correctCookies(input);
        input=correctApples(input);
        input=correctFood(input);
        //System.out.println(currenttext);
        ArrayList<Item> allItems = deserializeItem(input);
        printResults(allItems);
        System.out.println(formatResults());

    }

    public String formatResults(){
        allPrices.add(milkPrices);
        allPrices.add(breadPrices);
        allPrices.add(cookiesPrices);
        allPrices.add(applesPrices);
        ArrayList<String> previousPrices = new ArrayList<>();
        boolean firstloop = true;
        String savedPrice = "";
        int repeatedPrice = 0;
        String equalBar = "=============";
        String dashBar =  "-------------";
        String result = "";
        result += "name:    Milk";
        result += String.format("%30s","seen: " + numMilk + " times") +  "\n";
        result += equalBar;
        result += String.format("%30s",equalBar) +  "\n";
        for(String s : milkPrices){
            if(firstloop) {
                savedPrice = s;
                firstloop = false;
            }
            if(savedPrice.equals(s)){
                repeatedPrice++;
            }
        }
        int remainder = milkPrices.size()-repeatedPrice;
        for(String s : milkPrices){
            if(!previousPrices.contains(s) && s.equals(savedPrice)){
                result += "Price:   "+ s;
                result += String.format("%30s","seen: " + repeatedPrice + " times") +  "\n";
                result += dashBar;
                result += String.format("%30s",dashBar) +  "\n";

                previousPrices.add(s);
            }
            if(!previousPrices.contains(s)){
                result += "Price:   "+ s;
                result += String.format("%30s","seen: " + remainder + " times") +  "\n";
                result += dashBar;
                result += String.format("%30s",dashBar) +  "\n";

                previousPrices.add(s);
            }
        }
        previousPrices.clear();
        firstloop = true;
        savedPrice = "";
        repeatedPrice = 0;

        result += "\n";
        result += "name:   Bread";
        result += String.format("%30s","seen: " + numBread + " times") +  "\n";
        result += equalBar;
        result += String.format("%30s",equalBar) +  "\n";
        for(String s : breadPrices){
            if(firstloop) {
                savedPrice = s;
                firstloop = false;
            }
            if(savedPrice.equals(s)){
                repeatedPrice++;
            }
        }
        remainder = breadPrices.size()-repeatedPrice;
        for(String s : breadPrices){
            if(!previousPrices.contains(s) && s.equals(savedPrice)){
                result += "";
                result += "Price:   "+ s;
                result += String.format("%30s","seen: " + repeatedPrice + " times") +  "\n";
                result += dashBar;
                result += String.format("%30s",dashBar) +  "\n";

                previousPrices.add(s);
            }
            if(!previousPrices.contains(s)){
                result += "Price:   "+ s;
                result += String.format("%30s","seen: " + remainder + " times ") +  "\n";
                result += dashBar;
                result += String.format("%30s",dashBar) +  "\n";

                previousPrices.add(s);
            }
        }

        previousPrices.clear();
        firstloop = true;
        savedPrice = "";
        repeatedPrice = 0;

        result += "\n";
        result += "name: Cookies";
        result += String.format("%30s","seen: " + numCookies + " times") +  "\n";
        result += equalBar;
        result += String.format("%30s",equalBar) +  "\n";
        for(String s : cookiesPrices){
            if(firstloop) {
                savedPrice = s;
                firstloop = false;
            }
            if(savedPrice.equals(s)){
                repeatedPrice++;
            }
        }
        remainder = cookiesPrices.size()-repeatedPrice;
        for(String s : cookiesPrices){
            if(!previousPrices.contains(s) && s.equals(savedPrice)){
                result += "Price:   "+ s;
                result += String.format("%30s","seen: " + repeatedPrice + " times") +  "\n";
                result += dashBar;
                result += String.format("%30s",dashBar) +  "\n";

                previousPrices.add(s);
            }
            if(!previousPrices.contains(s)){
                result += "Price:   "+ s;
                result += String.format("%30s","seen: " + remainder + " times") +  "\n";
                result += dashBar;
                result += String.format("%30s",dashBar) +  "\n";
                result+="";

                previousPrices.add(s);
            }
        }
        previousPrices.clear();
        firstloop = true;
        savedPrice = "";
        repeatedPrice = 0;

        result += "\n";
        result += "name:  Apples";
        result += String.format("%30s","seen: " + numApples + " times") +  "\n";
        result += equalBar;
        result += String.format("%30s",equalBar) +  "\n";
        for(String s : applesPrices){
            if(firstloop) {
                savedPrice = s;
                firstloop = false;
            }
            if(savedPrice.equals(s)){
                repeatedPrice++;
            }
        }
        remainder = applesPrices.size()-repeatedPrice;
        for(String s : applesPrices){
            if(!previousPrices.contains(s) && s.equals(savedPrice)){
                result += "Price:   "+ s;
                result += String.format("%30s","seen: " + repeatedPrice + " times") +  "\n";
                result += dashBar;
                result+="";
                result += String.format("%30s",dashBar) +  "\n";

                previousPrices.add(s);
            }
            if(!previousPrices.contains(s)){
                result += "Price:   "+ s;
                result+="";
                result += String.format("%30s","seen: " + remainder + " times") +  "\n";
                result += dashBar;
                result += String.format("%30s",dashBar) +  "\n";

                previousPrices.add(s);
            }
        }
        result+= "\n"+"Errors       ";
        result += String.format("%30s","seen: " + exceptionsCaught + " times");



        return result;
    }
}
