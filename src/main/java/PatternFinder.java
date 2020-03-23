import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFinder {

    private Formater cleaner = new Formater();
    private ArrayList<String> itemWords;
    private ArrayList<String> validData;
    private ArrayList<Grocery> groceryObjectsList;


    public Integer count() {

        Pattern pattern = Pattern.compile("##");
        String[] myRawData = pattern.split(Main.formatedFile());
        return myRawData.length;
    }


    public Integer errors() {

        Integer total = count();
        ArrayList<Grocery> valid = createGroceryList();
        return total - valid.size();

    }


    public ArrayList<Grocery> createGroceryList () {

        String[] pairs = cleaner.splitItems();
        groceryObjectsList = new ArrayList<>();
        for (int i = 0; i < pairs.length; i++) {
            Pattern names = Pattern.compile("([nN][aA][mM][Ee]:)([a-zA-Z0]+)([:!;*^@])([pP][rR][iI][cC][Ee]:)(\\d\\.\\d\\d)");
            Matcher m = names.matcher(pairs[i]);
            while (m.find()) {
                groceryObjectsList.add(new Grocery(m.group(2), m.group(5)));
            }
        }

        return groceryObjectsList;
    }

//        public void printResults () {
//
//            ArrayList<Grocery> resultsToPrint = createGrocery();
//            for (int i = 0; i < resultsToPrint.size(); i++) {
//                System.out.println(resultsToPrint.get(i).toString());
//            }
//        }
}
