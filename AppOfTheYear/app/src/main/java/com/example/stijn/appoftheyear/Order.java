package com.example.stijn.appoftheyear;

import android.support.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

/**
 * Created by stijn on 6/12/2017.
 */

public class Order extends RealmObject{
    private String name;
    private double totalprice;
    private int totalItems;
    private boolean payed;
    private String visualList;



    //aanmaken van overzicht verschillende orders per klant
    public Order(String name, int price, String visualList){
        this.name = name;
        this.totalprice = price;
        this.visualList = visualList;
        payed = false;
        //this.ID_order = ID_order;
    }
    public Order(){
        payed= false;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getTotalprice() {
        return totalprice;
    }
    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
    public boolean isPayed() {
        return payed;
    }
    public void setPayed(boolean payed) {
        this.payed = payed;
    }
    public String getVisualList() {
        return visualList;
    }
    public void setVisualList(String visualList) {
        this.visualList = visualList;
    }
    public int getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
}
