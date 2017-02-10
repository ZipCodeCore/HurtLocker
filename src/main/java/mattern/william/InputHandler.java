package mattern.william;

import java.util.ArrayList;

/**
 * Created by williammattern on 2/8/17.
 */
public class InputHandler {
    static int jerksonExceptions = 0;
    ArrayList<GroceryListItem> list;
    String doubleHashPattern = "#{2}";

    public ArrayList<GroceryListItem> handleInput(String jerksonInput){
        list = new ArrayList<GroceryListItem>();
        for (String littleJerksonString: inputToStringCollection(jerksonInput)){
            try {
                GroceryListItem gli = inputStringToGLIConverter(littleJerksonString);
                list.add(gli);
            } catch (GroceryItemNotFoundException e){
                //e.printStackTrace(System.out);
            }
        }
        return list;
    }

    String[] inputToStringCollection(String jerksonInput){
        return jerksonInput.split(doubleHashPattern);
    }

    GroceryListItem inputStringToGLIConverter(String convertedJerksonString) throws  GroceryItemNotFoundException {
        try {
            StringToItemConverter jerksonStringToGLIConverter = new StringToItemConverter();
            return jerksonStringToGLIConverter.convertLittleJerksonStringToGLI(convertedJerksonString);
        }catch (GroceryItemNotFoundException e){
            throw new GroceryItemNotFoundException();
        }
    }
}
