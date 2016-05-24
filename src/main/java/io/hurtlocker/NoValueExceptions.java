package io.hurtlocker;

/**
 * Created by taiseerhabib on 5/24/16.
 */
public class NoValueExceptions extends NullPointerException {
    public NoValueExceptions(){
        super();
        ItemParser.setErrorCounter(ItemParser.getErrorCounter()+1);
    }
}
