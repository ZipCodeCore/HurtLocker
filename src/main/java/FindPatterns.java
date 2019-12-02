import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPatterns {
    private Integer errors = 0;

//    @Override
//    public String toString() {
//        return "FindPatterns{" +
//                "errors=" + errors +
//                ", matcher=" + matcher +
//                ", nameValues=" + nameValues +
//                ", findName=" + findName +
//                '}';
//    }

    public String loadFile() {
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


//    public Integer findNumOfItems () {
//        Integer numOfItems = 0;
//        Matcher matcher;
//        Pattern findItems = Pattern.compile( "[food]", Pattern.CASE_INSENSITIVE);
//        matcher = findItems.matcher(loadFile());
//        return null;
//    }

    public Integer count() {
        Pattern pattern = Pattern.compile("##");
        String [] myRawData = pattern.split(loadFile());
        return myRawData.length;

        //String[] rawData = loadFile().split("##");
        //Long count = Arrays.stream(rawData).filter(word -> word.toLowerCase().contains("food")).count();


//        for (int i = 0; i < rawData.length; i++){
//            System.out.println(rawData.toString());
//        }
        //return count.intValue();
        //System.out.println(rawData);
    }

    public String[] findValueName() {
        //String [] rawData = loadFile().split("##");
        Pattern pattern = Pattern.compile("[:;*^@#]");
        String [] myRawDataArray = pattern.split(loadFile());
        //String[] rawDataArray = loadFile().split("[:;*^@#]");
//        String [] individual;
//        for (int i = 0; i < rawDataArray.length; i++) {
//            individual = rawDataArray[i].split("[:;*^@]" );
//            System.out.println(rawDataArray[i].toString());;
//        }
//        for (int i = 0; i < rawData.length; i++)
//            rawData[i].split("[])
//        }
//        Matcher matcher;
//        ArrayList<String> nameValues = new ArrayList<>();
//        Pattern findName = Pattern.compile("[name]", Pattern.CASE_INSENSITIVE);
//        matcher = findName.matcher(loadFile());
        for (int i = 0; i < myRawDataArray.length; i++) {
            String s = myRawDataArray[i];
            System.out.println(s);
        }
        return myRawDataArray;
    }
    public ArrayList<String> findNames (){
        ArrayList<String> names = new ArrayList<>();
//        Pattern p = Pattern.compile("/([name]) = ([a-z)\\)/), Pattern.CASE_INSENSITIVE);
//        Matcher m;
//        m = p.matcher(loadFile());
return null;
    }

}







