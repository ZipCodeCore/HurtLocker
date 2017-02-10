import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by johncollins on 2/8/17.
 */
public class JerkSONparser
{
    public ArrayList<ArrayList> byGroups(String txt)
    {
        ArrayList<String> groupArray;// = new ArrayList<String>();
        ArrayList<ArrayList> keysXvaluesArray = new ArrayList<ArrayList>();

        Pattern groups = Pattern.compile("[^#]+");
        Matcher groupMatch = groups.matcher(txt);

        //StringBuffer result = new StringBuffer();
        while (groupMatch.find())
        {
            groupArray = new ArrayList<String>();
            //result.append(groupMatch.group());
            groupArray.add(groupMatch.group());
            keysXvaluesArray.add(groupArray);
        }
        //return result.toString();
        //return groupMatch.group();
        return keysXvaluesArray;

    }

    public String formatItemsPunctuation(ArrayList<String> groupArray)
    {
        String fixedString = "";
        for (String txt : groupArray
                )
        {
            Pattern pPattern = Pattern.compile("[;|!|#|%|^|@]");
            Matcher mMatcher = pPattern.matcher(txt);

            StringBuffer result = new StringBuffer();
            while (mMatcher.find())
            {
                mMatcher.appendReplacement(result, ",");
            }
            mMatcher.appendTail(result);
            fixedString = result.toString();
        }
        return fixedString;
    }

    public String correctKeysSpelling(ArrayList<String> groupArray)
    {
        String workingString = "";
        for (String txt : groupArray
                )
        {   //name
            Pattern namePattern = Pattern.compile("((?i)(n.{2}e))");
            Matcher nameMatcher = namePattern.matcher(txt);

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


        }
        return workingString;
    }

    public String correctValuesSpelling(ArrayList<String> groupArray)
    {
        String workingString = "";
        for (String txt : groupArray
                )
        {   //Milk
            Pattern milkPattern = Pattern.compile("((?i)(m.{2}k))");
            Matcher milkMatcher = milkPattern.matcher(txt);

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


        }
        return workingString;

    }

    public ArrayList<String> itemXgroupParser(String completeJerkSON)//does not work as needed
    {

        ArrayList<String> keysValuesArray = new ArrayList<String>();

        Pattern groups = Pattern.compile("[^#]+(?=#)");
        Matcher groupMatch = groups.matcher(completeJerkSON);
        while (groupMatch.find())
        {
            Pattern items = Pattern.compile("[^;|:|!|#|%|^|@]+");
            Matcher itemMatch = items.matcher(groupMatch.group());
            while (itemMatch.find())
            {
                keysValuesArray.add(itemMatch.group());
                //System.out.println(itemMatch.group());
            }
        }
        return keysValuesArray;
    }
/*
    public String errorCorrector(String errorString)
    {
        //keys grammar corrections
        String goodString;
        goodString =
                errorString.replaceAll("(?i)(n.{2}e)", "name")
                        .replaceAll("(?i)(p.{3}e)", "Price")
                        .replaceAll("(?i)(t.{2}e)", "type")
                        .replaceAll("(?i)(e.{8}n)", "expiration")

                        //values grammar corrections
                        .replaceAll("(?i)(m{2}k)", "Milk")//replaces all wrong 'm**k' with "Milk"
                        .replaceAll("(?i)(b.{3}d)", "Bread")
                        .replaceAll("(?i)(c.{5}s)", "Cookies")
                        .replaceAll("(?i)(a.{4}s)", "Apples")
                        .replaceAll("(?i)(f.{2}d)", "Food")

                        //key and value connector corrections
                        .replaceAll("[|:|!|%|^|@]", ":")

                        //key value pairs separator corrections
                        .replaceAll("[;]", ",");
        return goodString;

    }
    */
}



