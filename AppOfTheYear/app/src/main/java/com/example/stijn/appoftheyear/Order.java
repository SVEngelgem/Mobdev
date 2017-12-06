package com.example.stijn.appoftheyear;

import io.realm.RealmObject;

/**
 * Created by stijn on 6/12/2017.
 */

public class Order extends RealmObject{
    private Consumptie consumptie;
    private int amount;

    public Order(){

    }
    public Order(Consumptie consumptie, int amount){
        this.consumptie = consumptie;
        this.amount = amount;
    }

    public Consumptie getConsumptie(){
        return consumptie;
    }
    public void setConsumptie(Consumptie consumptie){
        this.consumptie = consumptie;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }

}
