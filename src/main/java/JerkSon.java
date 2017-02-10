import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by prestonbattin on 2/9/17.
 */
public class JerkSon {

    public String[] delimiterSplit(String file){
        return  file.split("(##)");
    }


    public String[] kVLineSplitter(String line){
        return line.split("[;|^|@|!|*|%]");
    }


    public String[] getFields(String[] feilds, Pattern[] patterns){

        String[] s = new String[4];
       Matcher name = patterns[0].matcher(feilds[0]);
       Matcher price = patterns[1].matcher(feilds[1]);
       Matcher type = patterns[2].matcher(feilds[2]);
       Matcher exp = patterns[3].matcher(feilds[3]);

       if(name.find())
       s[0] = name.group();
       else
           s[0] = "Bad";

       if(price.find())
       s[1] = price.group();
       else
           s[1] = "Bad";

       if(type.find())
       s[2] = type.group();
       else
           s[2] = "Bad";

       if(exp.find())
       s[3] = exp.group();
       else
           s[3] = "Bad";

       return s;
    }

    public GroceryItem makeGroceryItem(String[] fields){

        return new GroceryItem(fields[0], fields[1], fields[2], fields[3]);
    }

    public GroceryItem[] makeGroceryItemsArray(List<String[]> yolo){

        GroceryItem[] temp = new GroceryItem[yolo.size()];

        for( int i = 0; i < temp.length; i++){

            temp[i] = makeGroceryItem(getFields(yolo.get(i), Regex.patternArray));
        }
        return temp;
    }

    public List<String[]> makeList(String file){

        List<String[]> temp = new ArrayList<String[]>();

        String[] allDirtyData = delimiterSplit(file);

        for(String s: allDirtyData){

            temp.add(kVLineSplitter(s));
        }

        return temp;
    }


}
