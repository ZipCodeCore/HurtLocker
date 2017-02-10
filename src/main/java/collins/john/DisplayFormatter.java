package collins.john;

import java.util.*;

/**
 * Created by johncollins on 2/9/17.
 */
public class DisplayFormatter
{
    int applesCounter = 0;
    int breadCounter = 0;
    int cookiesCounter = 0;
    int milkCounter = 0;

    int errorCounter = 0;
    int actualErrorCounter = 0;

    Set<String> applePrice = new HashSet<String>();
    Set<String> breadPrice = new HashSet<String>();
    Set<String> cookiesPrice = new HashSet<String>();
    Set<String> milkPrice = new HashSet<String>();


    public void aggregateData(ArrayList<Map<String, String>> goodDataSet)
    {


        for (Map<String, String> itemMap : goodDataSet
                )
        {
            try
            {
                if (itemMap.containsValue("Apples"))
                {
                    applesCounter++;
                    applePrice.add(itemMap.get("Price"));
                } else if (itemMap.containsValue("Bread"))
                {
                    breadCounter++;
                    breadPrice.add(itemMap.get("Price"));
                } else if (itemMap.containsValue("Cookies"))
                {
                    cookiesCounter++;
                    cookiesPrice.add(itemMap.get("Price"));
                } else if (itemMap.containsValue("Milk"))
                {
                    milkCounter++;
                    milkPrice.add(itemMap.get("Price"));
                }
                if (itemMap.containsValue("expiration"))
                {
                    errorCounter++;
                }
            } catch (NullPointerException e)
            {
                actualErrorCounter++;
            }
        }

    }
}