package io.github.aaronclong.hurtlocker.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by aaronlong on 5/31/17.
 */
public class FileHandler {

  private String readFile;
  private String fileName;

  private FileHandler(String theFileName) {
    fileName = theFileName;
    readFile();
  }

  private void readFile() {
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      Path file = Paths.get(classLoader.getResource(fileName).toURI());
      byte[] fileBytes = Files.readAllBytes(file);
      readFile = new String(fileBytes);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static FileHandler makeFileHandler(String fileName) {
    return new FileHandler(fileName);
  }

  public String fileAsString() {
    return readFile;
  }
  
  public static void makeFile(String file) {
    try {
      Files.write(Paths.get(System.getProperty("user.home") + "/Downloads/output.txt"),
              file.getBytes());
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
