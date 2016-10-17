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
    public void splitByItemTest(){
        try {

            String[] splitByItem = JerkSONParser.splitJerkSONByItem(Main.readRawDataToString());
            Assert.assertEquals("Parser did not actually split items", "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016", splitByItem[0]);
//            for (String item : splitByItem){
//                System.out.println(item);
//            }

        } catch(JerkSONException e){
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
        }


    }
    //I feel I should probably be ashamed for writing a test this way. Like, that this is an abomination.
    //But...I did help me quickly identify several characters I needed to add to my regex in the method.
    @Test
    public void splitByFieldTest(){
        try{
            String[] splitByItem = JerkSONParser.splitJerkSONByItem(Main.readRawDataToString());
            String[][] splitByField = JerkSONParser.splitJerkSONByField(splitByItem);
            int count = 0;
            for(String[] fields : splitByField){
                Assert.assertEquals("Array at index " + count + " did not split properly" , 4, fields.length );
                for(String field : fields){
                    System.out.print(field +"\t");
                }
                System.out.println();
                count++;
            }

        } catch (JerkSONException e){
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
        }

    }

    @Test
    public void replaceZeroesWithOsTestWrongZeroesRemoved(){
       try{
           String toReplace = Main.readRawDataToString();
           String actual = JerkSONParser.replaceZeroesWithOs(toReplace);
           Assert.assertFalse("Did not replace Zeros with 0s where appropriate", actual.contains("o0"));

       } catch(JerkSONException e){
           System.err.println(e.getMessage());
           System.err.println(e.getStackTrace());
       }
    }

    @Test
    public void capitalizeFirstLetterTest(){
        try{
            String toReplace = Main.readRawDataToString();
            String actual = JerkSONParser.capitalizeFirstLetter(toReplace);
            Assert.assertEquals("Did not capitalize first letter of each word","NaMe", actual.substring(0, 4));
            System.out.println(actual);

        } catch(JerkSONException e){
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
        }
    }

    @Test
    public void lowercaseNonFirstLettersTest(){
        try{
            String toReplace = Main.readRawDataToString();
            String actual = JerkSONParser.lowercaseNonFirstLetters(toReplace);
            Assert.assertEquals("Did not lowercase capital letters in the middle of words","name", actual.substring(0, 4));
            System.out.println(actual);

        } catch(JerkSONException e){
            System.err.println(e.getMessage());
            System.err.println(e.getStackTrace());
        }
    }
}





