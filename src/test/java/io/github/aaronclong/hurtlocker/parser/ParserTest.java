package io.github.aaronclong.hurtlocker.parser;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by aaronlong on 5/31/17.
 */
public class ParserTest {

  private String jerkSonFile;

  @Before
  public void setUp() {
    try {
      ClassLoader classLoader = Parser.class.getClassLoader();
      Path file = Paths.get(classLoader.getResource("RawData.txt").toURI());
      byte[] csvBytes = Files.readAllBytes(file);
      jerkSonFile = new String(csvBytes);
      System.out.println(jerkSonFile);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Test
  public void testGetParser() {
    try {
      Parser parser = Parser.parse(jerkSonFile);
      System.out.println(parser.getParsed());
    } catch (ParserException e) {

    }
  }
}
