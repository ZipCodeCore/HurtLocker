public class StringParser {
    Main main = new Main();

    public String[] stringParser() throws Exception {
        String[] listArray = main.readRawDataToString().split("(##)");
        return listArray;
    }
}
