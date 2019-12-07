import org.apache.commons.io.IOUtils;
import sun.tools.jstat.Token;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.function.IntToDoubleFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    Integer errorCount;

    public static void main(String[] args) throws Exception {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

    public String readRawDataToString() throws Exception {
        DataCleaner cleaner = new DataCleaner();

        DataChart chart = new DataChart();
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        String cleanList = cleaner.dataConverter(result);
        ArrayList<ParsedItems> pairedList = cleaner.pairParser(cleanList);
        Set<String> labels = chart.foodLabel(pairedList);
        chart.itemFormatter(labels, pairedList);
        return null;

    }

}

