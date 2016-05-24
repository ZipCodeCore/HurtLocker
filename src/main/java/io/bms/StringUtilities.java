package io.bms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by samhudgens on 5/24/16.
 */
public class StringUtilities {

    public static String[] parseStringArray(String input){

        return input.split("##");
    }

    public static String[] splitStringIntoKeyValuePairs(String input){
        return input.split("[^a-zA-Z0-9\\\\:./]");
    }


    public static String grabKey(String testCase){
        Matcher matcher = Pattern.compile("^[^:]+\\s*?",Pattern.CASE_INSENSITIVE).matcher(testCase);
        matcher.find();

        return matcher.group();
    }

    public static String grabValue(String testCase) throws Error {
        Matcher matcher = Pattern.compile("[^:]*$",Pattern.CASE_INSENSITIVE).matcher(testCase);
        matcher.find();
        Matcher noValue = Pattern.compile("^$").matcher(matcher.group());
        if(noValue.find()){
            throw new Error("Missing Value");
        }
        return matcher.group();
    }

    public static String spellingCorrector(String testCase){
        Matcher matcher = Pattern.compile("0",Pattern.CASE_INSENSITIVE).matcher(testCase);
        matcher.find();
        return  matcher.replaceAll("o");
    }

    public static String normalizeWord(String input){
        return input.toLowerCase();
    }

}
