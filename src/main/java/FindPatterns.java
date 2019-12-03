import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPatterns {
    private Integer errors = 0;
    CleanTheJerk cleaner = new CleanTheJerk();
    ArrayList<String> itemWords;
    ArrayList<String> validData;
    ArrayList<GroceryObjects> groceryObjectsList;



    public Integer count() {
        Pattern pattern = Pattern.compile("##");
        String[] myRawData = pattern.split(HurtLocker.loadFile());
        return myRawData.length;
    }

    public String[] splitToWordsArray() {
        //String [] rawData = loadFile().split("##");
        Pattern pattern = Pattern.compile("([:!;*^@])| (\\##)");
        String[] myRawDataArray = pattern.split(HurtLocker.loadFile());
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


    public ArrayList<String> getFodNames() {
        ArrayList<String> foodNames = new ArrayList<>();
        //Pattern p = Pattern.compile("[:!;*^@]");
        for (int i = 0; i < cleaner.splitToItems().length; i++) {
            //String [] fields = p.split(splitToPairs()[i]);
            Pattern splitToWords = Pattern.compile("[:!;*^@]");
            String[] splitToWordsArray = splitToWords.split(cleaner.splitToItems()[i]);
            for (int j = 0; j < splitToWordsArray.length; j++) {
                foodNames.add(splitToWordsArray[2]);
            }
        }
        for (int i = 0; i < foodNames.size(); i++) {
            String s = foodNames.get(i);
            System.out.println(s);
        }
        return foodNames;

    }

    public Integer errors() {
        String[] items = cleaner.splitToItems();
        for (int i = 0; i < items.length; i++) {
            Pattern errorPattern = Pattern.compile(":;");
            Matcher errorMatcher = errorPattern.matcher(items[i]);
            if(errorMatcher.find()){
                errors++;
            }
        }
        return errors;
    }

   public void separateToWords () {
        String [] pairs = cleaner.splitToItems();
        String [] singleWords = new String[0];
           for (int i = 0; i < pairs.length; i++) {
               Pattern splitToWords = Pattern.compile("[:!;*^@]");
               singleWords = splitToWords.split(pairs[i]);
           }
           for (int i = 0; i < singleWords.length; i++) {
               System.out.println(singleWords);

           }

       }

   public ArrayList<String> findValidData () {
           String[] pairs = cleaner.splitToItems();
           validData = new ArrayList<>(Arrays.asList(pairs));

           ArrayList<String> allWords = new ArrayList<>();
           for (int i = 0; i < validData.size(); i++) {
               String item = pairs[i];
               Pattern splitToWords = Pattern.compile(":");
               String[] itemsSeparated = splitToWords.split(item);
               if (itemsSeparated.length != 8) {
                   validData.remove(i);
               }

           }
           return null;
       }

   public ArrayList<GroceryObjects> createGroceryObjects () {
       String[] pairs = cleaner.splitToItems();
       groceryObjectsList = new ArrayList<>();
       for (int i = 0; i < pairs.length; i++) {
           Pattern names = Pattern.compile("([nN][aA][mM][Ee]:)([a-zA-Z]+)([:!;*^@])([pP][rR][iI][cC][Ee]:)(\\d\\.\\d\\d)");
           Matcher m = names.matcher(pairs[i]);
           while (m.find()) {
               groceryObjectsList.add(new GroceryObjects(m.group(2), m.group(5)));
               System.out.println("I've been added!");
           }
           }

           return groceryObjectsList;
       }

   public void printResults () {
        ArrayList<GroceryObjects> resultsToPrint = createGroceryObjects();
        for (int i = 0; i < resultsToPrint.size(); i++) {
           System.out.println(resultsToPrint.get(i).toString());
           System.out.println(resultsToPrint.size());
       }
   }


   public void matchNames () {
           String [] pairs = cleaner.splitToItems();
           ArrayList pairsList = new ArrayList();
           for (int i = 0; i < pairs.length; i++) {
               String s = pairs[i];
               Pattern names = Pattern.compile("/([name:]) ([a-z])=\\1/", Pattern.CASE_INSENSITIVE);
               Matcher m = names.matcher(s);
               if (m.find()){
                   pairsList.add(m.group(2));
               }

           }
           for (int i = 0; i < pairsList.size(); i++) {
               String pair = pairs[i];

           }
           System.out.println(pairsList);

       }

}


//
//
//
//                   Pattern names = Pattern.compile("[name:]", Pattern.CASE_INSENSITIVE);
//                   Matcher m = names.matcher(splitToWordsArray[i]);
//                   if (m.matches())
//
//
//               }
//           }

//        for (int i = 0; i < foodNames.size(); i++) {
//             String s = foodNames.get(i);
//             System.out.println(s);
//        }

       //return foodNames;
    //}
//    Pattern names = Pattern.compile("/([name:]) ([a-z])=\\1/", Pattern.CASE_INSENSITIVE);
//    Matcher m = names.matcher(splitToPairs()[i]);








