package ibikunle.tolani;

import org.apache.commons.io.IOUtils;

/**
 * Created by tolaniibikunle on 2/15/17.
 */
public class Data {
    public String rawData;
    {
        try {
            rawData = readRawDataToString();
        } catch (Exception e){
            System.out.println("Exception caught"); // any time you have a method that throws an exception you must create a try and catch statement
            System.out.println(e.getMessage()); //calling the message on that exception object
        }

    }


    public  String readRawDataToString() throws Exception{ // we need to call this method inorder to put the value into rawData
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }
}
