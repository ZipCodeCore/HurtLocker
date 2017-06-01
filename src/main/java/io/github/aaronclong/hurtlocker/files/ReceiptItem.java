package io.github.aaronclong.hurtlocker.files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ReceiptItem {
  private String name;
  private Map<String, Integer> prices;
  private int originalSize;

  private ReceiptItem(String theName, ArrayList<Map<String, String>> list) {
    name = theName;
    originalSize = list.size();
    findPrices(list);
  }

  private void findPrices(ArrayList<Map<String, String>> list) {
    prices = new HashMap<>();
    for (Map<String, String> listing : list) {
      String price = listing.get("Price");
      Integer occurrences = prices.get(price);
      if (occurrences == null) {
        occurrences = 0;
      }

      prices.put(price, occurrences + 1);
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder(500);
    String header = String.format("name:   %s\t\tseen: %d times\n", name, originalSize);
    sb.append(header);
    for (Map.Entry<String, Integer> entry : prices.entrySet()) {
      sb.append("-------------\t\t -------------\n");
      sb.append(makeLinePerPrice(entry));
    }
    return sb.toString();
  }

  private static String makeLinePerPrice(Map.Entry<String, Integer> price) {
    String frequency = price.getValue() == 1 ? "time" : "times";
    return String.format("Price:   %s\t\tseen: %d %s\n", price.getKey(), price.getValue(), frequency);

  }

  public static ReceiptItem makeReceiptItem(String theName,
                                            ArrayList<Map<String, String>> list) {
    return new ReceiptItem(theName, list);
  }
}
