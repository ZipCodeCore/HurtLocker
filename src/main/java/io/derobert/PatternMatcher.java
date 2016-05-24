package io.derobert;

import java.util.regex.Pattern;

public class PatternMatcher {
    private static Pattern milkPattern = Pattern.compile("(?i)milk");
    private static Pattern breadPattern = Pattern.compile("(?i)bread");
    private static Pattern cookiesPattern = Pattern.compile("(?i)c(o|0)(o|0)kies");
    private static Pattern applesPattern = Pattern.compile("(?i)apples");
    private static Pattern namePattern = Pattern.compile("(?i)name");
    private static Pattern pricePattern = Pattern.compile("(?i)price");

    public static boolean foodIsMilk(String food){
        return milkPattern.matcher(food).matches();
    }

    public static boolean foodIsBread(String food){
        return breadPattern.matcher(food).matches();
    }

    public static boolean foodIsCookies(String food){
        return cookiesPattern.matcher(food).matches();
    }

    public static boolean foodIsApples(String food){
        return applesPattern.matcher(food).matches();
    }

    public static boolean stringIsName(String string){ return namePattern.matcher(string).matches(); }

    public static boolean stringIsPrice(String string){ return pricePattern.matcher(string).matches(); }
}
