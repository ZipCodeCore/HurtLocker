package ibikunle.tolani;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        //  String output = (new Main()).readRawDataToString();
        // System.out.println(output);
        JerkSonParser jerkSonParser = new JerkSonParser();
        Data data = new Data();
        System.out.println(jerkSonParser.parseItem(data.rawData));
        ArrayList<GroceryItem> g = jerkSonParser.makeGroceryList(data.rawData);
        for (GroceryItem g2 : g) {
            System.out.println(g2.getName()); // always remember that when you want to iterate through a collection if there are objects stored
            //always remember to get it via get.name get.id get whatever it is.

        }
        System.out.println(g.size());
        System.out.println(JerkSonParser.errorCount); // when its static dont need an instance can call it directly from the class name

    }




}
