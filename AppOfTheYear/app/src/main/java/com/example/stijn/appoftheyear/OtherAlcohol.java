package com.example.stijn.appoftheyear;

/**
 * Created by stijn on 19/11/2017.
 */

public class OtherAlcohol extends Alcohol {
    private String type;
    private String colour;

    //voor dergelijke dranken die zowel rode als witte variant hebben.
    public OtherAlcohol(String name, double price, String type, String colour, double alcoholPercentage){
        super();
        this.name = name;
        this.price = price;
        this.type = type;
        this.colour = colour;
        this.alcoholPercentage = alcoholPercentage;
    }
    //voor andere met enkel 1 kleur variant of cocktails
    public OtherAlcohol(String name, double price, String type, double alcoholPercentage){
        super();
        this.name = name;
        this.price = price;
        this.type = type;
        this.alcoholPercentage = alcoholPercentage;
    }
}
