import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by markhauenstein on 5/24/16.
 */
public class ShoppingList {


    public String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }
    public String[] listMaker(String rawData){
        String[] parsedString = rawData.split("##");
        return parsedString;
    }
    public static String[] itemParser(String itemValues){
        String[] parsedItem = itemValues.split(":|;|\\^|%|!|\\*|@");
        return parsedItem;
    }
    public ArrayList<Item> itemCreator(String[] array){

        ArrayList<Item> listOfItems = new ArrayList();
        int arrayListLength = array.length;
        for(int i=0;i<arrayListLength;i++){
            String[] parsedItem = itemParser(array[i]);
            listOfItems.add(new Item(parsedItem));
        }
        return listOfItems;
    }
}
