package com.example.stijn.appoftheyear;

import io.realm.RealmObject;
/**
 * Created by stijn on 27/11/2017.
 */

public class Hond extends RealmObject{
    public String geslacht;
    public String soort;

    public Hond(){
    }
    public Hond(String geslacht, String soort){
        this.geslacht = geslacht;
        this.soort = soort;
    }
}
