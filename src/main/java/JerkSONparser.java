import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by johncollins on 2/8/17.
 */
public class JerkSONparser
{
    public ArrayList<String> byGroups(String txt)
    {
        ArrayList<String> groupArray = new ArrayList<String>();
        Pattern groups = Pattern.compile("[^#]+?(?=##)");
        Matcher groupMatch = groups.matcher(txt);

        //StringBuffer result = new StringBuffer();
        while (groupMatch.find())
        {
            //result.append(groupMatch.group());
            groupArray.add(groupMatch.group());
        }
        //return result.toString();
        //return groupMatch.group();
        return groupArray;

    }

    public ArrayList<String> extractItems(ArrayList<String> groups)
    {
        ArrayList<String> keysValuesArray = new ArrayList<String>();

        for (String group : groups
                )
        {
            Pattern items = Pattern.compile("[^;|:|!|#|%|^]+?(?=([;|:|!|#|%|^]))");
            Matcher itemMatch = items.matcher(group);

            //StringBuffer result = new StringBuffer();
            while (itemMatch.find()){
                keysValuesArray.add(itemMatch.group());
            }
        }
        return keysValuesArray;
    }

}
