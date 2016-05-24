import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zihaocastine on 5/24/16.
 */
public class ItemTest {
    @Test
    public void testCreateItem(){
        Item item =new Item();
        item.setName("Milk");
        item.setPrice(3.23);
        item.setType("Food");
        item.setExpiration("1/25/2016");

        Assert.assertEquals("Milk",item.getName());
        Assert.assertEquals(3.23,item.getPrice(),0);
        Assert.assertEquals("Food",item.getType());
        Assert.assertEquals("1/25/2016",item.getExpiration());

    }

}
