import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {
    private String fileName;
    private String lineToWrite = "";
    FileWriter writer;

    public Writer(){
        this.fileName =  "src/main/resources/output.txt";
    }

    public void writeToFile(List<String> printAll) throws IOException {
        for(String s : printAll){
            lineToWrite = lineToWrite.concat(s);
        }
        writer = new FileWriter(this.fileName);
        PrintWriter printLine = new PrintWriter(writer);
        printLine.printf("%s" + "%n", lineToWrite);
        printLine.close();
    }
}
