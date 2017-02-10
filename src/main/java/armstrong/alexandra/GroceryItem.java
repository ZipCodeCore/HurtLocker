package armstrong.alexandra;

public class GroceryItem {
    private String name;
    protected String[] price = new String[2];
    private int nameCounter = 0;
    private int price1Counter = 0;
    private int price2Counter = 0;

    GroceryItem(String name, String price){
        this.name = name;
        this.price[0] = price;
        nameCounter++;
        price1Counter++;
    }

    public void duplicateName(){
        nameCounter++;
    }

    public void duplicate1Price(){
        price1Counter++;
    }

    public void duplicate2Price(){
        price2Counter++;
    }

    public String getName() {
        return name;
    }

    public String getPrice(int i) {
            return price[i];
    }

    public int getNameCounter() {
        return nameCounter;
    }

    public int getPrice1Counter() {
        return price1Counter;
    }

    public int getPrice2Counter() {
        return price2Counter;
    }


    /*public boolean equals(GroceryItem item){
        if (this.name.equals(item.name) && (this.price[0].equals(item.price[0]) )){
            duplicateName();
            duplicatePrice(item.price[0]);
            return true;
        } else if (this.name.equals(name)){
            duplicateName();
            this.price[1] = item.price[0];
            price2Counter++;
            return true;
        } else {
            return false;
        }
    }*/
}
