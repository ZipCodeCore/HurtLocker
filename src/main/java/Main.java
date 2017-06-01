import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

//    public static void main(String[] args) throws Exception{
//        String output = (new Main()).readRawDataToString();
//        System.out.println(output);
//
//    }

    public static void main(String[] args) throws Exception{
        Parser parser = new Parser();
        String rawDataString = (new Main()).readRawDataToString();
        Stream<String> itemStringStream = parser.getItemStringsStream(rawDataString);
        Stream<String> nameStream = parser.getNamesStream(itemStringStream);
        itemStringStream = parser.getItemStringsStream(rawDataString);
        Stream<String> priceStream = parser.getPricesStream(itemStringStream);
        HashMap<String, ArrayList<String>> itemMap = MapFactory.createItemMap(nameStream, priceStream, 28);
        Receipt receipt = new Receipt(itemMap);
        System.out.println(receipt.toString());
    }
}
