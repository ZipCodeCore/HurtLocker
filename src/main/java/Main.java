import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        JerkSon jerk = new JerkSon();
        //System.out.println(Arrays.toString(jerk.delimiterSplit(RawDataLocation.rawData)));

       String[] s= jerk.delimiterSplit(RawDataLocation.rawData);
        Pattern p = Pattern.compile("(?<=[Mm][iI][lL][kK][;][pP][rR][iI][cC][eE][:])\\d[.]\\d+");
        Matcher mm = p.matcher(s[0]);
        if(mm.find())
            System.out.println(mm.group());


        List<String[]> test = jerk.makeList(RawDataLocation.rawData);

        GroceryItem[] g = jerk.makeGroceryItemsArray(test);
        OutputFormatter out = new OutputFormatter();
        System.out.println(out.format(g));



//        System.out.println(kvPairs[0]);
//        Matcher m = Regex.nameDelimiter.matcher(kvPairs[0]);
//
//        Matcher mm = Regex.priceDelimiter.matcher(kvPairs[1]);
//
//        Matcher f = Regex.typeDelimiter.matcher(kvPairs[2]);
//
//        Matcher g = Regex.expirationDelimiter.matcher(kvPairs[3]);
//        if(g.find())
//            System.out.println(g.group());
//
//        if(f.find())
//            System.out.println(f.group());
//        if(mm.find())
//            System.out.println(mm.group());
//        if(m.find())System.out.println(m.group());
//
//
//
//
//
//        //    System.out.println(Arrays.toString(jerk.kVLineSplitter(kvPairs)));
        }
    }



