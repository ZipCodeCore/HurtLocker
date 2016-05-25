package io.assignmentTwo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {


    public void runParser(String rawData) {
        ArrayList<Item> parsedItems = parseRawData(rawData);
        printParsedData(formatArrayListIntoString(parsedItems));
    }

    public ArrayList<Item> parseRawData(String rawData) {
        ArrayList<Item> groceryList = new ArrayList<>();
        String[] splitByLines = splitDataByDoubleHashCharacter(rawData);
        ArrayList<ArrayList<String>> separatedValues = separateKeyPairValues(splitByLines);

        String name = null;
        String price = null;
        for (ArrayList<String> row : separatedValues) {
            Item item = new Item();
            for (int i = 0; i < row.size(); ++i) {
                if (i == 0) {
                    Pattern pattern = Pattern.compile("(?i)name:([^:@^*%;!]*)");
                    Matcher matcher = pattern.matcher(row.get(i));

                    while (matcher.find()) {
                        name = matcher.group();
                    }
                }
                if (i == 1) {
                    Pattern pattern = Pattern.compile("(?i)price:([^:@^*%;!]*)");
                    Matcher matcher = pattern.matcher(row.get(i));

                    while (matcher.find()) {
                        price = matcher.group();
                    }
                }
            }

            if (name.length() > 8 && price.length() > 8){
                try {
                    item.setName(name.replaceAll("(?i)name:", ""));
                } catch (Exception e) {
                }
                try {
                    item.setPrice(Double.parseDouble(price.replaceAll("(?i)price:", "")));
                } catch (Exception e) {
                }

                groceryList.add(item);
            }
        }
        return groceryList;
    }

    public String formatArrayListIntoString(ArrayList<Item> groceryList) {

        String formattedString = "";
        HashMap<String, Integer> names = countNames(groceryList);
        TreeMap<Double, Integer> applePrices = countApplePrices(groceryList);
        TreeMap<Double, Integer> breadPrices = countBreadPrices(groceryList);
        TreeMap<Double, Integer> cookiePrices = countCookiePrices(groceryList);
        TreeMap<Double, Integer> milkPrices = countMilkPrices(groceryList);
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            formattedString += String.format("name:    %s   \tseen: %d times\n=============   \t=============\n", key, value);
            if (isMilk(key)) {
                for (Map.Entry<Double, Integer> entry1 : milkPrices.entrySet()) {
                    Double key1 = entry1.getKey();
                    Integer value1 = entry1.getValue();
                    formattedString += String.format("Price:    %.2f   \tseen: %d times\n-------------   \t-------------\n\n", key1, value1);
                }
            }

            if (isCookies(key)) {
                for (Map.Entry<Double, Integer> entry2 : cookiePrices.entrySet()) {
                    Double key1 = entry2.getKey();
                    Integer value1 = entry2.getValue();
                    formattedString += String.format("Price:    %.2f   \tseen: %d times\n-------------   \t-------------\n\n", key1, value1);
                }
            }

            if (isBread(key)) {
                for (Map.Entry<Double, Integer> entry3 : breadPrices.entrySet()) {
                    Double key1 = entry3.getKey();
                    Integer value1 = entry3.getValue();
                    formattedString += String.format("Price:    %.2f   \tseen: %d times\n-------------   \t-------------\n\n", key1, value1);
                }
            }

            if (isApples(key)) {
                for (Map.Entry<Double, Integer> entry3 : applePrices.entrySet()) {
                    Double key1 = entry3.getKey();
                    Integer value1 = entry3.getValue();
                    formattedString += String.format("Price:    %.2f   \tseen: %d times\n-------------   \t-------------\n\n", key1, value1);
                }
            }
        }
        return formattedString;
    }

    public void printParsedData(String msg) {
        System.out.println(msg);
    }

    public String[] splitDataByDoubleHashCharacter(String rawData) {
        String[] separatedLines = rawData.split("##");
        return separatedLines;
    }

    public ArrayList<ArrayList<String>> separateKeyPairValues(String[] splitByLines) {
        ArrayList<ArrayList<String>> sv = new ArrayList<>();
        for (int i = 0; i < splitByLines.length; i++) {
            Pattern pattern = Pattern.compile("([^:@^*%;!]*)(:)([^:@^*%;!]*)");
            Matcher matcher = pattern.matcher(splitByLines[i]);
            ArrayList<String> lines = new ArrayList<>();
            while (matcher.find()) {
                lines.add(matcher.group());
            }
            sv.add(lines);
        }
        return sv;
    }

    public int countMilk(ArrayList<Item> groceryList) {
        int counter = 0;

        for (int i = 0; i < groceryList.size(); i++) {
            if (isMilk((groceryList.get(i).getName()))) {
                counter++;
            }
        }
        return counter;
    }

    public int countBread(ArrayList<Item> groceryList) {
        int counter = 0;

        for (int i = 0; i < groceryList.size(); i++) {
            if (isBread((groceryList.get(i).getName()))) {
                counter++;
            }
        }
        return counter;
    }

    public int countCookies(ArrayList<Item> groceryList) {
        int counter = 0;

        for (int i = 0; i < groceryList.size(); i++) {
            if (isCookies(groceryList.get(i).getName())) {
                counter++;
            }
        }
        return counter;
    }

    public int countApples(ArrayList<Item> groceryList) {
        int counter = 0;

        for (int i = 0; i < groceryList.size(); i++) {
            if (isApples(groceryList.get(i).getName())) {
                counter++;
            }
        }
        return counter;
    }

    public HashMap<String, Integer> countNames(ArrayList<Item> groceryList) {
        int apples = countApples(groceryList);
        int bread = countBread(groceryList);
        int cookies = countCookies(groceryList);
        int milk = countMilk(groceryList);
        HashMap<String, Integer> nameOccurences = new HashMap<>();
        nameOccurences.put("Milk", milk);
        nameOccurences.put("Cookies", cookies);
        nameOccurences.put("Bread", bread);
        nameOccurences.put("Apples", apples);
        return nameOccurences;

    }

    public TreeMap<Double, Integer> countMilkPrices(ArrayList<Item> groceryList) {
        ArrayList<Double> milkPrices = new ArrayList<>();

        for (int i = 0; i < groceryList.size(); i++) {
            if (isMilk((groceryList.get(i).getName()))) {
                milkPrices.add(groceryList.get(i).getPrice());
            }
        }
        TreeMap<Double, Integer> milkPriceOccurences = new TreeMap<>();
        for (int i = 0; i < milkPrices.size(); i++) {
            milkPriceOccurences.put(milkPrices.get(i), Collections.frequency(milkPrices, milkPrices.get(i)));
        }

        return milkPriceOccurences;
    }

    public TreeMap<Double, Integer> countBreadPrices(ArrayList<Item> groceryList) {
        ArrayList<Double> breadPrices = new ArrayList<>();

        for (int i = 0; i < groceryList.size(); i++) {
            if (isBread((groceryList.get(i).getName()))) {
                breadPrices.add(groceryList.get(i).getPrice());
            }
        }
        TreeMap<Double, Integer> breadPriceOccurences = new TreeMap<>();
        for (int i = 0; i < breadPrices.size(); i++) {
            breadPriceOccurences.put(breadPrices.get(i), Collections.frequency(breadPrices, breadPrices.get(i)));
        }

        return breadPriceOccurences;
    }

    public TreeMap<Double, Integer> countApplePrices(ArrayList<Item> groceryList) {
        ArrayList<Double> applePrices = new ArrayList<>();

        for (int i = 0; i < groceryList.size(); i++) {
            if (isApples((groceryList.get(i).getName()))) {
                applePrices.add(groceryList.get(i).getPrice());
            }
        }
        TreeMap<Double, Integer> applePriceOccurences = new TreeMap<>();
        for (int i = 0; i < applePrices.size(); i++) {
            applePriceOccurences.put(applePrices.get(i), Collections.frequency(applePrices, applePrices.get(i)));
        }

        return applePriceOccurences;
    }

    public TreeMap<Double, Integer> countCookiePrices(ArrayList<Item> groceryList) {
        ArrayList<Double> cookiePrices = new ArrayList<>();

        for (int i = 0; i < groceryList.size(); i++) {
            if (isCookies((groceryList.get(i).getName()))) {
                cookiePrices.add(groceryList.get(i).getPrice());
            }
        }
        TreeMap<Double, Integer> cookiePriceOccurences = new TreeMap<>();
        for (int i = 0; i < cookiePrices.size(); i++) {
            cookiePriceOccurences.put(cookiePrices.get(i), Collections.frequency(cookiePrices, cookiePrices.get(i)));
        }

        return cookiePriceOccurences;
    }


    public boolean isMilk(String str) {
        Pattern pattern = Pattern.compile("(?i)milk");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches())
            return true;
        else
            return false;
    }

    public boolean isCookies(String str) {

        Pattern pattern = Pattern.compile("(?i)c(o|0)(o|0)kies");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches())
            return true;
        else
            return false;
    }

    public boolean isBread(String str) {
        Pattern pattern = Pattern.compile("(?i)bread");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches())
            return true;
        else
            return false;
    }

    public boolean isApples(String str) {
        Pattern pattern = Pattern.compile("(?i)apples");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches())
            return true;
        else
            return false;
    }

}


