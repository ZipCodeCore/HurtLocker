package collins.john;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by johncollins on 2/8/17.
 */
public class JerkSONparser
{
    public ArrayList<String> separateByGroups(String txt)
    {
        ArrayList<String> groupArray = new ArrayList<String>();
        //ArrayList<ArrayList> keysXvaluesArray = new ArrayList<ArrayList>();

        Pattern groups = Pattern.compile("[^#]+");
        Matcher groupMatch = groups.matcher(txt);

        //StringBuffer result = new StringBuffer();
        while (groupMatch.find())
        {
            //groupArray = new ArrayList<String>();
            //result.append(groupMatch.group());
            groupArray.add(groupMatch.group());
            //keysXvaluesArray.add(groupArray);
        }

        return groupArray;

    }


    public String correctStringsFromByGroups(ArrayList<String> groupArray)
    {
        String workingString = "";
        for (int i = 0; i < groupArray.size(); i++)
        {
            workingString = groupArray.get(i);
            //punctuation
            Pattern puncPattern = Pattern.compile("[;|!|%|^|@|*]");
            Matcher puncMatcher = puncPattern.matcher(workingString);

            StringBuffer puncBuffer = new StringBuffer();
            while (puncMatcher.find())
            {
                puncMatcher.appendReplacement(puncBuffer, ",");
            }
            puncMatcher.appendTail(puncBuffer);
            workingString = puncBuffer.toString();


            //name
            Pattern namePattern = Pattern.compile("((?i)(n.{2}e))");
            Matcher nameMatcher = namePattern.matcher(workingString);

            StringBuffer nameBuffer = new StringBuffer();
            while (nameMatcher.find())
            {
                nameMatcher.appendReplacement(nameBuffer, "name");
            }
            nameMatcher.appendTail(nameBuffer);
            workingString = nameBuffer.toString();

            //price
            Pattern pricePattern = Pattern.compile("(?i)(p.{3}e)");
            Matcher priceMatcher = pricePattern.matcher(workingString);

            StringBuffer priceBuffer = new StringBuffer();
            while (priceMatcher.find())
            {
                priceMatcher.appendReplacement(priceBuffer, "Price");
            }
            priceMatcher.appendTail(priceBuffer);
            workingString = priceBuffer.toString();

            //type
            Pattern typePattern = Pattern.compile("(?i)(t.{2}e)");
            Matcher typeMatcher = typePattern.matcher(workingString);

            StringBuffer typeBuffer = new StringBuffer();
            while (typeMatcher.find())
            {
                typeMatcher.appendReplacement(typeBuffer, "type");
            }
            typeMatcher.appendTail(typeBuffer);
            workingString = typeBuffer.toString();

            //expiration
            Pattern expPattern = Pattern.compile("(?i)(e.{8}n)");
            Matcher expMatcher = expPattern.matcher(workingString);
            StringBuffer expBuffer = new StringBuffer();
            while (expMatcher.find())
            {
                expMatcher.appendReplacement(expBuffer, "expiration");
            }
            expMatcher.appendTail(expBuffer);
            workingString = expBuffer.toString();

//add values spelling here
            //Apples
            Pattern applesPattern = Pattern.compile("((?i)(a.{4}s))");
            Matcher applesMatcher = applesPattern.matcher(workingString);

            StringBuffer applesBuffer = new StringBuffer();
            while (applesMatcher.find())
            {
                applesMatcher.appendReplacement(applesBuffer, "Apples");
            }
            applesMatcher.appendTail(applesBuffer);
            workingString = applesBuffer.toString();

            //Milk
            Pattern milkPattern = Pattern.compile("((?i)(m.{2}k))");
            Matcher milkMatcher = milkPattern.matcher(workingString);

            StringBuffer milkBuffer = new StringBuffer();
            while (milkMatcher.find())
            {
                milkMatcher.appendReplacement(milkBuffer, "Milk");
            }
            milkMatcher.appendTail(milkBuffer);
            workingString = milkBuffer.toString();

            //Bread
            Pattern breadPattern = Pattern.compile("(?i)(b.{3}d)");
            Matcher breadMatcher = breadPattern.matcher(workingString);

            StringBuffer breadBuffer = new StringBuffer();
            while (breadMatcher.find())
            {
                breadMatcher.appendReplacement(breadBuffer, "Bread");
            }
            breadMatcher.appendTail(breadBuffer);
            workingString = breadBuffer.toString();

            //Cookies
            Pattern cookiesPattern = Pattern.compile("(?i)(c.{5}s)");
            Matcher cookiesMatcher = cookiesPattern.matcher(workingString);

            StringBuffer cookiesBuffer = new StringBuffer();
            while (cookiesMatcher.find())
            {
                cookiesMatcher.appendReplacement(cookiesBuffer, "Cookies");
            }
            cookiesMatcher.appendTail(cookiesBuffer);
            workingString = cookiesBuffer.toString();

            //Food
            Pattern foodPattern = Pattern.compile("(?i)(f.{2}d)");
            Matcher foodMatcher = foodPattern.matcher(workingString);
            StringBuffer foodBuffer = new StringBuffer();
            while (foodMatcher.find())
            {
                foodMatcher.appendReplacement(foodBuffer, "Food");
            }
            foodMatcher.appendTail(foodBuffer);
            workingString = foodBuffer.toString();

            groupArray.set(i, workingString);

        }
        return groupArray.toString();

    }


    public ArrayList<Map<String, String>> convertGroupsToMaps(ArrayList<String> groupsArray)
    {
        String temp1;
        String temp2 = "";
        ArrayList<Map<String, String>> groupsMapsArray = new ArrayList<Map<String, String>>();
        Map<String, String> itemMap;
        String workingString;
        //String itemString;
        for (int i = 0; i < groupsArray.size(); i++)

        {
            workingString = groupsArray.get(i);
            HashMap<String, String> tempMap = new HashMap<String, String>();
            Pattern pairPattern = Pattern.compile("[^,]+");
            Matcher pairMatcher = pairPattern.matcher(workingString);
            while (pairMatcher.find())
            {
                workingString = pairMatcher.group();
                Pattern kXvPattern = Pattern.compile("[^:]+");
                Matcher kXvMatcher = kXvPattern.matcher(workingString);
                while (kXvMatcher.find())
                {
                    temp1 = kXvMatcher.group();
                    if (tempMap.containsKey(temp2))
                    {
                        tempMap.put(temp2, temp1);
                        temp1 = "";
                        temp2 = temp1;
                    } else
                    {
                        tempMap.put(temp1, temp1);
                        temp2 = temp1;
                    }
                }
            }
            itemMap = tempMap;
            groupsMapsArray.add(itemMap);
        }
        return groupsMapsArray;
    }
}



