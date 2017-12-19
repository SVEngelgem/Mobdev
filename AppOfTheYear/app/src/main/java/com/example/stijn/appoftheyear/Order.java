package com.example.stijn.appoftheyear;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by stijn on 6/12/2017.
 */

public class Order extends RealmObject{
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String name;
    private int ID_order;
    private int ID_sub_order;
    private int beverage_id;
    private int beverage_price;


    public Order(){

    }
    //aanmaken van overzicht verschillende orders per klant
    public Order(String name){
        this.name = name;
        //this.ID_order = ID_order;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getID_order(){
        return ID_order;
    }
    public void setID_order(int ID_order){
        this.ID_order = ID_order;
    }
    public int getID_sub_order() {
        return ID_sub_order;
    }
    public void setID_sub_order(int ID_sub_order) {
        this.ID_sub_order = ID_sub_order;
    }
    public int getBeverage_id() {
        return beverage_id;
    }
    public void setBeverage_id(int beverage_id) {
        this.beverage_id = beverage_id;
    }
    public int getBeverage_price() {
        return beverage_price;
    }
    public void setBeverage_price(int beverage_price) {
        this.beverage_price = beverage_price;
    }
}
