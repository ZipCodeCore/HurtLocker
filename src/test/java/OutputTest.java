import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by randallcrame on 2/8/17.
 */
public class OutputTest {
    GroceryList gList;
    Output output;
    Milk milk;
    Milk milk2;
    Bread bread;

    @Before
    public void setUp(){
        gList = new GroceryList();
        output = new Output();
        milk = new Milk("3.23", "Food", "01/11/1111" );
        milk2 = new Milk("3.25", "Food", "01/11/1111" );
        bread = new Bread("0.99", "Food","1/11/1111");
        gList.add(milk);
        gList.add(milk);
        gList.add(milk2);
        gList.add(bread);
        gList.add(bread);
        gList.add(bread);
        gList.add(bread);


    }
    @Test
    public void outputNameTest(){
        String expected ="name:    Milk";
        String actual = output.outputName("Milk");
        Assert.assertEquals("Expect proper formatting with left justify 13 width of Class name", expected, actual);
    }

    @Test
    public void outputSeenTest(){
        String expected ="    seen: 5 times";
        String actual = output.outputSeen(5);
        Assert.assertEquals("Expect proper formatting with number 1 seen", expected, actual);
    }

    @Test
    public void outputErrorTest(){
        String expected ="Error        ";
        String actual = output.outputErrors();
        Assert.assertEquals("Expect proper formatting with Error", expected, actual);
    }

    @Test
    public void outputFormattedList(){
        output.outputFormattedItemList(gList.groceryList.get("Milk"));
    }

    @Test
    public void outputFullList(){
        output.outputFullList(gList.groceryList);
    }
}
