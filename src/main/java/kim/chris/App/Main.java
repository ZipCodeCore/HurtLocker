package kim.chris.App;

import kim.chris.Parser.Parser;
import org.apache.commons.io.IOUtils;

import java.io.PrintWriter;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        PrintWriter out = new PrintWriter("finished.txt");
        out.println(Parser.parseJerk(output));
        out.close();
    }
}
