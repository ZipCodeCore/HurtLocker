import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
  private  String groceryListData;

    public Parser() {
        this.groceryListData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String dataParser(){
        String parsedString = "";
        Pattern pattern = Pattern.compile("(?i)(name)");
        Matcher matcher = pattern.matcher(loadFile());
        parsedString = matcher.replaceAll("name");


        Pattern pattern1 = Pattern.compile("(?i)(##)");
        Matcher matcher1 = pattern1.matcher(parsedString);
        parsedString = matcher1.replaceAll(",\n");

        Pattern pattern2 = Pattern.compile("(?i)(C[o0][o0]kies[;])");
        Matcher matcher2 = pattern2.matcher(parsedString);
        parsedString = matcher2.replaceAll("Cookies,");

        return  parsedString;
    }


}
