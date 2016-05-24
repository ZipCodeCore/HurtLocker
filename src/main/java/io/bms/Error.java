package io.bms;

/**
 * Created by bms on 5/24/16.
 */
public class Error extends Throwable{

    private static int counter = 0;

    public Error(String message){
        super (message);
        counter++;
    }

    public static String formattedToString(){
        return "Errors\t\t\t\tseen: "+counter+" times";
    }
}
