import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by evanhitchings on 10/17/16.
 */
public class ParserTest {

    JerkSONParser jerkSONParser;
    String formatted;


    @Before
    public void setup() {
        jerkSONParser = new JerkSONParser();
        formatted = "Name:Milk;Price:3.23;Type:Food;Expiration:1/25/2016##Name:Bread;Price:1.23;Type:Food;Expiration:1/02/2016##Name:" +
                "Bread;Price:1.23;Type:Food;Expiration:2/25/2016##Name:Milk;Price:3.23;Type:Food^Expiration:1/11/2016##Name:Cookies;" +
                "Price:2.25;Type:Food%Expiration:1/25/2016##Name:Cookies;Price:2.25;Type:Food*Expiration:1/25/2016##Name:Cookies;" +
                "Price:2.25;Type:Food;Expiration:3/22/2016##Name:Cookies;Price:2.25;Type:Food;Expiration:1/25/2016##Name:Milk;" +
                "Price:3.23;Type:Food;Expiration:1/17/2016##Name:Milk;Price:1.23;Type:Food!Expiration:4/25/2016##Name:Apples;" +
                "Price:0.25;Type:Food;Expiration:1/23/2016##Name:Apples;Price:0.23;Type:Food;Expiration:5/02/2016##Name:Bread;" +
                "Price:1.23;Type:Food;Expiration:1/25/2016##Name:;Price:3.23;Type:Food;Expiration:1/04/2016##Name:Milk;Price:3.23;" +
                "Type:Food;Expiration:1/25/2016##Name:Bread;Price:1.23;Type:Food@Expiration:1/02/2016##Name:Bread;Price:1.23;Type:" +
                "Food@Expiration:2/25/2016##Name:Milk;Price:;Type:Food;Expiration:1/11/2016##Name:Cookies;Price:2.25;Type:Food;" +
                "Expiration:1/25/2016##Name:Cookies;Price:2.25;Type:Food;Expiration:1/25/2016##Name:Cookies;Price:2.25;Type:Food;" +
                "Expiration:3/22/2016##Name:Cookies;Price:2.25;Type:Food;Expiration:1/25/2016##Name:Milk;Price:3.23;Type:Food;Expiration:" +
                "1/17/2016##Name:Milk;Price:;Type:Food;Expiration:4/25/2016##Name:Apples;Price:0.25;Type:Food;Expiration:1/23/2016##Name:" +
                "Apples;Price:0.23;Type:Food;Expiration:5/02/2016##Name:Bread;Price:1.23;Type:Food;Expiration:1/25/2016##Name:;Price:3.23;Type:Food^Expiration:1/04/2016##";
    }


    @Test
    public void splitByItemTest() {


            String[] splitByItem = jerkSONParser.splitJerkSONByItem(Main.readRawDataToString());
            Assert.assertEquals("Parser did not actually split items", "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016", splitByItem[0]);
            for (String item : splitByItem) {
                System.out.println(item);
            }




    }

    //I feel I should probably be ashamed for writing a test this way. Like, that this is an abomination.
    //But...I did help me quickly identify several characters I needed to add to my regex in the method.
    @Test
    public void splitByFieldTest() {

            String[] splitByItem = jerkSONParser.splitJerkSONByItem(Main.readRawDataToString());
            String[][] splitByField = jerkSONParser.splitJerkSONByField(splitByItem);
            int count = 0;
            for (String[] fields : splitByField) {
                Assert.assertEquals("Array at index " + count + " did not split properly", 4, fields.length);
                for (String field : fields) {
                    System.out.print(field + "\t");
                }
                System.out.println();
                count++;
            }

    }

    @Test
    public void replaceZeroesWithOsTestWrongZeroesRemoved() {

        String toReplace = Main.readRawDataToString();
        String actual = jerkSONParser.replaceZeroesWithOs(toReplace);
        Assert.assertFalse("Did not replace Zeros with 0s where appropriate", actual.contains("o0"));

    }

    @Test
    public void capitalizeFirstLetterTest() {

        String toReplace = Main.readRawDataToString();
        String actual = jerkSONParser.capitalizeFirstLetter(toReplace);
        Assert.assertEquals("Did not capitalize first letter of each word", "NaMe", actual.substring(0, 4));
        System.out.println(actual);

    }

    @Test
    public void lowercaseNonFirstLettersTest() {

        String toReplace = Main.readRawDataToString();
        String actual = jerkSONParser.lowercaseNonFirstLetters(toReplace);
        Assert.assertEquals("Did not lowercase capital letters in the middle of words", "name", actual.substring(0, 4));
        System.out.println(actual);

    }

    @Test
    public void matcherCountTest() {
        Assert.assertEquals("Did not find 8 Milks", 8, jerkSONParser.matchesOfType(formatted, "Milk"));
    }

    @Test
    public void errorCountTest(){
        String[] byItems = jerkSONParser.splitJerkSONByItem(Main.readRawDataToString());
        String[][] byFields = jerkSONParser.splitJerkSONByField(byItems);
        Assert.assertEquals("Did not find correct number of errors", 4, jerkSONParser.errors(byFields));

    }

//    @Test
//    public void removeNameTest(){
//
//        String[] byItems = jerkSONParser.splitJerkSONByItem(formatted);
//        String[][] byFields = jerkSONParser.splitJerkSONByField(byItems);
//        jerkSONParser.removeNamesAfterErrorChecking(byFields);
//        Assert.assertEquals("Did not remove Name:", "Milk", byFields[0][0] );
//
//    }
//
//    @Test
//    public void fillMapWithValuesTest(){
//        String[] byItems = jerkSONParser.splitJerkSONByItem(formatted);
//        String[][] byFields = jerkSONParser.splitJerkSONByField(byItems);
//        jerkSONParser.removeNamesAfterErrorChecking(byFields);
//        jerkSONParser.fillMapWithKeys(byFields);
//        Assert.assertEquals("Map did not fill with keys", 4, jerkSONParser.getObjectMap().size());
//        System.out.println(jerkSONParser.getObjectMap().keySet());
//
//    }

    @Test
    public void removeFieldNameTest(){
        String[] byItems = jerkSONParser.splitJerkSONByItem(formatted);
        String[][] byFields = jerkSONParser.splitJerkSONByField(byItems);
        String[][] noNames = jerkSONParser.removeFieldName(byFields, "Name:");
        Assert.assertEquals("Field was not removed", "Milk", noNames[0][0]);
    }

}



