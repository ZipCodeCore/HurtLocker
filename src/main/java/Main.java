import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        Converter converter = new Converter();
        ArrayList<Item> result = converter.execute(converter.readRawDataToString());
        converter.printResult(result);

    }
}
