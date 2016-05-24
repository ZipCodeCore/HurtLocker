package io.derobert;

public class ItemInventory {
    private Apples apples = new Apples();
    private Bread bread = new Bread();
    private Cookies cookies = new Cookies();
    private Milk milk = new Milk();

    public Apples getApples() {
        return apples;
    }

    public Bread getBread() {
        return bread;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public Milk getMilk() {
        return milk;
    }

    public void setApples(Apples apples) {
        this.apples = apples;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    public String displayInventory(){
        String inventory = "";

        inventory += milk.formatItem() + "\n\n";
        inventory += bread.formatItem() + "\n\n";
        inventory += cookies.formatItem() + "\n\n";
        inventory += apples.formatItem() + "\n\n";
        inventory += ItemParser.formatErrorCount();

        return inventory;
    }
}
