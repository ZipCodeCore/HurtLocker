import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String readRawDataToString() {

        String result = null;
        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println((new Main()).readRawDataToString());
        OutputResults printer = new OutputResults();
        printer.printAllItems();
    }
}


