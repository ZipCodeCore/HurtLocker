package armstrong.alexandra;

public class Display {

    public static void displayItem(GroceryItem item){
        displayName(item);
        displaySpaces();
        displaySeen(item.getNameCounter());
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
        displaySeen(item.getPrice1Counter());
        singleLine();
        displaySpaces();
        singleLine();
        System.out.println();
        if(item.getPrice(1) != null){
            System.out.printf("Price:%7s", item.getPrice(1));
            displaySpaces();
            displaySeen(item.getPrice2Counter());
        }
    }

    public static void displayName(GroceryItem item){
        System.out.printf("name:%8s", item.getName());
    }

    public static void displaySeen(int counter){
        System.out.printf("seen: %d ", counter);
        System.out.println(timeVTimes(counter));
    }

    public static void displayErrors(int errorCount){
        System.out.printf("%-13s", "Errors");
        displaySpaces();
        System.out.printf("seen: %d times", errorCount);
    }

    public static void displaySpaces(){
        System.out.printf("\t\t");
    }

    public static String timeVTimes(int counter){
        if (counter == 1){
            return "time";
        } else {
            return "times";
        }
    }

}
