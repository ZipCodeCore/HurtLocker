package io.derobert;

import java.nio.file.Path;
import java.nio.file.Paths;

import static io.derobert.ItemParser.*;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

public class App {

    public String readRawDataToString() throws Exception{
        Path path = Paths.get(ClassLoader.getSystemResource("RawData.txt").toURI());
        return new String(readAllBytes(get(path.toUri())));
    }

    public void engine(){
        try {
            System.out.println( parseItems(readRawDataToString()) );
        } catch (Exception e) {
            System.out.println("Unable to read from file");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        App app = new App();
        app.engine();
    }
}
