package io.bms;

/**
 * Created by samhudgens on 5/24/16.
 */
public class Error extends Throwable{

    private static int counter = 0;

    public Error(String message){
        super (message);
        counter++;
    }

    public static String formatedToString(){
        return "Errors\t\t\t\tseen: "+counter+" times";
    }

    public static int returnCount(){
        return counter;
    }
}
