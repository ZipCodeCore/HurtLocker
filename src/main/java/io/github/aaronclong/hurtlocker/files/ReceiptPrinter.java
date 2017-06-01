package io.github.aaronclong.hurtlocker.files;

import  io.github.aaronclong.hurtlocker.parser.Parser;
import io.github.aaronclong.hurtlocker.parser.ParserException;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ReceiptPrinter {
  private FileHandler rawFile;
  private Parser parser;
  private StringBuilder fileOutPut;

  public ReceiptPrinter() {
    rawFile = FileHandler.makeFileHandler("RawData.txt");
    parser = Parser.parse(rawFile.fileAsString());
    fileOutPut = new StringBuilder(1000);
    generateFileString();
  }

  private void generateFileString() {
    try {
      Map<String, ArrayList<Map<String, String>>> parsed = parser.getParsed();
      for (Map.Entry<String, ArrayList<Map<String, String>>> entry : parsed.entrySet()) {
        ReceiptItem item = ReceiptItem.makeReceiptItem(entry.getKey(), entry.getValue());
        fileOutPut.append(item.toString());
      }
    } catch (ParserException e) {
      System.out.println(e.toString());
    }

  }

  public String toString() {
    return fileOutPut.toString();
  }
}
