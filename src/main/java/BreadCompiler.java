import java.util.ArrayList;

public class BreadCompiler {
    ItemCounter itemCounter = new ItemCounter();
    PriceParser priceParser = new PriceParser();
    StringParser stringParser = new StringParser();

    public String breadCompiler() throws Exception {
        String[] listArray = stringParser.stringParser();
        String breadPattern = "[Bb][Rr][Ee][Aa][Dd]";
        StringBuilder sb = new StringBuilder();
        ArrayList<String> parsedPrices= priceParser.priceParser(listArray,breadPattern);




        sb.append(itemCounter.itemCounter(listArray,breadPattern,"Bread")).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));
        sb.append(priceParser.priceCounter(parsedPrices,"1.23")).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));

        return sb.toString();
    }


}
