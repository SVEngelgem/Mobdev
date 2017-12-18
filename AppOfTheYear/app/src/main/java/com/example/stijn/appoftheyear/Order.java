package com.example.stijn.appoftheyear;

import io.realm.RealmObject;

/**
 * Created by stijn on 6/12/2017.
 */

public class Order extends RealmObject{
    private String name;
    private String locatie;
    private double totaal;
    private int order_total_id;
    private int order_id;
    private int beverage_id;


    public Order(){

    }
    //aanmaken van overzicht verschillende orders per klant
    public Order(String name, String locatie, int order_total_id){
        this.name = name;
        this.locatie = locatie;
        this.order_total_id = order_total_id;

    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getLocatie(){
        return locatie;
    }
    public void setLocatie(String locatie){
        this.locatie = locatie;
    }
    public int getOrder_total_id(){
        return order_total_id;
    }
    public void setOrder_total_id(int order_total_id){
        this.order_total_id = order_total_id;
    }

}
