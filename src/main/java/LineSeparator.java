import java.util.ArrayList;

public class LineSeparator {

    public static String[] separateTextAtNewLines(String text) {
        String[] lines = text.split("##");
        return lines;
    }
}
