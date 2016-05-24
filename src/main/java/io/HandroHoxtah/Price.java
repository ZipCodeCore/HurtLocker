package io.HandroHoxtah;

/**
 * Created by alejandrolondono on 5/24/16.
 */
public class Price {
    private double price;

    private int howMany;

    public double getPrice() {
        return price;
    }

    public Price(double price){
        this.price = price;
        increment();
    }

    public void increment(){
        this.howMany++;
    }

    public int getHowMany() {
        return howMany;
    }
}
