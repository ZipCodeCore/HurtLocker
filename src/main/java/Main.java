import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class Main {

    private String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public static void main(String[] args) throws Exception{
        Main driver=new Main();
        driver.start();
    }

    private void start() throws Exception {
        ItemParser itemParser=new ItemParser();
        Output output=new Output();
        ArrayList<String> data=itemParser.jerkSonParser(readRawDataToString());
        ArrayList<Item> items=itemParser.storeData(data);
        output.printTable(items);
    }


}
