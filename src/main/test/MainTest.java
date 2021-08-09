import org.junit.Test;

public class MainTest {

    Main test = new Main();

//    @Test
//    public void milkChangeTest() {
//        String result = test.changeMilk();
//        System.out.println(result);
//    }

    @Test
    public void poundNewLineTest() {
        String result = test.poundToNewLine(test.correctSeparator());
        System.out.println(result);
    }

    @Test // weird output
    public void correctedSeparatorTest() {
        String result = test.correctSeparator();
        System.out.println(result);
    }

//    @Test
//    public void applesChangeTest() {
//        String result = test.changeApples();
//        System.out.println(result);
//    }

    @Test
    public void entireFormattingTest() {
        String result = test.poundToNewLine(test.correctSeparator());
        String result1 = test.changeApples(result);
        String result2 = test.changeBread(result1);
        String result3 = test.changeCookies(result2);
        String result4 = test.changeMilk(result3);
        String result5 = test.nameChange(result4);
        String result6 = test.priceChange(result5);
        System.out.println(result6);
    }

    @Test
    public void printTest() {
        String result = test.doingTheFormatting();
        System.out.println(result);
    }
}
