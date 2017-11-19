package com.example.stijn.appoftheyear;

/**
 * Created by stijn on 19/11/2017.
 */

public class Bier extends Alcohol {
    // voor bepaling blond, trippel, dubbel, etc...
    private String type;

    public Bier(String name, double price, String type, double alcoholPercentage){
        super();
        this.name = name;
        this.price = price;
        this.type = type;
        this.alcoholPercentage = alcoholPercentage;

    }
}
