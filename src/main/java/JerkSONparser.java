import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerkSONparser {
    Map<String, Integer> listOfItems = new LinkedHashMap<String, Integer>();
    Map<String, Integer> listOfItemsandPrice = new LinkedHashMap<String, Integer>();


    public void parseInput(String input) {
        String input1 = input.toLowerCase();
        String[] itemArray = input1.split("##");
        for (int i = 0; i < itemArray.length; i++) {
            String[] currentItem = itemArray[i].split("[^a-zA-Z0-9/.:]");
            addItemToMap(currentItem[0], currentItem[1]);
         }
        }
        public void addItemToMap (String item, String price) {
            String correctItem = validateInput(item, price);
            if (!correctItem.equals(""))
            {
                Integer num = 1;
                if (listOfItems.containsKey(correctItem)) {
                    num = num + listOfItems.get(correctItem);
                }
                    listOfItems.put(correctItem, num);
                }
                else {
                    Integer num = 1;
                    if (listOfItems.containsKey("Errors")) {
                        num = num + listOfItems.get("Errors");
                    }
                    listOfItems.put("Errors", num);

                }
            }

            public void addItemAndCount (String item){
                int count = 1;
                if (listOfItemsandPrice.containsKey(item)) {
                    count = count + listOfItemsandPrice.get(item);
                }
                listOfItemsandPrice.put(item, count);
            }

            public String validateInput (String item, String price){

                String[] outputItem = item.split("[:]");
                String[] outputPrice = price.split("[:]");
                StringBuilder sb = new StringBuilder();
                if (outputItem.length > 1 && outputPrice.length > 1) {
                    String itemName = outputItem[1].toLowerCase().replace("0", "o");
                    addItemAndCount(itemName);

                    sb.append(itemName);
                    sb.append(":");
                    sb.append(outputPrice[1].toLowerCase());
                }
                return sb.toString();
            }

            public void printMap () {

                for (HashMap.Entry<String, Integer> entry1 : listOfItemsandPrice.entrySet()) {
                    String str = entry1.getKey();
                    Integer num = entry1.getValue();


                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("name:\t" + str)
                            .append("\t\tseen: " + num + " times\n")
                            .append("=============\t\t=============\n");

                    for (HashMap.Entry<String, Integer> entry2 : listOfItems.entrySet()) {
                        String[] str1 = entry2.getKey().split("[:]");
                        Integer num1 = entry2.getValue();

                        if (str1[0].equals(str)) {
                            stringBuilder.append("Price:\t" + str1[1])
                                    .append("\t\tseen: " + num1 + " times\n")
                                    .append("-------------\t\t-------------\n");
                        }
                    }
                    System.out.println(stringBuilder);
                }
                System.out.println("Errors:\t \t\t\tseen: " + listOfItems.get("Errors") + " times\n");
            }
        }




