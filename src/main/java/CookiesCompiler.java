import java.util.ArrayList;

public class CookiesCompiler {
    ItemCounter itemCounter = new ItemCounter();
    PriceParser priceParser = new PriceParser();
    StringParser stringParser = new StringParser();

    public String cookiesCompiler() throws Exception {
        String[] listArray = stringParser.stringParser();
        String cookiesPattern = "[Cc][0oO][Oo0][Kk][Ii][Ee][Ss]";
        StringBuilder sb = new StringBuilder();
        ArrayList<String> parsedPrices= priceParser.priceParser(listArray,cookiesPattern);




        sb.append(itemCounter.itemCounter(listArray,cookiesPattern,"Cookies")).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));
        sb.append(priceParser.priceCounter(parsedPrices,"2.25")).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));

        return sb.toString();
    }


}
