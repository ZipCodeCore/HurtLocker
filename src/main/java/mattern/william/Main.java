package mattern.william;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;


public class Main {


    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        String output = (new Main()).readRawDataToString();

        ArrayList<GroceryListItem> groceryList = inputHandler.handleInput(output);
        outputHandler.printGroceryReport(groceryList);
    }
}
