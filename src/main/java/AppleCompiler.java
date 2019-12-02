import java.util.ArrayList;

public class AppleCompiler {
    ItemCounter itemCounter = new ItemCounter();
    PriceParser priceParser = new PriceParser();
    StringParser stringParser = new StringParser();

    public String applesCompiler() throws Exception {
        String[] listArray = stringParser.stringParser();
        String applePattern = "[Aa][Pp][Pp][Ll][Ee][Ss]";
        StringBuilder sb = new StringBuilder();
        ArrayList<String> parsedPrices= priceParser.priceParser(listArray,applePattern);




        sb.append(itemCounter.itemCounter(listArray,applePattern,"Apples")).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));
        sb.append(priceParser.priceCounter(parsedPrices,"0.23")).append("\n");
        sb.append(priceParser.priceCounter(parsedPrices,"0.25")).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));

        return sb.toString();
    }


}
