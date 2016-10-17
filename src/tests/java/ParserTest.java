import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by evanhitchings on 10/17/16.
 */
public class ParserTest {

    JerkSONParser jerkSONParser;

    @Before
    public void setup(){
        jerkSONParser = new JerkSONParser();
    }



    @Test
    public void parseTest(){
        try {
            Assert.assertEquals("Parser did not actually parse data", Main.readRawDataToString(), JerkSONParser.parse(Main.readRawDataToString()) );
        } catch(JerkSONException e){
            System.err.println(e.getMessage());
        }

    }
}
