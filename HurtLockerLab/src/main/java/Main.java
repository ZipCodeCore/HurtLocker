import java.lang.*;

/**
 * Created by latashawatson on 2/8/17.
 */
public class Main {
    public String convertFiles() throws Exception{
        Class cls = Class.forName("java.lang.ClassLoader");
        ClassLoader clsClassLoader = cls.getClassLoader();
        String input = clsClassLoader.getResourceAsStream("RawData.txt").toString();
        return input;
    }

    public static void main(String[] args) throws Exception{
        String input = (new Main()).convertFiles();
        HurtLocker hurtLocker = new HurtLocker();
        hurtLocker.hurtLockerParser(input);


    }
}
