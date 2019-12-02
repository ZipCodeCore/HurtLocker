import org.apache.commons.io.IOUtils;

import java.sql.SQLOutput;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        MilkCompiler milkCompiler = new MilkCompiler();
        BreadCompiler breadCompiler = new BreadCompiler();
        CookiesCompiler cookiesCompiler = new CookiesCompiler();
        AppleCompiler appleCompiler = new AppleCompiler();
        ErrorCounter errorCounter = new ErrorCounter();

        System.out.println(milkCompiler.milkCompiler());
        System.out.println(breadCompiler.breadCompiler());
        System.out.println(cookiesCompiler.cookiesCompiler());
        System.out.println(appleCompiler.applesCompiler());
        System.out.println(errorCounter.errorCounter());
    }

}
