import java.util.ArrayList;

/**
 * Created by ryangross on 2/8/17.
 */
public class Display {


    public String addSpaces(String aString) {
        String spaces = "";
        while (spaces.length() != 8 - aString.length()) {
            spaces += " ";
        }
        spaces += aString;
        return spaces;
    }

    public String priceSpaces(String aString) {
        String spaces = "";
        while(spaces.length() != 7 - aString.length()) {
            spaces += " ";
        }
        spaces += aString;
        return spaces;
    }


    public String printApples(GroceryList aList) {
        String answer = "";
        answer += "Name:" + addSpaces("Apples") + "    Seen: " + String.valueOf(aList.counter("apples")) + " times\n" + "=============    " + "=============\n";
        for(int i = 0 ; i < aList.getUniqueGroceries().size(); i++) {
            if (aList.getUniqueGroceries().get(i).getName().toLowerCase().equals("apples")) {
                answer += "Price:" + priceSpaces( aList.getUniqueGroceries().get(i).getPrice()) + "    " + "Seen: " +
                        String.valueOf(aList.uniqueCounter(aList.getUniqueGroceries().get(i))) + " times\n"
                + "=============    " + "=============\n";
            }
        }
        return answer;
    }

    public String printCookies(GroceryList aList) {
        String answer = "";
        answer += "Name:" + addSpaces("Cookies") + "    Seen: " + String.valueOf(aList.counter("cookies")) + " times\n" + "=============    " + "=============\n";
        for(int i = 0 ; i < aList.getUniqueGroceries().size(); i++) {
            if (aList.getUniqueGroceries().get(i).getName().toLowerCase().equals("cookies")) {
                answer += "Price:" + priceSpaces( aList.getUniqueGroceries().get(i).getPrice()) + "    " + "Seen: " +
                        String.valueOf(aList.uniqueCounter(aList.getUniqueGroceries().get(i))) + " times\n"
                        + "=============    " + "=============\n";
            }
        }
        return answer;
    }

    public String printBread(GroceryList aList) {
        String answer = "";
        answer += "Name:" + addSpaces("Bread") + "    Seen: " + String.valueOf(aList.counter("bread")) + " times\n" + "=============    " + "=============\n";
        for(int i = 0 ; i < aList.getUniqueGroceries().size(); i++) {
            if (aList.getUniqueGroceries().get(i).getName().toLowerCase().equals("bread")) {
                answer += "Price:" + priceSpaces( aList.getUniqueGroceries().get(i).getPrice()) + "    " + "Seen: " +
                        String.valueOf(aList.uniqueCounter(aList.getUniqueGroceries().get(i))) + " times\n"
                        + "=============    " + "=============\n";
            }
        }
        return answer;
    }



    public String printMilk(GroceryList aList) {
        String answer = "";
        answer += "Name:" + addSpaces("Milk") + "    Seen: " + String.valueOf(aList.counter("milk")) + " times\n" + "=============    " + "=============\n";
        for(int i = 0 ; i < aList.getUniqueGroceries().size(); i++) {
            if (aList.getUniqueGroceries().get(i).getName().toLowerCase().equals("milk")) {
                answer += "Price:" + priceSpaces( aList.getUniqueGroceries().get(i).getPrice()) + "    " + "Seen: " +
                        String.valueOf(aList.uniqueCounter(aList.getUniqueGroceries().get(i))) + " times\n"
                        + "=============    " + "=============\n";
            }
        }
        return answer;
    }

    public String printErrors(GroceryList aList, int number) {
        String answer =  "Errors:" + addSpaces("") + "  " + "Seen: " + String.valueOf(number - aList.getAllGroceries().size() - 1) + " times";
        return answer;
    }







}
