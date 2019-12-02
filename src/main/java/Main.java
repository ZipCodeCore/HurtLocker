import org.apache.commons.io.IOUtils;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        StringParser stringParser = new StringParser();
        String[] listArray = stringParser.stringParser();

        Compiler compiler = new Compiler();
        ErrorCounter errorCounter = new ErrorCounter();

        System.out.println(compiler.compiler(listArray, "[Mm][Ii][Ll][Kk]", "Milk"));
        System.out.println(compiler.compiler(listArray,"[Bb][Rr][Ee][Aa][Dd]", "Bread"));
        System.out.println(compiler.compiler(listArray,"[Cc][0oO][Oo0][Kk][Ii][Ee][Ss]", "Cookies"));
        System.out.println(compiler.compiler(listArray, "[Aa][Pp][Pp][Ll][Ee][Ss]", "Apples"));
        System.out.println(errorCounter.errorCounter(listArray));
    }

}
