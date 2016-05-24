package io.HandroHoxtah;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

/**
 * Created by alejandrolondono on 5/24/16.
 */
public class Parser {


    private ArrayList<Item> items= new ArrayList<>();
    int error = 0;
    public Display display = new Display();
    public ArrayList<Item> getItems() {
        return items;
    }

    public String grammarNazi(String wrongWord){
        String newWord = "";
       if(wrongWord.matches("[M|m(1|i|I)l|Lk|K]{4}")){
            newWord = "Milk";
        }else if(wrongWord.matches("[c|C(o|O|0)+k|K(i|I|1)e|E(s|S|5)]{7}")){
            newWord = "Cookies";
        }else if(wrongWord.matches("[b|Br|R(3|e|E)(@|a|A)d|D]{5}")){
            newWord = "Bread";
        }else if(wrongWord.matches("[(a|A|@)(p|P)+(l|L|1)e|E(s|S|5)]{6}")){
            newWord = "Apples";
        }
        return newWord;
    }

    public void createItems(String data){
            ArrayList<String> dataFragments =  getDataFragment("[n|N(a|A|@)m|M(e|E|3)]{4}:([(a-z)|(A-Z)]{4,7}){0,1}[^(a-z)|(A-Z)]{1,2}[p|Pr|Ri|Ic|Ce|E]{5}:(\\d*.\\d{2}){0,1}", data);
        for (String dataFrag : dataFragments) {
            try {
                String nameValue = getDataFragment(":([(a-z)|(A-Z)]{4,7}){0,1}", dataFrag).get(0).substring(1);
                double price = Double.parseDouble(getDataFragment(":(\\d*.\\d{2})", dataFrag).get(0).substring(1));
                getItems().add(new Item(grammarNazi(nameValue), price));
            }catch(IndexOutOfBoundsException e){
                error++;
            }
        }

    }

    public void addItem(Item item){
        getItems().add(item);
    }

    public ArrayList<String> getDataFragment(String regex, String string){
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(string);
        ArrayList<String> matches = new ArrayList<>();
        while(m.find()){
            matches.add(m.group());
        }
        return matches;
    }

    public void parse(String data){
        createItems(data);
        display.output(getItems(), error);
    }
}
