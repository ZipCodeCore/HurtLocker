package crawley.james.hurtlocker;

/**
 * Created by jamescrawley on 10/17/16.
 */
public class DataMissingException extends Exception {

    DataMissingException () {
        super();
    }

    DataMissingException (String message) {
        super(message);
    }
}
