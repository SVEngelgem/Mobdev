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
}
