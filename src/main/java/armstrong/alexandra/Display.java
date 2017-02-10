package armstrong.alexandra;

public class Display {

    public static void displayItem(GroceryItem item){
        displayName(item);
        displaySpaces();
        displaySeenName(item);
        doubleLine();
        displaySpaces();
        doubleLine();
        System.out.println();
        displayPrice(item);

        System.out.println();
    }

    public static void doubleLine(){
        System.out.print("=============");
    }

    public static void singleLine(){
        System.out.print("-------------");
    }

    public static void displayPrice(GroceryItem item){
        String[] price = item.getPrice();
        System.out.printf("Price:%7s", price[0]);
        displaySpaces();
        displaySeenPrice(item);
        singleLine();
        displaySpaces();
        singleLine();
        System.out.println();
        if(price[1] != null){
            System.out.printf("Price:%7s", price[1]);
        }
    }

    public static void displayName(GroceryItem item){
        System.out.printf("name:%8s", item.getName());
    }

    public static void displaySeenName(GroceryItem item){
        System.out.printf("seen: %d times\n", item.getNameCounter());
    }

    public static void displaySeenPrice(GroceryItem item){
        System.out.printf("seen: %d times\n", item.getNumberCounter());
    }

    public static void displayErrors(int errorCount){
        System.out.printf("%13s", "Errors");
        displaySpaces();
        System.out.printf("seen: %d times", errorCount);
    }

    public static void displaySpaces(){
        System.out.printf("        ");
    }

}
