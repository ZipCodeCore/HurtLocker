/*import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsedList {


    static String rawDataStuff;
    public ParsedList() {this.rawDataStuff = uploadedFile();}

    private String uploadedFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch(IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    public  static String getRawDataStuff() {
        return rawDataStuff;
    }

    public String parsedString() {
        if (this.rawDataStuff.matches("m.+k")){return "MIlk";}
        else if (this.rawDataStuff.matches("br.+d")){return "Bread";}
        else if (this.rawDataStuff.matches("c.+s")){return "Cookies";}
        else {return "Apples";}

    }
    public String milkMatch() {
        Pattern pattern = Pattern.compile("m.+k");
        Matcher matcher = pattern.matcher(rawDataStuff);
        boolean matchFound = matcher.find();
    }









}*/
