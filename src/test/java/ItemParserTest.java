import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by zihaocastine on 5/24/16.
 */
public class ItemParserTest {
    @Test
    public void jerkSonParserTest(){
        ItemParser itemParser=new ItemParser();
        String expectedString="Milk,3.23,Food,1/25/2016";
        ArrayList<String> actualString = itemParser.jerkSonParser("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##");
        Assert.assertEquals(expectedString,actualString.get(0));
    }

    @Test
    public void jerkSonParserTestWithMoreThanOneDataSet(){
        ItemParser itemParser=new ItemParser();
        String expectedString="Milk,3.23,Food,1/25/2016";
        String expectedString2="BreaD,1.23,Food,1/02/2016";
        ArrayList<String> actualString = itemParser.jerkSonParser("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##");
        Assert.assertEquals(expectedString,actualString.get(0));
        Assert.assertEquals(expectedString2,actualString.get(1));
    }

    @Test
    public void jerkSonParserTestWithBadData(){
        ItemParser itemParser=new ItemParser();

        ArrayList<String> actualString = itemParser.jerkSonParser("naMe:Milk;price:;type:Food;expiration:1/25/2016##");

        Assert.assertTrue(actualString.isEmpty());
        Assert.assertEquals(1,itemParser.getCountException());

    }

    @Test
    public void storeDataTest(){
        ItemParser itemParser=new ItemParser();
        ArrayList<String> stringArrayList=new ArrayList<>();
        stringArrayList.add("Milk,3.23,Food,1/25/2016");
        Item expectedItem=new Item("Milk", 3.23,"Food","1/25/2016");
        ArrayList<Item> actualItem=itemParser.storeData(stringArrayList);
        Assert.assertEquals(expectedItem.getName(),actualItem.get(0).getName());
        Assert.assertEquals(expectedItem.getPrice(),actualItem.get(0).getPrice(),0);
        Assert.assertEquals(expectedItem.getType(),actualItem.get(0).getType());
        Assert.assertEquals(expectedItem.getExpiration(),actualItem.get(0).getExpiration());

    }

    @Test(expected = BadDataException.class)
    public void BadDataExceptionTest() throws BadDataException {
        ItemParser itemParser=new ItemParser();
        itemParser.getValueFromName("a,");

    }

}
