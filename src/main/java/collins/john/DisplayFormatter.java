package collins.john;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by johncollins on 2/9/17.
 */
public class DisplayFormatter
{
    int applesCounter = 0;
    int breadCounter = 0;
    int cookiesCounter = 0;
    int milkCounter = 0;

    int fakeErrorCounter = 0;
    int realErrorCounter = 0;

    HashMap<String, Integer> applePrice = new HashMap<String, Integer>();
    HashMap<String, Integer> breadPrice = new HashMap<String, Integer>();
    HashMap<String, Integer> cookiesPrice = new HashMap<String, Integer>();
    HashMap<String, Integer> milkPrice = new HashMap<String, Integer>();


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
                    if (!applePrice.containsKey(itemMap.get("Price")))
                    {
                        applePrice.put(itemMap.get("Price"), 1);
                    } else
                    {
                        applePrice.put(itemMap.get("Price"), applePrice.get(itemMap.get("Price")) + 1);

                    }

                } else if (itemMap.containsValue("Bread"))
                {
                    breadCounter++;
                    if (!breadPrice.containsKey(itemMap.get("Price")))
                    {
                        breadPrice.put(itemMap.get("Price"), 1);
                    } else
                    {
                        breadPrice.put(itemMap.get("Price"), breadPrice.get(itemMap.get("Price")) + 1);

                    }
                } else if (itemMap.containsValue("Cookies"))
                {
                    cookiesCounter++;
                    if (!cookiesPrice.containsKey(itemMap.get("Price")))
                    {
                        cookiesPrice.put(itemMap.get("Price"), 1);
                    } else
                    {
                        cookiesPrice.put(itemMap.get("Price"), cookiesPrice.get(itemMap.get("Price")) + 1);
                    }
                } else if (itemMap.containsValue("Milk"))
                {
                    milkCounter++;
                    if (!milkPrice.containsKey(itemMap.get("Price")))
                    {
                        milkPrice.put(itemMap.get("Price"), 1);
                    } else
                    {
                        milkPrice.put(itemMap.get("Price"), milkPrice.get(itemMap.get("Price")) + 1);
                    }
                }
                if (itemMap.containsValue("expiration"))
                {
                    fakeErrorCounter++;
                }


            } catch (NullPointerException e)
            {
                realErrorCounter++;
            }
        }

    }

    /////add prices counts
    public void countPrices(ArrayList<Map<String, String>> goodDataSet)
    {


        for (Map<String, String> itemMap : goodDataSet
                )
        {
            try
            {
                if (itemMap.containsKey("Apples"))
                {
                    if (!applePrice.containsKey(itemMap.get("Price")))
                    {

                        applePrice.put(itemMap.get("Price"), 1);

                    } else
                    {
                        applePrice.put(itemMap.get("Price"), applePrice.get(itemMap.get("Price")) + 1);

                    }
                } else if (itemMap.containsKey("Bread"))
                {

                    breadPrice.put(itemMap.get("Price"), breadPrice.get(itemMap.get("Price")) + 1);

                } else if (itemMap.containsKey("Cookies"))
                {

                    cookiesPrice.put(itemMap.get("Price"), cookiesPrice.get(itemMap.get("Price")) + 1);

                } else if (itemMap.containsKey("Milk"))
                {

                    milkPrice.put(itemMap.get("Price"), milkPrice.get(itemMap.get("Price")) + 1);

                }


            } catch (NullPointerException e)
            {
                realErrorCounter++;
            }
        }

    }


    public String formatForScreen()
    {
        String keyString = "label";
        String label = keyString + ":";
        String spaceCount = "";
        String itemName = "data";
        String itemCount = "X";
        //String key;
        //String value;
        //key +":"+13-(key.length()+1)+value.length())+
        String equalSignLine = "=============";
        String minusSignLine = "-------------";
        String emptySpaceLine = "        ";
        //String nameLine = "name:";
        //String priceLine = "Price:";
        String seenTimes = "seen: " + itemCount + " times";
        String error = "Error";

        spaceCount = this.whiteSpaceGenerator(label, itemName);

        return label + spaceCount + itemName + emptySpaceLine + seenTimes + "\n"
                + equalSignLine + emptySpaceLine + equalSignLine + "\n"
                + label + spaceCount + itemName + emptySpaceLine + seenTimes + "\n"
                + minusSignLine + emptySpaceLine + minusSignLine;
    }

    private String whiteSpaceGenerator(String label, String data)
    {
        String spaces = "";
        while (spaces.length() < ((13-label.length()) - data.length()))
        {
            spaces += " ";
        }
        return spaces;
    }


}