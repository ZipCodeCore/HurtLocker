import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
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
        namesStream = itemStringStream.peek( iS ->  getName(iS) );
        return null;
    }

    private Stream<String> getName(String iS) {
        //find regex for String after name:, before symbol
        Pattern pattern = Pattern.compile("regex");
        return pattern.splitAsStream(iS);
    }

    // used to see elements in stream for debugging purposes
    public static String[] getItemStringsArray(String rawDataString) {
        Pattern pattern = Pattern.compile("##");
        return pattern.split(rawDataString);
    }

//    public Stream<String> getRawDataStream() throws IOException{
//        Stream<String> rawDataStream = Files.lines(Paths.get("RawData.txt"));
//        return rawDataStream;
//    }


}
