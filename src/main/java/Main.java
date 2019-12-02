import org.apache.commons.io.IOUtils;
import sun.tools.jstat.Token;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String pepper = jerkSeasoning(result);
        String cinnamon = jerkSeasoning2(pepper);
        String tumeric = jerkSeasoning3(cinnamon);
        String thyme = jerkSeasoning4(tumeric);
        String lemon = jerkSeasoning5(thyme);
        String cumin = jerkSeasoning6(lemon);
        String chicken = jerkSeasoning7(cumin);
        String cloves = jerkSeasoning8(chicken);
        pairParser(cloves);
        return cloves;
    }

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

    public String jerkSeasoning(String string) {
        Pattern p1 = Pattern.compile("[;*^%!@]");
        Matcher m1 = p1.matcher(string);
        m1.find();
        int count = 0;
        while(m1.find()){
            count++;
        }
        System.out.println(count);
        return m1.replaceAll(" ");

    }

    public String jerkSeasoning2(String string) {
        Pattern p2 = Pattern.compile("#{2}");
        Matcher m2 = p2.matcher(string);
        m2.find();
        int count = 0;
        while(m2.find()){
            count++;
        }
        System.out.println(count);
        return m2.replaceAll("},\n");
    }

    public String jerkSeasoning3(String string) {
        Pattern p3 = Pattern.compile("/");
        Matcher m3 = p3.matcher(string);
        m3.find();
        return m3.replaceAll("-");
    }

    public String jerkSeasoning4(String string) {
        Pattern p4 = Pattern.compile("^(?i)name", Pattern.MULTILINE);
        Matcher m4 = p4.matcher(string);
        m4.find();
        return m4.replaceAll("name");
    }

    public String jerkSeasoning5(String string) {
        Pattern p5 = Pattern.compile("(?i)m[1i!]lk");
        Matcher m5 = p5.matcher(string);
        m5.find();
        return m5.replaceAll("Milk");
    }

    public String jerkSeasoning6(String string) {
        Pattern p6 = Pattern.compile("(?i)c[o0][o0]kies");
        Matcher m6 = p6.matcher(string);
        m6.find();
        return m6.replaceAll("Cookies");
    }

    public String jerkSeasoning7(String string) {

        Pattern p7 = Pattern.compile("(?i)bread");
        Matcher m7 = p7.matcher(string);
        m7.find();
        return m7.replaceAll("Bread");
    }
    public String jerkSeasoning8(String string) {

        Pattern p8 = Pattern.compile("(?i)Apples");
        Matcher m8 = p8.matcher(string);
        m8.find();
        return m8.replaceAll("Apples");
    }

    public void doThings(String string) {
        Pattern p = Pattern.compile("(?:(\\w*)=(\\d*)(?=&|$))");
        Matcher m = p.matcher(string);

        while (m.find()) {


        }


    }

    public void pairParser(String string){
        Pattern p8 = Pattern.compile("(\\S+):(\\S*)\\s(\\S+):(\\S*)\\s(\\S+):(\\S*)\\s(\\S+):(\\S*)(?:\\b(?!:)|$)");
        Matcher m8 = p8.matcher(string);
        List grouping = new ArrayList();
        while(m8.find()){
            LocalDate date = LocalDate.parse(m8.group(8));
           ParsedItems item = new ParsedItems(m8.group(2),Double.valueOf(m8.group(4)),m8.group(6),date);
           grouping.add(item);
           }


            // System.out.println(m8.group(1)+ " " + m8.group(2) +" "+ m8.group(3)+" "+ m8.group(4) + " " + m8.group(5)+ " " + m8.group(6) +" "+ m8.group(7)+" "+ m8.group(8));
           // grouping.put(m8.group(1),m8.group(2));
        }
    }


