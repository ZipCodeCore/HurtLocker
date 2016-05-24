package io.MMJ;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {

    public static String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public static void main(String[] args) throws Exception{
        ItemParser itemParser = new ItemParser();
        String currenttext= "";
        currenttext = readRawDataToString();
        //System.out.println(currenttext);
        //currenttext=itemParser.regexTest(currenttext);
        //currenttext=itemParser.correctSpelling(currenttext);

        currenttext=itemParser.correctName(currenttext);
        currenttext=itemParser.correctExpiration(currenttext);
        currenttext=itemParser.correctType(currenttext);
        currenttext=itemParser.correctPrice(currenttext);

        currenttext=itemParser.correctMilk(currenttext);
        currenttext=itemParser.correctBread(currenttext);
        currenttext=itemParser.correctCookies(currenttext);
        currenttext=itemParser.correctApples(currenttext);
        currenttext=itemParser.correctFood(currenttext);
        //System.out.println(currenttext);
        ArrayList<Item> allItems = itemParser.deserializeItem(currenttext);
        itemParser.printResults(allItems);
        System.out.println(itemParser.formatResults());
    }
}
