import java.util.ArrayList;

public class MilkCompiler {
    ItemCounter itemCounter = new ItemCounter();
    PriceParser priceParser = new PriceParser();
    StringParser stringParser = new StringParser();

    public String milkCompiler() throws Exception {
        String[] listArray = stringParser.stringParser();
        String milkPattern = "[Mm][Ii][Ll][Kk]";
        StringBuilder sb = new StringBuilder();
        ArrayList<String> parsedPrices= priceParser.priceParser(listArray,milkPattern);




        sb.append(itemCounter.itemCounter(listArray,milkPattern,"Milk")).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));
        sb.append(priceParser.priceCounter(parsedPrices,"3.23")).append("\n");
        sb.append(priceParser.priceCounter(parsedPrices,"1.23")).append("\n");
        sb.append(String.format("%-16s %16s", "=============", "========\n"));

        return sb.toString();
    }


}
