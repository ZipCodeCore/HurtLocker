import java.util.*;
import java.util.regex.*;


/**
 * Created by latashawatson on 2/8/17.
 */
public class HurtLocker {
    ArrayList<String> milkPrices = new ArrayList<>();
    ArrayList<String> breadPrices = new ArrayList<>();
    ArrayList<String> applesPrices = new ArrayList<>();
    ArrayList<String> cookiesPrices = new ArrayList<>();
    int milkTally1 = 0;
    int breadTally1 = 0;
    int applesTally1 = 0;
    int cookiesTally1 = 0;
    int numberOfErrors = 0;

     void hurtLockerParser(String input) {
        splitSort(input);
        HashMap milk = priceTally(milkPrices);
        formatToPrint(milk);
        HashMap apples = priceTally(applesPrices);
        formatToPrint(apples);
        HashMap bread = priceTally(breadPrices);
        formatToPrint(bread);
        HashMap cookies = priceTally(cookiesPrices);
        formatToPrint(cookies);
    }


     void splitSort(String input) {
        milkPrices.add(0, "Milk");
        breadPrices.add(0, "Bread");
        applesPrices.add(0, "Apples");
        cookiesPrices.add(0, "Cookies");
        String input1 = input.toLowerCase();
        String[] partsA1 = input1.split("(##)");
        Arrays.sort(partsA1);
        for (String var : partsA1) {
            Pattern pattern = Pattern.compile("(?<=\\bname:\\b).*.(?=\\b;price\\b)");
            Matcher m = pattern.matcher(var);
            if (m.find()) {
                switch (m.group()) {
                    case "milk":
                        Pattern patterns = Pattern.compile("(\\d\\.\\d\\d)");
                        Matcher match = patterns.matcher(var);
                        if (match.find()) {
                            milkPrices.add(match.group());
                        }
                        milkTally1++;
                        break;
                    case "bread":
                        Pattern p = Pattern.compile("(\\d\\.\\d\\d)");
                        Matcher mch = p.matcher(var);
                        if (mch.find()) {
                            breadPrices.add(mch.group());
                        }
                        breadTally1++;
                        break;
                    case "apples":
                        Pattern pa = Pattern.compile("(\\d\\.\\d\\d)");
                        Matcher ma = pa.matcher(var);
                        if (ma.find()) {
                            applesPrices.add(ma.group());
                        }
                        applesTally1++;
                        break;
                    case "cookies":
                        Pattern terns = Pattern.compile("(\\d\\.\\d\\d)");
                        Matcher tch = terns.matcher(var);
                        if (tch.find()) {
                            cookiesPrices.add(tch.group());
                        }
                        cookiesTally1++;
                        break;
                    case "co0kies":
                        Pattern tt = Pattern.compile("(\\d\\.\\d\\d)");
                        Matcher t = tt.matcher(var);
                        if (t.find()) {
                            cookiesPrices.add(t.group());
                        }
                        cookiesTally1++;
                }
            }
        }
        String milkTally = Integer.toString(milkTally1);
        milkPrices.add(milkTally);
        String breadTally = Integer.toString(breadTally1);
        breadPrices.add(breadTally);
        String applesTally = Integer.toString(applesTally1);
        applesPrices.add(applesTally);
        String cookiesTally = Integer.toString(cookiesTally1);
        cookiesPrices.add(cookiesTally);


    }

     HashMap priceTally(ArrayList<String> prices) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", prices.get(0));
        String nameTally = prices.get(prices.size() - 1);
        hm.put("nameTally", nameTally);
        int prices1Tally = 0;
        int prices2Tally = 0;
        String mirror = "0.0";
        for (int i = 1; i < prices.size() - 1; i++) {
            if (mirror.equals("0.0")) {
                mirror = prices.get(i);
                hm.put("price1", prices.get(i));
                prices1Tally++;
            } else if (prices.get(i).equals(hm.get("price1"))) prices1Tally++;
            else if (!(prices.get(i).equals(hm.get("price1")))) {
                hm.put("price2", prices.get(i));
                prices2Tally++;
            }

        }
        String price1Tally = Integer.toString(prices1Tally);
        String price2Tally = Integer.toString(prices2Tally);
        hm.put("price1Tally", price1Tally);
        hm.put("price2Tally", price2Tally);
        return hm;
    }

    private void formatToPrint(HashMap map) {
        System.out.println();
        System.out.printf("%-7s", "name:");
        System.out.printf("%7s", map.get("name"));
        System.out.print("          ");
        System.out.printf("%-7s", "seen:");
        System.out.printf("%7s", map.get("nameTally"));
        System.out.println();
        System.out.println("==============          ==============");
        System.out.println();
        System.out.printf("%-7s", "price:");
        System.out.printf("%7s", map.get("price1"));
        System.out.print("          ");
        System.out.printf("%-7s", "seen:");
        System.out.printf("%7s", map.get("price1Tally"));
        System.out.println();
        System.out.println("==============          ==============");
        System.out.println();
        if (!(map.get("price2") == null)) {
            try {
                System.out.printf("%-7s", "price:");
                System.out.printf("%7s", map.get("price2"));
                System.out.print("          ");
                System.out.printf("%-7s", "seen:");
                System.out.printf("%7s", map.get("price2Tally"));
                System.out.println();
                System.out.println("==============          ==============");
                System.out.println();
            } catch (Exception NullReferenceException) {
                NullReferenceException.printStackTrace();
                numberOfErrors++;
            }
        }
    }
}












//    ArrayList<String> items1 = new ArrayList();
//    String[] items2;

//    public void method() {
//        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
//        Pattern p = Pattern.compile("(name:..;price)");
//        Matcher matcher = p.matcher(input);
//        while (matcher.find()) {
//            items1.add(matcher.group());
//        }
//        for (String nameGroup : items1) {
//            items2 = nameGroup.split("(name:)|(;price)");
//        }
//        items1.clear();
//        for (String name : items2) {
//
//        }
//    }
//first parse toLowerCase()
//then separate ##
//separate ;
//separate ^
//separate %,*, @
//separate : (try to keep the colon and value together) with exception
//make first letter of key names uppercase
    /* String str = "java";
    String cap = str.substring(0, 1).toUpperCase() + str.substring(1); */
//printf with certain # of spaces -printf("'%10s'", "Hello");

//        ArrayList<String> prices = new ArrayList<>();         (:)|(\^)|(##)|(;)|(%)|(@)|(!)|(\*)
//        ArrayList<String> prices3 = new ArrayList<>();
//        //String[] prices2 = new String[prices.size()];   "(milk)|(\\d+[\\.]\\d\\d)|(food)"
//        String input1 = input.toLowerCase();
//        Pattern pattern = Pattern.compile("([A-Za-z0-9/.]+)");
//        Matcher m = pattern.matcher(input1);
//        while (m.find()) {
//            prices.add(m.group());
//        }
////        for(int i =0; i < prices.size(); i++) {
////            int x = i-1;
////            int y = i+1;
////            String varMilk = prices.get(x);
////            String varDes = prices.get(i);
////            String varFood = prices.get(y);
////            if((varMilk.equals("milk")) && (varFood.equals("food"))){
////                prices3.add(varDes);
////            }
////        }
//        for(String var: prices) {
//            System.out.println(var);
//        }
//        System.out.println(prices.size());
//    }
//}

     /*   String[] partsA1 = input1.split("(:)|(\\^)|(##)|(;)|(%)|(@)|(!)|(\\*)");  "([:;^@%*!])"
        ArrayList<String> newList1 = new ArrayList<>();
        ArrayList<String> newList2 = new ArrayList<>();
        int i = 3;
        for (String val : partsA1) {
            if (i % 2 == 0) {
                newList1.add(val);
            }
            i++;
        }
        for (String val : partsA1) {
            if (!(i % 2 == 0)) {
                newList2.add(val);
            }
            i++;
        }*/

//        System.out.println(newList1.size());
//        System.out.println(newList2.size());
//        for(String var: newList2) {
//            System.out.println(var);
//        }
//        for(String var: newList1){
//            System.out.println(var);
//       }

       /* for (int j = 0; j < newList2.size(); j++) {
            String key = newList2.get(j);
            String value = newList1.get(j);
            System.out.printf("%-15s", key);
            System.out.print(":");
            System.out.printf("%15s", value);
            System.out.println();
            System.out.println("===============================");
            System.out.println();
        }*/

//     for(String var: bud) {
//          for(String key: partsA) {
//            System.out.println(var);
//          for(String value: partsA) {
//              System.out.println(value);
//             System.out.println("==============================");
//              System.out.println();
////
//            for(int i = 0; i < partsA.length; i++) {
//                    String key = partsA[i];
//                    System.out.printf("%15s",key);
//                    System.out.print(":");
//                for(int j = i+1; j < partsA.length; j++) {
//                    String value = partsA[j];
//                    System.out.printf("%-15s", value);
//                    System.out.println();
//                    System.out.println("==============================");
//                }


// return partsA;
// }


//
//    public String[] hurtLocker3(String[] partsB) {
//        if(partsB[3] == null) {
//            String lastPart = partsB[2];
//            String[] partsPossible = lastPart.split("(^)|(%)|(\\W*)|(@)|(!)");
//            String partz1 = partsPossible[0];
//            String partz2 = partsPossible[1];
//            partsB[2] = partz1;
//            partsB[3] = partz2;
//        }
//        return partsB;
//    }
//
//    public String[] hurtLocker4(String[] partsB) {
//    String[] keyValuePairs = new String[1];
//    for(String kVP: partsB) {
//        keyValuePairs = kVP.split(":");
//    }
//    for(String oneWord: partsB) {
//        if(oneWord == null) {
//            oneWord = "null";
//        }
//    }
//    return keyValuePairs;
//    }
//}
