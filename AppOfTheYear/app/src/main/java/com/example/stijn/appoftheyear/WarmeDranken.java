package com.example.stijn.appoftheyear;

/**
 * Created by stijn on 19/11/2017.
 */

public class WarmeDranken extends Drank {
    private String variation;
    private String type;

    //geeft optie warme dranken zoals soep, thee, koffie en hun variaties
    public WarmeDranken(String name ,double price ,String type ,String variation){
        super();
        this.name = name;
        this.price = price;
        this.variation = variation;
        this.type = type;
    }
    //warme chocomelk heeft geen variatie
    public WarmeDranken(String name ,double price ,String type){
        super();
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
