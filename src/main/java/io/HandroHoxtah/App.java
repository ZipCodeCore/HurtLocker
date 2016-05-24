package io.HandroHoxtah;

/**
 * Created by alejandrolondono on 5/24/16.
 */
public class App {

    private Parser parser = new Parser();
    public void run(){
        Main main = new Main();
        try {
            parser.parse(main.readRawDataToString());
        }catch (Exception e){
            System.out.println("could not find the file, try again.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
