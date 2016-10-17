package crawley.james.hurtlocker;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {

    public String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public static void main(String[] args) throws Exception{

        Main main = new Main();
        String raw = main.readRawDataToString();
        JerkSONParser parser = new JerkSONParser(raw);

        while (parser.hasNext()) {
            try {
                parser.parseItem();
                parser.putItem();
            } catch (DataMissingException e) {
                parser.next();
            }

        }

        System.out.println(parser.printGroceryList());
    }
}
