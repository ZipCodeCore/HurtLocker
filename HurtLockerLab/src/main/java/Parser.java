import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by latashawatson on 2/9/17.
 */
//public class Parser {
//    int milkPrice1Tally = 0;
//    int breadPrice1Tally = 0;
//    int applesPrice1Tally = 0;
//    int cookiesPrice1Tally = 0;
//    int milkPrice2Tally = 0;
//    int breadPrice2Tally = 0;
//    int applesPrice2Tally = 0;
//    int cookiesPrice2Tally = 0;
//    String[] milkPrices = new String[1];
//    String[] breadPrices = new String[1];
//    String[] applesPrices = new String[1];
//    String[] cookiesPrices = new String[1];
//    int numberOfErrors = 0;
//    ArrayList<String> fieldValues = new ArrayList<>();
//    ArrayList<String> fieldHeaders = new ArrayList<>();
//    ArrayList<GroceryItem> milkItem = new ArrayList<>();
//    ArrayList<GroceryItem> breadItem = new ArrayList<>();
//    ArrayList<GroceryItem> applesItem = new ArrayList<>();
//    ArrayList<GroceryItem> cookiesItem = new ArrayList<>();
//    ArrayList<GroceryItem> items = new ArrayList<>();
//
//    public void runParser(String input) {
//        split(input);
//        createItem();
//        priceTally(milkItem);
//        priceTally(breadItem);
//        priceTally(cookiesItem);
//        priceTally(applesItem);
//        GroceryItem milk = milkItem.get(0);
//        GroceryItem bread = breadItem.get(0);
//        GroceryItem apples = applesItem.get(0);
//        GroceryItem cookies = cookiesItem.get(0);
//
//    }
//
//    public void split(String input) {
//        String input1 = input.toLowerCase();
//        String[] partsA1 = input1.split("(:)|(\\^)|(##)|(;)|(%)|(@)|(!)|(\\*)");
//        int i = 3;
//        for (String val : partsA1) {
//            if (i % 2 == 0) fieldValues.add(val);
//            i++;
//        }
//        for (String val : partsA1) {
//            if (!(i % 2 == 0)) fieldHeaders.add(val);
//            i++;
//        }
//    }
//
//    public void createItem() {
//        int n = (fieldHeaders.size()) / 4;
//        for (int i = 0; i < n; i++) {
//            ArrayList<String> itemFields = new ArrayList<>();
//            for (int j = 0; j <= 3; i++) {
//                itemFields.add(fieldValues.get(j));
//            }
//            String name = itemFields.get(0);
//            String price = itemFields.get(1);
//            String type = itemFields.get(2);
//            String expiration = itemFields.get(3);
//            try {
//                switch (name) {
//                    case "milk":
//                        milkItem.add(new GroceryItem(name, price, type, expiration));
//                        break;
//                    case "bread":
//                        breadItem.add(new GroceryItem(name, price, type, expiration));
//                        break;
//                    case "apples":
//                        applesItem.add(new GroceryItem(name, price, type, expiration));
//                        break;
//                    case "cookies":
//                        cookiesItem.add(new GroceryItem(name, price, type, expiration));
//                        break;
//                    case "co0kies":
//                        cookiesItem.add(new GroceryItem("cookies", price, type, expiration));
//                    default:
//                        break;
//                }
//            } catch (Exception nullReferenceException) {
//                nullReferenceException.printStackTrace();
//                numberOfErrors++;
//            }
//            itemFields.clear();
//        }
//
//    }
//
//    public void priceTally(ArrayList<GroceryItem> itemList) {
//        String mirror = "0.0";
//        for (GroceryItem obj : itemList) {
//            String name = obj.getName();
//            String price = obj.getPrice();
//            switch (name) {
//                case "milk":
//                    if (mirror.equals("0.0")) {
//                        mirror = price;
//                        milkPrices[0] = price;
//                        this.milkPrice1Tally++;
//                    }
//                    if (price.equals(milkPrices[0])) this.milkPrice1Tally++;
//                    if (!(price.equals(milkPrices[0]))) {
//                        milkPrices[1] = price;
//                        this.milkPrice2Tally++;
//                    }
//                    break;
//                case "bread":
//                    if (mirror.equals("0.0")) {
//                        mirror = price;
//                        breadPrices[0] = price;
//                        this.breadPrice1Tally++;
//                    }
//                    if (price.equals(breadPrices[0])) this.breadPrice1Tally++;
//                    if (!(price.equals(breadPrices[0]))) {
//                        breadPrices[1] = price;
//                        this.breadPrice2Tally++;
//                    }
//                    break;
//                case "apples":
//                    if (mirror.equals("0.0")) {
//                        mirror = price;
//                        applesPrices[0] = price;
//                        this.applesPrice1Tally++;
//                    }
//                    if (price.equals(applesPrices[0])) this.applesPrice1Tally++;
//                    if (!(price.equals(applesPrices[0]))) {
//                        applesPrices[1] = price;
//                        this.applesPrice2Tally++;
//                    }
//                    break;
//                case "cookies":
//                    if (mirror.equals("0.0")) {
//                        mirror = price;
//                        cookiesPrices[0] = price;
//                        this.cookiesPrice1Tally++;
//                    }
//                    if (price.equals(cookiesPrices[0])) this.cookiesPrice1Tally++;
//                    if (!(price.equals(cookiesPrices[0]))) {
//                        cookiesPrices[1] = price;
//                        this.cookiesPrice2Tally++;
//                    }
//                default:
//                    break;
//            }
//
//        }
//
//    }
//}
//
//    public void formatToPrint(HashMap map) {
//        System.out.printf("%-7s", "name:");
//        System.out.printf("%6s", map.get("name"));
//        System.out.print("          ");
//        System.out.printf("%-7s", "seen:");
//        System.out.printf("%6s", map.get("nameTally"));
//        System.out.println();
//        System.out.println("=============          =============");
//        System.out.println();
//        System.out.println();
//        System.out.printf("%-7s", "price:");
//        System.out.printf("%6s", map.get("price1"));
//        System.out.print("          ");
//        System.out.printf("%-7s", "seen:");
//        System.out.printf("%6s", map.get("price1Tally"));
//        System.out.println();
//        System.out.println("=============          =============");
//        System.out.println();
//        System.out.println();
//        System.out.printf("%-7s", "price:");
//        System.out.printf("%6s", map.get("price2"));
//        System.out.print("          ");
//        System.out.printf("%-7s", "seen:");
//        System.out.printf("%6s", map.get("price2Tally"));
//        System.out.println();
//        System.out.println("=============          =============");
//        System.out.println();
//        System.out.println();
//
//        }
//
//    }
//        System.out.println(fieldValues.size());
//        System.out.println(fieldHeaders.size());
//        for (String var : fieldHeaders) {
//            System.out.println(var);
//        }
//        for (String var : fieldValues) {
//            System.out.println(var);
//        }