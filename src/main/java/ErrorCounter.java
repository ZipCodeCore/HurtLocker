public class ErrorCounter {


    public String errorCounter() throws Exception {
        StringParser stringParser = new StringParser();
        String[] listArray = stringParser.stringParser();
        Integer counter = 0;
        for(String s : listArray){
            if(s.contains(":;")){
                counter++;
            }
        }
        return String.format("Number of errors: %d", counter);

    }
}
