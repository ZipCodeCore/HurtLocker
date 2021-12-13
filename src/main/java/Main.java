import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    Parser parsedData = new Parser();

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.println("JerkSON");
        System.out.println(output+"\n");

        Parser parser = new Parser();
        System.out.println("JSON");
        System.out.println(parser.dataParser());

        Main main = new Main();

//        System.out.println("Milk seen: "+main.countItem(parser.dataParser(),"Milk"));
//        System.out.println("1.23 Price seen: "+main.countItemAtPrice(parser.dataParser(),"Milk,price:1[.]23"));
//        System.out.println("3.23 Price seen : "+main.countItemAtPrice(parser.dataParser(), "Milk,price:3[.]23"));
//        System.out.println("No Price seen: "+main.countItemNoPrice(parser.dataParser(),"Milk,price:,"));
        // System.out.println(main.errorCounter());

        System.out.println(main.formatedOutput());
        main.outputToTXT();

    }

    public Integer countItem(String parsedData, String item){
        Integer count = 0;
        Pattern pattern = Pattern.compile(item);
        Matcher matcher = pattern.matcher(parsedData);
        while (matcher.find()){
            count++;
        }
        return count;
    }
    public Integer countItemAtPrice(String parsedData, String price){
        Integer count = 0;
        Pattern pattern = Pattern.compile(price);
        Matcher matcher = pattern.matcher(parsedData);
        while (matcher.find()){
            count++;
        }
        return count;
    }

    public Integer countKeyNoValue(String parsedData, String noValue){
        Integer count = 0;
        Pattern pattern = Pattern.compile(noValue);
        Matcher matcher = pattern.matcher(parsedData);
        while (matcher.find()){
            count++;
        }
        return count;
    }
    public Integer errorCounter(){
        Integer count = 0;
        String[] keys = {"name","price","type","expiration"};
        for (int i = 0; i < keys.length; i++) {
            count += countKeyNoValue(parsedData.dataParser(),keys[i]+":,");
        }
        return count;
    }



    public String formatedOutput(){
      String result = "";
        result = "name:    Milk \t\t seen: "+countItem(parsedData.dataParser(), "Milk")+" times\n" +
                "============= \t \t =============\n" +
                "Price: \t 3.23\t\t seen: "+countItemAtPrice(parsedData.dataParser(), "Milk,price:3[.]23")+" times\n" +
                "-------------\t\t -------------\n" +
                "Price:   1.23\t\t seen: "+countItemAtPrice(parsedData.dataParser(), "Milk,price:1[.]23")+" time\n" +
                "\n" +
                "name:   Bread\t\t seen: "+countItem(parsedData.dataParser(), "Bread")+" times\n" +
                "=============\t\t =============\n" +
                "Price:   1.23\t\t seen: "+countItemAtPrice(parsedData.dataParser(), "Bread,price:1[.]23")+" times\n" +
                "-------------\t\t -------------\n" +
                "\n" +
                "name: Cookies     \t seen: "+countItem(parsedData.dataParser(), "Cookies")+" times\n" +
                "=============     \t =============\n" +
                "Price:   2.25        seen: "+countItemAtPrice(parsedData.dataParser(), "Cookies,price:2[.]25")+" times\n" +
                "-------------        -------------\n" +
                "\n" +
                "name:  Apples     \t seen: "+countItem(parsedData.dataParser(), "Apples")+" times\n" +
                "=============     \t =============\n" +
                "Price:   0.25     \t seen: "+countItemAtPrice(parsedData.dataParser(), "Apples,price:0[.]25")+" times\n" +
                "-------------     \t -------------\n" +
                "Price:   0.23  \t \t seen: "+countItemAtPrice(parsedData.dataParser(), "Apples,price:0[.]23")+" times\n" +
                "\n" +
                "Errors         \t \t seen: "+errorCounter()+" times   ";


      return result;
    }

    public void outputToTXT() throws FileNotFoundException {

        FileOutputStream outputStream= new FileOutputStream("outputFormat.txt");
        Formatter formatter = new Formatter(outputStream);
        formatter.format(formatedOutput());
        formatter.flush();

    }

   
}
