import java.util.regex.Pattern;

/**
 * Created by prestonbattin on 2/9/17.
 */
public class Regex {


    static Pattern nameDelimiter = Pattern.compile("(?<=[:])\\w+");
    static Pattern priceDelimiter = Pattern.compile("(?<=[:])\\d+\\W\\d+");
    static Pattern typeDelimiter = Pattern.compile("(?<=[:])[fF]\\w+\\b");
    static Pattern expirationDelimiter = Pattern.compile("(?<=[:])\\d+/\\d+/\\d+\\b");


    static Pattern[] patternArray = {nameDelimiter, priceDelimiter,
            typeDelimiter, expirationDelimiter};

    static Pattern milk = Pattern.compile("[mM][iI][lL][kK]");
    static Pattern apples = Pattern.compile("[aA][pP][pP][lL][eE][sS]");
    static Pattern bread = Pattern.compile("[bB][rR][eE][aA][dD]");
    static Pattern cookies = Pattern.compile("[cC][oO0][oO0][kK][iI][eE][sS]");

    static Pattern price323 = Pattern.compile("[3][.][2][3]");
    static Pattern price123 = Pattern.compile("[1][.][2][3]");
    static Pattern price225 = Pattern.compile("[2][.][2][5]");
    static Pattern price25 = Pattern.compile("[.][2][5]");
    static Pattern price23 = Pattern.compile("[.][2][3]");

}
