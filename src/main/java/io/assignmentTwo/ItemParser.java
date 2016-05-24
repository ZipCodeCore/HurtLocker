package io.assignmentTwo;

import java.lang.reflect.Array;
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
                    Pattern pattern = Pattern.compile("(?i)name:\\w+");
                    Matcher matcher = pattern.matcher(row.get(i));

                    while (matcher.find()) {
                        name = matcher.group();
                    }
                }
                if (i == 1) {
                    Pattern pattern = Pattern.compile("(?i)price:\\w+([.]?\\d?)*");
                    Matcher matcher = pattern.matcher(row.get(i));

                    while (matcher.find()) {
                        price = matcher.group();
                    }
                }
            }
            if (name != null && price != null) {

                item.setName(name.replaceAll("(?i)name:", ""));
                item.setPrice(Double.parseDouble(price.replaceAll("(?i)price:", "")));
                groceryList.add(item);
            }
        }
        return groceryList;
    }

    public String formatArrayListIntoString(ArrayList<Item> groceryList) {

        TreeMap<String, Integer> names = countNames(groceryList);
        ArrayList<String> namesIterator = new ArrayList<>();
        ArrayList<String> namesOccurences = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            namesIterator.add(key);
            namesOccurences.add("" + value);
        }

        TreeMap<String, TreeMap<Double, Integer>> prices = countPrices(groceryList);
        ArrayList<Double> pricesIterator = new ArrayList<>();
        ArrayList<Integer> pricesOccurences = new ArrayList<>();

        for (Map.Entry<String, TreeMap<Double, Integer>> entry : prices.entrySet()) {
            TreeMap<Double, Integer> childMap = entry.getValue();

            for (Map.Entry<Double, Integer> entry2 : childMap.entrySet()) {
                Double childKey = entry2.getKey();
                Integer childValue = entry2.getValue();
                pricesIterator.add(childKey);
                pricesOccurences.add(childValue);
            }
        }
        String formattedString = "";
        for (int i = 0; i < 4; i++) {
            formattedString += String.format("name:%8s\t\t\tSeen: %s times\n=============\n", namesIterator.get(i), namesOccurences.get(i));

            for (int j = 0; j < pricesIterator.size() ; j++) {
                formattedString += String.format("Price:%7.2f\t\t\tSeen: %d times\n-------------\n\n", pricesIterator.get(j), pricesOccurences.get(j)+1);
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
            Pattern pattern = Pattern.compile("\\w+:\\w+([.]?\\d?)*");
            Matcher matcher = pattern.matcher(splitByLines[i]);
            ArrayList<String> lines = new ArrayList<>();
            while (matcher.find()) {
                lines.add(matcher.group());
            }
            sv.add(lines);
        }
        return sv;
    }

    public TreeMap<String, Integer> countNames(ArrayList<Item> groceryList) {
        TreeMap<String, Integer> counter = new TreeMap<>();

        ArrayList<String> milk = new ArrayList<>();
        ArrayList<String> cookies = new ArrayList<>();
        ArrayList<String> bread = new ArrayList<>();
        ArrayList<String> apples = new ArrayList<>();


        for (int i = 0; i < groceryList.size(); i++) {
            String name = groceryList.get(i).getName();
            double price = groceryList.get(i).getPrice();
            if (isApples(name)) {
                apples.add("ANOTHERONE");
            }
            if (isBread(name)) {
                bread.add("ANOTHERONE");
            }
            if (isCookies(name)) {
                cookies.add("ANOTHERONE");
            }
            if (isMilk(name)) {
                milk.add("ANOTHERONE");
            }
        }

        counter.put("Milk", milk.size());
        counter.put("Cookies", cookies.size());
        counter.put("Bread", bread.size());
        counter.put("Apples", apples.size());

        return counter;
    }

    public TreeMap<String, TreeMap<Double, Integer>> countPrices(ArrayList<Item> groceryList) {

        TreeMap<String, TreeMap<Double, Integer>> pricesCounter = new TreeMap<>();
        TreeMap<Double, Integer> milkCounter = new TreeMap<>();
        TreeMap<Double, Integer> breadCounter = new TreeMap<>();
        TreeMap<Double, Integer> cookieCounter = new TreeMap<>();
        TreeMap<Double, Integer> applesCounter = new TreeMap<>();

        ArrayList<Double> milkPrices = new ArrayList<>();
        ArrayList<Double> cookiesPrices = new ArrayList<>();
        ArrayList<Double> breadPrices = new ArrayList<>();
        ArrayList<Double> applesPrices = new ArrayList<>();


        for (int i = 0; i < groceryList.size(); i++) {

            String name = groceryList.get(i).getName();
            double price = groceryList.get(i).getPrice();
            if (isApples(name)) {
                applesPrices.add(price);
            }
            if (isBread(name)) {
                breadPrices.add(price);
            }
            if (isCookies(name)) {
                cookiesPrices.add(price);
            }
            if (isMilk(name)) {
                milkPrices.add(price);
            }
        }

        for (int i = 0; i < milkPrices.size(); i++) {
            double currentIndex = milkPrices.get(i);
            int occurrences = Collections.frequency(milkPrices, currentIndex);
            milkCounter.put(currentIndex, occurrences);

        }

        for (int i = 0; i < cookiesPrices.size(); i++) {
            double currentIndex = cookiesPrices.get(i);
            int occurrences = Collections.frequency(cookiesPrices, currentIndex);
            cookieCounter.put(currentIndex, occurrences);
        }

        for (int i = 0; i < breadPrices.size(); i++) {
            double currentIndex = breadPrices.get(i);
            int occurrences = Collections.frequency(breadPrices, currentIndex);
            breadCounter.put(currentIndex, occurrences);
        }

        for (int i = 0; i < applesPrices.size(); i++) {
            double currentIndex = cookiesPrices.get(i);
            int occurrences = Collections.frequency(applesPrices, currentIndex);
            applesCounter.put(currentIndex, occurrences);
        }

        pricesCounter.put("Milk", milkCounter);
        pricesCounter.put("Bread", breadCounter);
        pricesCounter.put("Cookies", cookieCounter);
        pricesCounter.put("Apples", applesCounter);

        return pricesCounter;
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


