import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static javax.script.ScriptEngine.FILENAME;


/**
 * Created by anthonyjones on 5/31/17.
 */
public class Parser {

    private int exceptionCounter;
    private ArrayList<String> cleanArrayList;


    // 28 take away the count of other items should equal the amount of error

    public String patternMatch(String file) //throws NoMatchFoundException
    {
        cleanArrayList = lineBreaker(file);
        cleanArrayList = exceptionHandler(cleanArrayList);

        Pattern milk = Pattern.compile("([M|m].\\w+[k|K][^,]+)");
        Matcher milkMatcher = milk.matcher(cleanArrayList.toString());
        ArrayList<String> milkArray = new ArrayList<>();
        String milkOutput;
        int milkCounter = 0;

        Pattern bread = Pattern.compile("([B|b].\\w+[D|d][^,]+)");
        Matcher breadMatcher = bread.matcher(cleanArrayList.toString());
        ArrayList<String> breadArray = new ArrayList<>();
        String breadOutput;
        int breadCounter = 0;


        Pattern cookies = Pattern.compile("([C|c].\\w+[S|s][^,]+)");
        Matcher cookiesMatcher = cookies.matcher(cleanArrayList.toString());
        ArrayList<String> cookieArray = new ArrayList<>();
        String cookieOutput;
        int cookieCounter = 0;


        Pattern apples = Pattern.compile("([A|a].\\w+[S|s][^,]+)");
        Matcher applesMatcher = apples.matcher(cleanArrayList.toString());
        ArrayList<String> appleArray = new ArrayList<>();
        String appleOutput;
        int appleCounter = 0;


//        Pattern cost = Pattern.compile("(\\d\\.\\d+)");
//        Matcher costMatcher = cost.matcher(file);
//        int costCounter = 0;

        while (milkMatcher.find()) {
            milkCounter++;
            milkArray.add(milkMatcher.group(1));
        }

        milkOutput = milkBreakDown(milkArray, milkCounter);


        while (breadMatcher.find()) {
            breadCounter++;
            breadArray.add(breadMatcher.group(1));
        }
        breadOutput = breadBreakDown(breadArray, breadCounter);

        while (cookiesMatcher.find()) {

            cookieCounter++;
            cookieArray.add(cookiesMatcher.group(1));
        }
        cookieOutput = cookieBreakDown(cookieArray, cookieCounter);

        while (applesMatcher.find()) {
            appleArray.add(applesMatcher.group(1));
            appleCounter++;

        }

        appleOutput = appleBreakDown(appleArray, appleCounter);

        String errors = String.format("%s%s%s%sErrors:\t\t\t\tseen: %s times",
                milkOutput, breadOutput,
                cookieOutput, appleOutput,
                this.exceptionCounter);
        return errors;


    }

    public ArrayList<String> lineBreaker(String file) {
        Pattern pattern = Pattern.compile("[^#]+");
        Matcher matcher = pattern.matcher(file);
        ArrayList<String> arrayListOfBrokenLines = new ArrayList<>();
        while (matcher.find()) {
            arrayListOfBrokenLines.add(matcher.group());
        }
        return arrayListOfBrokenLines;
    }


    public String milkBreakDown(ArrayList<String> arrayOfMilk, int milkCounter) {
        Pattern pattern = Pattern.compile("(\\d\\.\\d+)");
        Matcher matcher = pattern.matcher(arrayOfMilk.toString());
        ArrayList<String> price = new ArrayList<>();

        while (matcher.find()) {
            price.add(matcher.group(1));
        }
        Collections.sort(price, Collections.reverseOrder());


        Map<String, Long> counted = price.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        String formattedForOutput = String.format("name:\tMilk\t\t\tseen: %s times\n=============\t\t\t=============\n" +
                        "Price:\t%s\t\t\tseen: %s times\n-------------\t\t\t-------------\n" +
                        "Price:\t%s\t\t\tseen: %s time\n\n",
                milkCounter,
                counted.keySet().toArray()[1],
                counted.values().toArray()[1],
                counted.keySet().toArray()[0],
                counted.values().toArray()[0]);
        return formattedForOutput;
    }

    public String breadBreakDown(ArrayList<String> arrayOfBread, int breadCounter) {
        Pattern pattern = Pattern.compile("(\\d\\.\\d+)");
        Matcher matcher = pattern.matcher(arrayOfBread.toString());
        ArrayList<String> price = new ArrayList<>();

        while (matcher.find()) {
            price.add(matcher.group(1));
        }

        Collections.sort(price, Collections.reverseOrder());

        Map<String, Long> counted = price.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String formattedForOutput = String.format("name:\tBread\t\t\tseen: %s times\n=============\t\t\t=============\n" +
                        "Price:\t%s\t\t\tseen: %s times\n-------------\t\t\t-------------\n\n",
                breadCounter,
                counted.keySet().toArray()[0],
                counted.values().toArray()[0]);
        return formattedForOutput;
    }

    public String cookieBreakDown(ArrayList<String> arrayOfCookies, int cookieCounter) {
        Pattern pattern = Pattern.compile("(\\d\\.\\d+)");
        Matcher matcher = pattern.matcher(arrayOfCookies.toString());
        ArrayList<String> price = new ArrayList<>();

        while (matcher.find()) {
            price.add(matcher.group(1));
        }
        Collections.sort(price, Collections.reverseOrder());

        Map<String, Long> counted = price.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String formattedForOutput = String.format("name: Cookies\t\t\tseen: %s times\n=============\t\t\t=============\n" +
                        "Price:\t %s\t\t\tseen: %s times\n-------------\t\t\t-------------\n\n",
                cookieCounter,
                counted.keySet().toArray()[0],
                counted.values().toArray()[0]);
        return formattedForOutput;
    }

    public String appleBreakDown(ArrayList<String> arrayOfApples, int appleCounter) {
        Pattern pattern = Pattern.compile("(\\d\\.\\d+)");
        Matcher matcher = pattern.matcher(arrayOfApples.toString());
        ArrayList<String> price = new ArrayList<>();

        while (matcher.find()) {
            price.add(matcher.group(1));
        }
        Collections.sort(price, Collections.reverseOrder());

        Map<String, Long> counted = price.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String formattedForOutput = String.format("name:  Apples\t\t\tseen: %s times\n=============\t\t\t=============\n" +
                        "Price:\t %s\t\t\tseen: %s times\n-------------\t\t\t-------------\n" +
                        "Price:\t %s\t\t\tseen: %s times\n\n",
                appleCounter,
                counted.keySet().toArray()[1],
                counted.values().toArray()[1],
                counted.keySet().toArray()[0],
                counted.values().toArray()[0]);
        return formattedForOutput;
    }


    public ArrayList<String> exceptionHandler(ArrayList<String> newArrayList) //throws NoMatchFoundException// throws NoMatchFoundException
    {
        Pattern exception = Pattern.compile("(([N|n].\\w+[E|e].)(([M|m].\\w+[k|K])|([B|b].\\w+[D|d])|([A|a].\\w+[S|s])|([C|c].\\w+[S|s]))\\W([P|p].\\w+[e].)\\d.([^,]+))");
        Matcher exceptionMatcher = exception.matcher(newArrayList.toString());
        ArrayList<String> exceptionFreeArrayList = new ArrayList<>();
        exceptionCounter = 0;

        for (int i = 0; i < 28; i++) {

            if (exceptionMatcher.find()) {
                exceptionFreeArrayList.add(exceptionMatcher.group());
            } else {
                exceptionCounter++;
              //  throw new NoMatchFoundException();
            }
        }
        return exceptionFreeArrayList;
    }

    public void parseToTextFile(String file) //throws NoMatchFoundException
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/anthonyjones/dev/labs/HurtLocker/output.txt"))) {

            String content = patternMatch(file);

            bw.write(content);

            // no need to close it.
            //bw.close();

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
