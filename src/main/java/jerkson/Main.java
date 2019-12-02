package jerkson;

import org.apache.commons.io.IOUtils;

import java.util.List;
import java.util.Map;

public class Main {

    public String readRawDataToString() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
            return result;
        } catch(Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception{
        run();
    }

    public static void run() {
        String output = (new Main()).readRawDataToString();
        String parsed = JerkSONUtils.parseGobble(output);
        List<String> list = JerkSONUtils.stringToList(parsed);

        for (int i = 0; i < list.size(); i++) {
            String json = JerkSONUtils.prepJ2(list.get(i));
            list.set(i, json);
        }
        String out = prettyPrint(list);
        System.out.println(out);
    }

    public static String prettyPrint(List<String> list) {
        int initSize = list.size();
        StringBuilder out = new StringBuilder();
        list = JerkSONUtils.filterOutErrorEntries(list);
        Integer errorCount = initSize - list.size();
        Map<String, Integer> names = JerkSONUtils.getNameCounts(list);
        for (String name : names.keySet()) {
            out.append(String.format("\nName:%s%s\t\tseen: %s times\n" +
                            "=============\t\t=============\n",
                    tabs(name, 5), name, names.get(name)));
            Map<String, Integer> prices = JerkSONUtils.getPricesByName(list, name);
            int ct = 0;
            for (String price : prices.keySet()) {
                out.append(String.format("Price:%s%s\t\tseen: %s times\n",
                        tabs(price, 6), price, prices.get(price)));
                if (ct == 0) out.append("-------------\t\t-------------\n");
                ct++;
            }
        }

        out.append("\nErrors\t\t\t\tseen: " + errorCount + " times");
        return out.toString();
    }

    public static String tabs(String word, Integer labelLen) {
        String tabs = "";
        int num = 13 - labelLen - word.length();
        for (int i = 0; i < num; i++) {
            tabs = tabs + " ";
        }
        return tabs;
    }
}