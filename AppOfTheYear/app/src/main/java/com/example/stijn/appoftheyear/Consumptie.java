package com.example.stijn.appoftheyear;

import io.realm.RealmObject;

/**
 * Created by stijn on 29/11/2017.
 */

public class Consumptie extends RealmObject {
    private String name;
    private double price;

    public Consumptie(){

    }

    public Consumptie(String name, double price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

}
