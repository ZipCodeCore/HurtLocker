import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {

    public static String readRawDataToString() throws JerkSONException{
        Path path = null;
        try {
            path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        } catch(URISyntaxException e){
            System.err.println(e.getMessage());
        }
        try {
            return new String(readAllBytes(get(path.toUri())));
        } catch (IOException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Main mainString = new Main();


    }
}
