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
        System.out.printf("Price:%7s", item.getPrice(0));
        displaySpaces();
        displaySeen1Price(item);
        singleLine();
        displaySpaces();
        singleLine();
        System.out.println();
        if(item.getPrice(1) != null){
            System.out.printf("Price:%7s", item.getPrice(1));
            displaySpaces();
            displaySeen2Price(item);
        }
    }

    public static void displayName(GroceryItem item){
        System.out.printf("name:%8s", item.getName());
    }

    public static void displaySeenName(GroceryItem item){
        System.out.printf("seen: %d times\n", item.getNameCounter());
    }

    public static void displaySeen1Price(GroceryItem item){
        System.out.printf("seen: %d times\n", item.getPrice1Counter());
    }

    public static void displaySeen2Price(GroceryItem item){
        System.out.printf("seen: %d times\n", item.getPrice2Counter());
    }

    public static void displayErrors(int errorCount){
        System.out.printf("%-13s", "Errors");
        displaySpaces();
        System.out.printf("seen: %d times", errorCount);
    }

    public static void displaySpaces(){
        System.out.printf("        ");
    }

}
