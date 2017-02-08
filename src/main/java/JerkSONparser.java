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

        StringBuffer result = new StringBuffer();
        while (groupMatch.find())
        {
            //result.append(groupMatch.group());
            groupArray.add(groupMatch.group());
        }
        //return result.toString();
        //return groupMatch.group();
        return groupArray;

    }

    public ArrayList<String> extractMilk(ArrayList<String> groups)
    {
        ArrayList<String> milksArray = new ArrayList<String>();

        for (String milk : milksArray
                )
        {
            Pattern milks = Pattern.compile("[^#]+?(?=##)");
            Matcher milkMatch = milks.matcher(milk);
        }
        return null;
    }

}
