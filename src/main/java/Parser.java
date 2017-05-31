import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by andrewwong on 5/31/17.
 */
public class Parser {

    public String readRawDataToString() throws IOException{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public Stream<String> getItemStringsStream(String rawDataString) {
        Pattern pattern = Pattern.compile("##");
        return pattern.splitAsStream(rawDataString);
    }

    public Stream<String> getNamesStream(Stream<String> itemStringStream) {
        Stream<String> namesStream;
        namesStream = itemStringStream.flatMap( iS ->  getItemName(iS) );
        return namesStream;
    }

    private Stream<String> getItemName(String itemString) {
        String[] names = new String[1];

        Pattern p = Pattern.compile("([Nn][Aa][Mm][Ee]:)(\\w+)");
        Matcher m = p.matcher(itemString);

        while (m.find()) {
            System.out.println(m.group(2).replaceAll("0", "o").toLowerCase());
            names[0] = m.group(2).replaceAll("0", "o").toLowerCase();
        }
        return Arrays.stream(names);
    }

    public Stream<String> getPricesStream(Stream<String> itemStringStream) {
        Stream<String> namesStream;
        namesStream = itemStringStream.flatMap( iS ->  getItemPrice(iS) );
        return namesStream;
    }

    private Stream<String> getItemPrice(String itemString) {
        String[] prices = new String[1];

        Pattern p = Pattern.compile("([Pp][Rr][Ii][Cc][Ee]:)(\\d+\\.\\d+)");
        Matcher m = p.matcher(itemString);


        while (m.find()) {
            System.out.println(m.group(2));
            prices[0] = m.group(2);
        }
        return Arrays.stream(prices);
    }

    // used to see elements in stream for debugging purposes
    public static String[] getItemStringsArray(String rawDataString) {
        Pattern pattern = Pattern.compile("##");
        return pattern.split(rawDataString);
    }

}
