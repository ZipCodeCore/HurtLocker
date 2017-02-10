package marwamilton;

import java.util.regex.Pattern;

/**
 * Created by mkulima on 2/8/17.
 */
public class GroceryRegexEngine {

    Pattern Milk = Pattern.compile("(\\b[m|M][i|I][l|L][k|K])");

    Pattern Bread = Pattern.compile("\\b[b|B][r|R][e|E][a|A][d|D]");

    Pattern Cookies = Pattern.compile("[c|C][0-9|o|O][0-9|o|O][k|K][i|I][e|E][s|S]");

    Pattern Apples = Pattern.compile("[a|A][p|P]{2}[l|L][e|E][s|S]\\b");

    Pattern BAD = Pattern.compile("[B][A][D]");

    Pattern M323 = Pattern.compile("\\b([3][\\.][2][3])");
    Pattern M123 = Pattern.compile("\\b([1][\\.][2][3])");
    Pattern C225 = Pattern.compile("\\b([2][\\.][2][5])");
    Pattern A025 = Pattern.compile("\\b([0][\\.][2][5])");
    Pattern A023 = Pattern.compile("\\b([0][\\.][2][3])");

    Pattern[] GroceryPatterns = new Pattern[]{Milk,Bread,Cookies,Apples};

    Pattern[] Prices = new Pattern[]{M323, M123, C225, A025, A023};

}
