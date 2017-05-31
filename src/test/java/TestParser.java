import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewwong on 5/31/17.
 */
public class TestParser {
    String rawDataString;
    Parser parser;
    @Before
    public void init() {
        parser = new Parser();
        try{
            rawDataString = parser.readRawDataToString();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void testGetItemStringsStream() {
        // Given
        Optional<String> expectedFirst = Optional.of("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        long expectedCount = 28;
        // When
        Stream<String> actualStream = parser.getItemStringsStream(rawDataString);
        Optional<String> actualFirst = actualStream.findFirst();
        actualStream = parser.getItemStringsStream(rawDataString);
        long actualCount = actualStream.count();

        // Then
        assertEquals(expectedFirst, actualFirst);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testGetNameFromItemString() {
        // Given
        Stream<String> itemStringStream = parser.getItemStringsStream(rawDataString);
        Optional<String> expectedFirstName = Optional.of("Milk");

        // When
        Stream<String> nameStream = parser.getNamesStream(itemStringStream);
        Optional<String> actualFirstName = nameStream.findFirst();
        // Then
        assertEquals(expectedFirstName, actualFirstName);


    }
}
