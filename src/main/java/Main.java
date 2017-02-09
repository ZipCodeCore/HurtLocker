import org.apache.commons.io.IOUtils;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        JerkSonReader reader = new JerkSonReader(output);
        GroceryList groceryList = new GroceryList();
        Output outputList = new Output();


        System.out.println(output);

        groceryList.addToGroceryList(reader.convertDataToGroceries());
        outputList.outputFullList(groceryList.getGroceryList());
        outputList.outputFormattedError(reader.getErrors());
    }
}
