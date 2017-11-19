package com.example.stijn.appoftheyear;

/**
 * Created by stijn on 19/11/2017.
 */

public class Whiskey extends Alcohol {
    private String variation;

    public Whiskey(String name, double price, String variation, double alcoholPercentage){
        super();
        this.name = name;
        this.price = price;
        this.variation = variation;
        this.alcoholPercentage = alcoholPercentage;
    }
}
