package com.example.stijn.appoftheyear;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by stijn on 29/11/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
    }

}
