import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by andrewwong on 5/31/17.
 */
public class Parser {

    public Stream<String> getRawDataStream() throws IOException{
        Stream<String> rawDataStream = Files.lines(Paths.get("RawData.txt"));
        return rawDataStream;
    }

    public static Stream<String> getItemStringsStream(String rawDataString) {
        CharSequence rawDataSequence = rawDataString.toString();
        return Pattern.compile(".+?(?=##)").splitAsStream(rawDataSequence);
    }

//    public Stream<String> getItemStringsStream(Stream<String> rawDataStream) {
//        Stream<String> itemStringsStream = Stream.of(rawDataStream.)
//    }

//    public Stream<String> getFirstItemAsStream(Stream<String> rawDataStream) {
//         firstItemStream = Stream.of(rawDataStream.findFirst());
//    }
}
