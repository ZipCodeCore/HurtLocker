import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by evanhitchings on 10/17/16.
 */
public class ParserTest {

    JerkSONParser jerkSONParser;
    String subset;


    @Before
    public void setup() {
        subset = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:Co0kieS;price:;type:Food*expiration:1/25/2016";
        jerkSONParser = new JerkSONParser();
        jerkSONParser.setFormattedString(subset);

    }


    @Test
    public void splitByItemTest() {

            String[] splitByItem = jerkSONParser.splitJerkSONByItem();
            Assert.assertEquals("Parser did not actually split items", "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016", splitByItem[0]);
            for (String item : splitByItem) {
                System.out.println(item);
            }




    }

//    I feel I should probably be ashamed for writing a test this way. Like, that this is an abomination.
//    But...I did help me quickly identify several characters I needed to add to my regex in the method.
    @Test
    public void splitByFieldTest() {

            String[] splitByItem = jerkSONParser.splitJerkSONByItem();
            jerkSONParser.splitJerkSONByField(splitByItem);
            int count = 0;
            for (String[] fields : jerkSONParser.getSplitJerkson()) {
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
        jerkSONParser.replaceZeroesWithOs();
        Assert.assertFalse("Did not replace Zeros with 0s where appropriate", jerkSONParser.getFormattedString().contains("o0"));

    }

    @Test
    public void capitalizeFirstLetterTest() {
        jerkSONParser.capitalizeFirstLetter();
        Assert.assertEquals("Did not capitalize first letter of each word", "NaMe", jerkSONParser.getFormattedString().substring(0, 4));
    }
    @Test
    public void lowercaseNonFirstLettersTest() {
        jerkSONParser.lowercaseNonFirstLetters();
        Assert.assertEquals("Did not lowercase capital letters in the middle of words", "name", jerkSONParser.getFormattedString().substring(0, 4));
    }

    @Test
    public void matcherCountTest() {
        Assert.assertEquals("Did not find 1 Milk", 1, jerkSONParser.matchesOfType("Milk"));
    }


    @Test
    public void removeFieldNameTest(){
        jerkSONParser.capitalizeFirstLetter();
        jerkSONParser.lowercaseNonFirstLetters();
        jerkSONParser.replaceZeroesWithOs();
        String[] byItems = jerkSONParser.splitJerkSONByItem();
        jerkSONParser.splitJerkSONByField(byItems);
        jerkSONParser.removeFieldName("Name:", 0);
        Assert.assertEquals("Field was not removed", "Milk", jerkSONParser.getSplitJerkson()[0][0]);
    }

    @Test
    public void removeAllFieldNamesTest(){
        jerkSONParser.capitalizeFirstLetter();
        jerkSONParser.lowercaseNonFirstLetters();
        jerkSONParser.replaceZeroesWithOs();
        String[] byItems = jerkSONParser.splitJerkSONByItem();
        jerkSONParser.splitJerkSONByField(byItems);
        jerkSONParser.removeAllFieldNames();
        Assert.assertEquals("Not all fields were removed", "Milk", jerkSONParser.getSplitJerkson()[0][0]);

    }

    @Test
    public void createGroceryItemListTest(){
        jerkSONParser.runAll();
        jerkSONParser.createObjects();
        Assert.assertEquals("Size of Grocery list was not 3", 3, jerkSONParser.getObjectsCreated().size());
    }

    @Test
    public void errorsAfterCreatingGroceryListTest(){
        jerkSONParser.runAll();
        jerkSONParser.createObjects();
        Assert.assertEquals("Did not show 1 error as expected after", 1, jerkSONParser.getErrors());
    }



}



