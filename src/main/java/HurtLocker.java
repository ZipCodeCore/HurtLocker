import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HurtLocker {
    public String rawData;

    public static String loadFile() {
        File file = new File("/Users/david/Desktop/TrombelloProjects/IntelliJ Labs/HurtLocker/src/main/resources/RawData.txt");
        StringBuilder rawData = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                rawData.append(line);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawData.toString();
    }



}
