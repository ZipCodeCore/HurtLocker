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
        parsedString = matcher.replaceAll("{name");


        Pattern pattern1 = Pattern.compile("(?i)(##)");
        Matcher matcher1 = pattern1.matcher(parsedString);
        parsedString = matcher1.replaceAll("},\n");

        Pattern cookies = Pattern.compile("(?i)(C[o0][o0]kies[;])");
        Matcher matcherCookies = cookies.matcher(parsedString);
        parsedString = matcherCookies.replaceAll("Cookies,");

        Pattern milk = Pattern.compile("(?i)(milk[;])");
        Matcher matcherMilk = milk.matcher(parsedString);
        parsedString = matcherMilk.replaceAll("Milk,");

        Pattern bread = Pattern.compile("(?i)(bread[;])");
        Matcher matcherBread = bread.matcher(parsedString);
        parsedString = matcherBread.replaceAll("Bread,");

        Pattern apple = Pattern.compile("(?i)(apples)");
        Matcher matcherApple = apple.matcher(parsedString);
        parsedString = matcherApple.replaceAll("Apples");

        Pattern pattern5 = Pattern.compile("(?i)[;,](price)");
        Matcher matcher5 = pattern5.matcher(parsedString);
        parsedString = matcher5.replaceAll(",price");

        Pattern pattern6 = Pattern.compile("(?i)(;type)");
        Matcher matcher6 = pattern6.matcher(parsedString);
        parsedString = matcher6.replaceAll(",type");

        Pattern pattern7 = Pattern.compile("(?i)(food)[!;@^*%]");
        Matcher matcher7 = pattern7.matcher(parsedString);
        parsedString = matcher7.replaceAll("Food,");

        return  parsedString;
    }


}
