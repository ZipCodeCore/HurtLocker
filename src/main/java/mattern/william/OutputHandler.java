package mattern.william;

import java.util.Collection;

/**
 * Created by williammattern on 2/8/17.
 */
public class OutputHandler {
    GroceryReportFormatter groceryReportFormatter;

    public String printGroceryReport(GroceryList gl){
        groceryReportFormatter = new GroceryReportFormatter();
        return groceryReportFormatter.formatFinalReport(gl);
    }
}
