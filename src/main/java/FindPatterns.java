
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPatterns {
    private CleanTheJerk cleaner = new CleanTheJerk();
    private ArrayList<String> itemWords;
    private ArrayList<String> validData;
    private ArrayList<GroceryObjects> groceryObjectsList;


    public Integer count() {
        Pattern pattern = Pattern.compile("##");
        String[] myRawData = pattern.split(HurtLocker.loadFile());
        return myRawData.length;
    }

    public String[] splitToWordsArray() {
        //String [] rawData = loadFile().split("##");
        Pattern pattern = Pattern.compile("([:!;*^@])(##)");
        String[] myRawDataArray = pattern.split(HurtLocker.loadFile());
        for (int i = 0; i < myRawDataArray.length; i++) {
            String s = myRawDataArray[i];
            System.out.println(s);
        }
        return myRawDataArray;
    }

    public Integer errors() {
        Integer totalItemsInList = count();
        ArrayList<GroceryObjects> validItems = createGroceryObjects();
        return totalItemsInList - validItems.size();

//        for (int i = 0; i < items.length; i++) {
//            Pattern errorPattern = Pattern.compile(":;");
//            Matcher errorMatcher = errorPattern.matcher(items[i]);
//            if(errorMatcher.find()){
//                errors++;
//            }
//        }
//        return errors;
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

   public ArrayList<GroceryObjects> createGroceryObjects () {
       String[] pairs = cleaner.splitToItems();
       groceryObjectsList = new ArrayList<>();
       for (int i = 0; i < pairs.length; i++) {
           Pattern names = Pattern.compile("([nN][aA][mM][Ee]:)([a-zA-Z0]+)([:!;*^@])([pP][rR][iI][cC][Ee]:)(\\d\\.\\d\\d)");
           Matcher m = names.matcher(pairs[i]);
           while (m.find()) {
               groceryObjectsList.add(new GroceryObjects(m.group(2), m.group(5)));
           }
       }
       //System.out.println(groceryObjectsList);
       return groceryObjectsList;
   }

   public void printResults () {
        ArrayList<GroceryObjects> resultsToPrint = createGroceryObjects();
        for (int i = 0; i < resultsToPrint.size(); i++) {
           System.out.println(resultsToPrint.get(i).toString());
       }
   }
}









