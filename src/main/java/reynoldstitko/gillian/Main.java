package reynoldstitko.gillian;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;

public class Main {



    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws StringMismatchException, Exception{

        JerksonParser jerksonParser = new JerksonParser();

        String output = (new Main()).readRawDataToString();

        String[] result = jerksonParser.splitIncomingStringFile(output, "##");

        //System.out.println(output); //this prints out the rawdata file

        //Print the data after being split at the ##
//        for(int i = 0; i < result.length; i++){
//            System.out.println(result[i]);
//        }

        ArrayList<String> sepsRemoved = jerksonParser.findGroceryItem(result, "EA");
        System.out.println(sepsRemoved);

    }

}
