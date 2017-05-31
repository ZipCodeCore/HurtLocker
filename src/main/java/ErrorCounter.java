/**
 * Created by markbrown on 5/31/17.
 */
public final class ErrorCounter {

    private static int errorCount = 0;

    private ErrorCounter () {}

    public static int getErrorCount() {
        return errorCount;
    }

    public static void increaseErrorCount() {
        errorCount++;
    }
}
