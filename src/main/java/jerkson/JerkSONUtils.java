package jerkson;

import org.json.JSONObject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class JerkSONUtils {

    public static String[] breakIntoEntries(String in) {
        return split(in, "[#]+");
    }
     public static String[] breakEntry(String in) {
        return split(in, "[;^%@*!]");
    }

    public static String[] breakPair(String in) {
        return split(in, ":");
    }

    public static String prepForJSON(String entry) {
        String[] list = breakEntry(entry);
        String[] labels = {"name", "price", "type", "expiration"};
        String[] values = new String[4];
        for (int i = 0; i < 4; i++) {
            String[] arr = breakPair(list[i]);
            values[i] = (arr.length == 2) ? arr[1] : "\t";
        }
        return jsonBuilder(labels, values);
    }

    public static String[] split(String in, String regex) {
        return Pattern.compile(regex).split(in);
    }

    public static Boolean matches(String in, String regex) {
        return Pattern.compile(regex).matcher(in).matches();
    }

    public static String[] filterListByName(String[] list, String name) {
        return Arrays.stream(list)
                .filter(e ->
                        matches(
                                (new JSONObject(e)).get("name").toString(),
                                String.format("[%s0]+", fixName(name))))
                .collect(Collectors.toList())
                .toArray(new String[0]);

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

    public static String[] filterOutErrorEntries(String[] list) {
        return Arrays.stream(list)
                .filter(JerkSONUtils::checkErr)
                .collect(Collectors.toList())
                .toArray(new String[0]);
    }

    public static Boolean checkErr(String entry) {
        JSONObject json = new JSONObject(entry);
        for (String key : json.keySet())
            if (matches(json.get(key).toString(),"\t"))
                return false;
        return true;
    }

    public static Map<String, Integer> getNameCounts(String[] list) {
        Map<String, Integer> names = new HashMap();
        Arrays.stream(list).forEach(entry -> {
            String name = (new JSONObject(entry)).get("name").toString().toLowerCase();

            if (!matches(name, "\t")) {
                name = setNameToKey(name, names);
                if (!names.containsKey(name)) names.put(name, 1);
                else names.put(name, names.get(name) + 1);
            }
        });
        return names;
    }

    public static String setNameToKey(String name, Map<String, Integer> names) {
        for (String key : names.keySet())
            if (matches(key, "[" + fixName(name) + "]+"))
                return key;
        return name;
    }

    public static Map<String, Integer> getPricesByName(String[] list, String name) {
        Map<String, Integer> prices = new HashMap();
        Arrays.stream(filterListByName(list, name))
                .forEach(entry -> {
                    String price = (new JSONObject(entry)).get("price").toString();
                    if (!matches(price, "\t")) {
                        if (!prices.containsKey(price)) prices.put(price, 1);
                        else prices.put(price, prices.get(price) + 1);
                    }
                });
        return prices;
    }
}