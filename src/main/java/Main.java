import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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
        String toTest = "";
        try{
            toTest = Main.readRawDataToString();
        } catch(JerkSONException e){

        }
        toTest = JerkSONParser.replaceZeroesWithOs(toTest);
        toTest = JerkSONParser.capitalizeFirstLetter(toTest);
        System.out.println(toTest);
        toTest = JerkSONParser.lowercaseNonFirstLetters(toTest);
        System.out.println(toTest);
        String [] items = JerkSONParser.splitJerkSONByItem(toTest);
        Arrays.sort(items);


        String[][] fields = JerkSONParser.splitJerkSONByField(items);
        for(String[] item : fields){
            for(String field : item){
                System.out.print(field);
            }
            System.out.println();

        }


    }
}
