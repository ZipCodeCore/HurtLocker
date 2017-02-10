package armstrong.alexandra;

public class GroceryItem {
    private String name;
    private String[] price = new String[2];
    private int nameCounter = 0;
    private int numberCounter = 0;

    GroceryItem(String name, String price){
        this.name = name;
        this.price[0] = price;
        nameCounter++;
        numberCounter++;
    }

    public void duplicateName(){
        nameCounter++;
    }

    public void duplicatePrice(){
        numberCounter++;
    }

    public String getName() {
        return name;
    }

    public String[] getPrice() {
        return price;
    }

    public int getNameCounter() {
        return nameCounter;
    }

    public int getNumberCounter() {
        return numberCounter;
    }

    public boolean equals(String name, String price){
        if (this.name.equals(name) && this.price.equals(price)){
            duplicateName();
            duplicatePrice();
            return true;
        } else if (this.name.equals(name)){
            duplicateName();
            this.price[1] = price;
            return true;
        } else {
            return false;
        }
    }
}
