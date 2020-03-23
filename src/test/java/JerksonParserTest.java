import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class JerksonParserTest {

    private static final Logger log =
            Logger.getLogger((JerksonParserTest.class.getName()));
    JerksonParser jp;
    Main main;
    String output;
    String[] input;
    @Before
    public void init() throws Exception {
        main = new Main();
        jp = new JerksonParser();
        output = main.readRawDataToString();
        input  = jp.getObjects(output);
        jp.makeObjects(input);

    }

    @Test
    public void test(){

        for(String s : input){
            log.info(s);
        }
    }

    @Test
    public void test2(){
        for(JerksonObject i : jp.grocery){
            log.info(i.getObj().get("name"));
            log.info(i.getObj().get("price"));
            log.info(i.getObj().get("type"));
            log.info(i.getObj().get("exp"));
        }
    }
}