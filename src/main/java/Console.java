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

    public void writeToFile (List<String> lineToWrite) throws IOException {

        for(String each : lineToWrite){
            System.out.println(each.toString());
        }
//
//        this.writer = new FileWriter(this.path,this.appendToFile);
//        PrintWriter printLine = new PrintWriter(writer);
//        this.lineToWrite = lineToWrite;
//        formatLineToWrite();
//        printLine.printf("%s" + "%n", this.lineToWrite);
//        printLine.close();
    }

//    public void readFile (String dataToRead) throws IOException {
        //File fileToRead = new File(this.path);
//        Scanner sc = new Scanner(dataToRead);
//
//        sc.useDelimiter("##");
//        while (sc.hasNextLine()) {
//            System.out.println(sc.nextLine());
//        }
//    }

    private void formatLineToWrite (){
//        String formatedDate = String.valueOf(new Date());
//        formatedDate = formatedDate.substring(0,19);
//
//        this.lineToWrite = this.lineToWrite + formatedDate;
    }


}
