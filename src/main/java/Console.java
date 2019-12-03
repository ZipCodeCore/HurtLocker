import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Console {

    private String path = "";
    private String lineToWrite = "";
    private boolean appendToFile = true;
    FileWriter writer;

    public Console(String fileName, boolean append){
        //setup the parameters: file name/path and if overwrite
        this.appendToFile = append;
        this.path = System.getProperty("user.home") + "/" + fileName;
    }

    public void writeToFile (List<String> allLines) throws IOException {

        for(String each : allLines){
            lineToWrite = lineToWrite.concat(each);
        }

        System.out.println(lineToWrite);

        this.writer = new FileWriter(this.path,this.appendToFile);
        PrintWriter printLine = new PrintWriter(writer);
        printLine.printf("%s" + "%n", this.lineToWrite);
        printLine.close();
    }


}
