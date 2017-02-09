package mattern.william;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Created by williammattern on 2/8/17.
 */
public class OutputHandler {
    GroceryReportFormatter groceryReportFormatter;
    String finalReport;

    public void printGroceryReport(GroceryList gl){
        groceryReportFormatter = new GroceryReportFormatter();
        finalReport = groceryReportFormatter.formatFinalReport(gl);
        BufferedWriter bw = null;
        try{
            File file = new File("/Users/williammattern/Desktop/HurtLockerOutput.txt");
            if (!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(finalReport);
            System.out.println("File written successfully");
        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex){
                System.out.println("Error closing buffered writer" + ex);
            }
        }
    }
}
