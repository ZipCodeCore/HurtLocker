package io.steve_dimitri;

/**
 * Created by stevejaminson on 5/24/16.
 */
public class ItemListException extends Exception{

    String error;

    public ItemListException(String error){
        this.error = error;
        System.out.println(error);
    }
}
