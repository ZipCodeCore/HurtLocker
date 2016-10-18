/**
 * Created by evanhitchings on 10/17/16.
 */
public class GroceryItem {
    String name;
    String price;
    String type;
    String date;


    public GroceryItem(String[] fields) {
        this.name = fields[0];
        this.price = fields[1];
        this.type = fields[2];
        this.date = fields[3];
    }

    public static GroceryItem groceryItemFactory(String[] fields) throws JerkSONException{
        for(String field : fields){
            if(field.length() < 1){
                throw new JerkSONException("Found empty field");
            }
        }

        return new GroceryItem(fields);
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }
}
