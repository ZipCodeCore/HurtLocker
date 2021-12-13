import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println("Raw Data:");
        System.out.println(output + "\n");
        System.out.println("Regexed & Encapsulated:");
        List<Item> items = RegexThis.regexer(output);
        System.out.println(items + "\n");
        System.out.println("Summarization: ");
        System.out.println(Summarization.summarize(items));

    }
}
