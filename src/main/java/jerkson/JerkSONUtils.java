package jerkson;

import org.json.JSONObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JerkSONUtils {
    public static String parseGobble(String in) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            Character chip = in.charAt(i);
            Pattern patternA = Pattern.compile("[A-Za-z0-9/.:]");
            Pattern patternB = Pattern.compile(":");
            Matcher matcherA = patternA.matcher(chip.toString());
            Matcher matcherB = patternB.matcher(chip.toString());
            if (matcherA.matches()) {
                out.append(chip);
                if (matcherB.matches()) out.append("\t");
            }
            else out.append("\n");
        }
        return out.toString();
    }

    public static List<String> stringToList(String in) {
        return Arrays.asList(in.split("\n\n"));
    }

    public static String prepJ2(String entry) {
        String[] list = entry.split("\n");
        String[] labels = {"name", "price", "type", "expiration"};
        String[] values = new String[4];
        for (int i = 0; i < 4; i++) {
            String[] arr = list[i].split(":\t");
            values[i] = (arr.length == 2) ? arr[1] : "\t";
        }
        return jsonBuilder(labels, values);
    }

    public static List<String> filterListByName(List<String> list, String name) {
        return list.stream()
                .filter(e ->
                        (new JSONObject(e)).get("name").toString()
                                .matches(String.format("[%s0]+", fixName(name))))
                .collect(Collectors.toList());

    }

    public static String fixName(String name) {
        return name.toUpperCase() + name.toLowerCase();
    }

    public static String jsonBuilder(String[] labels, String[] values) {
        StringBuilder json = new StringBuilder().append("{");

        for (int i = 0; i < labels.length; i++) {
            if (values[i] == null) json.append(String.format("\"%s\": %s", labels[i], values[i]));
            else json.append(String.format("\"%s\": \"%s\"", labels[i], values[i]));

            if (i != labels.length-1) json.append(",");
        }
        json.append("}");
        return json.toString();
    }

    public static List<String> filterOutErrorEntries(List<String> list) {
        return list.stream()
                .filter(entry -> checkErr(entry))
                .collect(Collectors.toList());
    }

    public static Boolean checkErr(String entry) {
        JSONObject json = new JSONObject(entry);
        for (String key : json.keySet()) {
            if (json.get(key).toString().matches("\t"))
                return false;
        }
        return true;
    }

    public static Map<String, Integer> getNameCounts(List<String> list) {
        Map<String, Integer> names = new HashMap();
        list.stream().forEach(entry -> {
            String name = (new JSONObject(entry)).get("name").toString().toLowerCase();

            if (!name.matches("\t")) {
                for (String key : names.keySet()) {
                    if (key.matches("[" + fixName(name) + "]+")) {
                        name = key;
                        break;
                    }
                }
                if (!names.containsKey(name)) names.put(name, 1);
                else names.put(name, names.get(name) + 1);
            }
        });
        return names;
    }


    public static Map<String, Integer> getPricesByName(List<String> list, String name) {
        Map<String, Integer> prices = new HashMap();
        filterListByName(list, name).stream().forEach(entry -> {
            String price = (new JSONObject(entry)).get("price").toString();
            if (!price.matches("\t")) {
                if (!prices.containsKey(price)) prices.put(price, 1);
                else prices.put(price, prices.get(price) + 1);
            }
        });
        return prices;
    }
}