package mattern.william;

import java.util.Collection;

/**
 * Created by williammattern on 2/8/17.
 */
public class InputHandler {
    static int jerksonExceptions = 0;
    GroceryList groceryList;

    public GroceryList handleInput(String jerksonInput){
        groceryList = new GroceryList();
        for (String littleJerksonString: inputToStringCollection(jerksonInput)){
            try {
                GroceryListItem gli = inputStringToGLIConverter(littleJerksonString);
                groceryList.addGroceryListItemToList(gli);
            } catch (GroceryItemNotFoundException e){
                //e.printStackTrace(System.out);
            }
        }
        return groceryList;

    }

    String[] inputToStringCollection(String jerksonInput){
        JerksonToStringConverter jerksonToStringConverter = new JerksonToStringConverter();
        return jerksonToStringConverter.getMeAllTheItems(jerksonInput);
    }

    GroceryListItem inputStringToGLIConverter(String convertedJerksonString) throws  GroceryItemNotFoundException {
        try {
            LittleJerksonStringToGLIConverter jerksonStringToGLIConverter = new LittleJerksonStringToGLIConverter();
            return jerksonStringToGLIConverter.convertLittleJerksonStringToGLI(convertedJerksonString);
        }catch (GroceryItemNotFoundException e){
            throw new GroceryItemNotFoundException();
        }
    }
}
